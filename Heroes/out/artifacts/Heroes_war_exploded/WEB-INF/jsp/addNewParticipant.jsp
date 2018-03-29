<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>

<html>
<head>
    <title>Добавление нового участника</title>
</head>
<body>
<%@include file="util/styles.jsp"%>
<div class="row">
    <aside class="col-md-1"></aside>
    <section class="col-md-5">

        <form method="post" action="${pageContext.request.contextPath}/add-participant">
            <div class="container">
            </div>
            <div class="form-group">
                <label for="firstName">Имя: </label>
                <input id="firstName" type="text" name="name" class="form-control">
            </div>

            <div class="form-group">
                <label for="dateOfBirth">Дата рождения: </label>
                <input id="dateOfBirth" type="text" name="dateOfBirth" placeholder="yyyy-MM-dd" class="form-control">
            </div>
            <button type="submit" class="btn btn-default btn-block">Добавить</button>
        </form>
    </section>
</div>
</div>
</body>
</html>
