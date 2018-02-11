package controllers.referentiels;

import javax.inject.Inject;
import play.data.FormFactory;
import play.mvc.Controller;
import play.mvc.Result;
import schemas.referential.tables.pojos.RCategory;
import services.referentiel.RCategorySvr;
import models.util.EnvVarbl;
import views.html.referentiels.*;
import play.data.Form;

public class RCategoryCtrl extends Controller {
	@Inject
	FormFactory formFactory;

	@Inject
	RCategorySvr rCategorySvr;

	public Result getRCategoryJson(String q) {
		// TODO Auto-generated method stub
		return ok(play.libs.Json.toJson(rCategorySvr.findByRCategory(q)));
	}

	public Result show(String subAction, Long rCategoryPK) {
		RCategory rCtgry  = new RCategory();
		String viewMode = "";
		int page = 0;
		String filter = "";
		if (null == rCategoryPK || rCategoryPK == 0L) {
			rCtgry = new RCategory();
			viewMode = EnvVarbl.VIEW_MODE_CREATE;
			return ok(rCategory.render(rCategorySvr.pageRCategory(page, EnvVarbl.pageSize, filter), filter, new RCategory(),
					viewMode));
		} else if (EnvVarbl.VIEW_MODE_EDIT.equals(subAction)) {
			rCtgry = rCategorySvr.fetchOneById(rCategoryPK);
			viewMode = EnvVarbl.VIEW_MODE_EDIT;
		} else if (EnvVarbl.VIEW_MODE_DELETE.equals(subAction)) {
			rCtgry = rCategorySvr.fetchOneById(rCategoryPK);
			viewMode = EnvVarbl.VIEW_MODE_DELETE;
		} else {
			viewMode = EnvVarbl.VIEW_MODE_VIEW;
			rCtgry = rCategorySvr.fetchOneById(rCategoryPK);
		}
		return ok(rCategory.render(rCategorySvr.pageRCategory(page, EnvVarbl.pageSize, filter), filter, rCtgry, viewMode));
	}

	public Result save() {
		final String viewMode = formFactory.form().bindFromRequest().get("viewMode");
		final String rCategoryPK = formFactory.form().bindFromRequest().get("rCategory-key");
 		String errorMessage = "";
		Form<RCategory> uForm = formFactory.form(RCategory.class).bindFromRequest();
		if (uForm.hasErrors()) {
			flash("ERROR", "Saisie erronée.");
			// return badRequest(versementChequeTier.render(new VersementCheque(),
			// ViewType.VIEW_MODE_CREATE, generalDTOImpl.getRoIdentifiantInfo(0L,
			// EnvironmentalVariables.TIER)));
		}
		RCategory rCtgry = uForm.get();
		if (EnvVarbl.VIEW_MODE_EDIT.equals(viewMode)) {
			rCtgry.setId(Long.parseLong(rCategoryPK));
			//course.setCode(courseCode);
			// errorMessage = courseSvr.validate(versementCheque, false);
			rCategorySvr.save(rCtgry);
			flash("SUCCESS", "Course modifier.");
			return redirect(routes.RCategoryCtrl.show(EnvVarbl.VIEW_MODE_CREATE, EnvVarbl.pageInit));
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
		rCategorySvr.save(rCtgry);
		flash("SUCCESS", "Course enregistré.");
		return redirect(routes.RCategoryCtrl.show(EnvVarbl.VIEW_MODE_CREATE, EnvVarbl.pageInit));
	}
	// String errorMessage = "";
	// Form<Course> form = formFactory.form(Course.class).bindFromRequest();
	// Course course = form.get();
	// courseSvr.save(course);
	// return redirect(routes.CourseCtrl.show(EnvVarbl.VIEW_MODE_CREATE,
	// EnvVarbl.pageInit));

	// }

	public Result delete(Long rCategoryPK) {
		RCategory rCtgry = rCategorySvr.fetchOneById(rCategoryPK);
		rCategorySvr.delete(rCtgry);
		flash("SUCCESS", "La " + "" + " a été supprimé.");
		return redirect(routes.RCategoryCtrl.show(EnvVarbl.VIEW_MODE_CREATE, EnvVarbl.pageInit));
	}

	public Result list(int page, String filter) {
		String viewMode = "";
		return ok(rCategory.render(rCategorySvr.pageRCategory(page, EnvVarbl.pageSize, filter), filter, new RCategory(), viewMode));
	}
}
