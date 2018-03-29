<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<html>
<head>
    <title>Title</title>
</head>
<body>
<%@include file="util/styles.jsp" %>
<style>
    .main {
        word-wrap: break-word;
        overflow: hidden;
    }
</style>
<div>
    <div class="team">
        <div class="row">
            <c:forEach items="${requestScope.films}" var="film">
                <div class="col col-md-2">
                    <p values="${film.id}">
                    <div class="paragraphs">
                        <div class="row">
                            <div class="span4">
                                <div class="clearfix content-heading">
                                    <a href="${pageContext.request.contextPath}/film-details?id=${film.id}">${film.name}</a>
                                        <img src="./img/posters/${film.id}poster.jpg" alt="${film.name}" width="200" height="300">
                                        <div class="main" style="height: 145px;">
                                                ${film.description}
                                        </div>
                                </div>
                            </div>
                        </div>
                    </div>
                    </p>

                </div>
            </c:forEach>
        </div>
    </div>
</body>
</html>
