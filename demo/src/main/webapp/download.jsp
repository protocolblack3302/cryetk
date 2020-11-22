<!--
To change this license header, choose License Headers in Project Properties.
To change this template file, choose Tools | Templates
and open the template in the editor.
-->

<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@ taglib prefix = "c" uri = "http://java.sun.com/jsp/jstl/core" %>


<html>
<head>
    <title>ThankYou</title>
    <meta charset="UTF-8">
    <meta name="viewport" content="width=device-width, initial-scale=1.0">
    <link rel="stylesheet" href="styles/main.css" type="text/css">
</head>
<body>
<h3>songs in album</h3><br>
<table style="border: 5px solid #990000; border-collapse: collapse">

<tr>
            <th>productCode</th>
            <th>download options</th>
        </tr>

        <c:forEach var="i" items="${myList}">
            <tr>
                <%! int j=1; %>
                <td><%=j%></td>
                <td><a href="${i}">download</a></td>

                <%j++;%>
            </tr>
    </c:forEach>

    </table>
    <h2>${message}</h2>



</body>
</html>
