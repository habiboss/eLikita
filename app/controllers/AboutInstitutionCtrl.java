package controllers;

import java.util.ArrayList;
import com.google.inject.Inject;
import models.dto.AboutInstitutionDTO;
import models.util.EnvVarbl;
import models.util.SendEmail;
import play.data.Form;
import play.data.FormFactory;
import play.db.jpa.Transactional;
import play.mvc.Controller;
import play.mvc.Result;
import schemas.public_.tables.pojos.AboutInstitution;
import services.AboutInstitutionSvr;
import services.MainMenuPaneDTOSvr;
import services.admin.LogInfoSvr;
import views.html.admin.*;

public class AboutInstitutionCtrl extends Controller{
	@Inject
	FormFactory formFactory;
	@Inject
	AboutInstitutionSvr aboutInstitutionSvr;
	@Inject
    AboutInstitution aboutInstitutions;
	@Inject
	SendEmail sendEmail;
	@Inject
	MainMenuPaneDTOSvr mainMenuPaneDTOSvr;

	
	public Result show(String subAction, Long aboutInstitutionPK) {
		AboutInstitutionDTO aboutInstitutions = new AboutInstitutionDTO();
		String viewMode = "";
		int page = 0; String filter = "";
		if (null == aboutInstitutionPK || aboutInstitutionPK == 0L) {
			aboutInstitutions = new AboutInstitutionDTO();
			viewMode = EnvVarbl.VIEW_MODE_CREATE;
			return ok(aboutInstitution.render("", mainMenuPaneDTOSvr.mainMenuPane(), aboutInstitutions, viewMode));
		} else if (EnvVarbl.VIEW_MODE_EDIT.equals(subAction)) {
			aboutInstitutions = aboutInstitutionSvr.fetchOneAboutInstitutionDTO(aboutInstitutionPK);
			viewMode = EnvVarbl.VIEW_MODE_EDIT;
		} else if (EnvVarbl.VIEW_MODE_DELETE.equals(subAction)) {
			aboutInstitutions = aboutInstitutionSvr.fetchOneAboutInstitutionDTO(aboutInstitutionPK);
			viewMode = EnvVarbl.VIEW_MODE_DELETE;
		} else {
			viewMode = EnvVarbl.VIEW_MODE_VIEW;
			aboutInstitutions = aboutInstitutionSvr.fetchOneAboutInstitutionDTO(aboutInstitutionPK);
		}
		return ok(aboutInstitution.render("", mainMenuPaneDTOSvr.mainMenuPane(), aboutInstitutions, viewMode));
	}
	
	public Result save() {
		final String viewMode = formFactory.form().bindFromRequest().get("viewMode");
		final String institutionPK = formFactory.form().bindFromRequest().get("institutionPK-key");
		final String institutionCode = formFactory.form().bindFromRequest().get("institutionPK-code");
		String errorMessage = "";
		Form<AboutInstitution> uForm = formFactory.form(AboutInstitution.class).bindFromRequest();
		if (uForm.hasErrors()) {
			flash("ERROR", "Saisie erronée.");
			//return badRequest(versementChequeTier.render(new VersementCheque(), ViewType.VIEW_MODE_CREATE, generalDTOImpl.getRoIdentifiantInfo(0L, EnvironmentalVariables.TIER)));
		}
		AboutInstitution aboutInstitution = uForm.get();
		if (EnvVarbl.VIEW_MODE_EDIT.equals(viewMode)) {
			aboutInstitution.setId(Long.parseLong(institutionPK));
			//batch.setCode(BatchCode);
			//errorMessage = BatchSvr.validate(versementCheque, false);
			aboutInstitutionSvr.save(aboutInstitution);
			flash("SUCCESS", "AboutInstitution modifier.");
			return redirect(routes.AboutInstitutionCtrl.show(EnvVarbl.VIEW_MODE_VIEW, aboutInstitutionSvr.x().getId()));
		} 
        if (EnvVarbl.VIEW_MODE_CREATE.equals(viewMode)) {
			//errorMessage = BatchSvr.validate(versementCheque, true);
		
        } 
		if (null != errorMessage) {
			flash("ERROR", errorMessage);
			//return badRequest(versementChequeTier.render(versementCheque, ViewType.VIEW_MODE_CREATE, generalDTOImpl.getRoIdentifiantInfo(versementCheque.getId(), EnvironmentalVariables.TIER)));
		}
		aboutInstitutionSvr.save(aboutInstitution);
		
		flash("SUCCESS", "Batch enregistré.");
		return redirect(routes.AboutInstitutionCtrl.show(EnvVarbl.VIEW_MODE_VIEW, aboutInstitutionSvr.x().getId()));
	}
	
	public Result list(int page, String filter) {
 		return ok(institutionLst.render(aboutInstitutionSvr.pageInstitution(page, 5, filter), filter));
	}
	
	public Result getInstitutionJson(String q) {
		// TODO Auto-generated method stub
		return null;//ok(play.libs.Json.toJson(aboutInstitutionSvr.findByInstitution(q)));
	}
	
	public Result getInstitutionDetail(String instDetail) {
		// TODO Auto-generated method stub
		return null;//ok(play.libs.Json.toJson(aboutInstitutionSvr.x(Long.parseLong(instDetail))));
	}

}
