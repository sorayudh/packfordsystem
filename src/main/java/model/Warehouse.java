package model;

import java.io.Serializable;
import javax.persistence.*;
import java.util.List;


/**
 * The persistent class for the warehouse database table.
 * 
 */
@Entity
@NamedQuery(name="Warehouse.findAll", query="SELECT w FROM Warehouse w")
public class Warehouse implements Serializable {
	private static final long serialVersionUID = 1L;

	@Id
	@GeneratedValue(strategy=GenerationType.IDENTITY)
	@Column(name="warehouse_id")
	private int warehouseId;

	@Column(name="total_crate")
	private int totalCrate;

	@Column(name="warehouse_location")
	private String warehouseLocation;

	//bi-directional many-to-one association to Crate
	@OneToMany(mappedBy="warehouse")
	private List<Crate> crates;

	//bi-directional many-to-one association to PackfordEmployee
	@OneToMany(mappedBy="warehouse")
	private List<PackfordEmployee> packfordEmployees;

	public Warehouse() {
	}

	public int getWarehouseId() {
		return this.warehouseId;
	}

	public void setWarehouseId(int warehouseId) {
		this.warehouseId = warehouseId;
	}

	public int getTotalCrate() {
		return this.totalCrate;
	}

	public void setTotalCrate(int totalCrate) {
		this.totalCrate = totalCrate;
	}

	public String getWarehouseLocation() {
		return this.warehouseLocation;
	}

	public void setWarehouseLocation(String warehouseLocation) {
		this.warehouseLocation = warehouseLocation;
	}

	public List<Crate> getCrates() {
		return this.crates;
	}

	public void setCrates(List<Crate> crates) {
		this.crates = crates;
	}

	public Crate addCrate(Crate crate) {
		getCrates().add(crate);
		crate.setWarehouse(this);

		return crate;
	}

	public Crate removeCrate(Crate crate) {
		getCrates().remove(crate);
		crate.setWarehouse(null);

		return crate;
	}

	public List<PackfordEmployee> getPackfordEmployees() {
		return this.packfordEmployees;
	}

	public void setPackfordEmployees(List<PackfordEmployee> packfordEmployees) {
		this.packfordEmployees = packfordEmployees;
	}

	public PackfordEmployee addPackfordEmployee(PackfordEmployee packfordEmployee) {
		getPackfordEmployees().add(packfordEmployee);
		packfordEmployee.setWarehouse(this);

		return packfordEmployee;
	}

	public PackfordEmployee removePackfordEmployee(PackfordEmployee packfordEmployee) {
		getPackfordEmployees().remove(packfordEmployee);
		packfordEmployee.setWarehouse(null);

		return packfordEmployee;
	}

}