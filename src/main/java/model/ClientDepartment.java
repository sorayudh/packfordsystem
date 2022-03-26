package model;

import java.io.Serializable;
import javax.persistence.*;
import java.util.List;


/**
 * The persistent class for the client_department database table.
 * 
 */
@Entity
@Table(name="client_department")
@NamedQuery(name="ClientDepartment.findAll", query="SELECT c FROM ClientDepartment c")
public class ClientDepartment implements Serializable {
	private static final long serialVersionUID = 1L;

	@Id
	@GeneratedValue(strategy=GenerationType.IDENTITY)
	@Column(name="client_department_id")
	private int clientDepartmentId;

	@Column(name="department_name")
	private String departmentName;

	//bi-directional many-to-one association to ClientEmployee
	@OneToMany(mappedBy="clientDepartment")
	private List<ClientEmployee> clientEmployees;

	public ClientDepartment() {
	}

	public int getClientDepartmentId() {
		return this.clientDepartmentId;
	}

	public void setClientDepartmentId(int clientDepartmentId) {
		this.clientDepartmentId = clientDepartmentId;
	}

	public String getDepartmentName() {
		return this.departmentName;
	}

	public void setDepartmentName(String departmentName) {
		this.departmentName = departmentName;
	}

	public List<ClientEmployee> getClientEmployees() {
		return this.clientEmployees;
	}

	public void setClientEmployees(List<ClientEmployee> clientEmployees) {
		this.clientEmployees = clientEmployees;
	}

	public ClientEmployee addClientEmployee(ClientEmployee clientEmployee) {
		getClientEmployees().add(clientEmployee);
		clientEmployee.setClientDepartment(this);

		return clientEmployee;
	}

	public ClientEmployee removeClientEmployee(ClientEmployee clientEmployee) {
		getClientEmployees().remove(clientEmployee);
		clientEmployee.setClientDepartment(null);

		return clientEmployee;
	}

}