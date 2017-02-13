package models;

import play.data.format.Formats;
import play.db.jpa.JPA;
import javax.persistence.*;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;

@Entity
@Table(name = "note")
public class Note {

	@Id
	@GeneratedValue(strategy = GenerationType.AUTO)
	private Long id;

	@Column(name = "title")
	private Long noteTitle;
	@Column(name = "description")
	private Long noteDescription;
	@Column(name = "attachment")
	private String noteAttachment;
	@Column(name = "course")
	private String course;
	@Column(name = "batch")
	private String batch;
	@Column(name = "subject")
	private String subject;
	
	public Long getId() {
		return id;
	}
	public void setId(Long id) {
		this.id = id;
	}
	public Long getNoteTitle() {
		return noteTitle;
	}
	public void setNoteTitle(Long noteTitle) {
		this.noteTitle = noteTitle;
	}
	public Long getNoteDescription() {
		return noteDescription;
	}
	public void setNoteDescription(Long noteDescription) {
		this.noteDescription = noteDescription;
	}
	public String getNoteAttachment() {
		return noteAttachment;
	}
	public void setNoteAttachment(String noteAttachment) {
		this.noteAttachment = noteAttachment;
	}
	public String getCourse() {
		return course;
	}
	public void setCourse(String course) {
		this.course = course;
	}
	public String getBatch() {
		return batch;
	}
	public void setBatch(String batch) {
		this.batch = batch;
	}
	public String getSubject() {
		return subject;
	}
	public void setSubject(String subject) {
		this.subject = subject;
	}
	
	
}