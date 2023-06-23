<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<html>
<head>
    <title>Title</title>
    <style>

    </style>
</head>
<body>
<h1>Product List</h1>
<a class="button add-button" href="students?action=new">Add New Student</a>
<table>
    <tr>
        <th>ID</th>
        <th>Name</th>
        <th>examScore</th>
        <th>Image</th>
        <th>Action</th>
    </tr>
    <c:forEach var="student" items="${studentList}">
        <tr>
            <td>${student.id}</td>
            <td>${student.name}</td>
            <td>${student.price}</td>
            <td><img src="${student.imageUrl}" alt="Student Image" class="image-container"></td>
            <td>
                <a class="button" href="students?action=edit&id=${student.id}">Edit</a>
                <a class="button" href="students?actio=delete&id=${student.id}"
                   onclick="return confirm('Are you sure want to delete this student?')">Delete</a>
            </td>
        </tr>
    </c:forEach>
</table>
</body>
</html>