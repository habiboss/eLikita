package controllers;

import com.google.inject.Inject;

import models.Department;
import play.data.Form;
import play.data.FormFactory;
import play.db.jpa.Transactional;
import play.mvc.Controller;
import play.mvc.Result;
import services.DepartmentSvr;
import views.html.admin.*;

public class DepartmentCtrl extends Controller{
	@Inject
	FormFactory formFactory;
	
	@Transactional
	public Result read() {
		DepartmentSvr ds = new DepartmentSvr();
		return ok(department.render(ds.findList()));
	}
	
	@Transactional
	public Result save() {
		Form<Department> form = formFactory.form(Department.class).bindFromRequest();
		Department d = new Department();
		d = form.get();
		DepartmentSvr ds = new DepartmentSvr();
		ds.save(d);
		return redirect(routes.DepartmentCtrl.read());
		
	}

}
