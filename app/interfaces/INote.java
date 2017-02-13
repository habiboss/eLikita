package interfaces;

import java.util.List;

import models.Note;

public interface INote {
	
	public String save(Note note);
	
	public String update(Note note);
	
	public String delete(Note note);
	
	public List<Note> findList();
	
	public Note findById(Long id);
}
