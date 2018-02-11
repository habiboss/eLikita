package controllers.referentiels;

import com.google.inject.Inject;
import views.html.referentiels.*;
import play.data.Form;
import play.data.FormFactory;
import play.db.jpa.Transactional;
import play.mvc.Controller;
import play.mvc.Result;
import services.referentiel.RUserSvr;
import models.util.EnvVarbl;

public class RUserCtrl extends Controller{
	@Inject
	FormFactory formFactory;

	@Inject
	RUserSvr rUsrSvr;

	public Result getRUserJson(String q) {
		// TODO Auto-generated method stub
		return null;//ok(play.libs.Json.toJson(rUsrSvr.findById(id)(q)));
	}

	public Result show(String subAction, Long rUsrSvrPK) {
		schemas.referential.tables.pojos.RUser rUsr = new schemas.referential.tables.pojos.RUser();
		String viewMode = "";
		int page = 0;
		String filter = "";
		if (null == rUsrSvrPK || rUsrSvrPK == 0L) {
			rUsr = new schemas.referential.tables.pojos.RUser();
			viewMode = EnvVarbl.VIEW_MODE_CREATE;
			return ok(rUser.render(rUsrSvr.pageRUser(page, EnvVarbl.pageSize, filter), filter,
					new schemas.referential.tables.pojos.RUser(), viewMode));
		} else if (EnvVarbl.VIEW_MODE_EDIT.equals(subAction)) {
			rUsr = rUsrSvr.fetchOneById(rUsrSvrPK);
			viewMode = EnvVarbl.VIEW_MODE_EDIT;
		} else if (EnvVarbl.VIEW_MODE_DELETE.equals(subAction)) {
			rUsr = rUsrSvr.fetchOneById(rUsrSvrPK);
			viewMode = EnvVarbl.VIEW_MODE_DELETE;
		} else {
			viewMode = EnvVarbl.VIEW_MODE_VIEW;
			rUsr = rUsrSvr.fetchOneById(rUsrSvrPK);
		}
		return ok(rUser.render(rUsrSvr.pageRUser(page, EnvVarbl.pageSize, filter), filter, rUsr,
				viewMode));
	}

	public Result save() {
		final String viewMode = formFactory.form().bindFromRequest().get("viewMode");
		final String rUsrSvrPK = formFactory.form().bindFromRequest().get("rUser-key");
		final String rUsrSvrPKCode = formFactory.form().bindFromRequest().get("RUser-code");
		String errorMessage = "";
		Form<schemas.referential.tables.pojos.RUser> uForm = formFactory.form(schemas.referential.tables.pojos.RUser.class).bindFromRequest();
		if (uForm.hasErrors()) {
			flash("ERROR", "Saisie erronée.");
			// return badRequest(versementChequeTier.render(new VersementCheque(),
			// ViewType.VIEW_MODE_CREATE, generalDTOImpl.getRoIdentifiantInfo(0L,
			// EnvironmentalVariables.TIER)));
		}
		schemas.referential.tables.pojos.RUser rUsr = uForm.get();
		if (EnvVarbl.VIEW_MODE_EDIT.equals(viewMode)) {
			rUsr.setId(Long.parseLong(rUsrSvrPK));
			// course.setCode(courseCode);
			// errorMessage = courseSvr.validate(versementCheque, false);
			rUsrSvr.save(rUsr);
			flash("SUCCESS", "Course modifier.");
			return redirect(routes.RUserCtrl.show(EnvVarbl.VIEW_MODE_CREATE, EnvVarbl.pageInit));
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
		rUsrSvr.save(rUsr);
		flash("SUCCESS", "Course enregistré.");
		return redirect(routes.RUserCtrl.show(EnvVarbl.VIEW_MODE_CREATE, EnvVarbl.pageInit));
	}
	// String errorMessage = "";
	// Form<Course> form = formFactory.form(Course.class).bindFromRequest();
	// Course course = form.get();
	// courseSvr.save(course);
	// return redirect(routes.CourseCtrl.show(EnvVarbl.VIEW_MODE_CREATE,
	// EnvVarbl.pageInit));

	// }

	public Result delete(Long rUsrSvrPK) {
		schemas.referential.tables.pojos.RUser rCtctPrsType = rUsrSvr.fetchOneById(rUsrSvrPK);
		rUsrSvr.delete(rCtctPrsType);
		flash("SUCCESS", "La " + "" + " a été supprimé.");
		return redirect(routes.RUserCtrl.show(EnvVarbl.VIEW_MODE_CREATE, EnvVarbl.pageInit));
	}

	public Result list(int page, String filter) {
		String viewMode = "";
		return ok(rUser.render(rUsrSvr.pageRUser(page, EnvVarbl.pageSize, filter), filter, new schemas.referential.tables.pojos.RUser(),
				viewMode));
	}

}
