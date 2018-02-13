package controllers.referentiels;

import javax.inject.Inject;
import play.data.FormFactory;
import play.mvc.Controller;
import play.mvc.Result;
import services.referentiel.RAttendanceTypeSvr;

public class RAttendanceTypeCtrl extends Controller{
	@Inject
	FormFactory formFactory;
	
	@Inject
	RAttendanceTypeSvr rAttendanceTypeSvr;
	
	public Result getRAttendanceTypeJson(String q) {
		// TODO Auto-generated method stub
		return ok(play.libs.Json.toJson(rAttendanceTypeSvr.findByRAttendanceType(q)));
	}
}
