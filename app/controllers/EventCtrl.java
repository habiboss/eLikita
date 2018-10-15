package controllers;

import com.google.inject.Inject;
import models.Event;
import play.data.Form;
import play.data.FormFactory;
import play.db.jpa.Transactional;
import play.mvc.Controller;
import play.mvc.Result;
import services.EventSvr;
import views.html.admin.*;

public class EventCtrl extends Controller{

	@Inject
	FormFactory formFactory;
	//EventService eventService;

	public EventCtrl() {
		super();
	}

	@Transactional
	public Result save() {
        EventSvr x = new EventSvr();
		Form<Event> form = formFactory.form(Event.class).bindFromRequest();
		Event event = form.get();
		//event.setStartDate(form.field("startDate").value());
		//event.setEndDate(form.field("endDate").value());
		event.setTitle(form.field("title").value());
		event.setDescription(form.field("description").value());
		//System.out.println(form.field("title").value());
		//eventService.save(event);
		x.save(event);

		return null;

	}
	
	@Transactional
	public Result display() {
		EventSvr eventService = new EventSvr();
		
		return ok(event.render(eventService.findList()));
		
	}

}
