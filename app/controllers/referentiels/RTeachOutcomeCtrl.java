package controllers.referentiels;

import javax.inject.Inject;
import play.data.FormFactory;
import play.mvc.Controller;
import play.mvc.Result;
import schemas.referential.tables.pojos.RTeachOutcome;
import services.referentiel.RTeachOutcomeSvr;
import models.util.EnvVarbl;
import views.html.referentiels.*;
import play.data.Form;

public class RTeachOutcomeCtrl extends Controller{
	@Inject
	FormFactory formFactory;
	
	@Inject
	RTeachOutcomeSvr rTeachOutcomeSvr;
	
	public Result getRTeachOutcomeJson(String q) {
		// TODO Auto-generated method stub
		return ok(play.libs.Json.toJson(rTeachOutcomeSvr.findByRTeachOutcome(q)));
	}
	
	public Result show(String subAction, Long rTeachOutcomePK) {
		RTeachOutcome rTchOutcome = new RTeachOutcome();
		String viewMode = "";
		int page = 0; String filter = "";
		if (null == rTeachOutcomePK || rTeachOutcomePK == 0L) {
			rTchOutcome = new RTeachOutcome();
			viewMode = EnvVarbl.VIEW_MODE_CREATE;
			return ok(rTeachOutcome.render(rTeachOutcomeSvr.pageRTeachOutcome(page, EnvVarbl.pageSize, filter), filter, new RTeachOutcome(), viewMode));
		} else if (EnvVarbl.VIEW_MODE_EDIT.equals(subAction)) {
			rTchOutcome = rTeachOutcomeSvr.fetchOneById(rTeachOutcomePK);
			viewMode = EnvVarbl.VIEW_MODE_EDIT;
		} else if (EnvVarbl.VIEW_MODE_DELETE.equals(subAction)) {
			rTchOutcome = rTeachOutcomeSvr.fetchOneById(rTeachOutcomePK);
			viewMode = EnvVarbl.VIEW_MODE_DELETE;
		} else {
			viewMode = EnvVarbl.VIEW_MODE_VIEW;
			rTchOutcome = rTeachOutcomeSvr.fetchOneById(rTeachOutcomePK);
		}
		return ok(rTeachOutcome.render(rTeachOutcomeSvr.pageRTeachOutcome(page, EnvVarbl.pageSize, filter), filter, rTchOutcome, viewMode));
	}
	
	public Result save() {
		final String viewMode = formFactory.form().bindFromRequest().get("viewMode");
		final String rTeachOutcomePK = formFactory.form().bindFromRequest().get("rTeachOutcomePK-key");
		final String rTeachOutcomePKCode = formFactory.form().bindFromRequest().get("rTeachOutcomePK-code");
		String errorMessage = "";
		Form<RTeachOutcome> uForm = formFactory.form(RTeachOutcome.class).bindFromRequest();
		if (uForm.hasErrors()) {
			flash("ERROR", "Saisie erronée.");
			//return badRequest(versementChequeTier.render(new VersementCheque(), ViewType.VIEW_MODE_CREATE, generalDTOImpl.getRoIdentifiantInfo(0L, EnvironmentalVariables.TIER)));
		}
		RTeachOutcome rTchOutcome = uForm.get();
		if (EnvVarbl.VIEW_MODE_EDIT.equals(viewMode)) {
			rTchOutcome.setId(Long.parseLong(rTeachOutcomePK));
			//RTeachOutcome.setCode(courseCode);
			//errorMessage = courseSvr.validate(versementCheque, false);
			rTeachOutcomeSvr.save(rTchOutcome);
			flash("SUCCESS", "Course modifier.");
			return redirect(routes.RTeachOutcomeCtrl.show(EnvVarbl.VIEW_MODE_CREATE, EnvVarbl.pageInit));
		} 
        if (EnvVarbl.VIEW_MODE_CREATE.equals(viewMode)) {
			//errorMessage = courseSvr.validate(versementCheque, true);
		} 
		if (null != errorMessage) {
			flash("ERROR", errorMessage);
			//return badRequest(versementChequeTier.render(versementCheque, ViewType.VIEW_MODE_CREATE, generalDTOImpl.getRoIdentifiantInfo(versementCheque.getId(), EnvironmentalVariables.TIER)));
		}
		rTeachOutcomeSvr.save(rTchOutcome);
		flash("SUCCESS", "Course enregistré.");
		return redirect(routes.RTeachOutcomeCtrl.show(EnvVarbl.VIEW_MODE_CREATE, EnvVarbl.pageInit));
	}
		//String errorMessage = "";
		//Form<Course> form = formFactory.form(Course.class).bindFromRequest();
		//Course course = form.get();
		//courseSvr.save(course);
		//return redirect(routes.CourseCtrl.show(EnvVarbl.VIEW_MODE_CREATE, EnvVarbl.pageInit));
		
	//}
	
	public Result delete(Long rTeachOutcomePK) {
		RTeachOutcome rTchOutcome = rTeachOutcomeSvr.fetchOneById(rTeachOutcomePK);
		rTeachOutcomeSvr.delete(rTchOutcome);
		flash("SUCCESS", "La " + "" + " a été supprimé.");
		return redirect(routes.RTeachOutcomeCtrl.show(EnvVarbl.VIEW_MODE_CREATE, EnvVarbl.pageInit));
	}
	
	public Result list(int page, String filter) {
		String viewMode = "";
 		return ok(rTeachOutcome.render(rTeachOutcomeSvr.pageRTeachOutcome(page, EnvVarbl.pageSize, filter), filter, new RTeachOutcome(), viewMode));
	}
}
