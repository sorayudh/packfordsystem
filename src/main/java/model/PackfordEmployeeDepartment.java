package model;

import java.io.Serializable;
import javax.persistence.*;
import java.util.List;


/**
 * The persistent class for the packford_employee_department database table.
 * 
 */
@Entity
@Table(name="packford_employee_department")
@NamedQuery(name="PackfordEmployeeDepartment.findAll", query="SELECT p FROM PackfordEmployeeDepartment p")
public class PackfordEmployeeDepartment implements Serializable {
	private static final long serialVersionUID = 1L;

	@Id
	@GeneratedValue(strategy=GenerationType.IDENTITY)
	@Column(name="packford_employee_department_id")
	private int packfordEmployeeDepartmentId;

	@Column(name="department_name")
	private String departmentName;

	//bi-directional many-to-one association to PackfordEmployee
	@OneToMany(mappedBy="packfordEmployeeDepartment")
	private List<PackfordEmployee> packfordEmployees;

	public PackfordEmployeeDepartment() {
	}

	public int getPackfordEmployeeDepartmentId() {
		return this.packfordEmployeeDepartmentId;
	}

	public void setPackfordEmployeeDepartmentId(int packfordEmployeeDepartmentId) {
		this.packfordEmployeeDepartmentId = packfordEmployeeDepartmentId;
	}

	public String getDepartmentName() {
		return this.departmentName;
	}

	public void setDepartmentName(String departmentName) {
		this.departmentName = departmentName;
	}

	public List<PackfordEmployee> getPackfordEmployees() {
		return this.packfordEmployees;
	}

	public void setPackfordEmployees(List<PackfordEmployee> packfordEmployees) {
		this.packfordEmployees = packfordEmployees;
	}

	public PackfordEmployee addPackfordEmployee(PackfordEmployee packfordEmployee) {
		getPackfordEmployees().add(packfordEmployee);
		packfordEmployee.setPackfordEmployeeDepartment(this);

		return packfordEmployee;
	}

	public PackfordEmployee removePackfordEmployee(PackfordEmployee packfordEmployee) {
		getPackfordEmployees().remove(packfordEmployee);
		packfordEmployee.setPackfordEmployeeDepartment(null);

		return packfordEmployee;
	}


}