package controllers;

import java.util.ArrayList;
import com.google.inject.Inject;
import models.Batch;
import models.util.SendEmail;
import play.data.Form;
import play.data.FormFactory;
import play.db.jpa.Transactional;
import play.mvc.Controller;
import play.mvc.Result;
import schemas.public_.tables.pojos.AboutInstitution;
import services.AboutInstitutionSvr;
import views.html.admin.*;

public class AboutInstitutionCtrl extends Controller{
	@Inject
	FormFactory formFactory;
	@Inject
	AboutInstitutionSvr aboutInstitutionSvr;
	@Inject
    AboutInstitution aboutInstitutions;
	@Inject
	SendEmail sendEmail;
	
	
	@Transactional
	public Result read() {
		
		return ok(aboutInstitution.render());
	}
	
	@Transactional
	public Result create() {
		Form<AboutInstitution> form = formFactory.form(AboutInstitution.class).bindFromRequest();
		aboutInstitutionSvr.save(form, aboutInstitutions);
		flash("SUCCESS", "Enregistrement");
		sendEmail.main();
		return redirect(routes.AboutInstitutionCtrl.read());
		
	}
	
	public Result list(int page, String filter) {
 		return ok(institutionLst.render(aboutInstitutionSvr.pageInstitution(page, 5, filter), filter));
	}
	
	public Result getInstitutionJson(String q) {
		// TODO Auto-generated method stub
		return ok(play.libs.Json.toJson(aboutInstitutionSvr.findByInstitution(q)));
	}
	
	public Result getInstitutionDetail(String instDetail) {
		// TODO Auto-generated method stub
		return ok(play.libs.Json.toJson(aboutInstitutionSvr.x(Long.parseLong(instDetail))));
	}

}
