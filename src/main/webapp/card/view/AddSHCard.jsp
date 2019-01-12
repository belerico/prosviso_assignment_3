<%--
  Created by IntelliJ IDEA.
  User: co
  Date: 11/01/19
  Time: 15.15
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@ taglib prefix="s" uri="/struts-tags" %>
<%@ taglib prefix="S" uri="/struts-tags" %>
<html>
<head>
    <title>Title</title>
</head>
<body>
<h1>Select a sharable card you want to add to your wallet</h1>
<s:form action="addSHCard">
    <div class="form-group">
        <s:label for="cards" value="Card"/>
        <s:select cssClass="form-control"
                  list="sharableCards"
                  listKey="id"
                  listValue="'Card number: '+cardNumber + ', Slot:' + quantity"
                  name="cardId"/>
        <s:label for="cards" value="Share with user"/>
        <s:select cssClass="form-control"
                  list="usersShare"
                  listKey="id"
                  listValue="'Name: '+ name + ', Surname:' + surname + ' Email: ' + email"
                  name="userShareId"/>
    </div>
    <s:hidden name="userId" value="%{userId}"></s:hidden>
    <s:submit cssClass="btn btn-secondary" label="Add sharable card"/>
</s:form>
</body>
</html>
