package controllers;

import java.util.ArrayList;
import java.util.List;

import com.google.inject.Inject;
import models.dto.AssignmentDTO;
import models.util.EnvVarbl;
import play.data.Form;
import play.data.FormFactory;
import play.mvc.Controller;
import play.mvc.Result;
import schemas.public_.tables.pojos.AssignSubject;
import services.AssignSubjectSvr;
import services.referentiel.RClassTypeSvr;
import views.html.*;

public class AssignSubjectCtrl extends Controller{
	@Inject
	FormFactory formFactory;
	@Inject
	AssignSubjectSvr assignSubjectSvr;
	@Inject
	RClassTypeSvr rClassTypeSvr;
	
	public Result getAssignSubjectJson() {
		// TODO Auto-generated method stub
		return ok(play.libs.Json.toJson(rClassTypeSvr.findAll()));
	}
	public Result getSubjectByBatchJson(Long batchPK) {
		// TODO Auto-generated method stub
		return ok(play.libs.Json.toJson(assignSubjectSvr.getSubjectByBatch(batchPK)));
	}
	
	public Result show(String subAction, Long assignmentPK) {
		AssignmentDTO assignmentDTO = new AssignmentDTO();
		String viewMode = "";
		int page = 0; String filter = "";
		if (null == assignmentPK || assignmentPK == 0L) {
			assignmentDTO = new AssignmentDTO();
			viewMode = EnvVarbl.VIEW_MODE_CREATE;
			return ok(assignSubject.render(assignSubjectSvr.pageAssignSubject(page, EnvVarbl.pageSize, filter), filter, new AssignmentDTO(), viewMode));
		} else if (EnvVarbl.VIEW_MODE_EDIT.equals(subAction)) {
			//assignments = assignSubjectSvr.fetchOneById(assignmentPK);
			assignmentDTO = assignSubjectSvr.fetchOneAssignSubjectDTO(assignmentPK);
			viewMode = EnvVarbl.VIEW_MODE_EDIT;
		} else if (EnvVarbl.VIEW_MODE_DELETE.equals(subAction)) {
			assignmentDTO = assignSubjectSvr.fetchOneAssignSubjectDTO(assignmentPK);
			viewMode = EnvVarbl.VIEW_MODE_DELETE;
		} else {
			viewMode = EnvVarbl.VIEW_MODE_VIEW;
			assignmentDTO = assignSubjectSvr.fetchOneAssignSubjectDTO(assignmentPK);
		}
		return ok(assignSubject.render(assignSubjectSvr.pageAssignSubject(page, EnvVarbl.pageSize, filter), filter, assignmentDTO, viewMode));
	}
	
	public Result save() {
		final String viewMode = formFactory.form().bindFromRequest().get("viewMode");
		final String assignmentPK = formFactory.form().bindFromRequest().get("assignmentPK-key");
		final String assignmentCode = formFactory.form().bindFromRequest().get("assignmentPK-code");
		String errorMessage = "";
		Form<AssignSubject> uForm = formFactory.form(AssignSubject.class).bindFromRequest();
		if (uForm.hasErrors()) {
			flash("ERROR", "Saisie erronée.");
			//return badRequest(versementChequeTier.render(new VersementCheque(), ViewType.VIEW_MODE_CREATE, generalDTOImpl.getRoIdentifiantInfo(0L, EnvironmentalVariables.TIER)));
		}
		AssignSubject assignment = uForm.get();
		if (EnvVarbl.VIEW_MODE_EDIT.equals(viewMode)) {
			assignment.setId(Long.parseLong(assignmentPK));
			//assignment.setCode(AssignmentCode);
			//errorMessage = assignSubjectSvr.validate(versementCheque, false);
			assignSubjectSvr.save(assignment);
			flash("SUCCESS", "Assignment modifier.");
			return redirect(routes.AssignSubjectCtrl.show(EnvVarbl.VIEW_MODE_CREATE, EnvVarbl.pageInit));
		} 
        if (EnvVarbl.VIEW_MODE_CREATE.equals(viewMode)) {
			//errorMessage = assignSubjectSvr.validate(versementCheque, true);
		} 
		if (null != errorMessage) {
			flash("ERROR", errorMessage);
			//return badRequest(versementChequeTier.render(versementCheque, ViewType.VIEW_MODE_CREATE, generalDTOImpl.getRoIdentifiantInfo(versementCheque.getId(), EnvironmentalVariables.TIER)));
		}
		String[] subjectFk = {assignment.getSubjectFk().toString()};//{formFactory.form().bindFromRequest().get("subjectFkArray")};
				//formFactory.form().bindFromRequest().get("subjectFkArray");
 		//for(int i=0; i<subjectFk.length; i++) {
 			//System.out.println("xxxxxxxx" + subjectFk.length);
 			//System.out.println("xxxxxxxx" + subjectFk.length);
 		//}
		
		assignSubjectSvr.save(assignment);
		flash("SUCCESS", "Assignment enregistré.");
		return redirect(routes.AssignSubjectCtrl.show(EnvVarbl.VIEW_MODE_CREATE, EnvVarbl.pageInit));
	}

	public Result delete(Long assignmentPK) {
		AssignSubject assignSubject = assignSubjectSvr.fetchOneById(assignmentPK);
		assignSubjectSvr.delete(assignSubject);
		flash("SUCCESS", "La " + "" + " a été supprimé.");
		return redirect(routes.AssignSubjectCtrl.show(EnvVarbl.VIEW_MODE_CREATE, EnvVarbl.pageInit));
	}
	
	public Result list(int page, String filter) {
		String viewMode = "";
 		return ok(assignSubject.render(assignSubjectSvr.pageAssignSubject(page, EnvVarbl.pageSize, filter), filter, new AssignmentDTO(), viewMode));
	}
}
