package model;

import java.io.Serializable;
import javax.persistence.*;
import java.util.Date;


/**
 * The persistent class for the future_request database table.
 * 
 */
@Entity
@Table(name="future_request")
@NamedQuery(name="FutureRequest.findAll", query="SELECT f FROM FutureRequest f")
public class FutureRequest implements Serializable {
	private static final long serialVersionUID = 1L;

	@Id
	@GeneratedValue(strategy=GenerationType.IDENTITY)
	@Column(name="future_request_id")
	private int futureRequestId;

	@Temporal(TemporalType.TIMESTAMP)
	@Column(name="request_scheduled_time")
	private Date requestScheduledTime;

	//bi-directional many-to-one association to RequestDetail1
	@ManyToOne
	@JoinColumn(name="request_id")
	private RequestDetail1 requestDetail1;

	public FutureRequest() {
	}

	public int getFutureRequestId() {
		return this.futureRequestId;
	}

	public void setFutureRequestId(int futureRequestId) {
		this.futureRequestId = futureRequestId;
	}

	public Date getRequestScheduledTime() {
		return this.requestScheduledTime;
	}

	public void setRequestScheduledTime(Date requestScheduledTime) {
		this.requestScheduledTime = requestScheduledTime;
	}

	public RequestDetail1 getRequestDetail1() {
		return this.requestDetail1;
	}

	public void setRequestDetail1(RequestDetail1 requestDetail1) {
		this.requestDetail1 = requestDetail1;
	}

}