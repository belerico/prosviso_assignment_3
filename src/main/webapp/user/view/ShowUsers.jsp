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
    <title>Users</title>
    <style>
        .container {
            width: 70%;
            margin-left: auto;
            margin-right: auto;
        }
    </style>
</head>
<body>
<div class="container">
    <h2>Users</h2>
    <table class="table">
        <thead>
        <tr>
            <th scope="col">#</th>
            <th scope="col">Name</th>
            <th scope="col">Surname</th>
            <th scope="col">Date of birth</th>
            <th scope="col">Email</th>
            <th scope="col">Place</th>
            <th scope="col">Gender</th>
            <th scope="col">Add card</th>
            <th scope="col">Remove</th>
        </tr>
        </thead>
        <tbody>
        <s:iterator value="users" status="usersStatus">
            <tr>
                <th scope="row">
                    <s:property value="#usersStatus.index"/>
                        <%--<s:property value="id"/>--%>
                </th>
                <td>
                    <s:property value="name"/>
                </td>
                <td>
                    <s:property value="surname"/>
                </td>
                <td>
                    <s:date name="dateOfBirth" format="MM/dd/yy"/>
                        <%--<s:property value="dateOfBirth"/>--%>
                </td>
                <td>
                    <s:property value="email"/>
                </td>
                <td>
                    <s:property value="place.CAP + ', ' + place.city"/>
                </td>
                <td>
                    <s:if test="sex">
                        Male
                    </s:if>
                    <s:else>
                        Female
                    </s:else>
                </td>
                <td>
                    <a href="<s:url namespace="/user" action='removeUser'><s:param name="userId" value="%{id}"></s:param></s:url>">Remove</a>
                </td>
                <td>
                    <a href="<s:url namespace="/user" action='removeUser'><s:param name="userId" value="%{id}"></s:param></s:url>">Add
                        card</a>
                </td>
                    <%--<s:hidden value="" name="userId"/>--%>
            </tr>
        </s:iterator>
        </tbody>
    </table>
    <p><a href="<s:url action='userPage'/>">User</a></p>
    <p><a href="<s:url action='goIndex'/>">Go back to home</a></p>
</div>
</body>
</html>