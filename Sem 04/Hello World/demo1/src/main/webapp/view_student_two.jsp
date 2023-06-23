<%--
  Created by IntelliJ IDEA.
  User: maytinhhanoi
  Date: 5/24/2023
  Time: 4:35 AM
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<html>
<head>
    <title></title>
    <style>
        table, td, th {
            border: 1px solid;
        }

        table {
            width: 100%;
            border-collapse: collapse;
        }
    </style>
</head>
<body>
<h2>Student Table Demo</h2>

<table>
    <tr>

        <th>First Name</th>
        <th>Last Name</th>
        <th>Email</th>
    </tr>
    <c:forEach var="tempStudent" items="${studentList}">
        <tr>

            <td>${tempStudent.firstName}</td>
            <td>${tempStudent.lastName}</td>
            <td>${tempStudent.email}</td>
        </tr>
    </c:forEach>
</table>
</body>
</html>
