package controllers.utils;

import javax.inject.Inject;
import controllers.JourneeCtrl;
import models.util.Login;
import play.data.Form;
import play.data.FormFactory;
import play.mvc.Controller;
import play.mvc.Result;
import schemas.administrator.tables.pojos.ApplicationUser;
import services.AuthenticationService;
import services.RoUtilisateursImpl;

public class Authentication extends Controller {
	@Inject
	AuthenticationService authService;
	@Inject
	FormFactory formFactory;
	@Inject
	JourneeCtrl journeeCtrl;
	@Inject
	RoUtilisateursImpl userImpl;

	public Result index(String email, String password) {
		if (validate(email, password) == null) {
			return redirect(controllers.routes.JourneeCtrl.index());
		} else {
			flash("success", validate(email, password));
			return login();
		}
	}

	public String validate(String email, String password) {
		String result;
		String message = "Nom utilisateur ou/et Mot de Passe incorrect, Veuillez ressayer!";
		String message1 = null;
		System.out.println(email + "____has___" + password);

		if(authService.findByEmail(email) != null && password.equals(authService.findByEmail(email).getPassword())) {
			result =  message1;

		} else {
			result =   message;
		}
		return result;
	}
	
	/*
	 * */
	public String validatePosteComptable(String email){
		String result = null;
		String utilisateur = email.split("@")[0].toUpperCase();
		String pcRGT = "6000";
		System.out.println("u "+utilisateur);
		System.out.println("pc "+userImpl.findPosteComptable(utilisateur));
		if(!userImpl.findPosteComptable(utilisateur).equals(pcRGT)){
			result = "Connexion Interdite!";
		}
		System.out.println("resultvpc "+result);
		return result;
	}

	/**
	 * Login page.
	 */
	public Result login() {
		Form<models.util.Login> loginForm = formFactory.form(models.util.Login.class);
		return ok(views.html.loginX.render(loginForm));
	}

	/**
	 * Handle login form submission.
	 */
	public Result authenticate() {
		Form<Login> loginForm = formFactory.form(Login.class).bindFromRequest();
		System.out.println("form" + loginForm.get());
		Login login = loginForm.get();
		String email = login.getEmail();
		String password = login.getPassword();
		 
		if(validatePosteComptable(email)!= null){
			flash("error", validatePosteComptable(email));
			return badRequest(views.html.login.render(loginForm));
		}
		ApplicationUser au = authService.authenticate(email, password);
		
		if (loginForm.hasErrors()) {
			return badRequest(views.html.login.render(loginForm));
		} else {
			session().clear();
			session("email", loginForm.get().getEmail());
			return redirect(controllers.utils.routes.Authentication.index(email, password));
		}
	}

	/**
	 * Logout and clean the session.
	 */
	public Result logout() {
		session().clear();
		flash("success", "Vous vous êtes déconnecté!");
		return redirect(controllers.utils.routes.Authentication.login());
	}

}
