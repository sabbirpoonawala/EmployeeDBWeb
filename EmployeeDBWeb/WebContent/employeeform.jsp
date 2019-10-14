<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
    <%@include file="taglibs.jsp" %>
<!DOCTYPE html>
<html>
<head>
<meta charset="ISO-8859-1">
<title>Employee Registration</title>
<link href="css/form.css" rel="stylesheet"/>

</head>
<body>
<div align="center">
<form method="post" action="employee?action=newEmployee">
<table>
<tr>
<td><label for="employeeId">Employee Id:</label></td>
<td><input type="number" name="employeeId"/>&nbsp;<label style="color:red"><c:out value="${employeeIderror}"/></label></td>
</tr>

<tr>
<td><label for="firstName">First Name:</label></td>
<td><input type="text" name="firstName"/>&nbsp;<label style="color:red"><c:out value="${firstnameerror}"/></label></td>
</tr>

<tr>
<td><label for="lastName">Last Name:</label></td>
<td><input type="text" name="lastName"/>&nbsp;<label style="color:red"><c:out value="${lastnameerror}"/></label></td>
</tr>

<tr>
<td><label for="email">Email:</label></td>
<td><input type="email" name="email"/>&nbsp;<label style="color:red"><c:out value="${emailerror}"/></label><label style="color:red"><c:out value="${emailexisterror}"/></label></td>
</tr>

<tr>
<td><label for="phoneNumber">Phone Number:</label></td>
<td><input type="text" name="phoneNumber"/></td>
</tr>

<tr>
<td><label for="hireDate">Hire Date:</label></td>
<td><input type="date" name="hireDate"/></td>
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
<td><input type="number" name="salary"/>&nbsp;<label style="color:red"><c:out value="${salaryerror}"/></label></td>
</tr>


<tr>
<td><label for="commissionPCT">Commission PCT:</label></td>
<td><input type="number" name="commissionPCT" step="0.1"/></td>
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
<td><input type="submit" value="Register" class="button"></td>
<td><input type="reset" value="Cancel" class="button"/></td>
</tr>
</table>
</form>
</div>
</body>
</html>