package model;

import java.io.Serializable;
import javax.persistence.*;
import java.util.List;


/**
 * The persistent class for the crate database table.
 * 
 */
@Entity
@NamedQuery(name="Crate.findAll", query="SELECT c FROM Crate c")
public class Crate implements Serializable {
	private static final long serialVersionUID = 1L;

	@Id
	@GeneratedValue(strategy=GenerationType.IDENTITY)
	@Column(name="crate_id")
	private int crateId;

	private byte destroy;

	private int shelf;

	//bi-directional many-to-one association to Client
	@ManyToOne
	@JoinColumn(name="client_id")
	private Client client;

	//bi-directional many-to-one association to CrateContentType
	@ManyToOne
	@JoinColumn(name="crate_content_type_id")
	private CrateContentType crateContentType;

	//bi-directional many-to-one association to CrateStatus
	@ManyToOne
	@JoinColumn(name="crate_status_id")
	private CrateStatus crateStatus;

	//bi-directional many-to-one association to Warehouse
	@ManyToOne
	@JoinColumn(name="warehouse_id")
	private Warehouse warehouse;

	//bi-directional many-to-one association to RequestDetail1
	@OneToMany(mappedBy="crate")
	private List<RequestDetail1> requestDetail1s;

	public Crate() {
	}

	public int getCrateId() {
		return this.crateId;
	}

	public void setCrateId(int crateId) {
		this.crateId = crateId;
	}

	public byte getDestroy() {
		return this.destroy;
	}

	public void setDestroy(byte destroy) {
		this.destroy = destroy;
	}

	public int getShelf() {
		return this.shelf;
	}

	public void setShelf(int shelf) {
		this.shelf = shelf;
	}

	public Client getClient() {
		return this.client;
	}

	public void setClient(Client client) {
		this.client = client;
	}

	public CrateContentType getCrateContentType() {
		return this.crateContentType;
	}

	public void setCrateContentType(CrateContentType crateContentType) {
		this.crateContentType = crateContentType;
	}

	public CrateStatus getCrateStatus() {
		return this.crateStatus;
	}

	public void setCrateStatus(CrateStatus crateStatus) {
		this.crateStatus = crateStatus;
	}

	public Warehouse getWarehouse() {
		return this.warehouse;
	}

	public void setWarehouse(Warehouse warehouse) {
		this.warehouse = warehouse;
	}

	public List<RequestDetail1> getRequestDetail1s() {
		return this.requestDetail1s;
	}

	public void setRequestDetail1s(List<RequestDetail1> requestDetail1s) {
		this.requestDetail1s = requestDetail1s;
	}

	public RequestDetail1 addRequestDetail1(RequestDetail1 requestDetail1) {
		getRequestDetail1s().add(requestDetail1);
		requestDetail1.setCrate(this);

		return requestDetail1;
	}

	public RequestDetail1 removeRequestDetail1(RequestDetail1 requestDetail1) {
		getRequestDetail1s().remove(requestDetail1);
		requestDetail1.setCrate(null);

		return requestDetail1;
	}

}