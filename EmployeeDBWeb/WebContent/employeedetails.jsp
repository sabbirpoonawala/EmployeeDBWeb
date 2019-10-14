<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
    <%@include file="taglibs.jsp" %>
<!DOCTYPE html>
<html>
<head>
<meta charset="ISO-8859-1">
<title>Insert title here</title>
<link href="css/style.css" rel="stylesheet"/>
</head>
<body>
<h2 align="center">Employees Contact Details</h2>
<div align="center">
<table>
<tr>
<th>Employee Id</th><th>Full Name</th><th>Contact Details</th>
</tr>

<c:forEach items="${employeesModelList}" var="employeesmodel">
<tr>
<td><c:out value="${employeesmodel.employeeId}"/></td>
<td><c:out value="${employeesmodel.fullName}"/></td>
<td><c:out value="${employeesmodel.contactDetails}"/></td>
</tr>
</c:forEach>
</table>
</div>
</body>
</html>