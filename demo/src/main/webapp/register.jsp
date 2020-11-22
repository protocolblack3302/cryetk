<%--
  Created by IntelliJ IDEA.
  User: protocolblack
  Date: 19/11/20
  Time: 7:48 AM
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>WELCOME</title>
    <meta charset="UTF-8">
    <meta name="viewport" content="width=device-width, initial-scale=1.0">
    <link rel="stylesheet" href="styles/main.css" type="text/css"/>
</head>
<body>
<% String msg=(String)request.getAttribute("message");
    String text="JOIN OUR EMAIL LIST";
%>
<h1><%=text%></h1>


<% if(msg!=null){ %>
<p><%=msg%></p>
<% } %>

<form action="download" method="post">

    <input type="hidden" name="action" value="add">
    <label class="pad_top">NAME</label>
    <input type="text" name="name" value="${user.getName()}"><br>
    <label class="pad_top">EMAIL</label>
    <input type="email" name="email" value="${user.getEmail()}"><br>
    <label class="pad_top">AGE</label>
    <input type="number" name="age" value="${user.getAge()}"><br>
    <label>&nbsp;</label>
    <input type="submit" value="Join Now" class="margin_left">
</form>
</body>
</html>
