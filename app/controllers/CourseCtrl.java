package controllers;

import com.google.inject.Inject;

import models.Course;
import play.data.Form;
import play.data.FormFactory;
import play.db.jpa.Transactional;
import play.mvc.Controller;
import play.mvc.Result;
import services.CourseSvr;
import views.html.admin.*;

public class CourseCtrl extends Controller{
	
	@Inject
	FormFactory formFactory;
	@Inject
	CourseSvr courseSvr;
	
	@Transactional
	public Result read() {
		return ok(course.render(courseSvr.findList()));
	}
	
	@Transactional
	public Result save() {
		Form<Course> form = formFactory.form(Course.class).bindFromRequest();
		Course course = form.get();
		courseSvr.save(course);
		return redirect(routes.CourseCtrl.read());
		
	}
	
	

}
