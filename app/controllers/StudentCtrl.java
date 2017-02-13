package controllers;

import com.google.inject.Inject;

import models.Student;
import play.data.Form;
import play.data.FormFactory;
import play.mvc.Result;
import services.StudentSrv;

public class StudentCtrl {
	
	@Inject
	FormFactory formFactory;
	Student student;
	StudentSrv studentSrv;
	
	public Result save() {
		Form<Student> form = formFactory.form(Student.class).bindFromRequest();
		student = form.get();
		studentSrv.save(student);
		
		return null;
		
	}

}
