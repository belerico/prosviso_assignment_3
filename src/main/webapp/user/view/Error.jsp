<%@ taglib prefix="s" uri="/struts-tags" %>
<%--
  Created by IntelliJ IDEA.
  User: avogadro
  Date: 08/01/19
  Time: 12.34
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <link rel="stylesheet" href="https://stackpath.bootstrapcdn.com/bootstrap/4.2.1/css/bootstrap.min.css"
          integrity="sha384-GJzZqFGwb1QTTN6wy59ffF1BuGJpLSa9DkKMp0DgiMDm4iYMj70gZWKYbI706tWS" crossorigin="anonymous">
    <title>ERROR</title>
    <style>
        .container {
            width: 60%;
            margin-left: auto;
            margin-right: auto;
        }
    </style>
</head>
<body>
<div class="container">
    <h1>Ooops!</h1>
    <s:if test="hasActionErrors()">
        <div class="alert alert-danger" role="alert">
            <s:actionerror/>
        </div>
    </s:if>
    <p><a href="<s:url action='index'/>">Home</a></p>
    <p><a href="<s:url action='createUserPage'/>">Create a new user</a></p>
</div>
</body>
</html>
