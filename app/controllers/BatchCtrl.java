package controllers;

import java.text.DateFormat;
import java.text.SimpleDateFormat;
import java.util.Date;
import com.google.inject.Inject;
import models.dto.BatchDTO;
import models.util.EnvVarbl;
import play.data.Form;
import play.data.FormFactory;
import play.data.format.Formats.DateFormatter;
import play.db.jpa.Transactional;
import play.mvc.Controller;
import play.mvc.Result;
import schemas.public_.tables.pojos.Batch;
import services.BatchSvr;
import views.html.admin.*;

public class BatchCtrl extends Controller{
	
	@Inject
	FormFactory formFactory;
	@Inject
	BatchSvr batchSvr;
 	
	public Result getBatchJson(String q) {
		// TODO Auto-generated method stub
		return ok(play.libs.Json.toJson(batchSvr.findByBatch(q)));
	}
	
	public Result getBatchByCourse(Long coursePK) {
		// TODO Auto-generated method stub
		return ok(play.libs.Json.toJson(batchSvr.getBatchByCourse(coursePK)));
	}
	
	public Result show(String subAction, Long batchPK) {
		BatchDTO batchs = new BatchDTO();
		String viewMode = "";
		int page = 0; String filter = "";
		if (null == batchPK || batchPK == 0L) {
			batchs = new BatchDTO();
			viewMode = EnvVarbl.VIEW_MODE_CREATE;
			return ok(batch.render(batchSvr.pageBatch(page, EnvVarbl.pageSize, filter), filter, new BatchDTO(), viewMode));
		} else if (EnvVarbl.VIEW_MODE_EDIT.equals(subAction)) {
			batchs = batchSvr.fetchOneBatchDTO(batchPK);
			viewMode = EnvVarbl.VIEW_MODE_EDIT;
		} else if (EnvVarbl.VIEW_MODE_DELETE.equals(subAction)) {
			batchs = batchSvr.fetchOneBatchDTO(batchPK);
			viewMode = EnvVarbl.VIEW_MODE_DELETE;
		} else {
			viewMode = EnvVarbl.VIEW_MODE_VIEW;
			batchs = batchSvr.fetchOneBatchDTO(batchPK);
		}
		return ok(batch.render(batchSvr.pageBatch(page, EnvVarbl.pageSize, filter), filter, batchs, viewMode));
	}
	
	public Result save() {
		final String viewMode = formFactory.form().bindFromRequest().get("viewMode");
		final String batchPK = formFactory.form().bindFromRequest().get("batchPK-key");
		final String batchCode = formFactory.form().bindFromRequest().get("batchPK-code");
		String errorMessage = "";
		Form<Batch> uForm = formFactory.form(Batch.class).bindFromRequest();
		if (uForm.hasErrors()) {
			flash("ERROR", "Saisie erronée.");
			//return badRequest(versementChequeTier.render(new VersementCheque(), ViewType.VIEW_MODE_CREATE, generalDTOImpl.getRoIdentifiantInfo(0L, EnvironmentalVariables.TIER)));
		}
		Batch batch = uForm.get();
		if (EnvVarbl.VIEW_MODE_EDIT.equals(viewMode)) {
			batch.setId(Long.parseLong(batchPK));
			//batch.setCode(BatchCode);
			//errorMessage = BatchSvr.validate(versementCheque, false);
			batchSvr.save(batch);
			flash("SUCCESS", "Batch modifier.");
			return redirect(routes.BatchCtrl.show(EnvVarbl.VIEW_MODE_CREATE, EnvVarbl.pageInit));
		} 
        if (EnvVarbl.VIEW_MODE_CREATE.equals(viewMode)) {
			//errorMessage = BatchSvr.validate(versementCheque, true);
		
        } 
		if (null != errorMessage) {
			flash("ERROR", errorMessage);
			//return badRequest(versementChequeTier.render(versementCheque, ViewType.VIEW_MODE_CREATE, generalDTOImpl.getRoIdentifiantInfo(versementCheque.getId(), EnvironmentalVariables.TIER)));
		}
		batchSvr.save(batch);
		flash("SUCCESS", "Batch enregistré.");
		return redirect(routes.BatchCtrl.show(EnvVarbl.VIEW_MODE_CREATE, EnvVarbl.pageInit));
	}
		//String errorMessage = "";
		//Form<Batch> form = formFactory.form(Batch.class).bindFromRequest();
		//Batch Batch = form.get();
		//BatchSvr.save(Batch);
		//return redirect(routes.BatchCtrl.show(EnvVarbl.VIEW_MODE_CREATE, EnvVarbl.pageInit));
		
	//}
	
	public Result delete(Long batchPK) {
		Batch batch = batchSvr.fetchOneById(batchPK);
		batchSvr.delete(batch);
		flash("SUCCESS", "La " + batch.getBatchName() + " a été supprimé.");
		return redirect(routes.BatchCtrl.show(EnvVarbl.VIEW_MODE_CREATE, EnvVarbl.pageInit));
	}
	
	public Result list(int page, String filter) {
		String viewMode = "";
 		return ok(batch.render(batchSvr.pageBatch(page, EnvVarbl.pageSize, filter), filter, new BatchDTO(), viewMode));
	}


}
