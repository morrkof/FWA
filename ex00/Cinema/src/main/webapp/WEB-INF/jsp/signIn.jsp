<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>Add new user</title>
</head>
<body>
<div>
    <h3>Lets add new user!</h3>
</div>

<div>
    <div>
        <form method="post">
            <label>Email:
                <input type="email" pattern=".*@.*.*" required name="name" style="width: 30%"> <br/>
            </label>

            <label>Password:
                <input type="password" name="pass" style="width: 30%"> <br/>
            </label>
            <button type="submit">Submit</button>
        </form>
    </div>
</div>

<div>
    <button onclick="location.href='/cinema'">Back to main menu</button>
</div>
</body>
</html>
