<%--
  Created by IntelliJ IDEA.
  User: maytinhhanoi
  Date: 5/31/2023
  Time: 4:15 AM
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>Title</title>
</head>
<body>
<h1>Student detail</h1>
<form>
    <p>ID : ${student.id}</p>
    <p>Student Name : ${student.studentName}</p>
    <p>Exam Score : ${student.grade}</p>
    <img src="${student.imageUrl}" alt="Image Student">
</form>
</body>
</html>
