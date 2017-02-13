package models;

import play.data.format.Formats;
import javax.persistence.*;
import java.util.Date;

@Entity
@Table(name = "batch")
public class Batch {

	@Id
	@GeneratedValue(strategy = GenerationType.AUTO)
	private Long id;

	@Column(name = "batch_name")
	private String batchName;
	@Formats.DateTime(pattern = "dd/MM/yyyy")
	@Column(name = "start_date")
	private Date startDate;
	@Formats.DateTime(pattern = "dd/MM/yyyy")
	@Column(name = "end_date")
	private Date endDate;
	@Column(name = "max_student")
	private Long maxStudent;
	
	@ManyToOne
	public Course course;

	public Long getId() {
		return id;
	}

	public void setId(Long id) {
		this.id = id;
	}

	public String getBatchName() {
		return batchName;
	}

	public void setBatchName(String batchName) {
		this.batchName = batchName;
	}

	public Date getStartDate() {
		return startDate;
	}

	public void setStartDate(Date startDate) {
		this.startDate = startDate;
	}

	public Date getEndDate() {
		return endDate;
	}

	public void setEndDate(Date endDate) {
		this.endDate = endDate;
	}

	public Long getMaxStudent() {
		return maxStudent;
	}

	public void setMaxStudent(Long maxStudent) {
		this.maxStudent = maxStudent;
	}

	public Course getCourse() {
		return course;
	}

	public void setCourse(Course course) {
		this.course = course;
	}

}