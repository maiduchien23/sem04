<%--
  Created by IntelliJ IDEA.
  User: maytinhhanoi
  Date: 6/19/2023
  Time: 2:32 PM
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<html>
<head>
    <title>Phone</title>
    <link type="text/css" rel="stylesheet" href="css/style.css">
    <style>
        .add-phone-button {

            border: solid;
            background-color: green;
            font-style: initial;
            font-family: sans-serif;
            color: white;
            padding: 12px;
            margin-bottom: 0;
            display: inline-block;
            border-radius: 10px;
            text-decoration: none;

        }
        .delete-link{
            border: solid;
            background-color: red;
            font-style: initial;
            font-family: sans-serif;
            color: white;
            padding: 12px;
            margin-bottom: 0;
            display: inline-block;
            border-radius: 10px;
            text-decoration: none;
        }
        .button {
            border: solid;
            background-color: green;
            font-style: initial;
            font-family: sans-serif;
            color: white;
            display: inline-block;
            border-radius: 10px;
            text-decoration: none;
            padding: 10px;
        }

        table{
            width: 100%;
            border-collapse: collapse;
        }
        tr{
            border-bottom: 1px solid grey;
        }
        th {
            text-align: left;
        }
        th,td{
            border-bottom: 1px solid grey;
            padding: 12px;
        }

    </style>

</head>
<body>
<div id="container">
    <div id="content">
        <input type="button" value="Add Phone" onclick="window.location.href='add-phone.jsp';return false;" class="add-phone-button"/>

        <table>
            <tr>
                <th> Name</th>
                <th> Brand</th>
                <th> Price </th>
                <th>Description </th>
                <th>Action</th>
            </tr>
            <c:forEach var="tempPhone" items="${PHONE_LIST}">

                <c:url var="tempLink" value="PhoneControllerServlet">
                    <c:param name="command" value="LOAD"/>
                    <c:param name="id" value="${tempPhone.id}"/>
                </c:url>

                <c:url var="deleteLink" value="PhoneControllerServlet">
                    <c:param name="command" value="DELETE"/>
                    <c:param name="id" value="${tempPhone.id}"/>
                </c:url>

                <tr>
                    <td>${tempPhone.name}</td>
                    <td>${tempPhone.brand}</td>
                    <td>${tempPhone.price}</td>
                    <td>${tempPhone.description }</td>
                    <td>

                        <a href="${deleteLink}" class="delete-link" onclick="if(!(confirm('Are you sure you want to delete this phone ?'))) return false">Delete</a>
                    </td>
                </tr>
            </c:forEach>
        </table>
    </div>
</div>
</body>
</html>
