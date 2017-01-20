package controllers;

import com.google.inject.Inject;

import models.Institution;
import play.data.Form;
import play.data.FormFactory;
import play.db.jpa.Transactional;
import play.mvc.Result;
import services.businessRegistrationService;

public class businessRegistrationCtrl{
	
	@Inject
	FormFactory formFactory;

	public businessRegistrationCtrl() {
		super();
	}

	@Transactional
	public Result save() {
		businessRegistrationService businessRgService = new businessRegistrationService();
		Form<Institution> form = formFactory.form(Institution.class).bindFromRequest();
		Institution institution = form.get();
		institution.setEmail(form.field("Email").value());
		
		String fname = form.field("FirstName").value();
		System.out.println(fname);
		businessRgService.save(institution);

		return null;
		
	}

}
