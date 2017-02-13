package services;

import java.util.List;

import interfaces.IEvent;
import models.Event;
import play.db.jpa.JPA;

public class EventService implements IEvent{
	
	

	public String save(Event event) {
		try {
			JPA.em().persist(event);
		} catch (Exception e) {
			// TODO: handle exception
		}
		return null;
	}

	@Override
	public String update(Event event) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public String delete(Event event) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public List<Event> findList() {
		String Querry_findList = "SELECT event FROM Event event ORDER BY event.id";
		try {
			return JPA.em().createQuery(Querry_findList).getResultList();
		} catch (Exception e) {
			// TODO: handle exception
		}
		return null;
	}

}
