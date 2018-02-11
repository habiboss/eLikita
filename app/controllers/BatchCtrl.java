package controllers;

import java.text.DateFormat;
import java.text.SimpleDateFormat;
import java.util.Date;

import com.google.inject.Inject;

import models.Batch;
import play.data.Form;
import play.data.FormFactory;
import play.data.format.Formats.DateFormatter;
import play.db.jpa.Transactional;
import play.mvc.Controller;
import play.mvc.Result;
import services.BatchSvr;
import services.CourseSvr;
import views.html.admin.*;

public class BatchCtrl extends Controller{
	
	@Inject
	FormFactory formFactory;
	
	@Transactional
	public Result read() {
		//BatchSvr x = new BatchSvr();
		//CourseSvr c = new CourseSvr(); 
		return null;//ok(batch.render(x.findList(), c.findList()));
	}
	
	@Transactional
	public Result save() {
		/*BatchSvr x = new BatchSvr(null);
		Form<Batch> form = formFactory.form(Batch.class).bindFromRequest();
		if(form.hasErrors()) {
			flash("error");
		} else {
			Batch b = form.get();
			String courseId = form.field("codeCourse").value();
     		String result = x.save(b, Long.parseLong(courseId));
			if (result != null) {
                flash("error-secteur", "Ce secteur est déjà accessible par l'utilisateur");
            } else {
                flash("success-secteur", "Le secteur est désormais accessible par l'utilisateur");
            }
		}
		*/
		
		return redirect(routes.BatchCtrl.read());
		
	}

}
