<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="ISO-8859-1">
<title>Add Client</title>
</head>
<body>

	<h2>Add a Client</h2>
	<br/>
	<form method = "GET">
		Client Name: <input type = "text" name = "clientName"><br/><br/>
		Origin: <input type = "text" name = "clientOrigin"><br/><br/>
		
		<input type = "submit" value = "Add" />
	</form>
	
	<%
		if (request.getParameter("clientName") != null)
		{
			RequestDispatcher rd = request.getRequestDispatcher("PackfordServlet?action=addClient");
			request.setAttribute("action", "addClient");
			request.setAttribute("clientName", request.getParameter("clientName"));
			request.setAttribute("clientOrigin", request.getParameter("clientOrigin"));
			rd.forward(request, response);
			
		}
	%>

</body>
</html>