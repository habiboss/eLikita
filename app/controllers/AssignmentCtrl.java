package controllers;

import com.google.inject.Inject;
import models.dto.AssignmentDTO;
import models.util.EnvVarbl;
import play.data.Form;
import play.data.FormFactory;
import play.mvc.Controller;
import play.mvc.Result;
import schemas.public_.tables.pojos.Assignment;
import services.AssignmentSvr;
import views.html.*;

public class AssignmentCtrl extends Controller{
	@Inject
	FormFactory formFactory;
	@Inject
	AssignmentSvr assignmentSvr;
	
	public Result getAssignmentJson(String q) {
		// TODO Auto-generated method stub
		return ok(play.libs.Json.toJson(assignmentSvr.findByAssignment(q)));
	}
	
	public Result show(String subAction, Long assignmentPK) {
		AssignmentDTO assignmentDTO = new AssignmentDTO();
		String viewMode = "";
		int page = 0; String filter = "";
		if (null == assignmentPK || assignmentPK == 0L) {
			assignmentDTO = new AssignmentDTO();
			viewMode = EnvVarbl.VIEW_MODE_CREATE;
			return ok(assignment.render(assignmentSvr.pageAssignment(page, EnvVarbl.pageSize, filter), filter, new AssignmentDTO(), viewMode));
		} else if (EnvVarbl.VIEW_MODE_EDIT.equals(subAction)) {
			//assignments = assignmentSvr.fetchOneById(assignmentPK);
			assignmentDTO = assignmentSvr.fetchOneAssignmentDTO(assignmentPK);
			viewMode = EnvVarbl.VIEW_MODE_EDIT;
		} else if (EnvVarbl.VIEW_MODE_DELETE.equals(subAction)) {
			assignmentDTO = assignmentSvr.fetchOneAssignmentDTO(assignmentPK);
			viewMode = EnvVarbl.VIEW_MODE_DELETE;
		} else {
			viewMode = EnvVarbl.VIEW_MODE_VIEW;
			assignmentDTO = assignmentSvr.fetchOneAssignmentDTO(assignmentPK);
		}
		return ok(assignment.render(assignmentSvr.pageAssignment(page, EnvVarbl.pageSize, filter), filter, assignmentDTO, viewMode));
	}
	
	public Result save() {
		final String viewMode = formFactory.form().bindFromRequest().get("viewMode");
		final String assignmentPK = formFactory.form().bindFromRequest().get("assignmentPK-key");
		final String assignmentCode = formFactory.form().bindFromRequest().get("assignmentPK-code");
		String errorMessage = "";
		Form<Assignment> uForm = formFactory.form(Assignment.class).bindFromRequest();
		if (uForm.hasErrors()) {
			flash("ERROR", "Saisie erronée.");
			//return badRequest(versementChequeTier.render(new VersementCheque(), ViewType.VIEW_MODE_CREATE, generalDTOImpl.getRoIdentifiantInfo(0L, EnvironmentalVariables.TIER)));
		}
		Assignment assignment = uForm.get();
		if (EnvVarbl.VIEW_MODE_EDIT.equals(viewMode)) {
			assignment.setId(Long.parseLong(assignmentPK));
			//assignment.setCode(AssignmentCode);
			//errorMessage = assignmentSvr.validate(versementCheque, false);
			assignmentSvr.save(assignment);
			flash("SUCCESS", "Assignment modifier.");
			return redirect(routes.AssignmentCtrl.show(EnvVarbl.VIEW_MODE_CREATE, EnvVarbl.pageInit));
		} 
        if (EnvVarbl.VIEW_MODE_CREATE.equals(viewMode)) {
			//errorMessage = assignmentSvr.validate(versementCheque, true);
		} 
		if (null != errorMessage) {
			flash("ERROR", errorMessage);
			//return badRequest(versementChequeTier.render(versementCheque, ViewType.VIEW_MODE_CREATE, generalDTOImpl.getRoIdentifiantInfo(versementCheque.getId(), EnvironmentalVariables.TIER)));
		}
		assignmentSvr.save(assignment);
		flash("SUCCESS", "Assignment enregistré.");
		return redirect(routes.AssignmentCtrl.show(EnvVarbl.VIEW_MODE_CREATE, EnvVarbl.pageInit));
	}
		//String errorMessage = "";
		//Form<Assignment> form = formFactory.form(Assignment.class).bindFromRequest();
		//Assignment Assignment = form.get();
		//assignmentSvr.save(Assignment);
		//return redirect(routes.AssignmentCtrl.show(EnvVarbl.VIEW_MODE_CREATE, EnvVarbl.pageInit));
		
	//}
	
	public Result delete(Long assignmentPK) {
		Assignment assignment = assignmentSvr.fetchOneById(assignmentPK);
		assignmentSvr.delete(assignment);
		flash("SUCCESS", "La " + assignment.getTitle() + " a été supprimé.");
		return redirect(routes.AssignmentCtrl.show(EnvVarbl.VIEW_MODE_CREATE, EnvVarbl.pageInit));
	}
	
	public Result list(int page, String filter) {
		String viewMode = "";
 		return ok(assignment.render(assignmentSvr.pageAssignment(page, EnvVarbl.pageSize, filter), filter, new AssignmentDTO(), viewMode));
	}
}
