package model;

import java.io.Serializable;
import javax.persistence.*;
import java.util.List;


/**
 * The persistent class for the client_branch database table.
 * 
 */
@Entity
@Table(name="client_branch")
@NamedQuery(name="ClientBranch.findAll", query="SELECT c FROM ClientBranch c")
public class ClientBranch implements Serializable {
	private static final long serialVersionUID = 1L;

	@Id
	@GeneratedValue(strategy=GenerationType.IDENTITY)
	@Column(name="branch_id")
	private int branchId;

	@Column(name="branch_address")
	private String branchAddress;

	@Column(name="branch_name")
	private String branchName;

	@Column(name="total_employee")
	private int totalEmployee;

	//bi-directional many-to-one association to Client
	@ManyToOne
	@JoinColumn(name="client_id")
	private Client client;

	//bi-directional many-to-one association to ClientEmployee
	@OneToMany(mappedBy="clientBranch")
	private List<ClientEmployee> clientEmployees;

	//bi-directional many-to-one association to RequestDetail1
	@OneToMany(mappedBy="clientBranch")
	private List<RequestDetail1> requestDetail1s;

	public ClientBranch() {
	}

	public int getBranchId() {
		return this.branchId;
	}

	public void setBranchId(int branchId) {
		this.branchId = branchId;
	}

	public String getBranchAddress() {
		return this.branchAddress;
	}

	public void setBranchAddress(String branchAddress) {
		this.branchAddress = branchAddress;
	}

	public String getBranchName() {
		return this.branchName;
	}

	public void setBranchName(String branchName) {
		this.branchName = branchName;
	}

	public int getTotalEmployee() {
		return this.totalEmployee;
	}

	public void setTotalEmployee(int totalEmployee) {
		this.totalEmployee = totalEmployee;
	}

	public Client getClient() {
		return this.client;
	}

	public void setClient(Client client) {
		this.client = client;
	}

	public List<ClientEmployee> getClientEmployees() {
		return this.clientEmployees;
	}

	public void setClientEmployees(List<ClientEmployee> clientEmployees) {
		this.clientEmployees = clientEmployees;
	}

	public ClientEmployee addClientEmployee(ClientEmployee clientEmployee) {
		getClientEmployees().add(clientEmployee);
		clientEmployee.setClientBranch(this);

		return clientEmployee;
	}

	public ClientEmployee removeClientEmployee(ClientEmployee clientEmployee) {
		getClientEmployees().remove(clientEmployee);
		clientEmployee.setClientBranch(null);

		return clientEmployee;
	}

	public List<RequestDetail1> getRequestDetail1s() {
		return this.requestDetail1s;
	}

	public void setRequestDetail1s(List<RequestDetail1> requestDetail1s) {
		this.requestDetail1s = requestDetail1s;
	}

	public RequestDetail1 addRequestDetail1(RequestDetail1 requestDetail1) {
		getRequestDetail1s().add(requestDetail1);
		requestDetail1.setClientBranch(this);

		return requestDetail1;
	}

	public RequestDetail1 removeRequestDetail1(RequestDetail1 requestDetail1) {
		getRequestDetail1s().remove(requestDetail1);
		requestDetail1.setClientBranch(null);

		return requestDetail1;
	}

}