<%@ include file="common-fragments/header.jsp"%>
<%@ include file="common-fragments/navigation.jsp"%>

<div class="container">
<div class="h1 mt-lg-5">Hi ${name} <br></div>
<%--    todo.caption is defined in messages.properties files--%>
    <caption><p class="h2  mb-lg-3"><spring:message code="todo.caption"/></p></caption>

    <table class="table table-striped">


        <thead>
        <tr>
            <th>Description</th>
            <th>Date</th>
            <th>Completed</th>
        </tr>
        </thead>

    <tbody>
    <%--Like a advanced for-loop using jstl tag--%>
    <c:forEach items="${todos}" var="todo">
        <tr>
            <td>${todo.desc}</td>
            <td><fmt:formatDate pattern="dd/MM/yyyy" value="${todo.targetDate}" /></td>
            <td>${todo.done}</td>
            <td><a href="/update-todo?id=${todo.id}" class="btn btn-success">Update</a></td>
            <td><a href="/delete-todo?id=${todo.id}" class="btn btn-danger">Delete</a></td>
        </tr>
    </c:forEach>
    </tbody>
</table>
<div>
<a href="/add-todo" class="btn btn-primary">Add</a>
</div>
</div>

<%@ include file="common-fragments/footer.jsp" %>
