<%@ page import="edu.school21.cinema.models.Image" %>
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

        <c:set var="image" value="${sessionScope.image}"/>

        <img src="images/1/<%=((Image)session.getAttribute("image")).getUniqueName()%>"
             width="300" height="300" class="w3-image w3-round">

        <form method="post" action="/upload" enctype="multipart/form-data" style="width: 30%">
            <br>
            <input type="file" name="file" class="w3-input w3-border">
            <button type="submit" class="w3-button w3-block w3-section w3-cyan w3-ripple w3-padding" style="width: 30%">Upload</button>
        </form>

        <h3>
            <c:set var="user" value="${requestScope.user.firstname}"/>
            <c:out value="${requestScope.user.firstname}"/>
            <c:out value="${requestScope.user.lastname}"/>
            </br>
            <c:out value="${requestScope.user.email}"/>
        </h3>

        <table class="w3-table w3-bordered w3-border w3-centered w3-card" style="width: 50%">
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
                    <td><c:out value="${sess.normalDate}"/></td>
                    <td><c:out value="${sess.normalTime}"/></td>
                    <td><c:out value="${sess.ip}"/></td>
                </tr>
            </c:forEach>
            </tbody>
        </table>

        <table class="w3-table w3-bordered w3-border w3-centered w3-card" style="width: 50%">
            <thead>
            <tr class="w3-cyan">
                <th>File name</th>
                <th>Size</th>
                <th>MIME</th>
                <th>Set as avatar</th>
            </tr>
            </thead>
            <tbody>
            <c:forEach items="${requestScope.userImages}" var="img">
                <tr>
                    <td><c:out value="${img.originalName}"/></td>
                    <td><c:out value="${img.normalSize}"/></td>
                    <td><c:out value="${img.mimetype}"/></td>
                    <td>
                        <form method="post" action="setImage" style="width: 30%">
                        <div class="w3-padding" align="center">
                            <button type="submit" class="w3-button w3-block w3-section w3-cyan w3-ripple w3-padding" value="${img.id}" name="img">set</button>
                        </div>
                    </form>
                    </td>
                </tr>
            </c:forEach>
            </tbody>
        </table>


        <form method="get" action="logout" style="width: 50%">
            <div class="w3-padding" align="center">
                <button type="submit" class="w3-button w3-block w3-section w3-pale-blue w3-ripple w3-padding">Logout</button>
            </div>
        </form>
    </div>
</div>
</body>
</html>




