<%--
  Created by IntelliJ IDEA.
  User: 占大帅
  Date: 2017/7/9
  Time: 10:05
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@ page isELIgnored="false" %>
<html>
<head>
    <title>登录页面</title>
</head>
<body>
<h1>user login</h1>
<form action="login" method="post">
    username:<input type="text" name="username"/><p/>
    password:<input type="password" name="password"/><p/>
    <p/>
    ${msg}
    <input type="submit" value="submit">
</form>
</body>
</html>
