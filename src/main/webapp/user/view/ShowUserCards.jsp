<%--
  Created by IntelliJ IDEA.
  User: co
  Date: 13/01/19
  Time: 2.42
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@ taglib prefix="s" uri="/struts-tags" %>
<html>
<head>
    <%--<link rel="stylesheet" href="/webjars/bootstrap/4.1.0/css/bootstrap.min.css"/>--%>
    <link rel="stylesheet" href="https://stackpath.bootstrapcdn.com/bootstrap/4.2.1/css/bootstrap.min.css"
          integrity="sha384-GJzZqFGwb1QTTN6wy59ffF1BuGJpLSa9DkKMp0DgiMDm4iYMj70gZWKYbI706tWS" crossorigin="anonymous">
    <title>Cards</title>
</head>
<body>
<div>
    <h2><s:property value="'Standard cards of ' + user.name + ' ' + user.surname + ', ' + user.email"/></h2>
    <table class="table">
        <thead>
        <tr>
            <th scope="col">#</th>
            <th scope="col">CardNumber</th>
            <th scope="col">Type</th>
            <th scope="col">Quantity</th>
            <th scope="col">Activity</th>
            <th scope="col">Remove</th>
        </tr>
        </thead>
        <tbody>
        <s:iterator value="userStandardCards" status="userStandardCardsStatus" var="c">
            <tr>
                <td scope="row">
                    <s:property value="#userStandardCardsStatus.index"/>
                </td>
                <td>
                    <s:property value="%{ #c.getStandardCard().getCardNumber() }"/>
                </td>
                <td>
                    <s:if test="%{#c instanceof com.assignment3.jpa.model.SharableCard}">
                        Sharable card
                    </s:if>
                    <s:else>
                        Standard card
                    </s:else>
                </td>
                <td>
                    <s:property value="%{ #c.getStandardCard().getQuantity() }"/>
                </td>
                <td>
                    <a href="<s:url namespace="/activity" action="createActivityPage"><s:param name="activityId" value="%{ #c.getStandardCard().getBusinessActivity().getId() }"/></s:url>"><s:property
                            value="%{ #c.getStandardCard().getBusinessActivity().getName() }"/></a>
                </td>
                <td>
                    <a href="<s:url namespace="/user" action="removeCard"><s:param name="userId" value="user.id"/><s:param name="cardId" value="%{ #c.getStandardCard().getId() }"/></s:url>">Remove</a>
                </td>
            </tr>
        </s:iterator>
        </tbody>
    </table>
    <span><a href="<s:url namespace="/user" action="removeAllCards"><s:param name="userId" value="user.id"/></s:url>">Remove all <s:property
            value="user.name + ' ' + user.surname"/> cards</a></span><br>
    <span><a href="<s:url namespace="/user" action='showUsers'/>">Show users</a></span><br>
    <span><a href="<s:url namespace="/user" action='createUserPage'/>">User page</a></span><br>
    <span><a href="<s:url action='goIndex'/>">Go back to home</a></span>
</div>
</body>
</html>