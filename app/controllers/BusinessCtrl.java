package controllers;

import com.google.inject.Inject;

import models.InstitutionDetail;
import play.data.Form;
import play.data.FormFactory;
import play.db.jpa.Transactional;
import play.mvc.Result;
import services.businessRegistrationService;

public class BusinessCtrl{
	
	@Inject
	FormFactory formFactory;

	public BusinessCtrl() {
		super();
	}

	@Transactional
	public Result save() {
		businessRegistrationService businessRgService = new businessRegistrationService();
		Form<InstitutionDetail> form = formFactory.form(InstitutionDetail.class).bindFromRequest();
		InstitutionDetail institution = form.get();
		institution.setEmail(form.field("Email").value());
		
		String fname = form.field("FirstName").value();
		System.out.println(fname);
		businessRgService.save(institution);

		return null;
		
	}

}
