<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>Profile page (now empty)</title>
    <link rel="stylesheet" href="https://www.w3schools.com/w3css/4/w3.css">
</head>
<body>
<c:out value="Hello"/>
<h2>
    <c:set var="user" value="${requestScope.user.firstname}"/>
    <c:out value="${requestScope.user.firstname}"/>
    <c:out value="${requestScope.user.email}"/>
</h2>

<table>
    <tr>
        <th>"Date"</th>
        <th>"Time"</th>
        <th>"IP"</th>
    </tr>
</table>

<%--TODO add table with sessions, table with pics, button upload, button logout, pic--%>
<%--TODO add this all to user entity--%>
<form method="get" action="profile">

</form>
<h2>VY ZALOGINELIS!</h2>
<form method="get" action="logout" class="w3-container w3-card-4 w3-light-grey w3-text-blue w3-margin"
      style="width: 30%">
    <button type="submit" class="w3-button w3-block w3-section w3-cyan w3-ripple w3-padding">Logout</button>
</form>
</body>
</html>




