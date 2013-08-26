package org.focusns.dao.core;

/*
 * #%L
 * FocusSNS Runtime
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

import org.focusns.dao.AbstractDaoTest;
import org.focusns.model.common.Page;
import org.focusns.model.core.ProjectLink;
import org.junit.Ignore;
import org.junit.Test;
import org.springframework.beans.factory.annotation.Autowired;

@Ignore
public class ProjectLinkDaoTest extends AbstractDaoTest {

    @Autowired
    private ProjectLinkDao projectLinkDao;

    @Test
    public void testInsert() {
        ProjectLink link = new ProjectLink();
        link.setFromProjectId(1);
        link.setToProjectId(1);
        //
        projectLinkDao.insert(link);
    }

    @Test
    public void testFetchByFromProjectId() {
        Page<ProjectLink> page = new Page<ProjectLink>(10);
        page = projectLinkDao.fetchByFromProjectId(page, 2L, "people", null);
        System.out.println(page.getResults().size());
    }
}
