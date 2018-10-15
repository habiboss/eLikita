package controllers.referentiels;

import javax.inject.Inject;
import play.mvc.Controller;
import play.mvc.Result;
import services.referentiel.RMonthSvr;
import services.referentiel.RYearSvr;

public class RYearCtrl extends Controller{
	@Inject
	RYearSvr rYearSvr;
	
	public Result getYearJson(String q) {
		// TODO Auto-generated method stub
		return ok(play.libs.Json.toJson(rYearSvr.findByRYear(q)));
	}
}
