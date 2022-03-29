package dao;


import java.util.ArrayList;
import java.util.Date;
import java.util.List;

import javax.ejb.LocalBean;
import javax.ejb.Stateless;
import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;


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
 * Session Bean implementation class PackfordDTO
 */
@Stateless
@LocalBean
public class PackfordDTO {
	
	@PersistenceContext(unitName="PackfordSystem")
	EntityManager em;
	
	
	

    /**
     * Default constructor. 
     */
    public PackfordDTO() {
        // TODO Auto-generated constructor stub
    }
    
    //list client data from Client class
    public List<Client> allClients(){
    	List queryResults = em.createQuery("SELECT c FROM Client c").getResultList();
    	List<Client> listResult = new ArrayList<Client>();
    	
    	for(int i = 0; i < queryResults.size(); i++)
    	{
    		Client c = new Client();
    		c = (Client)queryResults.get(i);
    		listResult.add(c);
    	}
    	
    	return listResult;
    }
    
    //list client employee data from ClientEmployee class
    public List<ClientEmployee> allClientEmployees(){
    	List queryResults = em.createQuery("SELECT c FROM ClientEmployee c").getResultList();
    	List<ClientEmployee> listResult = new ArrayList<ClientEmployee>();
    
    	for(int i = 0; i < queryResults.size(); i++)
    	{
    		ClientEmployee c = new ClientEmployee();
    		c = (ClientEmployee)queryResults.get(i);
    		listResult.add(c);
    	}
    	
    	return listResult;
    }
    
    //add new client by name and origin
    public void addClient(String name, String origin)
    {
    	Client c = new Client();
    	c.setClientName(name);
    	c.setOrigin(origin);
    	
    	em.persist(c);
    }
    
    //list packford employee department data from PackfordEmployeeDepartment class
    public List<PackfordEmployeeDepartment> allPackfordEmployeeDepartment()
    {
    	List<PackfordEmployeeDepartment> listPackfordEmployeeDepartment = em.createNamedQuery("PackfordEmployeeDepartment.findAll", PackfordEmployeeDepartment.class).getResultList();
    	return listPackfordEmployeeDepartment;
    }
    
    //list warehouse data form Warehouse class
    public List<Warehouse> allWarehouses()
    {
    	List<Warehouse> listWarehouse = em.createNamedQuery("Warehouse.findAll", Warehouse.class).getResultList();
    	return listWarehouse;
    }
    
    //add a new packford employee to the system with department, warehouse, name, password, phone, email, address
    public void insertPackfordEmployeeWithDetails(int idDepartment, int idWarehouse, String employeeName, String employeePwd,int phone, String employeeEmail, String employeeAddress)
    {
    	PackfordEmployeeDepartment a = em.find(PackfordEmployeeDepartment.class, idDepartment);
    	
    	Warehouse w = em.find(Warehouse.class, idWarehouse);
    	
    	
    	PackfordEmployee c = new PackfordEmployee();
    	c.setEmployeeName(employeeName);
    	c.setPassword(employeePwd);
    	c.setPhone(phone);
    	c.setEmail(employeeEmail);
    	c.setAddress(employeeAddress);
    	
    	c.setPackfordEmployeeDepartment(a);
    	c.setWarehouse(w);
    	
    	em.persist(c);
    }
    
    //add a new client employee to the system with client, branch, department, name, password, phone, email, address
    public void insertClientEmployeeWithDetails(int idClient, int idClientBranch, int idClientDepartment, String clientemployeeName, String clientemployeePwd, int phone, String clientemployeeEmail, String clientemployeeAddress)
    {
    	Client c = em.find(Client.class, idClient);
    	
    	ClientBranch b = em.find(ClientBranch.class, idClientBranch);
    	
    	ClientDepartment d = em.find(ClientDepartment.class, idClientDepartment);
    	
    	ClientEmployee e = new ClientEmployee();
    	e.setEmployeeName(clientemployeeName);
    	e.setPassword(clientemployeePwd);
    	e.setPhone(phone);
    	e.setEmail(clientemployeeEmail);
    	e.setAddress(clientemployeeAddress);
    	
    	e.setClient(c);
    	e.setClientBranch(b);
    	e.setClientDepartment(d);
    	
    	em.persist(e);
    	
    }
    
    //add new request to the system with crate, request type, branch, client employee
    public void insertRequestWithDetails(int idCrate, int idRequestType, int idBranch, int idClientEmployee)
    {
    	Crate c = em.find(Crate.class, idCrate);
    	RequestType t = em.find(RequestType.class, idRequestType);
    	ClientBranch b = em.find(ClientBranch.class, idBranch);
    	ClientEmployee e = em.find(ClientEmployee.class, idClientEmployee);
    	
    	
    	RequestDetail1 r = new RequestDetail1();
    	r.setRequestDateTime(new Date());
    	r.setCrate(c);
    	r.setRequestType(t);
    	r.setClientBranch(b);
    	r.setClientEmployee(e);
    	
    	em.persist(r);
    }
    
    //update crate status for crate tracking
    public void updateCrateStatusByCrate(int idCrate, int idCrateStatus)
    {
    	CrateStatus s = em.find(CrateStatus.class, idCrateStatus);
    	Crate c = em.find(Crate.class, idCrate);
    	
    	c.setCrateStatus(s);
    	
    	em.persist(c);
    	
    	
    	
    }
    
    //list all crate data from Crate class
    public List<Crate> allCrate()
    {
    	List<Crate> listCrate = em.createNamedQuery("Crate.findAll", Crate.class).getResultList();
    	return listCrate;
    }
    
    //list all request type data from RequestType class
    public List<RequestType> allRequestType()
    {
    	List<RequestType> listRequestType = em.createNamedQuery("RequestType.findAll", RequestType.class).getResultList();
    	return listRequestType;
    }
    
    //list all client branch data from ClientBranch class
    public List<ClientBranch> allClientBranch()
    {
    	List<ClientBranch> listClientBranch = em.createNamedQuery("ClientBranch.findAll", ClientBranch.class).getResultList();
    	return listClientBranch;
    }
    
    //list all client employee data from ClientEmployee class
    public List<ClientEmployee> allClientEmployee()
    {
    	List<ClientEmployee> listClientEmployee = em.createNamedQuery("ClientEmployee.findAll", ClientEmployee.class).getResultList();
    	return listClientEmployee;
    }
    
    //list all client data from Client class
    public List<Client> allClient()
    {
    	List<Client> listClient = em.createNamedQuery("Client.findAll", Client.class).getResultList();
    	return listClient;
    }
    
    //list all client department data from ClientDeparment class
    public List<ClientDepartment> allClientDepartment()
    {
    	List<ClientDepartment> listClientDepartment = em.createNamedQuery("ClientDepartment.findAll", ClientDepartment.class).getResultList();
    	return listClientDepartment;
    }
    
    //list crates
    public List<Crate> allCrates(){
    	List queryResults = em.createQuery("SELECT c FROM Crate c").getResultList();
    	List<Crate> listResult = new ArrayList<Crate>();
    	
    	for(int i = 0; i < queryResults.size(); i++)
    	{
    		Crate c = new Crate();
    		c = (Crate)queryResults.get(i);
    		listResult.add(c);
    	}
    	
    	return listResult;
    }
    
    //list crate status data from CrateStatus class
    public List<CrateStatus> allCrateStatus()
    {
    	List<CrateStatus> listCrateStatus = em.createNamedQuery("CrateStatus.findAll", CrateStatus.class).getResultList();
    	return listCrateStatus;
    }
    
    //list packford employee 
    public List<PackfordEmployee> allPackfordEmployee(){
    	List queryResults = em.createQuery("SELECT c FROM PackfordEmployee c").getResultList();
    	List<PackfordEmployee> listResult = new ArrayList<PackfordEmployee>();
    	
    	for(int i = 0; i < queryResults.size(); i++)
    	{
    		PackfordEmployee c = new PackfordEmployee();
    		c = (PackfordEmployee)queryResults.get(i);
    		listResult.add(c);
    	}
    	
    	return listResult;
    }
    
    //list request detail
    public List<RequestDetail1> allRequestDetails(){
    	List queryResults = em.createQuery("SELECT c FROM RequestDetail1 c").getResultList();
    	List<RequestDetail1> listResult = new ArrayList<RequestDetail1>();
    	
    	for(int i = 0; i < queryResults.size(); i++)
    	{
    		RequestDetail1 c = new RequestDetail1();
    		c = (RequestDetail1)queryResults.get(i);
    		listResult.add(c);
    	}
    	
    	return listResult;
    }
    
    //list warehouse
    public List<Warehouse> allWarehouse(){
    	List queryResults = em.createQuery("SELECT c FROM Warehouse c").getResultList();
    	List<Warehouse> listResult = new ArrayList<Warehouse>();
    	
    	for(int i = 0; i < queryResults.size(); i++)
    	{
    		Warehouse c = new Warehouse();
    		c = (Warehouse)queryResults.get(i);
    		listResult.add(c);
    	}
    	
    	return listResult;
    }
    
    
    //verify user login
    public Boolean checkUser(String username,String password) 
    {
    	Boolean result = (Boolean) em.createQuery("SELECT EXISTS(SELECT * FROM packford_employee WHERE employee_name = "+username+" and password = "+password+")").getSingleResult();
    	return result;
    }

	 

}
