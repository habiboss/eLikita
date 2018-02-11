package controllers.referentiels;

import com.google.inject.Inject;
import models.util.EnvVarbl;
import play.data.FormFactory;
import play.mvc.Controller;
import play.mvc.Result;
import schemas.referential.tables.pojos.RClassType;
import services.referentiel.RClassTypeSvr;
import views.html.referentiels.*;
import play.data.Form;

public class RClassTypeCtrl extends Controller{
	@Inject
	FormFactory formFactory;
	@Inject
	RClassTypeSvr rClassTypeSvr;
	
	public Result getClassTypeJson(String q) {
		// TODO Auto-generated method stub
		return ok(play.libs.Json.toJson(rClassTypeSvr.findByRClassType(q)));
	}
	
	public Result show(String subAction, Long rClassTypePK) {
		RClassType rClssType = new RClassType();
		String viewMode = "";
		int page = 0; String filter = "";
		if (null == rClassTypePK || rClassTypePK == 0L) {
			rClssType = new RClassType();
			viewMode = EnvVarbl.VIEW_MODE_CREATE;
			return ok(rClassType.render(rClassTypeSvr.pageRClassType(page, EnvVarbl.pageSize, filter), filter, new RClassType(), viewMode));
		} else if (EnvVarbl.VIEW_MODE_EDIT.equals(subAction)) {
			rClssType = rClassTypeSvr.fetchOneById(rClassTypePK);
			viewMode = EnvVarbl.VIEW_MODE_EDIT;
		} else if (EnvVarbl.VIEW_MODE_DELETE.equals(subAction)) {
			rClssType = rClassTypeSvr.fetchOneById(rClassTypePK);
			viewMode = EnvVarbl.VIEW_MODE_DELETE;
		} else {
			viewMode = EnvVarbl.VIEW_MODE_VIEW;
			rClssType = rClassTypeSvr.fetchOneById(rClassTypePK);
		}
		return ok(rClassType.render(rClassTypeSvr.pageRClassType(page, EnvVarbl.pageSize, filter), filter, rClssType, viewMode));
	}
	
	public Result save() {
		final String viewMode = formFactory.form().bindFromRequest().get("viewMode");
		final String rClassTypePK = formFactory.form().bindFromRequest().get("rClassTypePK-key");
		String errorMessage = "";
		Form<RClassType> uForm = formFactory.form(RClassType.class).bindFromRequest();
		if (uForm.hasErrors()) {
			flash("ERROR", "Saisie erronée.");
			//return badRequest(versementChequeTier.render(new VersementCheque(), ViewType.VIEW_MODE_CREATE, generalDTOImpl.getRoIdentifiantInfo(0L, EnvironmentalVariables.TIER)));
		}
		RClassType rClassType = uForm.get();
		if (EnvVarbl.VIEW_MODE_EDIT.equals(viewMode)) {
			rClassType.setId(Long.parseLong(rClassTypePK));
			//rClassType.setCode(courseCode);
			//errorMessage = courseSvr.validate(versementCheque, false);
			rClassTypeSvr.save(rClassType);
			flash("SUCCESS", "Course modifier.");
			return redirect(routes.RClassTypeCtrl.show(EnvVarbl.VIEW_MODE_CREATE, EnvVarbl.pageInit));
		} 
        if (EnvVarbl.VIEW_MODE_CREATE.equals(viewMode)) {
			//errorMessage = courseSvr.validate(versementCheque, true);
		} 
		if (null != errorMessage) {
			flash("ERROR", errorMessage);
			//return badRequest(versementChequeTier.render(versementCheque, ViewType.VIEW_MODE_CREATE, generalDTOImpl.getRoIdentifiantInfo(versementCheque.getId(), EnvironmentalVariables.TIER)));
		}
		rClassTypeSvr.save(rClassType);
		flash("SUCCESS", "Course enregistré.");
		return redirect(routes.RClassTypeCtrl.show(EnvVarbl.VIEW_MODE_CREATE, EnvVarbl.pageInit));
	}
		//String errorMessage = "";
		//Form<Course> form = formFactory.form(Course.class).bindFromRequest();
		//Course course = form.get();
		//courseSvr.save(course);
		//return redirect(routes.CourseCtrl.show(EnvVarbl.VIEW_MODE_CREATE, EnvVarbl.pageInit));
		
	//}
	
	public Result delete(Long rClassTypePK) {
		RClassType rClassType = rClassTypeSvr.fetchOneById(rClassTypePK);
		rClassTypeSvr.delete(rClassType);
		flash("SUCCESS", "La " + "" + " a été supprimé.");
		return redirect(routes.RClassTypeCtrl.show(EnvVarbl.VIEW_MODE_CREATE, EnvVarbl.pageInit));
	}
	
	public Result list(int page, String filter) {
		String viewMode = "";
 		return ok(rClassType.render(rClassTypeSvr.pageRClassType(page, EnvVarbl.pageSize, filter), filter, new RClassType(), viewMode));
	}
}
