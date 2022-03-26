package servlet;

import java.io.IOException;
import java.io.PrintWriter;
import java.sql.Connection;
import java.sql.Date;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.List;

import javax.ejb.EJB;
import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import dao.PackfordDTO;
import model.Client;
import model.Crate;
import model.PackfordEmployee;
import model.PackfordEmployeeDepartment;
import model.Warehouse;


/**
 * Servlet implementation class PackfordServlet
 */
@WebServlet("/PackfordServlet")
public class PackfordServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
	
	
	@EJB
	private PackfordDTO pfDTO;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public PackfordServlet() {
        super();
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		//response.getWriter().append("Served at: ").append(request.getContextPath());
		
		String param_action = request.getParameter("action");
		String tableStr = new String();
		
		switch(param_action) {
			case "showAllClients":
			{
				List<Client> clientlist = pfDTO.allClients();
				
				tableStr += "<table border='1'";
				tableStr += "<tr><td>Client ID</td><td>Client Name</td><td>Origin</td></tr>";
				for(int i = 0; i < clientlist.size(); i++)
				{
					tableStr +="<tr><td>" + String.valueOf(clientlist.get(i).getClientId()) + 
							"</td><td>" + clientlist.get(i).getClientName() + 
							"</td><td>" + clientlist.get(i).getOrigin() +"</td><tr>";
				}
				tableStr += "</table>";
			}
			break;
			case "addClient":
			{
				String name = request.getParameter("clientName");
				String origin = request.getParameter("clientOrigin");
				
				pfDTO.addClient(name, origin);
				
				tableStr += "<br/><strong>Client inserted</strong>";
			}
			break;
			case "showAllCrates":
			{
				List<Crate> cratelist = pfDTO.allCrates();
				
				tableStr += "<h1>View all Crates</h1>";
				tableStr += "<table border='1'";
				tableStr += "<tr><td>Crate ID</td><td>Client </td><td>Crate Status</td><td>Content Type</td><td>Warehouse Location</td><td>Shelf</td></tr>";
				for(int i = 0; i < cratelist.size(); i++)
				{
					tableStr +="<tr><td>" + String.valueOf(cratelist.get(i).getCrateId()) + 
							"</td><td>" + cratelist.get(i).getClient().getClientName() + 
							"</td><td>" + cratelist.get(i).getCrateStatus().getCrateStatus() +
							"</td><td>" + cratelist.get(i).getCrateContentType().getContentName() +
							"</td><td>" + cratelist.get(i).getWarehouse().getWarehouseLocation() +
							"</td><td>" + cratelist.get(i).getShelf() +"</td><tr>";
				}
				tableStr += "</table>";
			}
			break;
			case "showAllPackfordEmployee":
			{
				List<PackfordEmployee> packfordemployeelist = pfDTO.allPackfordEmployee();
				
				tableStr += "<h1>View all Packford's Employees</h1>";
				tableStr += "<table border='1'";
				tableStr += "<tr><td>Employee ID</td><td>Warehouse </td><td>Department</td><td>Employee Name</td><td>Phone Number</td><td>Email</td><td>Address</td></tr>";
				for(int i = 0; i < packfordemployeelist.size(); i++)
				{
					tableStr +="<tr><td>" + String.valueOf(packfordemployeelist.get(i).getPackfordEmployeeId()) + 
							"</td><td>" + packfordemployeelist.get(i).getWarehouse().getWarehouseLocation() + 
							"</td><td>" + packfordemployeelist.get(i).getPackfordEmployeeDepartment().getDepartmentName() +
							"</td><td>" + packfordemployeelist.get(i).getEmployeeName() +
							"</td><td>" + packfordemployeelist.get(i).getPhone() +
							"</td><td>" + packfordemployeelist.get(i).getEmail() +
							"</td><td>" + packfordemployeelist.get(i).getAddress() +"</td><tr>";
				}
				tableStr += "</table>";
				
			}
			break;
			case "addPackfordEmployee":
			{
				List<PackfordEmployeeDepartment> PackfordEmployeeDepartmentlist = pfDTO.allPackfordEmployeeDepartment();
				List<Warehouse> Warehouselist = pfDTO.allWarehouses();
				
				HttpSession session = request.getSession();
				session.setAttribute("PackfordEmployeeDepartmentlist", PackfordEmployeeDepartmentlist);
				session.setAttribute("Warehouselist", Warehouselist);
				
				RequestDispatcher dispatcher = request.getRequestDispatcher("addPackfordEmployee.jsp");
				dispatcher.forward(request, response);
			}
			break;
			case "addPackfordEmployeewithdetails":
			{
				
				String cbxDepartment = request.getParameter("deparmentID");
				int idDepartment = Integer.parseInt(cbxDepartment);
				String cbxWarehouse = request.getParameter("warehouseID");
				int idWarehouse = Integer.parseInt(cbxWarehouse);
				String employeeName = request.getParameter("employeeName");
				String employeePwd = request.getParameter("employeePwd");
				String employeePhone = request.getParameter("employeePhone");
				int phone = Integer.parseInt(employeePhone);
				String employeeEmail = request.getParameter("employeeEmail");
				String employeeAddress = request.getParameter("employeeAddress");
				
				pfDTO.insertBookWithDetails(idDepartment, idWarehouse, employeeName, employeePwd, phone, employeeEmail, employeeAddress);

				tableStr += " <br/><strong>Employee is inserted </strong>";
				
			}
			
			
			default:
				
				break;
				
		}
		
		response.setContentType("text/html;charset=UTF-8");
		
		PrintWriter out = response.getWriter();
		out.println("<html>");
		out.println("<head>");
		out.println("<title> Packford System </title>");
		out.println("</head>");
		
		out.println("<body>");
		out.println(tableStr);
		out.println("</body>");
		out.println("</html>");
		out.close();
		
		
	}
		


	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		String param_action = request.getParameter("action");
		String tableStr = new String();
		
		switch(param_action) {
		case "login":
		{
			String username = request.getParameter("txtName");
			String password = request.getParameter("txtPwd");
			Boolean output = pfDTO.checkUser(username, password);
			if(output) {
				RequestDispatcher dispatcher = request.getRequestDispatcher("home.jsp");
				dispatcher.forward(request, response);
			}
			else {
				tableStr += "<br/><strong>Please check username and password</strong>";
			}
			
		}
		break;
		
		default:
			
			break;
		}
		
		response.setContentType("text/html;charset=UTF-8");
		
		PrintWriter out = response.getWriter();
		out.println("<html>");
		out.println("<head>");
		out.println("<title> Packford System </title>");
		out.println("</head>");
		
		out.println("<body>");
		out.println(tableStr);
		out.println("</body>");
		out.println("</html>");
		out.close();
		
	}

}
