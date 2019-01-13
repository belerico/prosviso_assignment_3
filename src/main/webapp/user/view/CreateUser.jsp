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
    <style>
        .container {
            width: 60%;
            margin-left: auto;
            margin-right: auto;
        }
    </style>
    <s:head/>
</head>
<body>
<div class="container">
    <h1>Fill form to register into the webapp</h1>
    <s:form namespace="/user" action="%{ userId == null ? 'createUser' : 'updateUser' }">
        <s:fielderror cssClass="alert alert-danger">
            <s:param>user.email</s:param>
            <s:param>user.name</s:param>
            <s:param>user.surname</s:param>
            <s:param>user.dateOfBirth</s:param>
            <s:param>user.password</s:param>
        </s:fielderror>
        <div class="form-group">
            <s:label for="email" value="Email"/>
            <s:textfield cssClass="form-control" name="user.email" value="%{ user.email }" requiredLabel="true"/>
        </div>
        <div class="form-group">
            <s:label for="name" value="Name"/>
            <s:textfield cssClass="form-control" name="user.name" value="%{ user.name }" requiredLabel="true"/>
        </div>
        <div class="form-group">
            <s:label for="surname" value="Surname"/>
            <s:textfield cssClass="form-control" name="user.surname" value="%{ user.surname }" requiredLabel="true"/>
        </div>
        <div class="form-group">
            <s:label for="user.dateOfBirth" value="Date of birth"/>
            <s:textfield cssClass="form-control" name="user.dateOfBirth" value="%{ user.dateOfBirth }"
                         requiredLabel="true"/>
        </div>
        <div class="form-group">
            <s:label for="password" value="Password"/>
            <s:password cssClass="form-control" name="user.password" value="%{ user.password }" showPassword="true"
                        requiredLabel="true"/>
        </div>
        <div class="form-group">
            <s:label for="places" value="Place"/>
            <s:select cssClass="form-control"
                      list="places"
                      listKey="id"
                      listValue="CAP + ', ' + city"
                      name="placeId"
                      requiredLabel="true"/>
        </div>
        <div class="form-group">
            <s:label for="sex" value="Gender"/>
            <s:select cssClass="form-control"
                      list="#{true:'Male', false:'Female'}"
                      name="user.sex"
                      value="sex"
                      requiredLabel="true"/>
        </div>
        <s:if test="%{ userId != null }">
            <s:hidden name="userId" value="%{ userId }"></s:hidden>
        </s:if>
        <s:submit cssClass="btn btn-secondary" label="Create user"/>
    </s:form>
    <span><a href="<s:url action='showUsers'/>">Show all users</a></span><br>
    <span><a href="<s:url action='userPage'/>">User page</a></span><br>
    <span><a href="<s:url namespace="/home" action='goIndex'/>">Go back to home</a></span>
</div>
</body>
</html>
