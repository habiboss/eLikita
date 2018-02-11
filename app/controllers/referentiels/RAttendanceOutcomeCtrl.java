package controllers.referentiels;

import javax.inject.Inject;
import models.util.EnvVarbl;
import play.data.FormFactory;
import play.mvc.Controller;
import play.mvc.Result;
import schemas.referential.tables.pojos.RAttendanceOutcome;
import services.referentiel.RAttendanceOutcomeSvr;
import services.referentiel.RLevelSvr;
import play.data.Form;
import views.html.referentiels.*;

public class RAttendanceOutcomeCtrl extends Controller {
	@Inject
	FormFactory formFactory;

	@Inject
	RAttendanceOutcomeSvr rAttendanceOutcomeSvr;

	public Result getLevelJson(String q) {
		// TODO Auto-generated method stub
		return ok(play.libs.Json.toJson(rAttendanceOutcomeSvr.findByOutcome(q)));
	}

	public Result show(String subAction, Long rAttdceOutcomePK) {
		RAttendanceOutcome rAttdceOutcome  = new RAttendanceOutcome();
		String viewMode = "";
		int page = 0;
		String filter = "";
		if (null == rAttdceOutcomePK || rAttdceOutcomePK == 0L) {
			rAttdceOutcome = new RAttendanceOutcome();
			viewMode = EnvVarbl.VIEW_MODE_CREATE;
			return ok(rAttendanceOutcome.render(rAttendanceOutcomeSvr.pageRAttendanceOutcome(page, EnvVarbl.pageSize, filter), filter, new RAttendanceOutcome(),
					viewMode));
		} else if (EnvVarbl.VIEW_MODE_EDIT.equals(subAction)) {
			rAttdceOutcome = rAttendanceOutcomeSvr.fetchOneById(rAttdceOutcomePK);
			viewMode = EnvVarbl.VIEW_MODE_EDIT;
		} else if (EnvVarbl.VIEW_MODE_DELETE.equals(subAction)) {
			rAttdceOutcome = rAttendanceOutcomeSvr.fetchOneById(rAttdceOutcomePK);
			viewMode = EnvVarbl.VIEW_MODE_DELETE;
		} else {
			viewMode = EnvVarbl.VIEW_MODE_VIEW;
			rAttdceOutcome = rAttendanceOutcomeSvr.fetchOneById(rAttdceOutcomePK);
		}
		return ok(rAttendanceOutcome.render(rAttendanceOutcomeSvr.pageRAttendanceOutcome(page, EnvVarbl.pageSize, filter), filter, rAttdceOutcome, viewMode));
	}

	public Result save() {
		final String viewMode = formFactory.form().bindFromRequest().get("viewMode");
		final String rAttendanceOutcomePK = formFactory.form().bindFromRequest().get("rAttendanceOutcomePK-key");
		String errorMessage = "";
		Form<RAttendanceOutcome> uForm = formFactory.form(RAttendanceOutcome.class).bindFromRequest();
		if (uForm.hasErrors()) {
			flash("ERROR", "Saisie erronée.");
			// return badRequest(versementChequeTier.render(new VersementCheque(),
			// ViewType.VIEW_MODE_CREATE, generalDTOImpl.getRoIdentifiantInfo(0L,
			// EnvironmentalVariables.TIER)));
		}
		RAttendanceOutcome rAttdceOutcome = uForm.get();
		if (EnvVarbl.VIEW_MODE_EDIT.equals(viewMode)) {
			rAttdceOutcome.setId(Long.parseLong(rAttendanceOutcomePK));
			//course.setCode(courseCode);
			// errorMessage = courseSvr.validate(versementCheque, false);
			rAttendanceOutcomeSvr.save(rAttdceOutcome);
			flash("SUCCESS", "Course modifier.");
			return redirect(routes.RAttendanceOutcomeCtrl.show(EnvVarbl.VIEW_MODE_CREATE, EnvVarbl.pageInit));
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
		rAttendanceOutcomeSvr.save(rAttdceOutcome);
		flash("SUCCESS", "Course enregistré.");
		return redirect(routes.RAttendanceOutcomeCtrl.show(EnvVarbl.VIEW_MODE_CREATE, EnvVarbl.pageInit));
	}
	// String errorMessage = "";
	// Form<Course> form = formFactory.form(Course.class).bindFromRequest();
	// Course course = form.get();
	// courseSvr.save(course);
	// return redirect(routes.CourseCtrl.show(EnvVarbl.VIEW_MODE_CREATE,
	// EnvVarbl.pageInit));

	// }

	public Result delete(Long rAttendanceOutcomePK) {
		RAttendanceOutcome rAttdceOutcome = rAttendanceOutcomeSvr.fetchOneById(rAttendanceOutcomePK);
		rAttendanceOutcomeSvr.delete(rAttdceOutcome);
		flash("SUCCESS", "La " + "" + " a été supprimé.");
		return redirect(routes.RAttendanceOutcomeCtrl.show(EnvVarbl.VIEW_MODE_CREATE, EnvVarbl.pageInit));
	}

	public Result list(int page, String filter) {
		String viewMode = "";
		return ok(rAttendanceOutcome.render(rAttendanceOutcomeSvr.pageRAttendanceOutcome(page, EnvVarbl.pageSize, filter), filter, new RAttendanceOutcome(), viewMode));
	}
}
