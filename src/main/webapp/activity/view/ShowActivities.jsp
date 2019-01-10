<%--
  Created by IntelliJ IDEA.
  User: co
  Date: 09/01/19
  Time: 14.27
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
</head>
<body>
<div>
    <h2>Business Activities</h2>
    <table class="table">
        <thead>
        <tr>
            <th scope="col">#</th>
            <th scope="col">Name</th>
            <th scope="col">Type</th>
            <th scope="col">Remove</th>
            <th scope="col">Add card</th>
        </tr>
        </thead>
        <tbody>
        <s:iterator value="businessActivities" status="activitiesStatus">
            <tr>
                <th scope="row">
                    <s:property value="#activitiesStatus.index"/>
                        <%--<s:property value="id"/>--%>
                </th>
                <td>
                    <s:property value="name"/>
                </td>
                <td>
                    <s:property value="type"/>
                </td>
                <td>
                    <a href="<s:url namespace="/activity" action='removeActivity'><s:param name="activityId" value="%{id}"></s:param></s:url>">Remove</a>
                </td>
                <td>
                    <a href="<s:url namespace="/activity" action='removeActivity'><s:param name="activityId" value="%{id}"></s:param></s:url>">Add
                        card</a>
                </td>
            </tr>
        </s:iterator>
        </tbody>
    </table>
    <span><a href="<s:url action='createActivityPage'/>">Create a new business activity</a></span><br>
    <span><a href="<s:url action='activityPage'/>">Activity page</a></span><br>
    <span><a href="<s:url action='goIndex'/>">Home</a></span>
</div>
</body>
</html>
