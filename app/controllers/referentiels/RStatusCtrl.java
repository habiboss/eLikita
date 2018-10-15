package controllers.referentiels;

import javax.inject.Inject;

import play.mvc.Controller;
import play.mvc.Result;
import services.referentiel.RStatusSvr;
import services.referentiel.RYearSvr;

public class RStatusCtrl extends Controller{
	@Inject
	RStatusSvr rStatusSvr;
	
	public Result getStatusJson(String q) {
		// TODO Auto-generated method stub
		return ok(play.libs.Json.toJson(rStatusSvr.findByRStatus(q)));
	}
}
