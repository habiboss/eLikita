package controllers;

import com.google.inject.Inject;

import models.Note;
import play.data.Form;
import play.data.FormFactory;
import play.db.jpa.Transactional;
import play.mvc.Controller;
import play.mvc.Result;
import services.NoteSvr;
import views.html.admin.*;

public class NoteCtrl extends Controller{
	@Inject
	FormFactory formFactory;

	@Transactional
	public Result read() {
		NoteSvr n = new NoteSvr();
		return ok(note.render(n.findList()));
		
	}
	
	@Transactional
	public Result save() {
		Form<Note> form = formFactory.form(Note.class).bindFromRequest();
		NoteSvr ns = new NoteSvr();
		Note n = form.get();
		ns.save(n);
		
		
		
		return redirect(routes.NoteCtrl.read());
		
	}
}
