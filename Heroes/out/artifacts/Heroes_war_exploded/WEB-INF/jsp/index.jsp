<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@include file="util/styles.jsp" %>
<html>
<head>
    <title>Главная страница</title>
</head>
<body>
<style>
    .main {
        word-wrap: break-word;
        overflow: hidden;
        font-size: 12px;
    }
</style>
<div class="row">
    <div class="col-xs-12">
        <c:forEach var="film" items="${requestScope.films}">
            <div class="col-md-3">
                <p><a href="${pageContext.request.contextPath}/film-details?id=${film.id}">
                    <img src="./img/posters/${film.id}poster.jpg" alt="${film.name}" class="img-thumbnail" width="60%"
                         height="auto"></a></p>
                <div class="main" style="height: 100px;">
                        ${film.description}
                </div>
            </div>
        </c:forEach>

    </div>
</div>
</body>
</html>
