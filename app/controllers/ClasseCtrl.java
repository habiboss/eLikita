package controllers;

import com.google.inject.Inject;
import models.util.EnvVarbl;
import play.data.Form;
import play.data.FormFactory;
import play.mvc.Result;
import schemas.public_.tables.pojos.Classe;
import services.ClasseSvr;
import play.mvc.Controller;
import services.CourseSvr;
import views.html.*;

public class ClasseCtrl extends Controller{
	@Inject
	FormFactory formFactory;
	@Inject
	ClasseSvr classeSvr;
	
	public Result show(String subAction, Long classePK) {
		Classe classes = new Classe();
		String viewMode = "";
		int page = 0; String filter = "";
		if (null == classePK || classePK == 0L) {
			classes = new Classe();
			viewMode = EnvVarbl.VIEW_MODE_CREATE;
			return ok(classe.render(classeSvr.pageClasse(page, EnvVarbl.pageSize, filter), filter, new Classe(), viewMode));
		} else if (EnvVarbl.VIEW_MODE_EDIT.equals(subAction)) {
			classes = classeSvr.fetchOneById(classePK);
			viewMode = EnvVarbl.VIEW_MODE_EDIT;
		} else if (EnvVarbl.VIEW_MODE_DELETE.equals(subAction)) {
			classes = classeSvr.fetchOneById(classePK);
			viewMode = EnvVarbl.VIEW_MODE_DELETE;
		} else {
			viewMode = EnvVarbl.VIEW_MODE_VIEW;
			classes = classeSvr.fetchOneById(classePK);
		}
		return ok(classe.render(classeSvr.pageClasse(page, EnvVarbl.pageSize, filter), filter, classes, viewMode));
	}
	
	public Result save() {
		final String viewMode = formFactory.form().bindFromRequest().get("viewMode");
		final String coursePK = formFactory.form().bindFromRequest().get("coursePK-key");
		final String courseCode = formFactory.form().bindFromRequest().get("coursePK-code");
		String errorMessage = "";
		Form<Classe> uForm = formFactory.form(Classe.class).bindFromRequest();
		if (uForm.hasErrors()) {
			flash("ERROR", "Saisie erronée.");
			//return badRequest(versementChequeTier.render(new VersementCheque(), ViewType.VIEW_MODE_CREATE, generalDTOImpl.getRoIdentifiantInfo(0L, EnvironmentalVariables.TIER)));
		}
		Classe classe = uForm.get();
		if (EnvVarbl.VIEW_MODE_EDIT.equals(viewMode)) {
			classe.setId(Long.parseLong(coursePK));
			//classe.setCode(courseCode);
			//errorMessage = courseSvr.validate(versementCheque, false);
			classeSvr.save(classe);
			flash("SUCCESS", "Course modifier.");
			return redirect(routes.ClasseCtrl.show(EnvVarbl.VIEW_MODE_CREATE, EnvVarbl.pageInit));
		} 
        if (EnvVarbl.VIEW_MODE_CREATE.equals(viewMode)) {
			//errorMessage = courseSvr.validate(versementCheque, true);
		} 
		if (null != errorMessage) {
			flash("ERROR", errorMessage);
			//return badRequest(versementChequeTier.render(versementCheque, ViewType.VIEW_MODE_CREATE, generalDTOImpl.getRoIdentifiantInfo(versementCheque.getId(), EnvironmentalVariables.TIER)));
		}
		classeSvr.save(classe);
		flash("SUCCESS", "Course enregistré.");
		return redirect(routes.ClasseCtrl.show(EnvVarbl.VIEW_MODE_CREATE, EnvVarbl.pageInit));
	}
		//String errorMessage = "";
		//Form<Course> form = formFactory.form(Course.class).bindFromRequest();
		//Course course = form.get();
		//courseSvr.save(course);
		//return redirect(routes.CourseCtrl.show(EnvVarbl.VIEW_MODE_CREATE, EnvVarbl.pageInit));
		
	//}
	
	public Result delete(Long classePK) {
		Classe classe = classeSvr.fetchOneById(classePK);
		classeSvr.delete(classe);
		flash("SUCCESS", "La " + classe.getName_() + " a été supprimé.");
		return redirect(routes.CourseCtrl.show(EnvVarbl.VIEW_MODE_CREATE, EnvVarbl.pageInit));
	}
	
	public Result list(int page, String filter) {
		String viewMode = "";
 		return ok(classe.render(classeSvr.pageClasse(page, EnvVarbl.pageSize, filter), filter, new Classe(), viewMode));
	}
	
}
