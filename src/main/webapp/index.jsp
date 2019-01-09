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
    <link rel="stylesheet" href="https://stackpath.bootstrapcdn.com/bootstrap/4.2.1/css/bootstrap.min.css"
          integrity="sha384-GJzZqFGwb1QTTN6wy59ffF1BuGJpLSa9DkKMp0DgiMDm4iYMj70gZWKYbI706tWS" crossorigin="anonymous">
    <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
    <title>Basic Struts 2 Application - Welcome</title>
</head>
<body>
<h1>Welcome to Card webapp!</h1>
<p><a href="<s:url action='user/userPage'/>">User</a></p>
<p><a href="<s:url action='business/business'/>">Business Activity</a></p>
<p><a href="<s:url action='place/showPlace'/>">Places</a></p>
</body>
</html>
