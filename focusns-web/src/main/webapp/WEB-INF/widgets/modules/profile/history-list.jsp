<%@ page contentType="text/html; UTF-8" pageEncoding="UTF-8" %>
<%@ include file="/WEB-INF/widgets/widget.jsp" %>

<ui:widget>
    <ui:widget-body>
        <ul class="nav nav-tabs">
            <li class="active">
                <a href="#">全部</a>
            </li>
            <li><a href="#">说说</a></li>
            <li><a href="#">...</a></li>
        </ul>

        <c:choose>
            <c:when test="${empty page.results}">
                <div class="alert alert-info">
                    当前还没有任何动态...
                </div>
            </c:when>
            <c:otherwise>
                <c:forEach items="${page.results}" var="history">
                    <ul class="media-list">
                        <li class="media">
                            <a class="pull-left" href='<c:url value="/${history.createdBy.project.code}/profile" />'>
                                <tool:img-avatar styleClass="media-object" projectUserId="${history.createdBy.id}" width="50" height="50" />
                            </a>
                            <div class="media-body">
                                <!--<h4 class="media-heading">Media heading</h4>-->
                                <p>${history.content}</p>
                                <tool:abbr-date value="${history.createdAt}" />
                                <!-- Nested media object -->
                                <c:forEach items="${history.children}" var="childHistory">
                                    <div class="media">
                                        <a class="pull-left" href='<c:url value="/${childHistory.createdBy.project.code}/profile" />'>
                                            <tool:img-avatar styleClass="media-object" projectUserId="${childHistory.createdBy.id}" width="50" height="50" />
                                        </a>
                                        <p>${childHistory.content}</p>
                                        <tool:abbr-date value="${childHistory.createdAt}" />
                                    </div>
                                </c:forEach>
                            </div>

                            <c:if test="${not empty sessionScope.projectUser}">
                                <form action='<widget:actionUrl value="/project/history-create" />' method="post">

                                    <textarea name="content"></textarea>

                                    <input type="hidden" name="targetType" value="${template.targetType}"/>
                                    <input type="hidden" name="targetId" value="${template.targetId}"/>
                                    <input type="hidden" name="projectId" value="${template.projectId}"/>
                                    <input type="hidden" name="createdById" value="${template.createdById}"/>
                                    <input type="hidden" name="parentId" value="${history.id}"/>
                                    <input type="hidden" name="redirect" value='<c:url value="/${project.code}/profile" />' />

                                    <button class="btn btn-primary pull-right" type="submit">回复</button>
                                </form>
                            </c:if>
                        </li>
                    </ul>
                </c:forEach>
            </c:otherwise>
        </c:choose>
    </ui:widget-body>
</ui:widget>