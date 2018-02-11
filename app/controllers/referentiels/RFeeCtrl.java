package controllers.referentiels;

import javax.inject.Inject;
import models.util.EnvVarbl;
import play.data.Form;
import play.data.FormFactory;
import play.mvc.Controller;
import play.mvc.Result;
import schemas.referential.tables.pojos.RFee;
import services.referentiel.RFeeSvr;
import views.html.referentiels.*;

public class RFeeCtrl extends Controller{
	@Inject
	FormFactory formFactory;
	
	@Inject
	RFeeSvr rFeeSvr;
	
	public Result getRFeeJson(String q) {
		// TODO Auto-generated method stub
		return ok(play.libs.Json.toJson(rFeeSvr.findByRFee(q)));
	}
	
	public Result show(String subAction, Long rFeePK) {
		RFee rFees = new RFee();
		String viewMode = "";
		int page = 0; String filter = "";
		if (null == rFeePK || rFeePK == 0L) {
			rFees = new RFee();
			viewMode = EnvVarbl.VIEW_MODE_CREATE;
			return ok(rFee.render(rFeeSvr.pageRFee(page, EnvVarbl.pageSize, filter), filter, new RFee(), viewMode));
		} else if (EnvVarbl.VIEW_MODE_EDIT.equals(subAction)) {
			rFees = rFeeSvr.fetchOneById(rFeePK);
			viewMode = EnvVarbl.VIEW_MODE_EDIT;
		} else if (EnvVarbl.VIEW_MODE_DELETE.equals(subAction)) {
			rFees = rFeeSvr.fetchOneById(rFeePK);
			viewMode = EnvVarbl.VIEW_MODE_DELETE;
		} else {
			viewMode = EnvVarbl.VIEW_MODE_VIEW;
			rFees = rFeeSvr.fetchOneById(rFeePK);
		}
		return ok(rFee.render(rFeeSvr.pageRFee(page, EnvVarbl.pageSize, filter), filter, rFees, viewMode));
	}
	
	public Result save() {
		final String viewMode = formFactory.form().bindFromRequest().get("viewMode");
		final String rFeePK = formFactory.form().bindFromRequest().get("rFeePK-key");
 		String errorMessage = "";
		Form<RFee> uForm = formFactory.form(RFee.class).bindFromRequest();
		if (uForm.hasErrors()) {
			flash("ERROR", "Saisie erronée.");
			//return badRequest(versementChequeTier.render(new VersementCheque(), ViewType.VIEW_MODE_CREATE, generalDTOImpl.getRoIdentifiantInfo(0L, EnvironmentalVariables.TIER)));
		}
		RFee rFees = uForm.get();
		if (EnvVarbl.VIEW_MODE_EDIT.equals(viewMode)) {
			rFees.setId(Long.parseLong(rFeePK));
			//RFee.setCode(courseCode);
			//errorMessage = courseSvr.validate(versementCheque, false);
			rFeeSvr.save(rFees);
			flash("SUCCESS", "Course modifier.");
			return redirect(routes.RFeeCtrl.show(EnvVarbl.VIEW_MODE_CREATE, EnvVarbl.pageInit));
		} 
        if (EnvVarbl.VIEW_MODE_CREATE.equals(viewMode)) {
			//errorMessage = courseSvr.validate(versementCheque, true);
		} 
		if (null != errorMessage) {
			flash("ERROR", errorMessage);
			//return badRequest(versementChequeTier.render(versementCheque, ViewType.VIEW_MODE_CREATE, generalDTOImpl.getRoIdentifiantInfo(versementCheque.getId(), EnvironmentalVariables.TIER)));
		}
		rFeeSvr.save(rFees);
		flash("SUCCESS", "Course enregistré.");
		return redirect(routes.RFeeCtrl.show(EnvVarbl.VIEW_MODE_CREATE, EnvVarbl.pageInit));
	}
		//String errorMessage = "";
		//Form<Course> form = formFactory.form(Course.class).bindFromRequest();
		//Course course = form.get();
		//courseSvr.save(course);
		//return redirect(routes.CourseCtrl.show(EnvVarbl.VIEW_MODE_CREATE, EnvVarbl.pageInit));
		
	//}
	
	public Result delete(Long rFeePK) {
		RFee rFees = rFeeSvr.fetchOneById(rFeePK);
		rFeeSvr.delete(rFees);
		flash("SUCCESS", "La " + "" + " a été supprimé.");
		return redirect(routes.RFeeCtrl.show(EnvVarbl.VIEW_MODE_CREATE, EnvVarbl.pageInit));
	}
	
	public Result list(int page, String filter) {
		String viewMode = "";
 		return ok(rFee.render(rFeeSvr.pageRFee(page, EnvVarbl.pageSize, filter), filter, new RFee(), viewMode));
	}
}
