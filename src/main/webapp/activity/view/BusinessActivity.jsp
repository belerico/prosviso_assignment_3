<%--
  Created by IntelliJ IDEA.
  User: co
  Date: 07/01/19
  Time: 19.24
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
    <title>Business Activity</title>
</head>
<body>
<h1>Business activity page</h1>
<p><a href="<s:url action='showActivities'/>">Show all business activities</a></p>
<p><a href="<s:url action='createActivityPage'/>">Create a new business activity</a></p>
</body>
</html>