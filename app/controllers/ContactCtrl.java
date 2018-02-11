package controllers;

import com.google.inject.Inject;
import schemas.public_.tables.pojos.ContactDetail;
import play.data.Form;
import play.data.FormFactory;
import play.db.jpa.Transactional;
import play.mvc.Controller;
import play.mvc.Result;
import services.ContactSvr;

public class ContactCtrl extends Controller{
	@Inject
	FormFactory formFactory;
	@Inject
	ContactSvr contactSvr;
	
	
	@Transactional
	public Result save() {
		Form<ContactDetail> form = formFactory.form(ContactDetail.class).bindFromRequest();
		//contactSvr.save(form, contact);
		
		return TODO;
	}

}
