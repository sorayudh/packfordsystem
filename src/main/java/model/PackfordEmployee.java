package model;

import java.io.Serializable;
import javax.persistence.*;
import java.util.Date;


/**
 * The persistent class for the packford_employee database table.
 * 
 */
@Entity
@Table(name="packford_employee")
@NamedQuery(name="PackfordEmployee.findAll", query="SELECT p FROM PackfordEmployee p")
public class PackfordEmployee implements Serializable {
	private static final long serialVersionUID = 1L;

	@Id
	@GeneratedValue(strategy=GenerationType.IDENTITY)
	@Column(name="packford_employee_id")
	private int packfordEmployeeId;

	private String address;

	@Temporal(TemporalType.DATE)
	@Column(name="date_of_join")
	private Date dateOfJoin;

	private String email;

	@Column(name="employee_name")
	private String employeeName;

	private String password;

	private int phone;

	//bi-directional many-to-one association to PackfordEmployeeDepartment
	@ManyToOne
	@JoinColumn(name="packford_employee_department_id")
	private PackfordEmployeeDepartment packfordEmployeeDepartment;

	//bi-directional many-to-one association to Warehouse
	@ManyToOne
	@JoinColumn(name="warehouse_id")
	private Warehouse warehouse;

	public PackfordEmployee() {
	}

	public int getPackfordEmployeeId() {
		return this.packfordEmployeeId;
	}

	public void setPackfordEmployeeId(int packfordEmployeeId) {
		this.packfordEmployeeId = packfordEmployeeId;
	}

	public String getAddress() {
		return this.address;
	}

	public void setAddress(String address) {
		this.address = address;
	}

	public Date getDateOfJoin() {
		return this.dateOfJoin;
	}

	public void setDateOfJoin(Date dateOfJoin) {
		this.dateOfJoin = dateOfJoin;
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

	public PackfordEmployeeDepartment getPackfordEmployeeDepartment() {
		return this.packfordEmployeeDepartment;
	}

	public void setPackfordEmployeeDepartment(PackfordEmployeeDepartment packfordEmployeeDepartment) {
		this.packfordEmployeeDepartment = packfordEmployeeDepartment;
	}

	public Warehouse getWarehouse() {
		return this.warehouse;
	}

	public void setWarehouse(Warehouse warehouse) {
		this.warehouse = warehouse;
	}

}