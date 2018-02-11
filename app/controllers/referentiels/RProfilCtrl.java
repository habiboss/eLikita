package controllers.referentiels;

import com.google.inject.Inject;
import models.util.EnvVarbl;
import play.data.Form;
import play.data.FormFactory;
import play.db.jpa.Transactional;
import play.mvc.Controller;
import play.mvc.Result;
import schemas.referential.tables.pojos.RProfil;
import services.ProfilSvr;
import services.referentiel.RProfilSvr;
import views.html.referentiels.*;

public class RProfilCtrl extends Controller{
	@Inject
	FormFactory formFactory;
	
	@Inject
	RProfilSvr rProfilSvr;
	
	public Result getRProfilJson(String q) {
		// TODO Auto-generated method stub
		return ok(play.libs.Json.toJson(rProfilSvr.findByRProfil(q)));
	}
	
	public Result show(String subAction, Long rProfilPK) {
		schemas.referential.tables.pojos.RProfil rPrfil = new schemas.referential.tables.pojos.RProfil();
		String viewMode = "";
		int page = 0; String filter = "";
		if (null == rProfilPK || rProfilPK == 0L) {
			rPrfil = new schemas.referential.tables.pojos.RProfil();
			viewMode = EnvVarbl.VIEW_MODE_CREATE;
			return ok(rProfil.render(rProfilSvr.pageRProfil(page, EnvVarbl.pageSize, filter), filter, new RProfil(), viewMode));
		} else if (EnvVarbl.VIEW_MODE_EDIT.equals(subAction)) {
			rPrfil = rProfilSvr.fetchOneById(rProfilPK);
			viewMode = EnvVarbl.VIEW_MODE_EDIT;
		} else if (EnvVarbl.VIEW_MODE_DELETE.equals(subAction)) {
			rPrfil = rProfilSvr.fetchOneById(rProfilPK);
			viewMode = EnvVarbl.VIEW_MODE_DELETE;
		} else {
			viewMode = EnvVarbl.VIEW_MODE_VIEW;
			rPrfil = rProfilSvr.fetchOneById(rProfilPK);
		}
		return ok(rProfil.render(rProfilSvr.pageRProfil(page, EnvVarbl.pageSize, filter), filter, rPrfil, viewMode));
	}
	
	public Result save() {
		final String viewMode = formFactory.form().bindFromRequest().get("viewMode");
		final String rProfilPK = formFactory.form().bindFromRequest().get("rProfilPK-key");
		//final String rProfilPK = formFactory.form().bindFromRequest().get("rProfilPK-code");
		String errorMessage = "";
		Form<schemas.referential.tables.pojos.RProfil> uForm = formFactory.form(schemas.referential.tables.pojos.RProfil.class).bindFromRequest();
		if (uForm.hasErrors()) {
			flash("ERROR", "Saisie erronée.");
			//return badRequest(versementChequeTier.render(new VersementCheque(), ViewType.VIEW_MODE_CREATE, generalDTOImpl.getRoIdentifiantInfo(0L, EnvironmentalVariables.TIER)));
		}
		schemas.referential.tables.pojos.RProfil rPrfil = uForm.get();
		if (EnvVarbl.VIEW_MODE_EDIT.equals(viewMode)) {
			rPrfil.setId(Long.parseLong(rProfilPK));
			//RProfil.setCode(courseCode);
			//errorMessage = courseSvr.validate(versementCheque, false);
			rProfilSvr.save(rPrfil);
			flash("SUCCESS", "Course modifier.");
			return redirect(routes.RProfilCtrl.show(EnvVarbl.VIEW_MODE_CREATE, EnvVarbl.pageInit));
		} 
        if (EnvVarbl.VIEW_MODE_CREATE.equals(viewMode)) {
			//errorMessage = courseSvr.validate(versementCheque, true);
		} 
		if (null != errorMessage) {
			flash("ERROR", errorMessage);
			//return badRequest(versementChequeTier.render(versementCheque, ViewType.VIEW_MODE_CREATE, generalDTOImpl.getRoIdentifiantInfo(versementCheque.getId(), EnvironmentalVariables.TIER)));
		}
		rProfilSvr.save(rPrfil);
		flash("SUCCESS", "Course enregistré.");
		return redirect(routes.RProfilCtrl.show(EnvVarbl.VIEW_MODE_CREATE, EnvVarbl.pageInit));
	}
		//String errorMessage = "";
		//Form<Course> form = formFactory.form(Course.class).bindFromRequest();
		//Course course = form.get();
		//courseSvr.save(course);
		//return redirect(routes.CourseCtrl.show(EnvVarbl.VIEW_MODE_CREATE, EnvVarbl.pageInit));
		
	//}
	
	public Result delete(Long rProfilPK) {
		RProfil rPrfil = rProfilSvr.fetchOneById(rProfilPK);
		rProfilSvr.delete(rPrfil);
		flash("SUCCESS", "La " + "" + " a été supprimé.");
		return redirect(routes.RProfilCtrl.show(EnvVarbl.VIEW_MODE_CREATE, EnvVarbl.pageInit));
	}
	
	public Result list(int page, String filter) {
		String viewMode = "";
 		return ok(rProfil.render(rProfilSvr.pageRProfil(page, EnvVarbl.pageSize, filter), filter, new RProfil(), viewMode));
	}
}
