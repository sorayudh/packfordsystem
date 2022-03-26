package model;

import java.io.Serializable;
import javax.persistence.*;


/**
 * The persistent class for the periodic_request_detail database table.
 * 
 */
@Entity
@Table(name="periodic_request_detail")
@NamedQuery(name="PeriodicRequestDetail.findAll", query="SELECT p FROM PeriodicRequestDetail p")
public class PeriodicRequestDetail implements Serializable {
	private static final long serialVersionUID = 1L;

	@Id
	@GeneratedValue(strategy=GenerationType.IDENTITY)
	@Column(name="periodic_request_detail_id")
	private int periodicRequestDetailId;

	@Column(name="delivered_time")
	private int deliveredTime;

	@Column(name="request_completed")
	private byte requestCompleted;

	@Column(name="request_count")
	private int requestCount;

	@Column(name="request_status")
	private int requestStatus;

	@Column(name="start_time")
	private int startTime;

	//bi-directional many-to-one association to PeriodicRequest
	@ManyToOne
	@JoinColumn(name="periodic_request_id")
	private PeriodicRequest periodicRequest;

	public PeriodicRequestDetail() {
	}

	public int getPeriodicRequestDetailId() {
		return this.periodicRequestDetailId;
	}

	public void setPeriodicRequestDetailId(int periodicRequestDetailId) {
		this.periodicRequestDetailId = periodicRequestDetailId;
	}

	public int getDeliveredTime() {
		return this.deliveredTime;
	}

	public void setDeliveredTime(int deliveredTime) {
		this.deliveredTime = deliveredTime;
	}

	public byte getRequestCompleted() {
		return this.requestCompleted;
	}

	public void setRequestCompleted(byte requestCompleted) {
		this.requestCompleted = requestCompleted;
	}

	public int getRequestCount() {
		return this.requestCount;
	}

	public void setRequestCount(int requestCount) {
		this.requestCount = requestCount;
	}

	public int getRequestStatus() {
		return this.requestStatus;
	}

	public void setRequestStatus(int requestStatus) {
		this.requestStatus = requestStatus;
	}

	public int getStartTime() {
		return this.startTime;
	}

	public void setStartTime(int startTime) {
		this.startTime = startTime;
	}

	public PeriodicRequest getPeriodicRequest() {
		return this.periodicRequest;
	}

	public void setPeriodicRequest(PeriodicRequest periodicRequest) {
		this.periodicRequest = periodicRequest;
	}

}