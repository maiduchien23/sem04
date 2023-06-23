<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>

<!DOCTYPE html>
<html>
<head>

</head>
<body>
<h1>Student Form</h1>
<c:choose>
    <c:when test="${empty student.id}">
        <h1>Create New</h1>
        <form method="POST" action="students?action=create" enctype="multipart/form-data">
            <label for="studentName">Name:</label>
            <input type="text" id="studentName" name="studentName"/>
            <br/><br/>
            <label for="grade">Grade:</label>
            <input type="text" id="grade" name="grade"/>
            <br/><br/>
            <label for="image">Image:</label>
            <input type="file" id="image" name="image">
            <br/><br/>
            <input type="submit" value="Create"/>
            <a class="button" href="students">Cancel</a>
        </form>
    </c:when>
    <c:otherwise>
        <h1>Edit</h1>
        <form method="POST" action="students?action=update" enctype="multipart/form-data">
            <input type="hidden" id="id" name="id" value="${student.id}">
            <label for="studentName">Name :</label>
            <input type="text" id="studentName" name="studentName" value="${student.studentName}">
            <br/><br/>
            <label for="grade">Price :</label>
            <input type="text" id="grade" name="grade" value="${student.grade}">
            <br/><br/>
            <label for="image">Image:</label>
            <input type="file" id="image" name="image">
            <br/><br/>
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