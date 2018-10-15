package controllers.referentiels;

import javax.inject.Inject;
import play.mvc.Controller;
import play.mvc.Result;
import services.referentiel.RMonthSvr;

public class RMonthCtrl extends Controller{
	@Inject
	RMonthSvr rMonthSvr;
	
	public Result getMonthJson(String q) {
		// TODO Auto-generated method stub
		return ok(play.libs.Json.toJson(rMonthSvr.findByRMonth(q)));
	}
}
