<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%--
  Created by IntelliJ IDEA.
  User: maytinhhanoi
  Date: 5/26/2023
  Time: 3:03 AM
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<%@ page import="java.util.*" %>
<%
  String[] cities = {"HaNoi", "Singaproe","London"};

  pageContext.setAttribute("myCities", cities);
%>
<html>
<head>
    <title>Title</title>
</head>
<body>
  <c:forEach var="tempCity" items="${myCities}">

    ${tempCity}<br/>

  </c:forEach>
</body>
</html>
