package controllers;

import java.util.Date;
import com.google.inject.Inject;
import models.util.Roles;
import play.mvc.Controller;
import play.mvc.Result;
import services.AuthenticationService;
import services.EventSvr;
import services.MainMenuPaneDTOSvr;
import views.html.*;
import views.html.admin.*;

public class Application extends Controller {

	@Inject
	AuthenticationService authenticationService;
	@Inject
	JourneeCtrl journeeCtrl;
	@Inject
	MainMenuPaneDTOSvr mainMenuPaneDTOSvr;

	public Result index() {

		//String currentUser = authenticationService.findByEmail(session("email")).getMetaData();
		//String x = currentUser.substring(12);
		//String role = x.substring(0, x.length() - 3);

		/*
		 * if (role.equals(Roles.NUMERAIRE)) { return ok(views.html.menu.render(role));
		 * } else if (currentUser.equals(Roles.CHEQUE)) { return
		 * ok(views.html.menu.render(role)); } else if
		 * (currentUser.equals(Roles.COMPENSATIONRGT)) { return
		 * ok(views.html.menu.render(role)); }else if
		 * (currentUser.equals(Roles.SUPPRESSION_QUITTANCE)) { return
		 * ok(views.html.menu.render(role)); }
		 */
		return ok(views.html.index.render(new Date(journeeCtrl.getJournee()).toLocaleString(), mainMenuPaneDTOSvr.mainMenuPane()));
	}

	public Result index2() {

		return ok(studentInvoice.render(new Date(journeeCtrl.getJournee()).toLocaleString(), mainMenuPaneDTOSvr.mainMenuPane()));
	}

	public Result index3() {
		// return ok(courseDirectory.render());
		return null;
	}

	public Result courseManagement() {

		return ok(courseManagement.render());
	}

	/*
	 * public Result studentRegistration() {
	 * 
	 * return ok(studentRegistration.render()); }
	 */

	public Result staffRegistration() {

		return ok(staffRegistration.render());
	}

	public Result courseInformation() {

		return ok(courseInformation.render());
	}

	public Result registration() {

		return ok(registration.render());
	}

	public Result businessRegistration() {

		return ok(businessRegistration.render());
	}

	public Result personalDetail() {

		return ok(personalDetail.render());
	}

	public Result courseRegistration() {

		return ok(courseRegistration.render());
	}

 	public Result newEvent() {
		EventSvr x = new EventSvr();

		return ok(event.render(x.findList()));
	}

	public Result newSubject() {

		return ok(newSubject.render());
	}

	public Result profileManagement() {

		return ok(profileManagement.render());
	}

}
