package models;

import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.Table;

@Entity
@Table(name = "classe")
public class Classe {
	
	@Id
	@GeneratedValue(strategy = GenerationType.AUTO)
	private Long id;
	
	
	@Column(name = "class_number")
	private Long classNumber;
	@Column(name = "description")
	private Long description;
	@Column(name = "student_no")
	private String studentNo;
	
	@ManyToOne(cascade = CascadeType.ALL)
	@JoinColumn(name="lecturer_fk")
	public Lecturer lecturer;
	
	@ManyToOne(cascade = CascadeType.ALL)
	@JoinColumn(name="module_fk")
	public Module module;

	public Long getId() {
		return id;
	}

	public void setId(Long id) {
		this.id = id;
	}

	public Long getClassNumber() {
		return classNumber;
	}

	public void setClassNumber(Long classNumber) {
		this.classNumber = classNumber;
	}

	public Long getDescription() {
		return description;
	}

	public void setDescription(Long description) {
		this.description = description;
	}

	public String getStudentNo() {
		return studentNo;
	}

	public void setStudentNo(String studentNo) {
		this.studentNo = studentNo;
	}

	public Lecturer getLecturer() {
		return lecturer;
	}

	public void setLecturer(Lecturer lecturer) {
		this.lecturer = lecturer;
	}

	public Module getModule() {
		return module;
	}

	public void setModule(Module module) {
		this.module = module;
	}
	
	

}
