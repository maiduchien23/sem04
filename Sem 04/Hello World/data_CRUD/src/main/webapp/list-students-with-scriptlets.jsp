<%--
  Created by IntelliJ IDEA.
  User: maytinhhanoi
  Date: 6/4/2023
  Time: 6:35 AM
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@ page import="java.util.*" %>
<%@ page import="com.example.data_crud.Student" %>
<html>
<head>
    <title>Student Tracker App</title>
  <link type="text/css" rel="stylesheet" href="/css/style.css">
</head>
<%
  List<Student> theStudents=
          (List<Student>) request.getAttribute("STUDENT_LIST");
%>
<body>
<div id="wrapper">
  <div id="header">
    <h2>CodeLeanAcademy</h2>
  </div>

</div>
<div id="container">
  <div id="content">
    <table>
      <tr>
        <th>First Name</th>
        <th>Last Name</th>
        <th>Email</th>
      </tr>
      <% for (Student tempStudent : theStudents){ %>
      <tr>
        <td> <%= tempStudent.getFirstName() %> </td>
        <td> <%= tempStudent.getLastName() %> </td>
        <td> <%= tempStudent.getEmail() %> </td>
      </tr>
      <% } %>
    </table>
  </div>
</div>
</body>
</html>
