<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>Добавить в избранное</title>
</head>
<body>
<div class="container">
    <label>Название:</label>${requestScope.film.name}<br>
    <label>Продолжительность:</label> ${requestScope.film.duration}<br>
    <label>Премьера:</label> ${requestScope.film.premiere}<br>
    <label>Возрастное ограничение:</label> ${requestScope.film.ageLimit}<span>+</span><br>
    <label>Страна:</label> ${requestScope.film.countryName}<br>
    <label>Описание:</label> ${requestScope.film.description}<br>
</div>

</body>
</html>
