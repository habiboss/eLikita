package controllers.referentiels;

import javax.inject.Inject;
import play.data.FormFactory;
import play.mvc.Controller;
import play.mvc.Result;
import services.referentiel.RCampusSvr;

public class RCampusCtrl extends Controller{
	@Inject
	FormFactory formFactory;
	@Inject
	RCampusSvr rCampusSvr;
	
	public Result getRCampusJson(String q) {
		// TODO Auto-generated method stub
		return ok(play.libs.Json.toJson(rCampusSvr.findByRCampus(q)));
	}

}
