<%--
  Created by IntelliJ IDEA.
  User: avogadro
  Date: 09/01/19
  Time: 21.50
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@ taglib prefix="s" uri="/struts-tags" %>
<html>
<head>
    <%--<link rel="stylesheet" href="/webjars/bootstrap/4.1.0/css/bootstrap.min.css"/>--%>
    <link rel="stylesheet" href="https://stackpath.bootstrapcdn.com/bootstrap/4.2.1/css/bootstrap.min.css"
          integrity="sha384-GJzZqFGwb1QTTN6wy59ffF1BuGJpLSa9DkKMp0DgiMDm4iYMj70gZWKYbI706tWS" crossorigin="anonymous">
    <title>Business Activities</title>
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
    <h2>Business Activities</h2>
    <table class="table">
        <thead>
        <tr>
            <th scope="col">#</th>
            <th scope="col">Name</th>
            <th scope="col">Type</th>
        </tr>
        </thead>
        <tbody>
        <s:iterator value="Cards" status="activitiesStatus">
            <tr>
                <th scope="row">
                    <s:property value="#activitiesStatus.index"/>
                        <%--<s:property value="id"/>--%>
                </th>
                <td>
                    <s:property value="DTYPE"/>
                </td>
                <td>
                    <s:property value="cardNumber"/>
                </td>
                <td>
                    <s:property value="quantity"/>
                </td>
                <s:hidden value="%{id}" name="id"/>
            </tr>
        </s:iterator>
        </tbody>
    </table>
    <p><a href="<s:url action='businessPage'/>">Business Activities</a></p>
</div>
</body>
</html>