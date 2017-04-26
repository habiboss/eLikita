package controllers;

import com.google.inject.Inject;

import models.AboutInstitution;
import models.Batch;
import play.data.Form;
import play.data.FormFactory;
import play.db.jpa.Transactional;
import play.mvc.Controller;
import play.mvc.Result;
import services.AboutInstitutionSvr;
import views.html.admin.*;

public class AboutInstitutionCtrl extends Controller{
	@Inject
	FormFactory formFactory;
	@Inject
	AboutInstitutionSvr aboutInstitutionSvr;
	@Inject
    AboutInstitution aboutInstitutions;
	
	@Transactional
	public Result read() {
		
		return ok(aboutInstitution.render());
	}
	
	@Transactional
	public Result create() {
		Form<AboutInstitution> form = formFactory.form(AboutInstitution.class).bindFromRequest();
		
		aboutInstitutionSvr.save(form, aboutInstitutions);
		return null;
		
	}

}
