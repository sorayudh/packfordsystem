<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<%@ taglib prefix="fn" uri="http://java.sun.com/jsp/jstl/functions"%>

<%@ page import="model.PackfordEmployeeDepartment" %>
<%@ page import="model.Warehouse" %>
<%@ page import="java.util.List" %>

<!DOCTYPE html>
<html>
<head>
<meta charset="ISO-8859-1">
<title>Add Packford's Employee</title>
</head>
<body>
	
	
	<h2>Add a Packford's Employee</h2>
	<br/>
	<form action="addPackfordEmployee.jsp" method = "GET">
		
		Select Department:&nbsp; <select name="cbxDepartment" style="width: 200px">
			<c:forEach items="${PackfordEmployeeDepartmentlist}" var="department">
				<option value="${department.packfordEmployeeDepartmentId}">${department.departmentName}</option>
			</c:forEach>
		</select>
		<br/><br/>
		Select Warehouse:&nbsp; <select name="cbxWarehouse" style="width: 200px">
			<c:forEach items="${Warehouselist}" var="warehouse">
				<option value="${warehouse.warehouseId}">${warehouse.warehouseLocation}</option>
			</c:forEach>
		</select>
		<br/><br/>
		Employee Name: <input type = "text" name = "employeeName"><br/><br/>
		Password: <input type = "text" name = "employeePwd"><br/><br/>
		Phone Number: <input type = "number" name = "employeePhone"><br/><br/>
		Email: <input type = "text" name = "employeeEmail"><br/><br/>
		Address: <input type = "text" name = "employeeAddress"><br/><br/>
		
		<br/>
		<input type = "submit" value = "Add" />
	</form>
	<%
		if (request.getParameter("cbxDepartment") != null && request.getParameter("cbxWarehouse") != null && request.getParameter("employeeName") != null) {
			response.sendRedirect("PackfordServlet?action=addPackfordEmployeewithdetails" + "&deparmentID=" + 
									request.getParameter("cbxDepartment") + 
									"&warehouseID=" + request.getParameter("cbxWarehouse") +
									"&employeeName=" + request.getParameter("employeeName") +
									"&employeePwd=" + request.getParameter("employeePwd") +
									"&employeePhone=" + request.getParameter("employeePhone") +
									"&employeeEmail=" + request.getParameter("employeeEmail") +
									"&employeeAddress=" + request.getParameter("employeeAddress"));
	}
	%>
	
	<%
	@SuppressWarnings("unchecked")
	List<PackfordEmployeeDepartment>PackfordEmployeeDepartmentlist = (List<PackfordEmployeeDepartment>) session.getAttribute("PackfordEmployeeDepartmentlist");
	List<Warehouse>Warehouselist = (List<Warehouse>) session.getAttribute("Warehouselist");
	
	%>


</body>
</html>