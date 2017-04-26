package controllers;

import com.google.inject.Inject;

import models.Student;
import play.data.Form;
import play.data.FormFactory;
import play.mvc.Controller;
import play.mvc.Result;
import services.StudentSrv;

public class StudentCtrl extends Controller{
	
	@Inject
	FormFactory formFactory;
	@Inject
	Student student;
	@Inject
	StudentSrv studentSrv;
	
	public Result save() {
		Form<Student> form = formFactory.form(Student.class).bindFromRequest();
		Student student = form.get();
		studentSrv.save(student);
		
		return TODO;
		
	}

}
