package controllers.referentiels;

import com.google.inject.Inject;
import views.html.referentiels.*;
import play.data.Form;
import play.data.FormFactory;
import play.db.jpa.Transactional;
import play.mvc.Controller;
import play.mvc.Result;
import schemas.referential.tables.pojos.RUserType;
import services.referentiel.RUserTypeSvr;
import models.util.EnvVarbl;

public class RUserCtrl extends Controller{
	@Inject
	FormFactory formFactory;

	@Inject
	RUserTypeSvr rUserTypeSvr;

	public Result getRUserJson(String q) {
		// TODO Auto-generated method stub
		return ok(play.libs.Json.toJson(rUserTypeSvr.findByRUserType(q)));
	}

	public Result show(String subAction, Long rUserTypeSvrPK) {
		schemas.referential.tables.pojos.RUserType rUsr = new schemas.referential.tables.pojos.RUserType();
		String viewMode = "";
		int page = 0;
		String filter = "";
		if (null == rUserTypeSvrPK || rUserTypeSvrPK == 0L) {
			rUsr = new schemas.referential.tables.pojos.RUserType();
			viewMode = EnvVarbl.VIEW_MODE_CREATE;
			return ok(rUser.render(rUserTypeSvr.pageRUserType(page, EnvVarbl.pageSize, filter), filter,
					new schemas.referential.tables.pojos.RUserType(), viewMode));
		} else if (EnvVarbl.VIEW_MODE_EDIT.equals(subAction)) {
			rUsr = rUserTypeSvr.fetchOneById(rUserTypeSvrPK);
			viewMode = EnvVarbl.VIEW_MODE_EDIT;
		} else if (EnvVarbl.VIEW_MODE_DELETE.equals(subAction)) {
			rUsr = rUserTypeSvr.fetchOneById(rUserTypeSvrPK);
			viewMode = EnvVarbl.VIEW_MODE_DELETE;
		} else {
			viewMode = EnvVarbl.VIEW_MODE_VIEW;
			rUsr = rUserTypeSvr.fetchOneById(rUserTypeSvrPK);
		}
		return ok(rUser.render(rUserTypeSvr.pageRUserType(page, EnvVarbl.pageSize, filter), filter, rUsr,
				viewMode));
	}

	public Result save() {
		final String viewMode = formFactory.form().bindFromRequest().get("viewMode");
		final String rUserTypeSvrPK = formFactory.form().bindFromRequest().get("rUser-key");
		final String rUserTypeSvrPKCode = formFactory.form().bindFromRequest().get("RUser-code");
		String errorMessage = "";
		Form<schemas.referential.tables.pojos.RUserType> uForm = formFactory.form(schemas.referential.tables.pojos.RUserType.class).bindFromRequest();
		if (uForm.hasErrors()) {
			flash("ERROR", "Saisie erronée.");
			// return badRequest(versementChequeTier.render(new VersementCheque(),
			// ViewType.VIEW_MODE_CREATE, generalDTOImpl.getRoIdentifiantInfo(0L,
			// EnvironmentalVariables.TIER)));
		}
		schemas.referential.tables.pojos.RUserType rUsr = uForm.get();
		if (EnvVarbl.VIEW_MODE_EDIT.equals(viewMode)) {
			rUsr.setId(Long.parseLong(rUserTypeSvrPK));
			// course.setCode(courseCode);
			// errorMessage = courseSvr.validate(versementCheque, false);
			rUserTypeSvr.save(rUsr);
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
		rUserTypeSvr.save(rUsr);
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

	public Result delete(Long rUserTypeSvrPK) {
		schemas.referential.tables.pojos.RUserType rCtctPrsType = rUserTypeSvr.fetchOneById(rUserTypeSvrPK);
		rUserTypeSvr.delete(rCtctPrsType);
		flash("SUCCESS", "La " + "" + " a été supprimé.");
		return redirect(routes.RUserCtrl.show(EnvVarbl.VIEW_MODE_CREATE, EnvVarbl.pageInit));
	}

	public Result list(int page, String filter) {
		String viewMode = "";
		return ok(rUser.render(rUserTypeSvr.pageRUserType(page, EnvVarbl.pageSize, filter), filter, new RUserType(),
				viewMode));
	}

}
