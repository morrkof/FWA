<%@ page import="edu.school21.cinema.models.Image" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>Profile</title>
    <link rel="stylesheet" href="https://www.w3schools.com/w3css/4/w3.css">
</head>

<body>
<div class="w3-panel" style="display:flex;justify-content: center;flex-wrap: wrap">
    <div style="flex: 0 0 20%; padding-right: 10px">
        <img src="images/1/<%=((Image)session.getAttribute("image")).getUniqueName()%>" width="300" height="300"
             class="w3-image w3-round">

        <form method="post" action="/upload" enctype="multipart/form-data">
            <br>
            <input type="file" name="file" class="w3-input">
            <button type="submit" class="w3-button w3-block w3-cyan w3-ripple w3-padding">Upload</button>
        </form>
    </div>

    <div style="flex: 0 0 40%;">
        <h3>
            <c:out value="${requestScope.user.firstname}"/>
            <c:out value="${requestScope.user.lastname}"/>
            </br>
            <c:out value="${requestScope.user.email}"/>
        </h3>

        <table class="w3-table w3-bordered w3-centered w3-card">
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
    </div>

    <table class="w3-table w3-bordered w3-centered w3-card" style="width: 60%">
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
                <td> <a href="<c:out value="${img.filepath}"/>"><c:out value="${img.originalName}"/> </a></td>
                <td><c:out value="${img.normalSize}"/></td>
                <td><c:out value="${img.mimetype}"/></td>
                <td>
                    <form method="post" action="setImage">
                        <div class="w3-padding" align="center">
                            <button type="submit"
                                    class="w3-button w3-block w3-cyan w3-ripple"
                                    value="${img.id}" name="img">set
                            </button>
                        </div>
                    </form>
                </td>
            </tr>
        </c:forEach>
        </tbody>
    </table>

    <form method="get" action="logout" style="width: 60%">
        <div class="w3-padding">
            <button type="submit" class="w3-button w3-block w3-section w3-pale-blue w3-ripple w3-padding">
                Logout
            </button>
        </div>
    </form>
</div>
</body>
</html>




