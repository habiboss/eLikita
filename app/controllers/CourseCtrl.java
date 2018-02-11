package controllers;

import com.google.inject.Inject;
import models.util.EnvVarbl;
import schemas.public_.tables.pojos.Course;
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
	
	public Result show(String subAction, Long coursePK) {
		Course courses = new Course();
		String viewMode = "";
		int page = 0; String filter = "";
		if (null == coursePK || coursePK == 0L) {
			courses = new Course();
			viewMode = EnvVarbl.VIEW_MODE_CREATE;
			return ok(course.render(courseSvr.pageCourse(page, EnvVarbl.pageSize, filter), filter, new Course(), viewMode));
		} else if (EnvVarbl.VIEW_MODE_EDIT.equals(subAction)) {
			courses = courseSvr.fetchOneById(coursePK);
			viewMode = EnvVarbl.VIEW_MODE_EDIT;
		} else if (EnvVarbl.VIEW_MODE_DELETE.equals(subAction)) {
			courses = courseSvr.fetchOneById(coursePK);
			viewMode = EnvVarbl.VIEW_MODE_DELETE;
		} else {
			viewMode = EnvVarbl.VIEW_MODE_VIEW;
			courses = courseSvr.fetchOneById(coursePK);
		}
		return ok(course.render(courseSvr.pageCourse(page, EnvVarbl.pageSize, filter), filter, courses, viewMode));
	}
	
	public Result save() {
		final String viewMode = formFactory.form().bindFromRequest().get("viewMode");
		final String coursePK = formFactory.form().bindFromRequest().get("coursePK-key");
		final String courseCode = formFactory.form().bindFromRequest().get("coursePK-code");
		String errorMessage = "";
		Form<Course> uForm = formFactory.form(Course.class).bindFromRequest();
		if (uForm.hasErrors()) {
			flash("ERROR", "Saisie erronée.");
			//return badRequest(versementChequeTier.render(new VersementCheque(), ViewType.VIEW_MODE_CREATE, generalDTOImpl.getRoIdentifiantInfo(0L, EnvironmentalVariables.TIER)));
		}
		Course course = uForm.get();
		if (EnvVarbl.VIEW_MODE_EDIT.equals(viewMode)) {
			course.setId(Long.parseLong(coursePK));
			course.setCode(courseCode);
			//errorMessage = courseSvr.validate(versementCheque, false);
			courseSvr.save(course);
			flash("SUCCESS", "Course modifier.");
			return redirect(routes.CourseCtrl.show(EnvVarbl.VIEW_MODE_CREATE, EnvVarbl.pageInit));
		} 
        if (EnvVarbl.VIEW_MODE_CREATE.equals(viewMode)) {
			//errorMessage = courseSvr.validate(versementCheque, true);
		} 
		if (null != errorMessage) {
			flash("ERROR", errorMessage);
			//return badRequest(versementChequeTier.render(versementCheque, ViewType.VIEW_MODE_CREATE, generalDTOImpl.getRoIdentifiantInfo(versementCheque.getId(), EnvironmentalVariables.TIER)));
		}
		courseSvr.save(course);
		flash("SUCCESS", "Course enregistré.");
		return redirect(routes.CourseCtrl.show(EnvVarbl.VIEW_MODE_CREATE, EnvVarbl.pageInit));
	}
		//String errorMessage = "";
		//Form<Course> form = formFactory.form(Course.class).bindFromRequest();
		//Course course = form.get();
		//courseSvr.save(course);
		//return redirect(routes.CourseCtrl.show(EnvVarbl.VIEW_MODE_CREATE, EnvVarbl.pageInit));
		
	//}
	
	public Result delete(Long coursePK) {
		Course course = courseSvr.fetchOneById(coursePK);
		courseSvr.delete(course);
		flash("SUCCESS", "La " + course.getTitle() + " a été supprimé.");
		return redirect(routes.CourseCtrl.show(EnvVarbl.VIEW_MODE_CREATE, EnvVarbl.pageInit));
	}
	
	public Result list(int page, String filter) {
		String viewMode = "";
 		return ok(course.render(courseSvr.pageCourse(page, EnvVarbl.pageSize, filter), filter, new Course(), viewMode));
	}

}
