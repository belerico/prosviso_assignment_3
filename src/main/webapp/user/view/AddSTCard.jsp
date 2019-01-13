<%--
  Created by IntelliJ IDEA.
  User: co
  Date: 11/01/19
  Time: 15.14
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@ taglib prefix="s" uri="/struts-tags" %>
<html>
<head>
    <title>Subscribe to a standard card</title>
</head>
<body>
<div class="container">
    <h1>Select a standard card you want to add to your wallet</h1>
    <s:form action="addSTCard">
    <div class="form-group">
        <s:label for="cards" value="Card"/>
        <s:select cssClass="form-control"
                  list="standardCards"
                  listKey="id"
                  listValue="'Card number: '+cardNumber + ', Slot:' + quantity"
                  name="cardId"/>
    </div>
        <s:hidden name="userId" value="%{userId}"></s:hidden>
        <s:submit cssClass="btn btn-secondary" label="Create activity"/>
    </s:form>

</body>
</html>
