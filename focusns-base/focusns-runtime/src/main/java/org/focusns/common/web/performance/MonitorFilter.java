package org.focusns.common.web.performance;

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

import java.io.IOException;

import javax.servlet.FilterChain;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.apache.commons.logging.Log;
import org.apache.commons.logging.LogFactory;
import org.springframework.util.StopWatch;
import org.springframework.util.StringUtils;
import org.springframework.web.filter.OncePerRequestFilter;

public class MonitorFilter extends OncePerRequestFilter {

    private static final Log log = LogFactory.getLog(MonitorFilter.class);

    @Override
    protected void doFilterInternal(HttpServletRequest request, HttpServletResponse response, FilterChain filterChain)
            throws ServletException, IOException {
        //
        if (log.isTraceEnabled()) {
            //
            String requestDesc = getRequestDescription(request);
            StopWatch stopWatch = new StopWatch();
            stopWatch.start(requestDesc);
            //
            filterChain.doFilter(request, response);
            //
            stopWatch.stop();
            //
            log.trace(stopWatch.prettyPrint());
        } else {
            filterChain.doFilter(request, response);
        }
    }

    private String getRequestDescription(HttpServletRequest request) {
        StringBuilder sb = new StringBuilder(request.getRequestURI());
        if (StringUtils.hasText(request.getQueryString())) {
            sb.append("?").append(request.getQueryString());
        }
        sb.append(" [").append(request.getMethod()).append("]");
        return sb.toString();
    }

}
