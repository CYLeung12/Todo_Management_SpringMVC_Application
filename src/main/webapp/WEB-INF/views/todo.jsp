<%@ include file="common-fragments/header.jsp"%>
<%@ include file="common-fragments/navigation.jsp"%>

<div class="container">
<h1>Add a Todo</h1>

<%--    Use Sprint tap form:form for form-binding which take form elements to a bean, use commandName to specify the name of the object you want to bind--%>
<%--    commandName must set as class name with lowercase, or the hibernate validation would not work--%>
<form:form method="post" commandName="todo">
    <p>${errorMessage}</p>
<%--    Store id on the form as hidden values, so the value will be the same after updating the todo.
It is not prefered to put value as hidden on form (esp username), as users can change the value from front-end creatging security issue--%>
    <form:hidden path="id"/>

    <div class="mb-3">
        <form:label path="desc" for="desc">Description</form:label>    <%-- path tag is the attribute name of the object--%>
        <form:input path="desc" type="text" id="desc" class="form-control" required="required"/>    <%--Path to property for data binding--%>
        <form:errors path="desc"  cssClass="text-warning"/>   <%--Path to errors object for data binding--%>
    </div>
    <div class="mb-3">
        <form:label path="targetDate" for="targetDate">Target Date</form:label>    <%-- path tag is the attribute name of the object--%>
        <form:input path="targetDate" type="text" id="targetDate" class="form-control" required="required"/>    <%--Path to property for data binding--%>
        <form:errors path="targetDate"  cssClass="text-warning"/>   <%--Path to errors object for data binding--%>
    </div>
    <button type="submit" class="btn btn-success">Submit</button>


</form:form>
</div>

<%@ include file="common-fragments/footer.jsp" %>