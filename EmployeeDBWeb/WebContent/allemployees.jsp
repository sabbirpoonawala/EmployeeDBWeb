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
<table>
<tr>
<th>Employee Id</th><th>First Name</th><th>Last Name</th><th>Email</th><th>PhoneNumber</th><th>Hire Date</th><th>Job Id</th><th>Salary</th><th>Commission Pct</th><th>Manager id</th><th>Department Id</th><th>Update</th><th>Delete</th>
</tr>
<c:forEach items="${allemployeesList}" var="employeesModel">
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
<c:choose>
<c:when test="${employeesModel.managerId==0}">
<td><c:out value="${'No Manager'}"/></td>
</c:when>
<c:otherwise>
<td><c:out value="${employeesModel.managerId}"/></td>
</c:otherwise>
</c:choose>
<td><c:out value="${employeesModel.departmentId}"/></td>

<td>
<form method="post" action="<c:url value="employee?action=updateEmployeeForm&employeeId=${employeesModel.employeeId}"></c:url>">
<input type="submit" value="Update"/>
</form>
</td>
<td>
<form method="post" action="<c:url value="employee?action=deleteEmployee&employeeId=${employeesModel.employeeId}"></c:url>">
<input type="submit" value="Delete"/>
</form>
</td>
</tr>
</c:forEach>
</table>

</body>
</html>