package servlet;

import java.io.IOException;
import java.io.PrintWriter;

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
import model.ClientBranch;
import model.ClientDepartment;
import model.ClientEmployee;
import model.Crate;
import model.CrateStatus;
import model.PackfordEmployee;
import model.PackfordEmployeeDepartment;
import model.RequestDetail1;
import model.RequestType;
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
		
		String param_action = request.getParameter("action");
		String tableStr = new String();
		
		switch(param_action) {
		
			//show all clients in table
			case "showAllClients":
			{
				List<Client> clientlist = pfDTO.allClients();
				
				tableStr += "<h2>View all Clients</h2>";
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
			
			//show all client employee in table
			case "showAllClientEmployee":
			{
				List<ClientEmployee> clientemployeelist = pfDTO.allClientEmployees();
				
				tableStr += "<h2>View all Client's Employee</h2>";
				tableStr += "<table border='1'";
				tableStr += "<tr><td>Employee ID</td><td>Client Name</td><td>Branch</td><td>Department</td><td>Employee Name</td><td>Phone Number</td><td>Email</td><td>Address</td></tr>";
				for(int i = 0; i < clientemployeelist.size(); i++)
				{
					tableStr +="<tr><td>" + String.valueOf(clientemployeelist.get(i).getClientEmployeeId()) + 
							"</td><td>" + clientemployeelist.get(i).getClient().getClientName() + 
							"</td><td>" + clientemployeelist.get(i).getClientBranch().getBranchName() + 
							"</td><td>" + clientemployeelist.get(i).getClientDepartment().getDepartmentName() + 
							"</td><td>" + clientemployeelist.get(i).getEmployeeName() + 
							"</td><td>" + clientemployeelist.get(i).getPhone() + 
							"</td><td>" + clientemployeelist.get(i).getEmail() +
							"</td><td>" + clientemployeelist.get(i).getAddress() +"</td><tr>";
				}
				tableStr += "</table>";
			}
			break;
			
			//add client
			case "addClient":
			{
				String name = request.getParameter("clientName");
				String origin = request.getParameter("clientOrigin");
				
				pfDTO.addClient(name, origin);
				
				tableStr += "<br/><strong>Client inserted</strong>";
			}
			break;
			
			//show all crate in table
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
			
			//show all packford employee in table
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
			
			// add packford employee
			case "addPackfordEmployee":
			{
				List<PackfordEmployeeDepartment> PackfordEmployeeDepartmentlist = pfDTO.allPackfordEmployeeDepartment();
				List<Warehouse> Warehouselist = pfDTO.allWarehouses();
				
				HttpSession session = request.getSession();
				session.setAttribute("PackfordEmployeeDepartmentlist", PackfordEmployeeDepartmentlist);
				session.setAttribute("Warehouselist", Warehouselist);
				
				//request dispatcher addPackfordEmployee.jsp
				RequestDispatcher dispatcher = request.getRequestDispatcher("addPackfordEmployee.jsp");
				dispatcher.forward(request, response);
			}
			break;
			
			//add packford employee with parameter inputed from addPackfordEmployee.jsp
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
				
				pfDTO.insertPackfordEmployeeWithDetails(idDepartment, idWarehouse, employeeName, employeePwd, phone, employeeEmail, employeeAddress);

				tableStr += " <br/><strong>Employee is inserted </strong>";
				
			}
			break;
			
			//add client employee
			case "addClientEmployee":
			{
				List<Client> Clientlist = pfDTO.allClient();
				List<ClientBranch> ClientBranchlist =pfDTO.allClientBranch();
				List<ClientDepartment> ClientDepartmentlist = pfDTO.allClientDepartment();
				
				HttpSession session = request.getSession();
				session.setAttribute("Clientlist", Clientlist);
				session.setAttribute("ClientBranchlist", ClientBranchlist);
				session.setAttribute("ClientDepartmentlist", ClientDepartmentlist);
				
				//request dispatcher addClientEmployee.jsp
				RequestDispatcher dispatcher = request.getRequestDispatcher("addClientEmployee.jsp");
				dispatcher.forward(request, response);
				
			}
			break;
			
			//add packford employee with parameter inputed from addClientEmployee.jsp
			case "addClientEmployeewithdetails":
			{
				String cbxClient = request.getParameter("clientId");
				int idClient = Integer.parseInt(cbxClient);
				String cbxClientBranch = request.getParameter("branchId");
				int idClientBranch = Integer.parseInt(cbxClientBranch);
				String cbxClientDepartment = request.getParameter("clientDepartmentId");
				int idClientDepartment = Integer.parseInt(cbxClientDepartment);
				String clientemployeeName = request.getParameter("clientemployeeName");
				String clientemployeePwd = request.getParameter("clientemployeePwd");
				String clientemployeePhone = request.getParameter("clientemployeePhone");
				int phone = Integer.parseInt(clientemployeePhone);
				String clientemployeeEmail = request.getParameter("clientemployeeEmail");
				String clientemployeeAddress = request.getParameter("clientemployeeAddress");
				
				pfDTO.insertClientEmployeeWithDetails(idClient, idClientBranch, idClientDepartment, clientemployeeName, clientemployeePwd, phone, clientemployeeEmail, clientemployeeAddress);
				
				tableStr += " <br/><strong>Client Employee is inserted </strong>";
				
			}
			break;
			
			//add request
			case "addRequest":
			{
				List<Crate> Cratelist = pfDTO.allCrate();
				List<RequestType> RequestTypelist = pfDTO.allRequestType();
				List<ClientBranch>ClientBranchlist = pfDTO.allClientBranch();
				List<ClientEmployee> ClientEmployeelist = pfDTO.allClientEmployee();
				
				HttpSession session = request.getSession();
				session.setAttribute("Cratelist", Cratelist);
				session.setAttribute("RequestTypelist", RequestTypelist);
				session.setAttribute("ClientBranchlist", ClientBranchlist);
				session.setAttribute("ClientEmployeelist", ClientEmployeelist);
				
				//request dispatcher addRequest.jsp
				RequestDispatcher dispatcher = request.getRequestDispatcher("addRequest.jsp");
				dispatcher.forward(request, response);
				
			}
			break;
			
			//add request with parameter inputed from addRequest.jsp
			case "addRequestwithdetails":
			{
				String cbxCrate = request.getParameter("crateId");
				int idCrate = Integer.parseInt(cbxCrate);
				String cbxRequestType = request.getParameter("requestTypeId");
				int idRequestType = Integer.parseInt(cbxRequestType);
				String cbxClientBranch = request.getParameter("branchId");
				int idBranch = Integer.parseInt(cbxClientBranch);
				String cbxClientEmployee = request.getParameter("clientEmployeeId");
				int idClientEmployee = Integer.parseInt(cbxClientEmployee);
				
				pfDTO.insertRequestWithDetails(idCrate, idRequestType, idBranch, idClientEmployee);
				
				tableStr += " <br/><strong>Request is made successfully</strong>";
			}
			break;
			
			//show all request in table
			case "showAllRequests":
			{
				List<RequestDetail1> requestdetaillist = pfDTO.allRequestDetails();
				
				tableStr += "<h1>View all Requests</h1>";
				tableStr += "<table border='1'";
				tableStr += "<tr><td>Request ID</td><td>Crate ID</td><td>Request Type</td><td>Branch Name</td><td>Client Employee</td><td>Request Date and Time</td></tr>";
				for(int i = 0; i < requestdetaillist.size(); i++)
				{
					tableStr +="<tr><td>" + String.valueOf(requestdetaillist.get(i).getRequest1Id()) + 
							"</td><td>" + requestdetaillist.get(i).getCrate().getCrateId() + 
							"</td><td>" + requestdetaillist.get(i).getRequestType().getRequestType() +
							"</td><td>" + requestdetaillist.get(i).getClientBranch().getBranchName() +
							"</td><td>" + requestdetaillist.get(i).getClientEmployee().getEmployeeName() +
							"</td><td>" + requestdetaillist.get(i).getRequestDateTime() +"</td><tr>";
				}
				tableStr += "</table>";
				
			}
			break;
			
			//update crate status 
			case "updateCrateStatus":
			{
				List<Crate> Cratelist = pfDTO.allCrate();
				List<CrateStatus> CrateStatuslist = pfDTO.allCrateStatus();
				 
				HttpSession session = request.getSession();
				session.setAttribute("Cratelist", Cratelist);
				session.setAttribute("CrateStatuslist", CrateStatuslist);
				
				//request dispatcher updateCrateStatus.jsp
				RequestDispatcher dispatcher = request.getRequestDispatcher("updateCrateStatus.jsp");
				dispatcher.forward(request, response);
			}
			break;
			
			//update crate status with parameter inputed from updateCrateStatus.jsp
			case "updateCrateStatusByCrate":
			{
				String cbxCrate = request.getParameter("crateId");
				int idCrate = Integer.parseInt(cbxCrate);
				String cbxCrateStatus = request.getParameter("crateStatusId");
				int idCrateStatus = Integer.parseInt(cbxCrateStatus);
				
				pfDTO.updateCrateStatusByCrate(idCrate, idCrateStatus);
				
				tableStr += " <br/><strong>Updated successfully</strong>";
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
		


	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		String param_action = request.getParameter("action");
		String tableStr = new String();
		
		switch(param_action) {
		//login
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
