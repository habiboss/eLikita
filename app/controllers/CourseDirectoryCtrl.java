package controllers;

import com.google.inject.Inject;
import play.mvc.Result;
import play.mvc.Controller;
import services.CourseSvr;
import views.html.*;

public class CourseDirectoryCtrl extends Controller{
	@Inject
	CourseSvr courseSvr;
	
	public Result read() {
		
		return ok(courseDirectory.render());
	}


}
