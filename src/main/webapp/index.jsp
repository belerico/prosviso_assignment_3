<%--
  Created by IntelliJ IDEA.
  User: belerico
  Date: 1/3/19
  Time: 2:28 PM
  To change this template use File | Settings | File Templates.
--%>
<!DOCTYPE html>
<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8" %>
<%@ taglib prefix="s" uri="/struts-tags" %>
<html>
<head>
    <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
    <title>Basic Struts 2 Application - Welcome</title>
</head>
<body>
<h1>Welcome To Struts 2!</h1>
<p><a href="<s:url action='user/hello'/>">User</a></p>
<p><a href="<s:url action='user/login'/>">UserLogin</a></p>
<p><a href="<s:url action='businessActivity/business'/>">Business Activity</a></p>
</body>
</html>
