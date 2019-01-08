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
<h1>Struts 2 Input Parameter Access Login</h1>

<s:form action="Welcome">
    <s:textfield name="username" label="Username"/>
    <s:password name="password" label="Password"/>
    <s:submit/>
</s:form>

</body>
</html>
