<%--
  Created by IntelliJ IDEA.
  User: co
  Date: 09/01/19
  Time: 14.41
  To change this template use File | Settings | File Templates.
--%>
<%@ taglib prefix="s" uri="/struts-tags" %>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <link rel="stylesheet" href="https://stackpath.bootstrapcdn.com/bootstrap/4.2.1/css/bootstrap.min.css"
          integrity="sha384-GJzZqFGwb1QTTN6wy59ffF1BuGJpLSa9DkKMp0DgiMDm4iYMj70gZWKYbI706tWS" crossorigin="anonymous">
    <title>ERROR</title>
</head>
<body>
<h1>Something went wrong</h1>
<s:if test="hasActionErrors()">
    <div class="alert alert-danger" role="alert">
        <s:actionerror/>
    </div>
</s:if>
<p><a href="<s:url action='createActivityPage'/>">Create a new business activity</a></p>
<p><a href="<s:url action='goIndex'/>">Go back to home</a></p>
</body>
</html>
