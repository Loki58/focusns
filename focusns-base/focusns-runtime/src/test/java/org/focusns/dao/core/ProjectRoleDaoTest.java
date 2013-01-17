/*
 * Copyright (C) 2011-2013 FocusSNS.
 *
 * This library is free software; you can redistribute it and/or
 * modify it under the terms of the GNU Lesser General Public
 * License as published by the Free Software Foundation; either
 * version 2.1 of the License, or (at your option) any later version.
 *
 * This library is distributed in the hope that it will be useful,
 * but WITHOUT ANY WARRANTY; without even the implied warranty of
 * MERCHANTABILITY or FITNESS FOR A PARTICULAR PURPOSE.  See the GNU
 * Lesser General Public License for more details.
 *
 * You should have received a copy of the GNU Lesser General Public
 * License along with this library; if not, write to the Free Software
 * Foundation, Inc., 51 Franklin Street, Fifth Floor, Boston,
 * MA 02110-1301  USA
 */

package org.focusns.dao.core;

import org.focusns.dao.AbstractDaoTest;
import org.focusns.model.core.ProjectRole;
import org.junit.Ignore;
import org.junit.Test;
import org.springframework.beans.factory.annotation.Autowired;

@Ignore
public class ProjectRoleDaoTest extends AbstractDaoTest {

    @Autowired
    private ProjectRoleDao projectRoleDao;

    @Test
    public void testInsert() {
        ProjectRole role = new ProjectRole();
        role.setLabel("管理员");
        role.setLevel(0);
        role.setProjectId(1);
        role.setCategoryId(1);
        //
        this.projectRoleDao.insert(role);
    }

    @Test
    public void testInsertAuthority() {
        this.projectRoleDao.insertAuthority(1, 1, 1);
    }

    @Test
    public void testDeleteAuthority() {
        this.projectRoleDao.deleteAuthority(1, 1, 1);
    }
}
