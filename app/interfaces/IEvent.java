package interfaces;

import java.util.List;

import models.Event;

public interface IEvent {
	
	public String save(Event event);
	
	public String update(Event event);
	
	public String delete(Event event);
	
	public List<Event> findList();

}
