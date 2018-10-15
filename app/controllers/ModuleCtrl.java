package controllers;

import com.google.inject.Inject;

import models.Module;
import play.data.Form;
import play.data.FormFactory;
import play.db.jpa.Transactional;
import play.mvc.Controller;
import play.mvc.Result;
import services.ModuleSvr;
import views.html.admin.*;

public class ModuleCtrl extends Controller{
	@Inject
	FormFactory formFactory;
	
	@Transactional
	public Result read() {
		ModuleSvr m = new ModuleSvr();
		
		return TODO;
	}
	
	@Transactional
	public Result save() {
		Form<Module> form = formFactory.form(Module.class).bindFromRequest();
		ModuleSvr ms = new ModuleSvr();
		Module m = form.get();
		ms.save(m);
		
		return TODO;
		
	}

}
