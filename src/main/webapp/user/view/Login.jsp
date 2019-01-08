<%--
  Created by IntelliJ IDEA.
  User: co
  Date: 08/01/19
  Time: 15.27
  To change this template use File | Settings | File Templates.
--%>
<%@ page language = "java" contentType = "text/html; charset = ISO-8859-1"
         pageEncoding = "ISO-8859-1"%>
<%@ taglib prefix = "s" uri = "/struts-tags"%>
<html>
<head>
    <title>User Login</title>
</head>
<body>
<form action = "loginAction" method = "post">
    <h1>Insert credentials</h1>
    Email:<br/><input type = "text" name = "email"/><br/>
    Password:<br/><input type = "password" name = "password"/><br/>
    <input type = "submit" value = "Login"/>
</form>

</body>
</html>
