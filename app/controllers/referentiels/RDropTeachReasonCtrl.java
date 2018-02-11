package controllers.referentiels;

import javax.inject.Inject;
import models.util.EnvVarbl;
import play.data.FormFactory;
import play.mvc.Controller;
import play.mvc.Result;
import schemas.referential.tables.pojos.RDropTeachReason;
import services.referentiel.RDropTeachReasonSvr;
import views.html.referentiels.*;
import play.data.Form;

public class RDropTeachReasonCtrl extends Controller{
	@Inject
	FormFactory formFactory;
	
	@Inject
	RDropTeachReasonSvr rDropTeachReasonSvr;

	public Result getRDropTeachReasonJson(String q) {
		// TODO Auto-generated method stub
		return ok(play.libs.Json.toJson(rDropTeachReasonSvr.findByRDropTeachReason(q)));
	}

	public Result show(String subAction, Long rDropTeachReasonPK) {
		RDropTeachReason rDrpTchReason = new RDropTeachReason();
		String viewMode = "";
		int page = 0;
		String filter = "";
		if (null == rDropTeachReasonPK || rDropTeachReasonPK == 0L) {
			rDrpTchReason = new RDropTeachReason();
			viewMode = EnvVarbl.VIEW_MODE_CREATE;
			return ok(rDropTeachReason.render(rDropTeachReasonSvr.pageRDropTeachReason(page, EnvVarbl.pageSize, filter),
					filter, new RDropTeachReason(), viewMode));
		} else if (EnvVarbl.VIEW_MODE_EDIT.equals(subAction)) {
			rDrpTchReason = rDropTeachReasonSvr.fetchOneById(rDropTeachReasonPK);
			viewMode = EnvVarbl.VIEW_MODE_EDIT;
		} else if (EnvVarbl.VIEW_MODE_DELETE.equals(subAction)) {
			rDrpTchReason = rDropTeachReasonSvr.fetchOneById(rDropTeachReasonPK);
			viewMode = EnvVarbl.VIEW_MODE_DELETE;
		} else {
			viewMode = EnvVarbl.VIEW_MODE_VIEW;
			rDrpTchReason = rDropTeachReasonSvr.fetchOneById(rDropTeachReasonPK);
		}
		return ok(rDropTeachReason.render(rDropTeachReasonSvr.pageRDropTeachReason(page, EnvVarbl.pageSize, filter),
				filter, rDrpTchReason, viewMode));
	}

	public Result save() {
		final String viewMode = formFactory.form().bindFromRequest().get("viewMode");
		final String rDropTeachReasonPK = formFactory.form().bindFromRequest().get("rDropTeachReasonPK-key");
		final String rDropTeachReasonPKCode = formFactory.form().bindFromRequest().get("rDropTeachReasonPK-code");
		String errorMessage = "";
		Form<RDropTeachReason> uForm = formFactory.form(RDropTeachReason.class).bindFromRequest();
		if (uForm.hasErrors()) {
			flash("ERROR", "Saisie erronée.");
			// return badRequest(versementChequeTier.render(new VersementCheque(),
			// ViewType.VIEW_MODE_CREATE, generalDTOImpl.getRoIdentifiantInfo(0L,
			// EnvironmentalVariables.TIER)));
		}
		RDropTeachReason rDrpTchReason = uForm.get();
		if (EnvVarbl.VIEW_MODE_EDIT.equals(viewMode)) {
			rDrpTchReason.setId(Long.parseLong(rDropTeachReasonPK));
			// RDropTeachReason.setCode(courseCode);
			// errorMessage = courseSvr.validate(versementCheque, false);
			rDropTeachReasonSvr.save(rDrpTchReason);
			flash("SUCCESS", "Course modifier.");
			return redirect(routes.RDropTeachReasonCtrl.show(EnvVarbl.VIEW_MODE_CREATE, EnvVarbl.pageInit));
		}
		if (EnvVarbl.VIEW_MODE_CREATE.equals(viewMode)) {
			// errorMessage = courseSvr.validate(versementCheque, true);
		}
		if (null != errorMessage) {
			flash("ERROR", errorMessage);
			// return badRequest(versementChequeTier.render(versementCheque,
			// ViewType.VIEW_MODE_CREATE,
			// generalDTOImpl.getRoIdentifiantInfo(versementCheque.getId(),
			// EnvironmentalVariables.TIER)));
		}
		rDropTeachReasonSvr.save(rDrpTchReason);
		flash("SUCCESS", "Course enregistré.");
		return redirect(routes.RDropTeachReasonCtrl.show(EnvVarbl.VIEW_MODE_CREATE, EnvVarbl.pageInit));
	}
	// String errorMessage = "";
	// Form<Course> form = formFactory.form(Course.class).bindFromRequest();
	// Course course = form.get();
	// courseSvr.save(course);
	// return redirect(routes.CourseCtrl.show(EnvVarbl.VIEW_MODE_CREATE,
	// EnvVarbl.pageInit));

	// }

	public Result delete(Long rDropTeachReasonPK) {
		RDropTeachReason rDrpTchReason = rDropTeachReasonSvr.fetchOneById(rDropTeachReasonPK);
		rDropTeachReasonSvr.delete(rDrpTchReason);
		flash("SUCCESS", "La " + "" + " a été supprimé.");
		return redirect(routes.RDropTeachReasonCtrl.show(EnvVarbl.VIEW_MODE_CREATE, EnvVarbl.pageInit));
	}

	public Result list(int page, String filter) {
		String viewMode = "";
		return ok(rDropTeachReason.render(rDropTeachReasonSvr.pageRDropTeachReason(page, EnvVarbl.pageSize, filter),
				filter, new RDropTeachReason(), viewMode));
	}
}
