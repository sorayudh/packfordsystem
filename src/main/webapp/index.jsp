<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="ISO-8859-1">
<title>Login</title>
</head>
<body>

<div>
	<h1>User Login</h1>
</div>
<form  action="home.jsp" method = "post">
	<table>
		<tr><td>Enter Name:</td><td><input type=text name=txtName></td></tr>
		<tr><td>Enter Password:</td><td><input type=password name=txtPwd></td></tr>
		<tr><td><input type=submit value=login></td></tr>
	</table>

</form>

<%
		if (request.getParameter("txtName") != null && request.getParameter("txtPwd") != null)
		{
			RequestDispatcher rd = request.getRequestDispatcher("PackfordServlet?action=login");
			request.setAttribute("action", "login");
			request.setAttribute("txtName", request.getParameter("txtName"));
			request.setAttribute("txtPwd", request.getParameter("txtPwd"));
			rd.forward(request, response);
			
		}
		
	%>

</body>
</html>