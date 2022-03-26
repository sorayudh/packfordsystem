package model;

import java.io.Serializable;
import javax.persistence.*;
import java.util.Date;
import java.util.List;


/**
 * The persistent class for the client database table.
 * 
 */
@Entity
@NamedQuery(name="Client.findAll", query="SELECT c FROM Client c")
public class Client implements Serializable {
	private static final long serialVersionUID = 1L;

	@Id
	@GeneratedValue(strategy=GenerationType.IDENTITY)
	@Column(name="client_id")
	private int clientId;

	@Column(name="client_name")
	private String clientName;

	@Temporal(TemporalType.DATE)
	@Column(name="date_of_joining")
	private Date dateOfJoining;

	private String origin;

	@Column(name="total_number_of_crate")
	private int totalNumberOfCrate;

	@Column(name="total_request_made")
	private int totalRequestMade;

	//bi-directional many-to-one association to ClientBranch
	@OneToMany(mappedBy="client")
	private List<ClientBranch> clientBranches;

	//bi-directional many-to-one association to ClientEmployee
	@OneToMany(mappedBy="client")
	private List<ClientEmployee> clientEmployees;

	//bi-directional many-to-one association to Crate
	@OneToMany(mappedBy="client")
	private List<Crate> crates;

	public Client() {
	}

	public int getClientId() {
		return this.clientId;
	}

	public void setClientId(int clientId) {
		this.clientId = clientId;
	}

	public String getClientName() {
		return this.clientName;
	}

	public void setClientName(String clientName) {
		this.clientName = clientName;
	}

	public Date getDateOfJoining() {
		return this.dateOfJoining;
	}

	public void setDateOfJoining(Date dateOfJoining) {
		this.dateOfJoining = dateOfJoining;
	}

	public String getOrigin() {
		return this.origin;
	}

	public void setOrigin(String origin) {
		this.origin = origin;
	}

	public int getTotalNumberOfCrate() {
		return this.totalNumberOfCrate;
	}

	public void setTotalNumberOfCrate(int totalNumberOfCrate) {
		this.totalNumberOfCrate = totalNumberOfCrate;
	}

	public int getTotalRequestMade() {
		return this.totalRequestMade;
	}

	public void setTotalRequestMade(int totalRequestMade) {
		this.totalRequestMade = totalRequestMade;
	}

	public List<ClientBranch> getClientBranches() {
		return this.clientBranches;
	}

	public void setClientBranches(List<ClientBranch> clientBranches) {
		this.clientBranches = clientBranches;
	}

	public ClientBranch addClientBranch(ClientBranch clientBranch) {
		getClientBranches().add(clientBranch);
		clientBranch.setClient(this);

		return clientBranch;
	}

	public ClientBranch removeClientBranch(ClientBranch clientBranch) {
		getClientBranches().remove(clientBranch);
		clientBranch.setClient(null);

		return clientBranch;
	}

	public List<ClientEmployee> getClientEmployees() {
		return this.clientEmployees;
	}

	public void setClientEmployees(List<ClientEmployee> clientEmployees) {
		this.clientEmployees = clientEmployees;
	}

	public ClientEmployee addClientEmployee(ClientEmployee clientEmployee) {
		getClientEmployees().add(clientEmployee);
		clientEmployee.setClient(this);

		return clientEmployee;
	}

	public ClientEmployee removeClientEmployee(ClientEmployee clientEmployee) {
		getClientEmployees().remove(clientEmployee);
		clientEmployee.setClient(null);

		return clientEmployee;
	}

	public List<Crate> getCrates() {
		return this.crates;
	}

	public void setCrates(List<Crate> crates) {
		this.crates = crates;
	}

	public Crate addCrate(Crate crate) {
		getCrates().add(crate);
		crate.setClient(this);

		return crate;
	}

	public Crate removeCrate(Crate crate) {
		getCrates().remove(crate);
		crate.setClient(null);

		return crate;
	}

}