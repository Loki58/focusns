package org.focusns.service.msg;

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

import java.util.Date;

import org.focusns.model.common.Page;
import org.focusns.model.msg.Message;
import org.focusns.service.AbstractServiceTest;
import org.junit.Ignore;
import org.junit.Test;
import org.springframework.beans.factory.annotation.Autowired;

@Ignore
public class MessageServiceTest extends AbstractServiceTest {

    @Autowired
    private MessageService messageService;

    @Test
    public void testCreateMessage() {
        Message message = new Message();
        message.setTitle("xinxi");
        message.setContent("neirong");
        message.setCreatedAt(new Date());
        message.setProjectId(1);
        message.setCreatedById(1);
        message.setToProjectId(1);
        //
        messageService.createMessage(message);
    }

    @Test
    public void testselectPage() {
        Page<Message> page = new Page(10);
        page = messageService.selectPageByBox(page, "in", 1);
        System.out.println(page.getTotalCount());
    }

}
