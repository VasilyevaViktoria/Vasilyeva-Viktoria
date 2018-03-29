<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@ include file="util/lib-content.jsp" %>
<html>
<head>
    <title>Title</title>
</head>
<body>
<style>
    .v {
        margin: 30px;
        padding: 15px;
        text-align: center;
        background-color: #f7ebf3;
        border-color: #ddd;
        border-width: 1px;
        border-radius: 4px 4px 0 0;
        -webkit-box-shadow: none;
        box-shadow: none;
    }
    #v1{
        padding-bottom: 80px;
    }

    .button {
        margin: 40px;
    }

    .language {
        link: "red";
    }
</style>
<p style="color: white">
    <%@include file="util/header.jsp" %>
</p>

<div class="row">
    <div class="col-xs-6">
        <form method="post" action="${pageContext.request.contextPath}/login">
            <div class="v">
                <label><fmt:message key="login.name"/></label>
            </div>

            <div class="v" id="v1">
                <div class="form-group">
                    <label for="login"><fmt:message key="login.email"/>:</label><br>
                    <input id="login" type="email" name="login">
                </div>

                <div class="form-group">
                    <label for="password"><fmt:message key="login.password"/>:</label><br>
                    <input id="password" type="password" name="password">
                </div>
                <c:if test="${not empty requestScope.errors}">
                    <div style="color: red">
                        <c:forEach var="error" items="${requestScope.errors}">
                            <span>${error}<fmt:message key="login.error"/></span><br>
                        </c:forEach>
                    </div>
                </c:if>
            </div>
            <div class="button">
                <button type="submit" class="btn btn-default"><label><fmt:message key="login.join"/></label></button>
            </div>
        </form>
    </div>
    <div class="col-xs-6">

        <form method="post" action="${pageContext.request.contextPath}/register-new-user">
            <div class="v">
                <label><fmt:message key="registration.name"/></label>
            </div>

            <div class="v">
                <div class="form-group">
                    <label for="loginreg"><fmt:message key="login.username"/>:</label><br>
                    <input id="loginreg" type="text" name="loginreg">
                </div>

                <div class="form-group">
                    <label for="email"><fmt:message key="login.email"/>:</label><br>
                    <input id="email" type="email" name="email">
                </div>

                <div class="form-group">
                    <label for="passreg"><fmt:message key="login.password"/>:</label><br>
                    <input id="passreg" type="password" name="passreg">
                </div>
            </div>

            <div class="button">
                <button type="submit" class="btn btn-default"><label><fmt:message key="register.register"/></label></button>
            </div>
        </form>
    </div>
</div>
</body>
</html>
