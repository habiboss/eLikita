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
	
	@Transactional
	public Result read() {
		CourseSvr x = new CourseSvr();
		return ok(course.render(x.findList()));
	}
	
	@Transactional
	public Result save() {
		Form<Course> form = formFactory.form(Course.class).bindFromRequest();
		Course course = form.get();
		CourseSvr x = new CourseSvr();
		x.save(course);
		return redirect(routes.CourseCtrl.read());
		
	}
	
	

}
