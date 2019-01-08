<%@ taglib prefix="s" uri="/struts-tags" %>
<%--
  Created by IntelliJ IDEA.
  User: belerico
  Date: 1/8/19
  Time: 3:55 PM
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <%--<link rel="stylesheet" href="/webjars/bootstrap/4.1.0/css/bootstrap.min.css"/>--%>
    <link rel="stylesheet" href="https://stackpath.bootstrapcdn.com/bootstrap/4.2.1/css/bootstrap.min.css"
          integrity="sha384-GJzZqFGwb1QTTN6wy59ffF1BuGJpLSa9DkKMp0DgiMDm4iYMj70gZWKYbI706tWS" crossorigin="anonymous">
    <title>Places</title>
</head>
<body>
<h2>Places generated on startup</h2>

<%--<ol>
    <s:iterator value="places">
        <li>
            <s:property value="CAP"/>
            <s:property value="city"/>
            <s:property value="province"/>
            <s:property value="region"/>
        </li>
    </s:iterator>
</ol>--%>

<table class="table">
    <thead>
    <tr>
        <th scope="col">#</th>
        <th scope="col">CAP</th>
        <th scope="col">City</th>
        <th scope="col">Province</th>
        <th scope="col">Region</th>
    </tr>
    </thead>
    <tbody>
    <s:iterator value="places" status="placesStatus">
        <tr>
            <th scope="row">
                <s:property value="#placesStatus.index"/>
                    <%--<s:property value="id"/>--%>
            </th>
            <td>
                <s:property value="CAP"/>
            </td>
            <td>
                <s:property value="city"/>
            </td>
            <td>
                <s:property value="province"/>
            </td>
            <td>
                <s:property value="region"/>
            </td>
            <s:hidden value="%{id}" name="id"/>
        </tr>
    </s:iterator>
    </tbody>
</table>
</body>
</html>
