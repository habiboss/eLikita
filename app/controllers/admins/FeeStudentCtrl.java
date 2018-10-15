package controllers.admins;

import javax.inject.Inject;

import models.util.EnvVarbl;
import play.mvc.Controller;
import play.mvc.Result;
import schemas.administrator.tables.pojos.FeeStudent;
import services.admin.FeeStudentSvr;

public class FeeStudentCtrl extends Controller {
	
	@Inject
	FeeStudentSvr feeStudentSvr;
	
	public Result initialiseNewApprovedStudent(String codeUi) {
		feeStudentSvr.save(new FeeStudent(), codeUi);
		return redirect(controllers.routes.StudentCtrl.list(EnvVarbl.pageSize, EnvVarbl.filterInit));
	}

}
