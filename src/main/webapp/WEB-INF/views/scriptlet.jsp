<%@ page import="java.util.Date" %>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>Yahoo!!! Frm JSP</title>
</head>
<%--Write scriptlet within <% %> to write Java code in JSP, but it's bad practice because is a View which should not show any business logic--%>
<%
Date date = new Date();
%>

<body>

<div>Current date is <%=date%></div>     <%--use scriptlet expression <%=[variable name]%> to place the inline java code--%>
My First JSP ${name}    <%--use the attribute defined in the servlet class using expression lanuage: ${attribute name}--%>

</body>
</html>
