<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>

<!DOCTYPE html>
<html>
<head>
</head>
<body>
<h1>Product Form</h1>
<c:choose>
<c:when test="$(empty product.id)">
<form method="POST" action="students?action=create" enctype="multipart/form-data">
    <form method="POST" action="students?action=create">
        <%--@declare id="examscore"--%><label for="name">Name:</label>
        <input type="text" id= "name" name= "name">
        <br><br>
        <label for="examScore">Price: </label>
        <input type="text" id="price" name="examScore">
        <br><br>

        <label for="image">Image:</label>
        <input type="file" id="image" name="image">
        <br><br>

        <input type="submit" value="Create">
        <a class="button" href="students">Cancel</a>
    </form>
    </c:when>
    <c:otherwise>
    <form method= "POST" action="students?action=update" enctype="multipart/form-data">
        <form method="POST" action="students?action=update">
            <input type="hidden" name="id" value="${student.id}">
            <Label for="name">Name:</label>
            <input type="text" id="name" name= "name" value= "${student.name}">
            <br><br>
            <label for="price">Price:</label>
            <input type="text" id="examScore" name="price" value="${student.price}">
            <br><br>

            <label for="image">Image:</label>
            <input type="file" id="image" name="image">
            <br><br>


            <input type="submit" value="Update">
            <a class="button" href="students">Cancel</a>
        </form>
        <form method="POST" action="students?action=delete">
            <input type="hidden" name="id" value="${student.id}">
            <input class="button" type="submit" value="Delete">
        </form>
        </c:otherwise>

        </c:choose>
</body>
</html>