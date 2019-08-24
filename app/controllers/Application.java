package controllers;

import java.util.Date;
import com.google.inject.Inject;
import play.mvc.Controller;
import play.mvc.Result;


public class Application extends Controller {

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
		return null;
	}


}
