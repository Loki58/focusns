package org.focusns.web.site;

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

import org.focusns.common.web.widget.annotation.bind.WidgetAttribute;
import org.focusns.common.web.widget.stereotype.Widget;
import org.focusns.model.core.ProjectFeature;
import org.focusns.model.core.ProjectUser;
import org.focusns.service.core.ProjectFeatureService;
import org.focusns.web.widget.constraint.annotation.RequiresProjectUser;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;

@Widget
@RequestMapping("site")
public class UserMenuWidget {

    @Autowired
    private ProjectFeatureService featureService;

    @RequestMapping("/menu-user")
    @RequiresProjectUser
    public String doView(@WidgetAttribute ProjectUser projectUser, Model model) {
        //
        Long projectId = projectUser.getProjectId();
        List<ProjectFeature> features = featureService.getProjectFeatures(projectId);
        model.addAttribute("features", features);
        //
        return "site/menu-user";
    }
}
