package controllers.referentiels;

import javax.inject.Inject;
import play.data.FormFactory;
import play.mvc.Controller;
import play.mvc.Result;
import services.referentiel.RSyllabusSvr;

public class RSyllabusCtrl extends Controller{
	@Inject
	FormFactory formFactory;
	
	@Inject
	RSyllabusSvr rSyllabusSvr;
	
	public Result getRSyllabusNameJson(String q) {
		// TODO Auto-generated method stub
		return ok(play.libs.Json.toJson(rSyllabusSvr.findByRSyllabus(q)));
	}
}
