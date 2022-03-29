package model;

import java.io.Serializable;
import javax.persistence.*;
import java.util.Date;
import java.util.List;


/**
 * The persistent class for the request_detail1 database table.
 * 
 */
@Entity
@Table(name="request_detail1")
@NamedQuery(name="RequestDetail1.findAll", query="SELECT r FROM RequestDetail1 r")
public class RequestDetail1 implements Serializable {
	private static final long serialVersionUID = 1L;

	@Id
	@GeneratedValue(strategy=GenerationType.IDENTITY)
	@Column(name="request1_id")
	private int request1Id;

	@Column(name="file_request")
	private byte fileRequest;

	@Column(name="periodic_request")
	private byte periodicRequest;

	@Column(name="request_charges")
	private int requestCharges;

	@Temporal(TemporalType.TIMESTAMP)
	@Column(name="request_completion_date_time")
	private Date requestCompletionDateTime;

	@Temporal(TemporalType.TIMESTAMP)
	@Column(name="request_date_time")
	private Date requestDateTime;

	@Column(name="request_status")
	private int requestStatus;

	@Temporal(TemporalType.TIMESTAMP)
	@Column(name="tentative_delivery")
	private Date tentativeDelivery;

	@Column(name="upcoming_request")
	private byte upcomingRequest;

	//bi-directional many-to-one association to FileRequestDetail
	@OneToMany(mappedBy="requestDetail1")
	private List<FileRequestDetail> fileRequestDetails;

	//bi-directional many-to-one association to FutureRequest
	@OneToMany(mappedBy="requestDetail1")
	private List<FutureRequest> futureRequests;

	//bi-directional many-to-one association to PeriodicRequest
	@OneToMany(mappedBy="requestDetail1")
	private List<PeriodicRequest> periodicRequests;

	//bi-directional many-to-one association to ClientBranch
	@ManyToOne
	@JoinColumn(name="client_branch_id")
	private ClientBranch clientBranch;

	//bi-directional many-to-one association to ClientEmployee
	@ManyToOne
	@JoinColumn(name="client_employee_id")
	private ClientEmployee clientEmployee;

	//bi-directional many-to-one association to Crate
	@ManyToOne
	@JoinColumn(name="crate_id")
	private Crate crate;

	//bi-directional many-to-one association to RequestType
	@ManyToOne
	@JoinColumn(name="request_type_id")
	private RequestType requestType;

	public RequestDetail1() {
	}

	public int getRequest1Id() {
		return this.request1Id;
	}

	public void setRequest1Id(int request1Id) {
		this.request1Id = request1Id;
	}

	public byte getFileRequest() {
		return this.fileRequest;
	}

	public void setFileRequest(byte fileRequest) {
		this.fileRequest = fileRequest;
	}

	public byte getPeriodicRequest() {
		return this.periodicRequest;
	}

	public void setPeriodicRequest(byte periodicRequest) {
		this.periodicRequest = periodicRequest;
	}

	public int getRequestCharges() {
		return this.requestCharges;
	}

	public void setRequestCharges(int requestCharges) {
		this.requestCharges = requestCharges;
	}

	public Date getRequestCompletionDateTime() {
		return this.requestCompletionDateTime;
	}

	public void setRequestCompletionDateTime(Date requestCompletionDateTime) {
		this.requestCompletionDateTime = requestCompletionDateTime;
	}

	public Date getRequestDateTime() {
		return this.requestDateTime;
	}

	public void setRequestDateTime(Date requestDateTime) {
		this.requestDateTime = requestDateTime;
	}

	public int getRequestStatus() {
		return this.requestStatus;
	}

	public void setRequestStatus(int requestStatus) {
		this.requestStatus = requestStatus;
	}

	public Date getTentativeDelivery() {
		return this.tentativeDelivery;
	}

	public void setTentativeDelivery(Date tentativeDelivery) {
		this.tentativeDelivery = tentativeDelivery;
	}

	public byte getUpcomingRequest() {
		return this.upcomingRequest;
	}

	public void setUpcomingRequest(byte upcomingRequest) {
		this.upcomingRequest = upcomingRequest;
	}

	public List<FileRequestDetail> getFileRequestDetails() {
		return this.fileRequestDetails;
	}

	public void setFileRequestDetails(List<FileRequestDetail> fileRequestDetails) {
		this.fileRequestDetails = fileRequestDetails;
	}

	public FileRequestDetail addFileRequestDetail(FileRequestDetail fileRequestDetail) {
		getFileRequestDetails().add(fileRequestDetail);
		fileRequestDetail.setRequestDetail1(this);

		return fileRequestDetail;
	}

	public FileRequestDetail removeFileRequestDetail(FileRequestDetail fileRequestDetail) {
		getFileRequestDetails().remove(fileRequestDetail);
		fileRequestDetail.setRequestDetail1(null);

		return fileRequestDetail;
	}

	public List<FutureRequest> getFutureRequests() {
		return this.futureRequests;
	}

	public void setFutureRequests(List<FutureRequest> futureRequests) {
		this.futureRequests = futureRequests;
	}

	public FutureRequest addFutureRequest(FutureRequest futureRequest) {
		getFutureRequests().add(futureRequest);
		futureRequest.setRequestDetail1(this);

		return futureRequest;
	}

	public FutureRequest removeFutureRequest(FutureRequest futureRequest) {
		getFutureRequests().remove(futureRequest);
		futureRequest.setRequestDetail1(null);

		return futureRequest;
	}

	public List<PeriodicRequest> getPeriodicRequests() {
		return this.periodicRequests;
	}

	public void setPeriodicRequests(List<PeriodicRequest> periodicRequests) {
		this.periodicRequests = periodicRequests;
	}

	public PeriodicRequest addPeriodicRequest(PeriodicRequest periodicRequest) {
		getPeriodicRequests().add(periodicRequest);
		periodicRequest.setRequestDetail1(this);

		return periodicRequest;
	}

	public PeriodicRequest removePeriodicRequest(PeriodicRequest periodicRequest) {
		getPeriodicRequests().remove(periodicRequest);
		periodicRequest.setRequestDetail1(null);

		return periodicRequest;
	}

	public ClientBranch getClientBranch() {
		return this.clientBranch;
	}

	public void setClientBranch(ClientBranch clientBranch) {
		this.clientBranch = clientBranch;
	}

	public ClientEmployee getClientEmployee() {
		return this.clientEmployee;
	}

	public void setClientEmployee(ClientEmployee clientEmployee) {
		this.clientEmployee = clientEmployee;
	}

	public Crate getCrate() {
		return this.crate;
	}

	public void setCrate(Crate crate) {
		this.crate = crate;
	}

	public RequestType getRequestType() {
		return this.requestType;
	}

	public void setRequestType(RequestType requestType) {
		this.requestType = requestType;
	}

}