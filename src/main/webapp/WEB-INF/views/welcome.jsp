<%@ include file="common-fragments/header.jsp"%>
<%@ include file="common-fragments/navigation.jsp"%>

<div class="container">
<div class="h1 mt-lg-5"><spring:message code="welcome.caption"/> ${name}</div>
<a class="btn btn-primary" href="/list-todos"><spring:message code="todoButton.caption"/> </a>.

</div>

<%@ include file="common-fragments/footer.jsp" %>
