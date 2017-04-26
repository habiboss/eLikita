package controllers.referentiels;

import com.google.inject.Inject;
import models.referentiel.RProfil;
import play.data.Form;
import play.data.FormFactory;
import play.mvc.Controller;
import play.mvc.Result;
import services.ProfilSvr;
import views.html.referentiels.*;

public class ProfilCtrl extends Controller{
	
	@Inject
	FormFactory formFactory;
	@Inject
	RProfil rProfil;
	@Inject
	ProfilSvr profilSvr;
	
	public Result read() {
		
		return ok(profil.render(profilSvr.findList()));
	}
	
	public Result create() {
		Form<RProfil> form = formFactory.form(RProfil.class).bindFromRequest();
		profilSvr.save(form, rProfil);
		return null;
		
	}

}
