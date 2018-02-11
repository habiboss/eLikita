package controllers.referentiels;

import javax.inject.Inject;
import models.util.EnvVarbl;
import play.data.FormFactory;
import play.mvc.Controller;
import play.mvc.Result;
import schemas.referential.tables.pojos.RDropAttendanceReason;
import services.referentiel.RDropAttendanceReasonSvr;
import views.html.referentiels.*;
import play.data.Form;

public class RDropAttendanceReasonCtrl extends Controller{
	@Inject
	FormFactory formFactory;
	
	@Inject
	RDropAttendanceReasonSvr rDropAttendanceReasonSvr;
	
	public Result getRDropAttendanceReasonJson(String q) {
		// TODO Auto-generated method stub
		return ok(play.libs.Json.toJson(rDropAttendanceReasonSvr.findByRDropAttendanceReason(q)));
	}
	
	public Result show(String subAction, Long rDrpAttdceReasonPK) {
		RDropAttendanceReason rDrpAttdceReason = new RDropAttendanceReason();
		String viewMode = "";
		int page = 0; String filter = "";
		if (null == rDrpAttdceReasonPK || rDrpAttdceReasonPK == 0L) {
			rDrpAttdceReason = new RDropAttendanceReason();
			viewMode = EnvVarbl.VIEW_MODE_CREATE;
			return ok(rDropAttendanceReason.render(rDropAttendanceReasonSvr.pageRDropAttendanceReason(page, EnvVarbl.pageSize, filter), filter, new RDropAttendanceReason(), viewMode));
		} else if (EnvVarbl.VIEW_MODE_EDIT.equals(subAction)) {
			rDrpAttdceReason = rDropAttendanceReasonSvr.fetchOneById(rDrpAttdceReasonPK);
			viewMode = EnvVarbl.VIEW_MODE_EDIT;
		} else if (EnvVarbl.VIEW_MODE_DELETE.equals(subAction)) {
			rDrpAttdceReason = rDropAttendanceReasonSvr.fetchOneById(rDrpAttdceReasonPK);
			viewMode = EnvVarbl.VIEW_MODE_DELETE;
		} else {
			viewMode = EnvVarbl.VIEW_MODE_VIEW;
			rDrpAttdceReason = rDropAttendanceReasonSvr.fetchOneById(rDrpAttdceReasonPK);
		}
		return ok(rDropAttendanceReason.render(rDropAttendanceReasonSvr.pageRDropAttendanceReason(page, EnvVarbl.pageSize, filter), filter, rDrpAttdceReason, viewMode));
	}
	
	public Result save() {
		final String viewMode = formFactory.form().bindFromRequest().get("viewMode");
		final String rDrpAttdceReasonPK = formFactory.form().bindFromRequest().get("rDrpAttdceReasonPK-key");
 		String errorMessage = "";
		Form<RDropAttendanceReason> uForm = formFactory.form(RDropAttendanceReason.class).bindFromRequest();
		if (uForm.hasErrors()) {
			flash("ERROR", "Saisie erronée.");
			//return badRequest(versementChequeTier.render(new VersementCheque(), ViewType.VIEW_MODE_CREATE, generalDTOImpl.getRoIdentifiantInfo(0L, EnvironmentalVariables.TIER)));
		}
		RDropAttendanceReason rDrpAttdceReason = uForm.get();
		if (EnvVarbl.VIEW_MODE_EDIT.equals(viewMode)) {
			rDrpAttdceReason.setId(Long.parseLong(rDrpAttdceReasonPK));
			//RDropAttendanceReason.setCode(courseCode);
			//errorMessage = courseSvr.validate(versementCheque, false);
			rDropAttendanceReasonSvr.save(rDrpAttdceReason);
			flash("SUCCESS", "Course modifier.");
			return redirect(routes.RDropAttendanceReasonCtrl.show(EnvVarbl.VIEW_MODE_CREATE, EnvVarbl.pageInit));
		} 
        if (EnvVarbl.VIEW_MODE_CREATE.equals(viewMode)) {
			//errorMessage = courseSvr.validate(versementCheque, true);
		} 
		if (null != errorMessage) {
			flash("ERROR", errorMessage);
			//return badRequest(versementChequeTier.render(versementCheque, ViewType.VIEW_MODE_CREATE, generalDTOImpl.getRoIdentifiantInfo(versementCheque.getId(), EnvironmentalVariables.TIER)));
		}
		rDropAttendanceReasonSvr.save(rDrpAttdceReason);
		flash("SUCCESS", "Course enregistré.");
		return redirect(routes.RDropAttendanceReasonCtrl.show(EnvVarbl.VIEW_MODE_CREATE, EnvVarbl.pageInit));
	}
		//String errorMessage = "";
		//Form<Course> form = formFactory.form(Course.class).bindFromRequest();
		//Course course = form.get();
		//courseSvr.save(course);
		//return redirect(routes.CourseCtrl.show(EnvVarbl.VIEW_MODE_CREATE, EnvVarbl.pageInit));
		
	//}
	
	public Result delete(Long rDrpAttdceReasonPK) {
		RDropAttendanceReason rDrpAttdceReason = rDropAttendanceReasonSvr.fetchOneById(rDrpAttdceReasonPK);
		rDropAttendanceReasonSvr.delete(rDrpAttdceReason);
		flash("SUCCESS", "La " + "" + " a été supprimé.");
		return redirect(routes.RDropAttendanceReasonCtrl.show(EnvVarbl.VIEW_MODE_CREATE, EnvVarbl.pageInit));
	}
	
	public Result list(int page, String filter) {
		String viewMode = "";
 		return ok(rDropAttendanceReason.render(rDropAttendanceReasonSvr.pageRDropAttendanceReason(page, EnvVarbl.pageSize, filter), filter, new RDropAttendanceReason(), viewMode));
	}
}
