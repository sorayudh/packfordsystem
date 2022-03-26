package model;

import java.io.Serializable;
import javax.persistence.*;


/**
 * The persistent class for the file_request_detail database table.
 * 
 */
@Entity
@Table(name="file_request_detail")
@NamedQuery(name="FileRequestDetail.findAll", query="SELECT f FROM FileRequestDetail f")
public class FileRequestDetail implements Serializable {
	private static final long serialVersionUID = 1L;

	@Id
	@GeneratedValue(strategy=GenerationType.IDENTITY)
	@Column(name="file_request_detail_id")
	private int fileRequestDetailId;

	@Column(name="file_delivered_in_crate")
	private int fileDeliveredInCrate;

	@Column(name="file_delivered_to_crate")
	private int fileDeliveredToCrate;

	//bi-directional many-to-one association to File
	@ManyToOne
	@JoinColumn(name="file_id")
	private File file;

	//bi-directional many-to-one association to RequestDetail1
	@ManyToOne
	@JoinColumn(name="request_id")
	private RequestDetail1 requestDetail1;

	public FileRequestDetail() {
	}

	public int getFileRequestDetailId() {
		return this.fileRequestDetailId;
	}

	public void setFileRequestDetailId(int fileRequestDetailId) {
		this.fileRequestDetailId = fileRequestDetailId;
	}

	public int getFileDeliveredInCrate() {
		return this.fileDeliveredInCrate;
	}

	public void setFileDeliveredInCrate(int fileDeliveredInCrate) {
		this.fileDeliveredInCrate = fileDeliveredInCrate;
	}

	public int getFileDeliveredToCrate() {
		return this.fileDeliveredToCrate;
	}

	public void setFileDeliveredToCrate(int fileDeliveredToCrate) {
		this.fileDeliveredToCrate = fileDeliveredToCrate;
	}

	public File getFile() {
		return this.file;
	}

	public void setFile(File file) {
		this.file = file;
	}

	public RequestDetail1 getRequestDetail1() {
		return this.requestDetail1;
	}

	public void setRequestDetail1(RequestDetail1 requestDetail1) {
		this.requestDetail1 = requestDetail1;
	}

}