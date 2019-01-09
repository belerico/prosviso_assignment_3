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
    <s:form action="createUser">
        <div class="form-group">
            <s:label for="email" value="Email"/>
            <s:textfield cssClass="form-control" name="email" value="%{ email }" requiredLabel="true"/>
        </div>
        <div class="form-group">
            <s:label for="name" value="Name"/>
            <s:textfield cssClass="form-control" name="name" value="%{ name }" requiredLabel="true"/>
        </div>
        <div class="form-group">
            <s:label for="surname" value="Surname"/>
            <s:textfield cssClass="form-control" name="surname" value="%{ surname }" requiredLabel="true"/>
        </div>
        <div class="form-group">
            <s:if test="hasActionErrors()">
                <div class="alert alert-danger" role="alert">
                    <s:actionerror/>
                </div>
            </s:if>
            <s:label for="dateOfBirth" value="Date of birth"/>
            <s:textfield cssClass="form-control" name="dateOfBirth" value="%{ dateOfBirth }" requiredLabel="true"/>
        </div>
        <div class="form-group">
            <s:label for="password" value="Password"/>
            <s:password cssClass="form-control" name="password" value="%{ password }" showPassword="true"
                        requiredLabel="true"/>
        </div>
        <div class="form-group">
            <s:label for="places" value="Place"/>
            <s:select cssClass="form-control"
                      headerKey="-1" headerValue="Select place"
                      list="places"
                      listKey="id"
                      listValue="CAP + ', ' + city"
                      name="placeId"/>
        </div>
        <%--<s:radio label="Sex" name="sex"  list="#{true:'Male', false:'Female'}" value="%{ user.isSex() }"/>--%>
        <s:submit cssClass="btn btn-secondary" label="Register"/>
    </s:form>
</div>
</body>
</html>
