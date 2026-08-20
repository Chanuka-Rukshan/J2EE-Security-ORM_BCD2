<%--
  Created by IntelliJ IDEA.
  User: K.A.Chanuka Rukshan
  Date: 8/20/2026
  Time: 12:59 PM
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>Login Page</title>
</head>
<body>

<h1>Login</h1>
<form method="POST" action="${pageContext.request.contextPath}/login">
    <table>
        <tr>
            <th>Username</th>
            <td><input type="text" name="username"/></td>
        </tr>
        <tr>
            <th>Password</th>
            <td><input type="password" name="password"/></td>
        </tr>
        <tr>
            <td></td>
            <td><input type="submit" value="Login"/></td>
        </tr>
    </table>
</form>

</body>
</html>
