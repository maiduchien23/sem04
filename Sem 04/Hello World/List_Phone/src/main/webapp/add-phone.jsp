<%--
  Created by IntelliJ IDEA.
  User: maytinhhanoi
  Date: 6/19/2023
  Time: 2:32 PM
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<html>
<head>
    <title>Add Phone</title>
    <style>
        body {
            font-family: Arial, sans-serif;
            margin: 0;
            padding: 20px;
        }

        h2 {
            margin-bottom: 20px;
        }

        form {
            width: 400px;
            margin: 0 auto;
        }

        label {
            display: block;
            margin-bottom: 10px;
        }

        input[type="text"],
        input[type="number"],


        select {
            width: 100%;
            padding: 8px;
            border: 1px solid #ccc;
            border-radius: 4px;
        }

        input[type="submit"],
        input[type="reset"] {
            padding: 10px 20px;
            background-color: #4CAF50;
            color: #fff;
            border: none;
            border-radius: 4px;
            cursor: pointer;
        }

        input[type="submit"]:hover,
        input[type="reset"]:hover {
            background-color: #45a049;
        }
    </style>
</head>
<body>
    <h1 style="text-align: center " >Add Phone</h1>

<form method="POST" action="PhoneControllerServlet?command=ADD" >

    <label for="name">Phone name: </label>
    <input type="text" id="name" name="name">
    <br><br>
    <label for="brand">Brand:</label>
    <select name="brand" id="brand" required>
        <option value="Apple">Apple</option>
        <option value="Samsung">Samsung</option>
        <option value="Nokia">Nokia</option>
        <option value="Others">Others</option>
    </select><br><br>

    <label for ="price">Price</label>
    <input type="number" name="price" id="price" min="0" step="0.01" required><br><br>
    <br><br>
    <label for="description">Description:</label><br>
    <input type="text" id="description" name="description">


    <br><br>
    <tr>
        <td><label></label></td>
        <td><input type="submit" value="Create" class="Create"/></td>
    </tr>
    <input type="reset" value="Reset">
    <a class="button" href="PhoneControllerServlet">Cancels</a>
</form>


</body>
</html>
