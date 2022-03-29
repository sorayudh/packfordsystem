package model;

import java.io.Serializable;
import javax.persistence.*;
import java.util.List;


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
	@Column(name="client_employee_id")
	private int clientEmployeeId;

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

	//bi-directional many-to-one association to RequestDetail1
	@OneToMany(mappedBy="clientEmployee")
	private List<RequestDetail1> requestDetail1s;

	public ClientEmployee() {
	}

	public int getClientEmployeeId() {
		return this.clientEmployeeId;
	}

	public void setClientEmployeeId(int clientEmployeeId) {
		this.clientEmployeeId = clientEmployeeId;
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

	public List<RequestDetail1> getRequestDetail1s() {
		return this.requestDetail1s;
	}

	public void setRequestDetail1s(List<RequestDetail1> requestDetail1s) {
		this.requestDetail1s = requestDetail1s;
	}

	public RequestDetail1 addRequestDetail1(RequestDetail1 requestDetail1) {
		getRequestDetail1s().add(requestDetail1);
		requestDetail1.setClientEmployee(this);

		return requestDetail1;
	}

	public RequestDetail1 removeRequestDetail1(RequestDetail1 requestDetail1) {
		getRequestDetail1s().remove(requestDetail1);
		requestDetail1.setClientEmployee(null);

		return requestDetail1;
	}

}