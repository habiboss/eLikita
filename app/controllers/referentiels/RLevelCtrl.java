package controllers.referentiels;

import javax.inject.Inject;
import models.util.EnvVarbl;
import play.data.FormFactory;
import play.mvc.Controller;
import play.mvc.Result;
import schemas.referential.tables.pojos.RLevel;
import services.referentiel.RLevelSvr;
import play.data.Form;
import views.html.referentiels.*;

public class RLevelCtrl extends Controller{
	@Inject
	FormFactory formFactory;
	
	@Inject
	RLevelSvr rLevelSvr;

	public Result getLevelJson(String q) {
		// TODO Auto-generated method stub
		return ok(play.libs.Json.toJson(rLevelSvr.findByRLevel(q)));
	}
	
	public Result show(String subAction, Long rLevelPK) {
		RLevel rLvl = new RLevel();
		String viewMode = "";
		int page = 0; String filter = "";
		if (null == rLevelPK || rLevelPK == 0L) {
			rLvl = new RLevel();
			viewMode = EnvVarbl.VIEW_MODE_CREATE;
			return ok(rLevel.render(rLevelSvr.pageRLevel(page, EnvVarbl.pageSize, filter), filter, new RLevel(), viewMode));
		} else if (EnvVarbl.VIEW_MODE_EDIT.equals(subAction)) {
			rLvl = rLevelSvr.fetchOneById(rLevelPK);
			viewMode = EnvVarbl.VIEW_MODE_EDIT;
		} else if (EnvVarbl.VIEW_MODE_DELETE.equals(subAction)) {
			rLvl = rLevelSvr.fetchOneById(rLevelPK);
			viewMode = EnvVarbl.VIEW_MODE_DELETE;
		} else {
			viewMode = EnvVarbl.VIEW_MODE_VIEW;
			rLvl = rLevelSvr.fetchOneById(rLevelPK);
		}
		return ok(rLevel.render(rLevelSvr.pageRLevel(page, EnvVarbl.pageSize, filter), filter, rLvl, viewMode));
	}
	
	public Result save() {
		final String viewMode = formFactory.form().bindFromRequest().get("viewMode");
		final String rLevelPK = formFactory.form().bindFromRequest().get("rLevelPK-key");
		final String courseCode = formFactory.form().bindFromRequest().get("rLevelPK-code");
		String errorMessage = "";
		Form<RLevel> uForm = formFactory.form(RLevel.class).bindFromRequest();
		if (uForm.hasErrors()) {
			flash("ERROR", "Saisie erronée.");
			//return badRequest(versementChequeTier.render(new VersementCheque(), ViewType.VIEW_MODE_CREATE, generalDTOImpl.getRoIdentifiantInfo(0L, EnvironmentalVariables.TIER)));
		}
		RLevel rLvl = uForm.get();
		if (EnvVarbl.VIEW_MODE_EDIT.equals(viewMode)) {
			rLvl.setId(Long.parseLong(rLevelPK));
			//rLvl.setCode(courseCode);
			//errorMessage = courseSvr.validate(versementCheque, false);
			rLevelSvr.save(rLvl);
			flash("SUCCESS", "Course modifier.");
			return redirect(routes.RLevelCtrl.show(EnvVarbl.VIEW_MODE_CREATE, EnvVarbl.pageInit));
		} 
        if (EnvVarbl.VIEW_MODE_CREATE.equals(viewMode)) {
			//errorMessage = courseSvr.validate(versementCheque, true);
		} 
		if (null != errorMessage) {
			flash("ERROR", errorMessage);
			//return badRequest(versementChequeTier.render(versementCheque, ViewType.VIEW_MODE_CREATE, generalDTOImpl.getRoIdentifiantInfo(versementCheque.getId(), EnvironmentalVariables.TIER)));
		}
		rLevelSvr.save(rLvl);
		flash("SUCCESS", "Course enregistré.");
		return redirect(routes.RLevelCtrl.show(EnvVarbl.VIEW_MODE_CREATE, EnvVarbl.pageInit));
	}
		//String errorMessage = "";
		//Form<Course> form = formFactory.form(Course.class).bindFromRequest();
		//Course course = form.get();
		//courseSvr.save(course);
		//return redirect(routes.CourseCtrl.show(EnvVarbl.VIEW_MODE_CREATE, EnvVarbl.pageInit));
		
	//}
	
	public Result delete(Long rLevelPK) {
		RLevel rLvl = rLevelSvr.fetchOneById(rLevelPK);
		rLevelSvr.delete(rLvl);
		flash("SUCCESS", "La " + "" + " a été supprimé.");
		return redirect(routes.RLevelCtrl.show(EnvVarbl.VIEW_MODE_CREATE, EnvVarbl.pageInit));
	}
	
	public Result list(int page, String filter) {
		String viewMode = "";
 		return ok(rLevel.render(rLevelSvr.pageRLevel(page, EnvVarbl.pageSize, filter), filter, new RLevel(), viewMode));
	}
}
