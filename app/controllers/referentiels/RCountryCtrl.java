package controllers.referentiels;

import com.google.inject.Inject;
import models.util.EnvVarbl;
import play.data.FormFactory;
import play.mvc.Controller;
import play.mvc.Result;
import schemas.referential.tables.pojos.RCountry;
import services.referentiel.RCountrySvr;
import views.html.referentiels.*;
import play.data.Form;

public class RCountryCtrl extends Controller{
	@Inject
	FormFactory formFactory;
	
	@Inject
	RCountrySvr rCountrySvr;
	
	public Result getRCountryJson(String q) {
		// TODO Auto-generated method stub
		return ok(play.libs.Json.toJson(rCountrySvr.findByRCountry(q)));
	}
	
	public Result show(String subAction, Long rCountryPK) {
		RCountry rCntry = new RCountry();
		String viewMode = "";
		int page = 0; String filter = "";
		if (null == rCountryPK || rCountryPK == 0L) {
			rCntry = new RCountry();
			viewMode = EnvVarbl.VIEW_MODE_CREATE;
			return ok(rCountry.render(rCountrySvr.pageRCountry(page, EnvVarbl.pageSize, filter), filter, new RCountry(), viewMode));
		} else if (EnvVarbl.VIEW_MODE_EDIT.equals(subAction)) {
			rCntry = rCountrySvr.fetchOneById(rCountryPK);
			viewMode = EnvVarbl.VIEW_MODE_EDIT;
		} else if (EnvVarbl.VIEW_MODE_DELETE.equals(subAction)) {
			rCntry = rCountrySvr.fetchOneById(rCountryPK);
			viewMode = EnvVarbl.VIEW_MODE_DELETE;
		} else {
			viewMode = EnvVarbl.VIEW_MODE_VIEW;
			rCntry = rCountrySvr.fetchOneById(rCountryPK);
		}
		return ok(rCountry.render(rCountrySvr.pageRCountry(page, EnvVarbl.pageSize, filter), filter, rCntry, viewMode));
	}
	
	public Result save() {
		final String viewMode = formFactory.form().bindFromRequest().get("viewMode");
		final String rCountryPK = formFactory.form().bindFromRequest().get("rCountryPK-key");
		final String rCountryPKCode = formFactory.form().bindFromRequest().get("rCountryPK-code");
		String errorMessage = "";
		Form<RCountry> uForm = formFactory.form(RCountry.class).bindFromRequest();
		if (uForm.hasErrors()) {
			flash("ERROR", "Saisie erronée.");
			//return badRequest(versementChequeTier.render(new VersementCheque(), ViewType.VIEW_MODE_CREATE, generalDTOImpl.getRoIdentifiantInfo(0L, EnvironmentalVariables.TIER)));
		}
		RCountry rCntry = uForm.get();
		if (EnvVarbl.VIEW_MODE_EDIT.equals(viewMode)) {
			rCntry.setId(Long.parseLong(rCountryPK));
			//RCountry.setCode(courseCode);
			//errorMessage = courseSvr.validate(versementCheque, false);
			rCountrySvr.save(rCntry);
			flash("SUCCESS", "Course modifier.");
			return redirect(routes.RCountryCtrl.show(EnvVarbl.VIEW_MODE_CREATE, EnvVarbl.pageInit));
		} 
        if (EnvVarbl.VIEW_MODE_CREATE.equals(viewMode)) {
			//errorMessage = courseSvr.validate(versementCheque, true);
		} 
		if (null != errorMessage) {
			flash("ERROR", errorMessage);
			//return badRequest(versementChequeTier.render(versementCheque, ViewType.VIEW_MODE_CREATE, generalDTOImpl.getRoIdentifiantInfo(versementCheque.getId(), EnvironmentalVariables.TIER)));
		}
		rCountrySvr.save(rCntry);
		flash("SUCCESS", "Course enregistré.");
		return redirect(routes.RCountryCtrl.show(EnvVarbl.VIEW_MODE_CREATE, EnvVarbl.pageInit));
	}
		//String errorMessage = "";
		//Form<Course> form = formFactory.form(Course.class).bindFromRequest();
		//Course course = form.get();
		//courseSvr.save(course);
		//return redirect(routes.CourseCtrl.show(EnvVarbl.VIEW_MODE_CREATE, EnvVarbl.pageInit));
		
	//}
	
	public Result delete(Long rCountryPK) {
		RCountry rCntry = rCountrySvr.fetchOneById(rCountryPK);
		rCountrySvr.delete(rCntry);
		flash("SUCCESS", "La " + "" + " a été supprimé.");
		return redirect(routes.RCountryCtrl.show(EnvVarbl.VIEW_MODE_CREATE, EnvVarbl.pageInit));
	}
	
	public Result list(int page, String filter) {
		String viewMode = "";
 		return ok(rCountry.render(rCountrySvr.pageRCountry(page, EnvVarbl.pageSize, filter), filter, new RCountry(), viewMode));
	}
}
