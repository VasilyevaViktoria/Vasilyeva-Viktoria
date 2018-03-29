<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@include file="util/styles.jsp"%>
<html>
<head>
    <title>Найти фильм</title>
</head>
<body>
<div class="row">
    <aside class="col-md-1"></aside>

    <section class="col-md-5">

        <form method="get" action="${pageContext.request.contextPath}/findFilm">
            <div class="container">
            </div>
            <div class="form-group">
                <label for="namePart">Введите название фильма или его часть:</label>
                <input id="namePart" type="text" name="namePart" class="form-control">
            </div>
            <button type="submit" class="btn btn-default">Найти фильм.</button>
        </form>

    </section>
</div>

<br>

<div class="row">
    <aside class="col-md-1"></aside>
    <section class="col-md-5">

        <form method="get" action="${pageContext.request.contextPath}/findFilm">
            <div class="container">
            </div>
            <div class="form-group">
                <label for="year">Введите год выхода фильма:</label>
                <input id="year" type="number" name="year" class="form-control">
            </div>
            <button type="submit" class="btn btn-default">Найти по году выхода.</button>
        </form>

    </section>
</div>

<br>
<br>

<div class="row">
    <aside class="col-md-7"></aside>
    <section class="col-md-17">
        <div class="container">
        </div>

        <div class="team">
            <div class="row">
                <c:forEach var="film" items="${requestScope.films}">
                    <div class="col col-md-2">
                        <p><a href="${pageContext.request.contextPath}/film-details?id=${film.id}">
                                ${film.name}</a></p>
                            <%--<div class="caption">--%>
                            <%--<h3>${movie.name}</h3>--%>
                            <%--<p>${movie.country}</p>--%>
                            <%--</div>--%>
                    </div>
                </c:forEach>
            </div>
        </div>

    </section>
</div>
</body>
</html>
