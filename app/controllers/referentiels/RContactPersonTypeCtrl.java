package controllers.referentiels;

import javax.inject.Inject;
import models.util.EnvVarbl;
import play.data.FormFactory;
import play.mvc.Controller;
import play.mvc.Result;
import schemas.referential.tables.pojos.RContactPersonType;
import services.referentiel.RContactPersonTypeSvr;
import views.html.referentiels.*;
import play.data.Form;

public class RContactPersonTypeCtrl extends Controller {
	@Inject
	FormFactory formFactory;

	@Inject
	RContactPersonTypeSvr rCtctPrsTypeSvr;

	public Result getRContactPersonTypeJson(String q) {
		// TODO Auto-generated method stub
		return ok(play.libs.Json.toJson(rCtctPrsTypeSvr.findByRContactPersonType(q)));
	}

	public Result show(String subAction, Long rCtctPrsTypePK) {
		schemas.referential.tables.pojos.RContactPersonType rCtctPrsType = new schemas.referential.tables.pojos.RContactPersonType();
		String viewMode = "";
		int page = 0;
		String filter = "";
		if (null == rCtctPrsTypePK || rCtctPrsTypePK == 0L) {
			rCtctPrsType = new RContactPersonType();
			viewMode = EnvVarbl.VIEW_MODE_CREATE;
			return ok(rContactPersonType.render(rCtctPrsTypeSvr.pageRContactPersonType(page, EnvVarbl.pageSize, filter), filter,
					new RContactPersonType(), viewMode));
		} else if (EnvVarbl.VIEW_MODE_EDIT.equals(subAction)) {
			rCtctPrsType = rCtctPrsTypeSvr.fetchOneById(rCtctPrsTypePK);
			viewMode = EnvVarbl.VIEW_MODE_EDIT;
		} else if (EnvVarbl.VIEW_MODE_DELETE.equals(subAction)) {
			rCtctPrsType = rCtctPrsTypeSvr.fetchOneById(rCtctPrsTypePK);
			viewMode = EnvVarbl.VIEW_MODE_DELETE;
		} else {
			viewMode = EnvVarbl.VIEW_MODE_VIEW;
			rCtctPrsType = rCtctPrsTypeSvr.fetchOneById(rCtctPrsTypePK);
		}
		return ok(rContactPersonType.render(rCtctPrsTypeSvr.pageRContactPersonType(page, EnvVarbl.pageSize, filter), filter, rCtctPrsType,
				viewMode));
	}

	public Result save() {
		final String viewMode = formFactory.form().bindFromRequest().get("viewMode");
		final String rCtctPrsTypePK = formFactory.form().bindFromRequest().get("rContactPersonType-key");
		String errorMessage = "";
		Form<schemas.referential.tables.pojos.RContactPersonType> uForm = formFactory.form(schemas.referential.tables.pojos.RContactPersonType.class).bindFromRequest();
		if (uForm.hasErrors()) {
			flash("ERROR", "Saisie erronée.");
			// return badRequest(versementChequeTier.render(new VersementCheque(),
			// ViewType.VIEW_MODE_CREATE, generalDTOImpl.getRoIdentifiantInfo(0L,
			// EnvironmentalVariables.TIER)));
		}
		schemas.referential.tables.pojos.RContactPersonType rCtctPrsType = uForm.get();
		if (EnvVarbl.VIEW_MODE_EDIT.equals(viewMode)) {
			rCtctPrsType.setId(Long.parseLong(rCtctPrsTypePK));
			// course.setCode(courseCode);
			// errorMessage = courseSvr.validate(versementCheque, false);
			rCtctPrsTypeSvr.save(rCtctPrsType);
			flash("SUCCESS", "Course modifier.");
			return redirect(routes.RContactPersonTypeCtrl.show(EnvVarbl.VIEW_MODE_CREATE, EnvVarbl.pageInit));
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
		rCtctPrsTypeSvr.save(rCtctPrsType);
		flash("SUCCESS", "Course enregistré.");
		return redirect(routes.RContactPersonTypeCtrl.show(EnvVarbl.VIEW_MODE_CREATE, EnvVarbl.pageInit));
	}
	// String errorMessage = "";
	// Form<Course> form = formFactory.form(Course.class).bindFromRequest();
	// Course course = form.get();
	// courseSvr.save(course);
	// return redirect(routes.CourseCtrl.show(EnvVarbl.VIEW_MODE_CREATE,
	// EnvVarbl.pageInit));

	// }

	public Result delete(Long rCtctPrsTypePK) {
		schemas.referential.tables.pojos.RContactPersonType rCtctPrsType = rCtctPrsTypeSvr.fetchOneById(rCtctPrsTypePK);
		rCtctPrsTypeSvr.delete(rCtctPrsType);
		flash("SUCCESS", "La " + "" + " a été supprimé.");
		return redirect(routes.RContactPersonTypeCtrl.show(EnvVarbl.VIEW_MODE_CREATE, EnvVarbl.pageInit));
	}

	public Result list(int page, String filter) {
		String viewMode = "";
		return ok(rContactPersonType.render(rCtctPrsTypeSvr.pageRContactPersonType(page, EnvVarbl.pageSize, filter), filter, new schemas.referential.tables.pojos.RContactPersonType(),
				viewMode));
	}
}
