<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>

<html>
<head>
    <title>Добавить участника в фильм</title>
</head>
<body>
<%@include file="util/styles.jsp" %>
<div class="row">
    <aside class="col-md-1"></aside>
    <section class="col-md-5">

        <form method="post" action="${pageContext.request.contextPath}/add-participant-to-film">
            <div class="form-group">
                <label>
                    <select name="dropdownChoiceFilm">
                        <c:forEach var="films" items="${requestScope.films}">
                            <option value="${films.id}">${films.name}</option>
                        </c:forEach>
                    </select>
                </label>
            </div>

            <%--<label>--%>
            <%--Показать--%>
            <%--<select name="myTable_length" aria-controls="myTable" class="">--%>
            <%--<option value="10">10</option>--%>
            <%--<option value="25">25</option>--%>
            <%--<option value="50">50</option>--%>
            <%--<option value="100">100</option>--%>
            <%--</select> участников</label>--%>

            <%--<div id="myTable_filter" class="dataTables_filter">--%>
            <%--<label>Найти:<input type="search" class="" placeholder="" aria-controls="myTable">--%>
            <%--</label></div>--%>
            <div class="form-group">
                <label>
                    <select multiple rows="10" name="dropdownChoiceParticipant">
                        <c:forEach var="participants" items="${requestScope.participants}">
                            <option value="${participants.id}">${participants.name}</option>
                        </c:forEach>
                    </select>
                </label>
            </div>

            <div class="form-group">
                <label for="career">Роль:</label>
                <input id="career" type="text" name="career" class="form-control">
            </div>

            <button type="submit" class="btn btn-default">Добавить участника</button>
        </form>
    </section>
</div>
</body>
</html>
