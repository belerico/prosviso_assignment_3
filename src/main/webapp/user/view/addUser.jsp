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
    <s:textfield name="email" label="email" />
    <s:textfield name="name" label="name" />
    <s:textfield name="surname" label="surname" />
    <s:date name="current" format="YYYY-MM-DD"/>
    <s:textfield name="username" label="Username"/>
    <s:password name="password" label="Password"/>
    <s:radio label="gender" name="yourAnswer" list="#{'1':'M','2':'F'}"  />
    <s:submit/>
</s:form>

</body>
</html>
