<%@ include file="common-fragments/header.jsp"%>
<%@ include file="common-fragments/navigation.jsp"%>

<div class="container">
<form action="/login" method="post">
    <p>${errorMessage}</p>
    <div class="mb-3">
        <label for="name">User name</label>
        <input type="text" id="name" name="name" class="form-control">
    </div>
    <div class="mb-3">
        <label for="password">Password</label>
        <input type="password" id="password" name="password" class="form-control">
    </div>
    <button type="submit" class="btn btn-primary">Login</button>
</form>
</div>

<%@ include file="common-fragments/footer.jsp" %>