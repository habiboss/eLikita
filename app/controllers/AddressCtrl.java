package controllers;

import com.google.inject.Inject;

import models.AddressDetail;
import play.data.Form;
import play.data.FormFactory;
import play.db.jpa.Transactional;
import play.mvc.Controller;
import play.mvc.Result;
import services.AddressSvr;
import services.StudentSrv;

public class AddressCtrl extends Controller{
	
	@Inject
	FormFactory formFactory;
	@Inject
	AddressSvr addressSvr;

	@Inject
	AddressDetail addressDetail;
	
	
	@Transactional
	public Result save() {
		Form<AddressDetail> form = formFactory.form(AddressDetail.class).bindFromRequest();
		//addressSvr.save(form, addressDetail);
		
		return TODO;
	}

}
