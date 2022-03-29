<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="ISO-8859-1">
<title>Home</title>
</head>
<body>

<h2>Welcome to Home Page</h2>

<a href='PackfordServlet?action=showAllClients'>View All Clients</a><br/>
<a href='PackfordServlet?action=showAllClientEmployee'>View All Client's Employees</a><br/>
<a href='PackfordServlet?action=showAllPackfordEmployee'>View All Packford's Employees</a><br/>
<a href='PackfordServlet?action=showAllCrates'>View All Crates</a><br/>
<a href='PackfordServlet?action=showAllRequests'>View All Requests</a><br/>
<a href='addClient.jsp'>Add a Client</a><br/>
<a href='PackfordServlet?action=addClientEmployee'>Add a Client's Employee</a><br/>
<a href='PackfordServlet?action=addPackfordEmployee'>Add a Packford's Employee</a><br/>
<a href='PackfordServlet?action=addRequest'>Add a Request (request a crate)</a><br/>
<a href='PackfordServlet?action=updateCrateStatus'>Update Crate Status (for tracking)</a><br/>



</body>
</html>