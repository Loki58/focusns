<%@page contentType="text/html" pageEncoding="UTF-8" %>
<%@taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@taglib prefix="l" tagdir="/WEB-INF/tags/layout" %>
<%@include file="position.jsp" %>

<!DOCTYPE html>
<html lang="zh">
<head>
    <meta charset="utf-8">
    <title>FocusSNS</title>
    <meta name="description" content="">
    <meta name="keywords" content="">
    <%@include file="stylesheet.jsp"%>
</head>

<body>

<div class="navbar navbar-inverse navbar-fixed-top">
    <div class="navbar-inner">
        <div class="container">
            <button type="button" class="btn btn-navbar" data-toggle="collapse" data-target=".nav-collapse">
                <span class="icon-bar"></span>
                <span class="icon-bar"></span>
                <span class="icon-bar"></span>
            </button>
            <a class="brand" href='<c:url value="/" />'>FocusSNS</a>
            <div class="nav-collapse collapse">
                <l:positionRender name="headerBar" />
            </div><!--/.nav-collapse -->
        </div>
    </div>
</div>

<div id="doc-bd">
    <div class="container">
        <div class="row">
            <l:positionExists name="leftColumn">
            <div class="${leftColumnClass}">
                <l:positionRender name="leftColumn" />
            </div>
            </l:positionExists>
            <l:positionExists name="mainColumn">
                <div class="${mainColumnClass}">
                    <l:positionRender name="mainColumn" />
                </div>
            </l:positionExists>
            <l:positionExists name="rightColumn">
                <div class="${rightColumnClass}">
                    <l:positionRender name="rightColumn" />
                </div>
            </l:positionExists>
        </div>
    </div>
</div>

<div id="doc-ft">
    <div class="container">
        <p>&copy; FocusSNS 2011~2013</p>
    </div>
</div>
<%@include file="javascript.jsp" %>
</body>
</html>
