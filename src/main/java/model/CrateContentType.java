package model;

import java.io.Serializable;
import javax.persistence.*;
import java.util.List;


/**
 * The persistent class for the crate_content_type database table.
 * 
 */
@Entity
@Table(name="crate_content_type")
@NamedQuery(name="CrateContentType.findAll", query="SELECT c FROM CrateContentType c")
public class CrateContentType implements Serializable {
	private static final long serialVersionUID = 1L;

	@Id
	@GeneratedValue(strategy=GenerationType.IDENTITY)
	@Column(name="crate_content_type_id")
	private int crateContentTypeId;

	@Column(name="content_name")
	private String contentName;

	//bi-directional many-to-one association to Crate
	@OneToMany(mappedBy="crateContentType")
	private List<Crate> crates;

	public CrateContentType() {
	}

	public int getCrateContentTypeId() {
		return this.crateContentTypeId;
	}

	public void setCrateContentTypeId(int crateContentTypeId) {
		this.crateContentTypeId = crateContentTypeId;
	}

	public String getContentName() {
		return this.contentName;
	}

	public void setContentName(String contentName) {
		this.contentName = contentName;
	}

	public List<Crate> getCrates() {
		return this.crates;
	}

	public void setCrates(List<Crate> crates) {
		this.crates = crates;
	}

	public Crate addCrate(Crate crate) {
		getCrates().add(crate);
		crate.setCrateContentType(this);

		return crate;
	}

	public Crate removeCrate(Crate crate) {
		getCrates().remove(crate);
		crate.setCrateContentType(null);

		return crate;
	}

}