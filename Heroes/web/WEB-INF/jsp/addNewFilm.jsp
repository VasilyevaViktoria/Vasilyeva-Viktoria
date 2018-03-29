<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<html>
<head>
    <title>Добавление нового фильма</title>
</head>
<body>
<%@include file="util/styles.jsp"%>
<div class="row">
    <aside class="col-md-1"></aside>
    <section class="col-md-7">

        <form method="post" action="${pageContext.request.contextPath}/add-new-film">
            <div class="container">
            </div>
            <div class="form-group">
                <label for="title">Название фильма:</label>
                <input id="title" type="text" name="name" class="form-control">
            </div>
            <div class="form-group">
                <label for="releaseDate">Премьера:</label>
                <input id="releaseDate" type="text" name="releaseDate" class="form-control">
            </div>
            <div class="form-group">
                <label for="duration">Длительность:</label>
                <input id="duration" type="text" name="duration" class="form-control">
            </div>

            <div class="form-group">
                <label for="ageLimit">Возрастное ограничение:</label>
                <input id="ageLimit" type="text" name="ageLimit" class="form-control">
            </div>

            <div class="form-group">
                <label for="description">Описание:</label>
                <input id="description" type="text" name="description" class="form-control">
            </div>

            <div class="form-group">
                <select class="btn btn-default dropdown-toggle" name="country" >
                    <c:forEach var="country" items="${requestScope.countries}">
                        <option value="${country.id}">${country.name}</option>
                    </c:forEach>
                </select>
            </div>
            <br><br><br>

            <button type="submit" class="btn btn-default btn-block">Добавить фильм</button>
        </form>
    </section>
</div>

</body>
</html>
