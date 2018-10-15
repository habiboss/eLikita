package controllers.admins;

import java.text.DateFormat;
import java.text.SimpleDateFormat;
import java.util.Date;
import com.google.inject.Inject;
import models.dto.AcademicYearDTO;
import models.util.EnvVarbl;
import play.data.Form;
import play.data.FormFactory;
import play.data.format.Formats.DateFormatter;
import play.mvc.Controller;
import play.mvc.Result;
import schemas.administrator.tables.pojos.AcademicYear;
import services.admin.AcademicYearSvr;
import views.html.admin.*;

public class AcademicYearCtrl extends Controller{

		@Inject
		FormFactory formFactory;
		@Inject
		AcademicYearSvr academicYearSvr;
		
		public Result show(String subAction, Long academicYearPK) {
			AcademicYearDTO academicYearDTOs = new AcademicYearDTO();
			String viewMode = "";
			int page = 0; String filter = "";
			if (null == academicYearPK || academicYearPK == 0L) {
				academicYearDTOs = new AcademicYearDTO();
				viewMode = EnvVarbl.VIEW_MODE_CREATE;
				return ok(academicYear.render(academicYearSvr.pageAcademicYear(page, EnvVarbl.pageSize, filter), filter, new AcademicYearDTO(), viewMode));
			} else if (EnvVarbl.VIEW_MODE_EDIT.equals(subAction)) {
				academicYearDTOs = academicYearSvr.fetchOneAcademicYearDTO(academicYearPK);
				viewMode = EnvVarbl.VIEW_MODE_EDIT;
			} else if (EnvVarbl.VIEW_MODE_DELETE.equals(subAction)) {
				academicYearDTOs = academicYearSvr.fetchOneAcademicYearDTO(academicYearPK);
				viewMode = EnvVarbl.VIEW_MODE_DELETE;
			} else {
				viewMode = EnvVarbl.VIEW_MODE_VIEW;
				academicYearDTOs = academicYearSvr.fetchOneAcademicYearDTO(academicYearPK);
			}
			return ok(academicYear.render(academicYearSvr.pageAcademicYear(page, EnvVarbl.pageSize, filter), filter, academicYearDTOs, viewMode));
		}
		
		public Result save() {
			final String viewMode = formFactory.form().bindFromRequest().get("viewMode");
			final String academicYearPK = formFactory.form().bindFromRequest().get("academicYearPK-key");
 			String errorMessage = "";
			Form<AcademicYear> uForm = formFactory.form(AcademicYear.class).bindFromRequest();
			if (uForm.hasErrors()) {
				flash("ERROR", "Saisie erronée.");
				//return badRequest(versementChequeTier.render(new VersementCheque(), ViewType.VIEW_MODE_CREATE, generalDTOImpl.getRoIdentifiantInfo(0L, EnvironmentalVariables.TIER)));
			}
			AcademicYear academicYear = uForm.get();
			if (EnvVarbl.VIEW_MODE_EDIT.equals(viewMode)) {
				academicYear.setId(Long.parseLong(academicYearPK));
				//batch.setCode(BatchCode);
				//errorMessage = BatchSvr.validate(versementCheque, false);
				academicYearSvr.save(academicYear);
				flash("SUCCESS", "Batch modifier.");
				return redirect(routes.AcademicYearCtrl.show(EnvVarbl.VIEW_MODE_CREATE, EnvVarbl.pageInit));
			} 
	        if (EnvVarbl.VIEW_MODE_CREATE.equals(viewMode)) {
				//errorMessage = BatchSvr.validate(versementCheque, true);
			
	        } 
			if (null != errorMessage) {
				flash("ERROR", errorMessage);
				//return badRequest(versementChequeTier.render(versementCheque, ViewType.VIEW_MODE_CREATE, generalDTOImpl.getRoIdentifiantInfo(versementCheque.getId(), EnvironmentalVariables.TIER)));
			}
			academicYearSvr.save(academicYear);
			flash("SUCCESS", "Batch enregistré.");
			return redirect(routes.AcademicYearCtrl.show(EnvVarbl.VIEW_MODE_CREATE, EnvVarbl.pageInit));
		}
			//String errorMessage = "";
			//Form<Batch> form = formFactory.form(Batch.class).bindFromRequest();
			//Batch Batch = form.get();
			//BatchSvr.save(Batch);
			//return redirect(routes.AcademicYearCtrl.show(EnvVarbl.VIEW_MODE_CREATE, EnvVarbl.pageInit));
			
		//}
		
		public Result delete(Long academicYearPK) {
			AcademicYear academicYear = academicYearSvr.fetchOneById(academicYearPK);
			academicYearSvr.delete(academicYear);
			flash("SUCCESS", "La " + "" + " a été supprimé.");
			return redirect(routes.AcademicYearCtrl.show(EnvVarbl.VIEW_MODE_CREATE, EnvVarbl.pageInit));
		}
		
		public Result list(int page, String filter) {
			String viewMode = "";
	 		return ok(academicYear.render(academicYearSvr.pageAcademicYear(page, EnvVarbl.pageSize, filter), filter, new AcademicYearDTO(), viewMode));
		}


	}

