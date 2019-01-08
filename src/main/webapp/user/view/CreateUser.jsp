<%--
  Created by IntelliJ IDEA.
  User: avogadro
  Date: 08/01/19
  Time: 10.01
  To change this template use File | Settings | File Templates.
--%>
<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8" %>
<%@ taglib prefix="s" uri="/struts-tags" %>
<html>
<head>
    <link rel="stylesheet" href="https://stackpath.bootstrapcdn.com/bootstrap/4.2.1/css/bootstrap.min.css"
          integrity="sha384-GJzZqFGwb1QTTN6wy59ffF1BuGJpLSa9DkKMp0DgiMDm4iYMj70gZWKYbI706tWS" crossorigin="anonymous">
    <title>Create user</title>
</head>
<body>
<h1>Fill form to register into the webapp</h1>
<s:form action="createUser">
    <s:textfield name="email" label="email" value="%{ email }" requiredLabel="true"/>
    <s:textfield name="name" label="name" value="%{ name }" requiredLabel="true"/>
    <s:textfield name="surname" label="surname" value="%{ surname }" requiredLabel="true"/>
    <s:textfield name="dateOfBirth" label="dateOfBirth" value="%{ dateOfBirth }" requiredLabel="true"/>
    <s:password name="password" label="Password" value="%{ password }" showPassword="true" requiredLabel="true"/>
    <%--<s:radio label="Sex" name="sex"  list="#{true:'Male', false:'Female'}" value="%{ user.isSex() }"/>--%>
    <s:submit label="Register"/>
</s:form>
</body>
</html>
