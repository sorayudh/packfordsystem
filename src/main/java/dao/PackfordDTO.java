package dao;


import java.util.ArrayList;
import java.util.List;

import javax.ejb.LocalBean;
import javax.ejb.Stateless;
import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;


import model.Client;
import model.Crate;
import model.PackfordEmployee;
import model.PackfordEmployeeDepartment;
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
    
    public void addClient(String name, String origin)
    {
    	Client c = new Client();
    	c.setClientName(name);
    	c.setOrigin(origin);
    	
    	em.persist(c);
    }
    public List<PackfordEmployeeDepartment> allPackfordEmployeeDepartment()
    {
    	List<PackfordEmployeeDepartment> listPackfordEmployeeDepartment = em.createNamedQuery("PackfordEmployeeDepartment.findAll", PackfordEmployeeDepartment.class).getResultList();
    	return listPackfordEmployeeDepartment;
    }
    public List<Warehouse> allWarehouses()
    {
    	List<Warehouse> listWarehouse = em.createNamedQuery("Warehouse.findAll", Warehouse.class).getResultList();
    	return listWarehouse;
    }
    
    public void insertBookWithDetails(int idDepartment, int idWarehouse, String employeeName, String employeePwd,int phone, String employeeEmail, String employeeAddress)
    {
    	PackfordEmployeeDepartment a = em.find(PackfordEmployeeDepartment.class, idDepartment);
    	
    	Warehouse w = em.find(Warehouse.class, idWarehouse);
    	
    	
    	PackfordEmployee c = new PackfordEmployee();
    	c.setEmployeeName(employeeName);
    	c.setPassword(employeePwd);
    	c.setPhone(phone);
    	c.setEmail(employeeEmail);
    	c.setAddress(employeeAddress);
    	
    	
    	//c.getPackfordEmployeeDepartment().add(a);
    	
    	//c.getWarehouse().add(w);
    	
    	em.persist(c);
    }
    
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
    
    
    
    public Boolean checkUser(String username,String password) 
    {
    	Boolean result = (Boolean) em.createQuery("SELECT EXISTS(SELECT * FROM packford_employee WHERE employee_name = "+username+" and password = "+password+")").getSingleResult();
    	return result;
    }

	 

}
