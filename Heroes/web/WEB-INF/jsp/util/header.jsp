<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@include file="styles.jsp"%>

<%--<form action="${pageContext.request.contextPath}/language">--%>
    <%--<select class="btn btn-default dropdown-toggle" name="lang" onchange="submit()">--%>
        <%--<option value="en_US" ${sessionScope.language eq 'en_US' ? 'selected' : ''}>English</option>--%>
        <%--<option value="ru_RU" ${sessionScope.language eq 'ru_RU' ? 'selected' : ''}>Русский</option>--%>
    <%--</select>--%>
<%--</form>--%>
<div a>
    <a href="${pageContext.request.contextPath}/language?lang=ru_RU" style="color: black">Rus</a>
    <a href="${pageContext.request.contextPath}/language?lang=en_US"  style="color: black">Eng</a>
</div>

