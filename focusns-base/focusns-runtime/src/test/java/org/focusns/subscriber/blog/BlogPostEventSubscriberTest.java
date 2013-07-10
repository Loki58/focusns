package org.focusns.event.blog;

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

import org.focusns.event.AbstractEventTest;
import org.focusns.event.blog.impl.BlogPostEventSubscriber;
import org.focusns.model.blog.BlogPost;
import org.focusns.service.blog.BlogPostService;
import org.junit.Assert;
import org.junit.Ignore;
import org.junit.Test;
import org.springframework.beans.factory.annotation.Autowired;

@Ignore
public class BlogPostEventSubscriberTest extends AbstractEventTest {

    @Autowired
    private BlogPostService blogPostService;
    @Autowired
    private BlogPostEventSubscriber blogPostEventSubscriber;

    @Test
    public void testGetBlogPostEvent() {
        //
        BlogPost blogPost = blogPostService.getBlogPost(1);
        Assert.assertTrue(blogPost.getId() == 1);
        //
        Assert.assertNotNull(blogPostEventSubscriber);
    }

}
