package model;

import java.io.Serializable;
import javax.persistence.*;
import java.util.List;


/**
 * The persistent class for the file database table.
 * 
 */
@Entity
@NamedQuery(name="File.findAll", query="SELECT f FROM File f")
public class File implements Serializable {
	private static final long serialVersionUID = 1L;

	@Id
	@GeneratedValue(strategy=GenerationType.IDENTITY)
	@Column(name="file_id")
	private int fileId;

	@Column(name="file_name")
	private String fileName;

	//bi-directional many-to-one association to FileRequestDetail
	@OneToMany(mappedBy="file")
	private List<FileRequestDetail> fileRequestDetails;

	public File() {
	}

	public int getFileId() {
		return this.fileId;
	}

	public void setFileId(int fileId) {
		this.fileId = fileId;
	}

	public String getFileName() {
		return this.fileName;
	}

	public void setFileName(String fileName) {
		this.fileName = fileName;
	}

	public List<FileRequestDetail> getFileRequestDetails() {
		return this.fileRequestDetails;
	}

	public void setFileRequestDetails(List<FileRequestDetail> fileRequestDetails) {
		this.fileRequestDetails = fileRequestDetails;
	}

	public FileRequestDetail addFileRequestDetail(FileRequestDetail fileRequestDetail) {
		getFileRequestDetails().add(fileRequestDetail);
		fileRequestDetail.setFile(this);

		return fileRequestDetail;
	}

	public FileRequestDetail removeFileRequestDetail(FileRequestDetail fileRequestDetail) {
		getFileRequestDetails().remove(fileRequestDetail);
		fileRequestDetail.setFile(null);

		return fileRequestDetail;
	}

}