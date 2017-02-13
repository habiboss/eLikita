package services;

import java.util.List;

import interfaces.INote;
import models.Note;
import play.db.jpa.JPA;

public class NoteSvr implements INote{

	@Override
	public String save(Note note) {
		// TODO Auto-generated method stub
		try {
			JPA.em().persist(note);
		} catch (Exception e) {
			// TODO: handle exception
		}
		return null;
	}

	@Override
	public String update(Note note) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public String delete(Note note) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public List<Note> findList() {
		// TODO Auto-generated method stub
		String Querry_findList = "SELECT note FROM Note note ORDER BY note.id";
		try {
			return JPA.em().createQuery(Querry_findList).getResultList();
		} catch (Exception e) {
			// TODO: handle exception
		}
		return null;
	}

	@Override
	public Note findById(Long id) {
		// TODO Auto-generated method stub
		String Querry_findById = "SELECT note FROM Note note WHERE note.id =:id";
		try {
			return (Note) JPA.em().createQuery(Querry_findById).setParameter("id", id).getSingleResult();
		} catch (Exception e) {
			// TODO: handle exception
		}
		return null;
	}

}
