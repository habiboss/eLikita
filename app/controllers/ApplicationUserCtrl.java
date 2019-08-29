package controllers;

import com.google.inject.Inject;

import play.data.Form;
import play.data.FormFactory;
import play.mvc.Controller;
import play.mvc.Result;
import schemas.public_.tables.pojos.ApplicationUser;
import services.ApplicationUserSvr;
import views.html.*;

public class ApplicationUserCtrl extends Controller{
	@Inject
	FormFactory formFactory;
	@Inject
	ApplicationUserSvr applicationUserSvr;
	
	public Result patient_registration() {	
		
		return ok(p_register.render());
	}
	
	public Result save() {
		Form<ApplicationUser> uForm = formFactory.form(ApplicationUser.class).bindFromRequest();
		ApplicationUser applicationUser = uForm.get();
		applicationUserSvr.save(applicationUser);
		flash("SUCCESS", "Donnee enregistré.");
		
		return redirect(controllers.utils.routes.Authentication.login());
	}
	

}
