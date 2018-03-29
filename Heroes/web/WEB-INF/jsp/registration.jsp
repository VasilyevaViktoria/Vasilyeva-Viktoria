<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@include file="util/styles.jsp"%>
<html>
<head>
    <title>Регистрационное поле</title>
</head>
<body>
<div class="row">
    <aside class="col-md-1"></aside>
    <section class="col-md-5">

        <form method="post" action="${pageContext.request.contextPath}/register-new-user">
            <div class="container">
            </div>

            <div class="form-group">
                Имя:<br>
                <input id="loginreg" type="text" name="loginreg">
            </div><br>

            <div class="form-group">
                Почта:<br>
                <input id="email" type="email" name="email">
            </div><br>

            <div class="form-group">
                Пароль:<br>
                <input id="passreg" type="password" name="passreg">
            </div><br>

            <button type="submit" class="btn btn-default">Зарегистрироватся</button>
        </form>

    </section>
</div>
</body>
</html>
