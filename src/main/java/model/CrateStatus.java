package model;

import java.io.Serializable;
import javax.persistence.*;
import java.util.List;


/**
 * The persistent class for the crate_status database table.
 * 
 */
@Entity
@Table(name="crate_status")
@NamedQuery(name="CrateStatus.findAll", query="SELECT c FROM CrateStatus c")
public class CrateStatus implements Serializable {
	private static final long serialVersionUID = 1L;

	@Id
	@GeneratedValue(strategy=GenerationType.IDENTITY)
	@Column(name="crate_status_id")
	private int crateStatusId;

	@Column(name="crate_status")
	private String crateStatus;

	//bi-directional many-to-one association to Crate
	@OneToMany(mappedBy="crateStatus")
	private List<Crate> crates;

	public CrateStatus() {
	}

	public int getCrateStatusId() {
		return this.crateStatusId;
	}

	public void setCrateStatusId(int crateStatusId) {
		this.crateStatusId = crateStatusId;
	}

	public String getCrateStatus() {
		return this.crateStatus;
	}

	public void setCrateStatus(String crateStatus) {
		this.crateStatus = crateStatus;
	}

	public List<Crate> getCrates() {
		return this.crates;
	}

	public void setCrates(List<Crate> crates) {
		this.crates = crates;
	}

	public Crate addCrate(Crate crate) {
		getCrates().add(crate);
		crate.setCrateStatus(this);

		return crate;
	}

	public Crate removeCrate(Crate crate) {
		getCrates().remove(crate);
		crate.setCrateStatus(null);

		return crate;
	}

}