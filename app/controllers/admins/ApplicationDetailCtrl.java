package controllers.admins;

import com.google.inject.Inject;
import models.util.EnvVarbl;
import play.data.Form;
import play.data.FormFactory;
import play.mvc.Controller;
import play.mvc.Result;
import schemas.public_.tables.pojos.ApplicationDetail;
import services.admin.AcademicYearSvr;
import services.admin.ApplicationDetailSvr;
import views.html.admin.*;

public class ApplicationDetailCtrl extends Controller {
	@Inject
	FormFactory formFactory;
	@Inject
	ApplicationDetailSvr applicationDetailSvr;

	public Result save() {
		// final String viewMode = formFactory.form().bindFromRequest().get("viewMode");
		// final String applicationDetailPK =
		// formFactory.form().bindFromRequest().get("applicationDetailPK-key");
		// String errorMessage = "";
		Form<ApplicationDetail> uForm = formFactory.form(ApplicationDetail.class).bindFromRequest();
		// if (uForm.hasErrors()) {
		// flash("ERROR", "Saisie erronée.");
		// return badRequest(versementChequeTier.render(new VersementCheque(),
		// ViewType.VIEW_MODE_CREATE, generalDTOImpl.getRoIdentifiantInfo(0L,
		// EnvironmentalVariables.TIER)));
		// }
		ApplicationDetail applicationDetail = uForm.get();
		// System.out.println("gggggg" + applicationDetail);
		/*
		 * if (EnvVarbl.VIEW_MODE_EDIT.equals(viewMode)) {
		 * applicationDetail.setId(Long.parseLong(applicationDetailPK));
		 * //batch.setCode(BatchCode); //errorMessage =
		 * BatchSvr.validate(versementCheque, false);
		 * applicationDetailSvr.save(applicationDetail); flash("SUCCESS",
		 * "Batch modifier."); return
		 * redirect(routes.AcademicYearCtrl.show(EnvVarbl.VIEW_MODE_CREATE,
		 * EnvVarbl.pageInit)); }
		 */
		// if (EnvVarbl.VIEW_MODE_CREATE.equals(viewMode)) {
		// errorMessage = BatchSvr.validate(versementCheque, true);
		// applicationDetailSvr.save(applicationDetail);
		// }
		// if (null != errorMessage) {
		// flash("ERROR", errorMessage);
		// return badRequest(versementChequeTier.render(versementCheque,
		// ViewType.VIEW_MODE_CREATE,
		// generalDTOImpl.getRoIdentifiantInfo(versementCheque.getId(),
		// EnvironmentalVariables.TIER)));
		// }
		// applicationDetailSvr.save(applicationDetail);
		applicationDetailSvr.save(applicationDetail);
		flash("SUCCESS", "Batch enregistré.");
		return redirect(controllers.routes.StudentCtrl.show(EnvVarbl.VIEW_MODE_S_PERSONALDETAIL, EnvVarbl.pageInit,
				applicationDetail.getCode()));

	}
	
	public Result approved(String uicode) {
		applicationDetailSvr.approved(uicode);
		return redirect(controllers.admins.routes.FeeStudentCtrl.initialiseNewApprovedStudent(uicode));
		
	}
	
	public Result list(int page, String filter) {
		String viewMode = filter;
		return ok(studentManagement.render(applicationDetailSvr.pageApplicationDetail(page, EnvVarbl.pageSize, filter), filter, viewMode));
	}
}
