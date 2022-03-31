<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>Profile page (now empty)</title>
    <link rel="stylesheet" href="https://www.w3schools.com/w3css/4/w3.css">
</head>
<body>

<%--TODO add table with sessions, table with pics, button upload, button logout, pic--%>
<%--TODO add this all to user entity--%>
<form method="get" action="profile" >
<%
    if (request.getSession().getAttribute("user") != null) {
        response.getWriter().println("<p>User '" + request.getSession().getAttribute("user") + "' added!</p>");
    } else
        response.getWriter().println("<p>ACCESS DENIED!</p>");

%>
</form>
<h2>VY ZALOGINELIS!</h2>
</body>
</html>




