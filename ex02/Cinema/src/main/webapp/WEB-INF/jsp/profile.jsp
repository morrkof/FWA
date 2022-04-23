<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>Profile</title>
    <link rel="stylesheet" href="https://www.w3schools.com/w3css/4/w3.css">
</head>
<body>
<div class="w3-panel">
    <div class="" align="center">

<%--        <img src="data:<%=session.getAttribute("mimeType")%>;base64,<%=session.getAttribute("image")%>"--%>
<%--             width="100" height="100">--%>
        <form method="post" action="/upload" enctype="multipart/form-data">
            <br>
            <input type="file" name="file">
            <button type="submit">Upload</button>
        </form>



        <h2>
            <c:set var="user" value="${requestScope.user.firstname}"/>
            <c:out value="${requestScope.user.firstname}"/>
            <c:out value="${requestScope.user.lastname}"/>
            <c:out value="${requestScope.user.email}"/>
        </h2>

        <table class="w3-table w3-bordered w3-border w3-centered w3-card" style="width: 30%">
            <thead>
            <tr class="w3-cyan">
                <th>Date</th>
                <th>Time</th>
                <th>IP</th>
            </tr>
            </thead>
            <tbody>
            <c:forEach items="${requestScope.userSessions}" var="sess">
                <tr>
                    <td><c:out value="${sess.date}"/></td>
                    <td><c:out value="${sess.time}"/></td>
                    <td><c:out value="${sess.ip}"/></td>
                </tr>
            </c:forEach>
            </tbody>
        </table>

        <%--TODO add table with sessions, table with pics, button upload, button logout, pic--%>
        <%--TODO add this all to user entity--%>
        <form method="get" action="profile">

        </form>
        <form method="get" action="logout" style="width: 30%">
            <div class="w3-padding" align="center">
                <button type="submit" class="w3-button w3-block w3-section w3-cyan w3-ripple w3-padding">Logout</button>
            </div>
        </form>
    </div>
</div>
</body>
</html>




