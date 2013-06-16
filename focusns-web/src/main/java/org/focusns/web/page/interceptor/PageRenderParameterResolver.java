package org.focusns.web.page.interceptor;

/*
 * #%L
 * FocusSNS Web
 * %%
 * Copyright (C) 2011 - 2013 FocusSNS
 * %%
 * This program is free software: you can redistribute it and/or modify
 * it under the terms of the GNU Lesser General Public License as 
 * published by the Free Software Foundation, either version 2.1 of the 
 * License, or (at your option) any later version.
 * 
 * This program is distributed in the hope that it will be useful,
 * but WITHOUT ANY WARRANTY; without even the implied warranty of
 * MERCHANTABILITY or FITNESS FOR A PARTICULAR PURPOSE.  See the
 * GNU General Lesser Public License for more details.
 * 
 * You should have received a copy of the GNU General Lesser Public 
 * License along with this program.  If not, see
 * <http://www.gnu.org/licenses/lgpl-2.1.html>.
 * #L%
 */

import java.util.List;
import java.util.Map;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.focusns.common.web.WebUtils;
import org.focusns.common.web.page.engine.PageRenderInterceptor;
import org.focusns.model.core.Project;
import org.focusns.model.core.ProjectCategory;
import org.focusns.model.core.ProjectFeature;
import org.focusns.service.core.ProjectCategoryService;
import org.focusns.service.core.ProjectFeatureService;
import org.focusns.service.core.ProjectService;
import org.focusns.web.Keys;
import org.springframework.beans.BeansException;
import org.springframework.context.ApplicationContext;
import org.springframework.context.ApplicationContextAware;
import org.springframework.util.StringUtils;
import org.springframework.web.util.UrlPathHelper;

public class PageRenderParameterResolver implements PageRenderInterceptor, ApplicationContextAware {

    private static final UrlPathHelper urlPathHelper = new UrlPathHelper();

    private ApplicationContext applicationContext;

    @Override
    public void setApplicationContext(ApplicationContext applicationContext) throws BeansException {
        this.applicationContext = applicationContext;
    }

    @Override
    public void beforeRender(HttpServletRequest request, HttpServletResponse response) {
        //
        Map<String, String> parameterMap = WebUtils.getParameterMap(request);
        String lookupPath = urlPathHelper.getLookupPathForRequest(request);
        //
        String projectCode = parameterMap.get(Keys.PARAMETER_PROJECT_CODE);
        if (StringUtils.hasText(projectCode)) {
            //
            ProjectService projectService = applicationContext.getBean(ProjectService.class);
            ProjectCategoryService projectCategoryService = applicationContext.getBean(ProjectCategoryService.class);
            ProjectFeatureService projectFeatureService = applicationContext.getBean(ProjectFeatureService.class);
            //
            Project project = projectService.getProject(projectCode);
            ProjectCategory projectCategory = projectCategoryService.getCategory(project.getCategoryId());
            //
            request.setAttribute(Keys.REQUEST_PROJECT, project);
            request.setAttribute(Keys.REQUEST_PROJECT_CATEGORY, projectCategory);
            //
            List<ProjectFeature> projectFeatures = projectFeatureService.getProjectFeatures(project.getId());
            for (ProjectFeature projectFeature : projectFeatures) {
                if (lookupPath.contains(projectFeature.getCode())) {
                    request.setAttribute(Keys.REQUEST_PROJECT_FEATURE, projectFeature);
                    break;
                }
            }
        }
        //
        Object projectUser = request.getSession().getAttribute(Keys.SESSION_PROJECT_USER);
        if (projectUser != null) {
            request.setAttribute(Keys.REQUEST_PROJECT_USER, projectUser);
        }
    }

    @Override
    public void afterRender(HttpServletRequest request, HttpServletResponse response) {
    }

}
