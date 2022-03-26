package model;

import java.io.Serializable;
import javax.persistence.*;


/**
 * The persistent class for the client_employee database table.
 * 
 */
@Entity
@Table(name="client_employee")
@NamedQuery(name="ClientEmployee.findAll", query="SELECT c FROM ClientEmployee c")
public class ClientEmployee implements Serializable {
	private static final long serialVersionUID = 1L;

	@Id
	@GeneratedValue(strategy=GenerationType.IDENTITY)
	@Column(name="`client_employee-id`")
	private int clientEmployee_id;

	private String address;

	private String email;

	@Column(name="employee_name")
	private String employeeName;

	private String password;

	private int phone;

	//bi-directional many-to-one association to Client
	@ManyToOne
	@JoinColumn(name="client_id")
	private Client client;

	//bi-directional many-to-one association to ClientBranch
	@ManyToOne
	@JoinColumn(name="branch_id")
	private ClientBranch clientBranch;

	//bi-directional many-to-one association to ClientDepartment
	@ManyToOne
	@JoinColumn(name="client_department_id")
	private ClientDepartment clientDepartment;

	public ClientEmployee() {
	}

	public int getClientEmployee_id() {
		return this.clientEmployee_id;
	}

	public void setClientEmployee_id(int clientEmployee_id) {
		this.clientEmployee_id = clientEmployee_id;
	}

	public String getAddress() {
		return this.address;
	}

	public void setAddress(String address) {
		this.address = address;
	}

	public String getEmail() {
		return this.email;
	}

	public void setEmail(String email) {
		this.email = email;
	}

	public String getEmployeeName() {
		return this.employeeName;
	}

	public void setEmployeeName(String employeeName) {
		this.employeeName = employeeName;
	}

	public String getPassword() {
		return this.password;
	}

	public void setPassword(String password) {
		this.password = password;
	}

	public int getPhone() {
		return this.phone;
	}

	public void setPhone(int phone) {
		this.phone = phone;
	}

	public Client getClient() {
		return this.client;
	}

	public void setClient(Client client) {
		this.client = client;
	}

	public ClientBranch getClientBranch() {
		return this.clientBranch;
	}

	public void setClientBranch(ClientBranch clientBranch) {
		this.clientBranch = clientBranch;
	}

	public ClientDepartment getClientDepartment() {
		return this.clientDepartment;
	}

	public void setClientDepartment(ClientDepartment clientDepartment) {
		this.clientDepartment = clientDepartment;
	}

}