<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
    <%@include file="taglibs.jsp" %>
<!DOCTYPE html>
<html>
<head>
<meta charset="ISO-8859-1">
<title>Employee Update</title>
<link href="css/form.css" rel="stylesheet"/>

</head>
<body>
<form method="post" action="employee?action=updateEmployee">
<table>
<tr>
<td><label for="employeeId">Employee Id:</label></td>
<td><input type="number" name="employeeId" value="${allemployeesModel.employeeId}" readonly="readonly"/></td>
</tr>

<tr>
<td><label for="firstName">First Name:</label></td>
<td><input type="text" name="firstName" value="${allemployeesModel.firstName}" readonly="readonly"/></td>
</tr>

<tr>
<td><label for="lastName">Last Name:</label></td>
<td><input type="text" name="lastName" value="${allemployeesModel.lastName}" readonly="readonly"/></td>
</tr>

<tr>
<td><label for="email">Email:</label></td>
<td><input type="email" name="email" value="${allemployeesModel.email}"/>&nbsp;<label style="color:red"><c:out value="${emailerror}"/></label><label style="color:red"><c:out value="${emailexisterror}"/></label></td>
</tr>

<tr>
<td><label for="phoneNumber">Phone Number:</label></td>
<td><input type="text" name="phoneNumber" value="${allemployeesModel.phoneNumber}"/></td>
</tr>

<tr>
<td><label for="hireDate">Hire Date:</label></td>
<td><input type="date" name="hireDate" value="${allemployeesModel.hireDate}" readonly="readonly"/></td>
</tr>

<tr>
<td><label for="jobId">Job Title:</label></td>
<td>
<select name="jobId">
<c:forEach items="${jobsList}" var="jobsmodel">
<option value="${jobsmodel.jobId}"><c:out value="${jobsmodel.jobTitle}"/></option>
</c:forEach>
</select>
</td>
</tr>


<tr>
<td><label for="salary">Salary:</label></td>
<td><input type="number" name="salary" value="${allemployeesModel.salary}"/>&nbsp;<label style="color:red"><c:out value="${salaryerror}"/></label></td>
</tr>


<tr>
<td><label for="commissionPCT">Commission PCT:</label></td>
<td><input type="number" name="commissionPCT" step="0.1" value="${allemployeesModel.commissionPCT}"/></td>
</tr>

<tr>
<td><label for="managerId">Manager Name:</label></td>
<td>
<select name="managerId">
<c:forEach items="${managersList}" var="managermodel">
<option value="${managermodel.employeeId}"><c:out value="${managermodel.firstName} ${managermodel.lastName}"/></option>
</c:forEach>
</select>
</td>
</tr>

<tr>
<td><label for="departmentId">Department Name:</label></td>
<td>
<select name="departmentId">
<c:forEach items="${departmentsList}" var="departmentsmodel">
<option value="${departmentsmodel.departmentId}"><c:out value="${departmentsmodel.departmentName}"/></option>
</c:forEach>
</select>
</td>
</tr>


<tr>
<td><input type="submit" value="Update" class="button"></td>
<td><input type="reset" value="Cancel" class="button"/></td>
</tr>



</table>
</form>
</body>
</html>