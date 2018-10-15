package controllers;

import com.google.inject.Inject;
import play.data.DynamicForm;
import play.data.Form;
import play.data.FormFactory;
import play.mvc.Controller;
import play.mvc.Result;
import services.AuthenticationService;
import play.mvc.Security;
import schemas.administrator.tables.pojos.Journee;
import services.JourneeService;
import services.RoUtilisateursImpl;
import controllers.utils.Secured;

@Security.Authenticated(Secured.class)
public class JourneeCtrl extends Controller {
	
	@Inject
	JourneeService js;
	@Inject
	AuthenticationService authService;
	@Inject
	FormFactory formFactory;
	//@Inject
	//QuittanceService qs;
	
	@Inject
	RoUtilisateursImpl roUtilisateur;
	
	public String getJournee() {
		return session().get("journee");
	}
	
	public String getUserConnected() {
		String logged = authService.findByEmail(session("email")).getEmail();//session().get("login");
		System.out.println("user connecté "+logged);
		return logged;
	}
	
	//A enlever apres le test
	public String getLoggedPosteComptable(){
		String pc = roUtilisateur.findPosteComptable(getUserConnected());
		System.out.println("poste comptable utilisateur "+pc);
		return pc;
	}
	public String getUserType(){
		String meta = authService.findByEmail(session("email")).getMetaData();
		System.out.println("metaData "+meta);
		return meta;
	}
	
	
	public Result index() {
		// tester si une journée est ouverte
		if (js.getCurrentJournee(getUserConnected()) != null) {
			session("journee", js.getCurrentJournee(getUserConnected()));
			/**
			 * Fonction de création de numéro fiche écritures par utilisateur/nature opération/journée
			 * Dans Oracle (table tmp_num_fiche).
			 */
			String role = authService.findByEmail(getUserConnected()).getMetaData();
			
//			qs.newQuittance(getLoggedPosteComptable(), getUserConnected(), getJournee(),getUserType());
//			System.out.println(qs.numQce(getLoggedPosteComptable()));
			
			
			if (role.contains("admin")) {
				return redirect(controllers.routes.Application.index());
			}
		}
		Journee j = new Journee();
		System.out.println("bbbbb" + getUserConnected());

		return ok(views.html.viewJournee.render(j));
	}
	
	public Result ouvrir(){
		DynamicForm requestData = formFactory.form().bindFromRequest();
		String j = requestData.get("journee");
		js.ouvrirJournee(j, getUserConnected());
		if(null!=js.journeeExiste(getUserConnected(), j)){
			flash("error", "La journée ouverte!");
			return redirect(routes.JourneeCtrl.index());
		}
		//les borderaux du la journée ouverte pour les versements tiers
		
		return redirect(controllers.routes.JourneeCtrl.index());
	}
	
	public  Result fermer() {
		js.fermerJournee(getUserConnected(),session().get("journee"));
		session().remove("journee");
		return redirect(controllers.routes.JourneeCtrl.index());
	}
}
