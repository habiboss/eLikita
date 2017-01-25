package controllers;

import play.db.jpa.Transactional;
import play.mvc.Controller;
import play.mvc.Result;
import views.html.*;
import views.html.admin.*;
public class Application extends Controller {

	@Transactional
	public Result index1() {

		return ok(index.render());
	}

	public Result index2() {

		return ok(universityDirectory.render());
	}

	public Result index3() {
		return ok(courseDirectory.render());
	}

	public Result courseManagement() {

		return ok(courseManagement.render());
	}

	public Result studentRegistration() {

		return ok(studentRegistration.render());
	}

	public Result login() {

		return ok(login.render());
	}

	public Result loginX() {

		return ok(loginX.render());
	}

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

		return ok(newEvent.render());
	}
	
	public Result newSubject() {

		return ok(newSubject.render());
	}
	
	public Result profileManagement() {

		return ok(profileManagement.render());
	}

	/**
	 * Action
	 *
	 * @return
	 */
	@Transactional
	public Result index() {
		return null;

	}

	/**
	 * Déconnexion d'un utilisateur
	 *
	 * @return
	 */
	public Result logout() {
		session().clear();
		flash("success", "Vous êtes déconnecté");
		return redirect(controllers.routes.Application.loginAdmin());
	}

	/**
	 * Formulaire d'authentification
	 *
	 * @return
	 */
	public Result loginAdmin() {
		return ok(login.render());
	}

	/**
	 * Authentification
	 *
	 * @return
	 */
	@Transactional
	public Result authentification() {
		return null;

	}

}
