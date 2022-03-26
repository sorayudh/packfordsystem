package model;

import java.io.Serializable;
import javax.persistence.*;
import java.util.Date;
import java.util.List;


/**
 * The persistent class for the periodic_request database table.
 * 
 */
@Entity
@Table(name="periodic_request")
@NamedQuery(name="PeriodicRequest.findAll", query="SELECT p FROM PeriodicRequest p")
public class PeriodicRequest implements Serializable {
	private static final long serialVersionUID = 1L;

	@Id
	@GeneratedValue(strategy=GenerationType.IDENTITY)
	@Column(name="periodic_request_id")
	private int periodicRequestId;

	@Temporal(TemporalType.TIMESTAMP)
	@Column(name="time_of_repetition")
	private Date timeOfRepetition;

	@Column(name="total_request_made")
	private int totalRequestMade;

	//bi-directional many-to-one association to RequestDetail1
	@ManyToOne
	@JoinColumn(name="request_id")
	private RequestDetail1 requestDetail1;

	//bi-directional many-to-one association to PeriodicRequestDetail
	@OneToMany(mappedBy="periodicRequest")
	private List<PeriodicRequestDetail> periodicRequestDetails;

	public PeriodicRequest() {
	}

	public int getPeriodicRequestId() {
		return this.periodicRequestId;
	}

	public void setPeriodicRequestId(int periodicRequestId) {
		this.periodicRequestId = periodicRequestId;
	}

	public Date getTimeOfRepetition() {
		return this.timeOfRepetition;
	}

	public void setTimeOfRepetition(Date timeOfRepetition) {
		this.timeOfRepetition = timeOfRepetition;
	}

	public int getTotalRequestMade() {
		return this.totalRequestMade;
	}

	public void setTotalRequestMade(int totalRequestMade) {
		this.totalRequestMade = totalRequestMade;
	}

	public RequestDetail1 getRequestDetail1() {
		return this.requestDetail1;
	}

	public void setRequestDetail1(RequestDetail1 requestDetail1) {
		this.requestDetail1 = requestDetail1;
	}

	public List<PeriodicRequestDetail> getPeriodicRequestDetails() {
		return this.periodicRequestDetails;
	}

	public void setPeriodicRequestDetails(List<PeriodicRequestDetail> periodicRequestDetails) {
		this.periodicRequestDetails = periodicRequestDetails;
	}

	public PeriodicRequestDetail addPeriodicRequestDetail(PeriodicRequestDetail periodicRequestDetail) {
		getPeriodicRequestDetails().add(periodicRequestDetail);
		periodicRequestDetail.setPeriodicRequest(this);

		return periodicRequestDetail;
	}

	public PeriodicRequestDetail removePeriodicRequestDetail(PeriodicRequestDetail periodicRequestDetail) {
		getPeriodicRequestDetails().remove(periodicRequestDetail);
		periodicRequestDetail.setPeriodicRequest(null);

		return periodicRequestDetail;
	}

}