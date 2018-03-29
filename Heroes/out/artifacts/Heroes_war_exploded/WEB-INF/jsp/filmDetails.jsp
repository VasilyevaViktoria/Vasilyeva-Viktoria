<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@include file="util/styles.jsp" %>
<html>
<head>
    <title>Детали фильма</title>
</head>
<body>
<style>
    .bg {
        margin-right: 100px;
        margin-left: 100px;
        background-color: #f7ebf3;
        border-color: #ddd;
        border-width: 1px;
        border-radius: 4px 4px 0 0;
        -webkit-box-shadow: none;
        box-shadow: none;

    }

    .b {
        margin-right: 100px;
        margin-left: 100px;
    }

    .k {
        background-color: #fff;
    }

</style>
<div class="team">

    <div class="container">
        <img src="./img/posters/${requestScope.film.id}poster.jpg" alt="${requestScope.film.name}" width="200"
             height="250" align="left">
        <label>Название:</label>${requestScope.film.name}<br>
        <label>Продолжительность:</label> ${requestScope.film.duration}<br>
        <label>Премьера:</label> ${requestScope.film.premiere}<br>
        <label>Возрастное ограничение:</label> ${requestScope.film.ageLimit}<span>+</span><br>
        <label>Страна:</label> ${requestScope.film.countryName}<br>
        <label>Описание:</label> ${requestScope.film.description}<br>
    </div>

    <br>

    <form  action="${pageContext.request.contextPath}/film-details?id=${requestScope.film.id}" method="post">
        <div class="b">
            <input type="submit" class="btn btn-default btn-s" value="Like!" name="Like!"><%--<span class="glyphicon glyphicon-heart-empty" aria-hidden="true"></span> Like!--%>
            ${requestScope.user.userId}
        </div>
    </form>

    <br>

    <div class="b">
        Рейтинг фильма:
        <br>
        <c:forEach var="i" begin="1" end="${requestScope.rating}">
            <span class="glyphicon glyphicon-star"></span>
        </c:forEach>
    </div>
    <br>
    <br>

    <div class="container">
        <form method="post" action="${pageContext.request.contextPath}/film-details?id=${requestScope.film.id}">
            <div class="container">
            </div>
            <div class="form-group">
                <label for="reviewText">Отзыв</label>
                <textarea id="reviewText" type="text" name="reviewText" class="form-control" rows="3"></textarea>
            </div>
            <div class="form-group">
                <input type="radio" name="review_stars" value="1"> 1
                <input type="radio" name="review_stars" value="2"> 2
                <input type="radio" name="review_stars" value="3"> 3
                <input type="radio" name="review_stars" value="4"> 4
                <input type="radio" name="review_stars" value="5"> 5
                <input type="radio" name="review_stars" value="6"> 6
                <input type="radio" name="review_stars" value="7"> 7
                <input type="radio" name="review_stars" value="8"> 8
                <input type="radio" name="review_stars" value="9"> 9
                <input type="radio" name="review_stars" value="10"> 10
            </div>
            <button type="submit" class="btn btn-default">Оставить отзыв</button>
        </form>
    </div>

    <br>
    <br>

    <div class="bg">
        <c:forEach var="review" items="${requestScope.reviews}">
            <p>${review.user.name} ${review.date}</p>
            <div class="k"><br></div>
            <div class="col-md-2">
                <c:forEach var="i" begin="1" end="${review.stars}">
                    <span class="glyphicon glyphicon-star"></span>
                </c:forEach>
            </div>
            <br>
            <p>${review.comment}</p>
            <br>
            <br>
        </c:forEach>
    </div>
</div>
</body>
</html>
