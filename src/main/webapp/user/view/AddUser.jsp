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
    <title>Title</title>
</head>
<body>
<h1>Fill form to register into the webapp</h1>

<s:form action="welcome">
    <s:textfield name="email" label="email" value="%{ user.getEmail() }"/>
    <s:textfield name="name" label="name" value="%{ user.getName() }"/>
    <s:textfield name="surname" label="surname" value="%{ user.getSurname() }"/>
    <s:textfield name="dateOfBirth" label="dateOfBirth" value="%{ user.getDateOfBirth() }"/>
    <s:password name="password" label="Password" value="%{ user.getPassword() }" showPassword="true"/>
    <s:radio label="Sex" name="sex"  list="#{true:'Male', false:'Female'}" value="%{ user.isSex() }"/>
    <s:submit/>
</s:form>

</body>
</html>
