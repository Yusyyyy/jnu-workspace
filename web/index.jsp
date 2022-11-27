<%--
  Created by IntelliJ IDEA.
  User: 余
  Date: 2022/11/25
  Time: 15:25
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
  <head>
    <title>首页</title>
  </head>
  <body>
  <a href ="http://localhost:8080/homework_war_exploded/Register.jsp">注册</a>
  <form method="post"action="http://localhost:8080/homework_war_exploded/Login">
    账号：<input type="text" name="id"><br>
    密码：<input type="password" name="password"><br>
    <input type="submit" value="登录"><input type="url" value="注册" >
  </form>
  </body>
</html>
