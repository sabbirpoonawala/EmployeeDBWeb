<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
    <%@include file="taglibs.jsp" %>

<!DOCTYPE html>
<html>
<head>
<meta charset="ISO-8859-1">
<title><c:out value="${operation}"/></title>
<link href="css/style.css" rel="stylesheet"/>
</head>
<body>

<div style="background-color: #CCC;width:100px;height:100px;">
<p align="center"><c:out value="${operation}"/></p>
</div>
<table>
<tr>
<th>Employee Id</th><th>First Name</th><th>Last Name</th><th>Email</th><th>PhoneNumber</th><th>Hire Date</th><th>Job Id</th><th>Salary</th><th>Commission Pct</th><th>Manager id</th><th>Department Id</th>
</tr>
<tr>
<td><c:out value="${employeesModel.employeeId}"/></td>
<td><c:out value="${employeesModel.firstName}"/></td>
<td><c:out value="${employeesModel.lastName}"/></td>
<td><c:out value="${employeesModel.email}"/></td>
<td><c:out value="${employeesModel.phoneNumber}"/></td>
<td><c:out value="${employeesModel.hireDate}"/></td>
<td><c:out value="${employeesModel.jobId}"/></td>
<td><c:out value="${employeesModel.salary}"/></td>
<td><c:out value="${employeesModel.commissionPCT}"/></td>
<td><c:out value="${employeesModel.managerId}"/></td>
<td><c:out value="${employeesModel.departmentId}"/></td>

</tr>
</table>
</body>
</html>