<%--
  Created by IntelliJ IDEA.
  User: 余
  Date: 2022/11/25
  Time: 19:36
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>注册</title>
</head>
<body>
<form method="post"action="http://localhost:8080/homework_war_exploded/Register">
    用户名：<input type="text" name="name"><br>
    密码：<input type="password" name="password"><br>
    确认密码：<input type="password" name="password2"><br>
    <input type="submit" value="注册">
</form>

</body>
</html>
