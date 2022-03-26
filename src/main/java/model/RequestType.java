package model;

import java.io.Serializable;
import javax.persistence.*;
import java.util.List;


/**
 * The persistent class for the request_type database table.
 * 
 */
@Entity
@Table(name="request_type")
@NamedQuery(name="RequestType.findAll", query="SELECT r FROM RequestType r")
public class RequestType implements Serializable {
	private static final long serialVersionUID = 1L;

	@Id
	@GeneratedValue(strategy=GenerationType.IDENTITY)
	@Column(name="request_type_id")
	private int requestTypeId;

	@Column(name="request_type")
	private String requestType;

	//bi-directional many-to-one association to RequestDetail1
	@OneToMany(mappedBy="requestType")
	private List<RequestDetail1> requestDetail1s;

	public RequestType() {
	}

	public int getRequestTypeId() {
		return this.requestTypeId;
	}

	public void setRequestTypeId(int requestTypeId) {
		this.requestTypeId = requestTypeId;
	}

	public String getRequestType() {
		return this.requestType;
	}

	public void setRequestType(String requestType) {
		this.requestType = requestType;
	}

	public List<RequestDetail1> getRequestDetail1s() {
		return this.requestDetail1s;
	}

	public void setRequestDetail1s(List<RequestDetail1> requestDetail1s) {
		this.requestDetail1s = requestDetail1s;
	}

	public RequestDetail1 addRequestDetail1(RequestDetail1 requestDetail1) {
		getRequestDetail1s().add(requestDetail1);
		requestDetail1.setRequestType(this);

		return requestDetail1;
	}

	public RequestDetail1 removeRequestDetail1(RequestDetail1 requestDetail1) {
		getRequestDetail1s().remove(requestDetail1);
		requestDetail1.setRequestType(null);

		return requestDetail1;
	}

}