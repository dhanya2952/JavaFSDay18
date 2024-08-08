<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ page isELIgnored="false" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Student view</title>
</head>
<body>
	<h1>Student Details</h1>
	<c:choose>
   
    <c:when test="${test == 'viewAll'}">
         <table>
         <tr>
          <th>Id</th>
          <th>Name</th>
         </tr>
        <c:forEach var="item" items="${list}">
           <tr>
          <td>${item.id}</td>
          <td>${item.name}</td>
         </tr>
                 
        </c:forEach>
        </table>
    </c:when>
    <c:otherwise>
    	<h1>Id: ${list.id}</h1>
        <h1>Name: ${list.name}</h1>
    </c:otherwise>
</c:choose>
</body>
</html>
