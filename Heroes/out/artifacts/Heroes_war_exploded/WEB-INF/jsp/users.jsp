<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@include file="util/styles.jsp"%>
<html>
<head>
    <title>Title</title>
</head>
<body>
<div class="row">
    <aside class="col-md-1"></aside>
    <section class="col-md-5">

        <form method="post" action="${pageContext.request.contextPath}/users">
            <div class="form-group">
                <select name="dropdownChoiceUser">
                    <c:forEach var="user" items="${requestScope.users}">
                        <option value="${user.id}">${user.name}</option>
                    </c:forEach>
                </select>
            </div>

            <div class="form-group">
                <select multiple rows="10" name="dropdownChoiceRole">
                    <c:forEach var="role" items="${requestScope.roles}">
                        <option value="${role}">${role}</option>
                    </c:forEach>
                </select>
            </div>

            <button type="submit" class="btn btn-default">Изменить права пользователя</button>
        </form>
    </section>
</div>
</body>
</html>
