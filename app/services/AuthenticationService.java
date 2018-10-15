package services;

import java.util.List;
import org.jooq.DSLContext;
import schemas.administrator.Tables;
import schemas.administrator.tables.pojos.ApplicationUser;
import schemas.administrator.tables.pojos.RoUsers;
import schemas.administrator.tables.records.ApplicationUserRecord;

import javax.inject.Inject;
public class AuthenticationService extends schemas.administrator.tables.daos.ApplicationUserDao {

	@Inject
	DSLContext sqlContext;

	@Inject
	public AuthenticationService(DSLContext sqlContext) {
		super();
		this.setConfiguration(sqlContext.configuration());
	}
	
	

	public String validate(ApplicationUser au) {
		String result = null;
		if (null == au) {
			result = "Aucune information reçue";
		} else {
			if (null == result && !fieldsAreEmpty(au).equals("")) {
				result = fieldsAreEmpty(au);
			}
			
		}
		return result;
	}

	// private Boolean emailExists(String email){
	// return !fetchByEmail(email).isEmpty();
	// }

	private String fieldsAreEmpty(ApplicationUser au) {
		
		String result = "";
		if (au.getEmail().equals("")) {
			result = "le champs Email ne peut pas etre vide";
			return result;
		}
		if (au.getPassword().equals("")) {
			result = "le champs Password ne peut pas etre vide";
			return result;
		}
		if (null == getUtilisateur(au)) {
			result = "Cet utilisateur n'existe pas dans la table de référence des utilisateurs";
		}
		return result;
	}

	public List<ApplicationUser> listUser() {
		return sqlContext.selectFrom(Tables.APPLICATION_USER).fetchInto(ApplicationUser.class);
	}

	// public ApplicationUser findByLogin(String login) {
	// return fetchOneByEmail(login);
	// }

	public ApplicationUser findByEmail(String email) {
		return fetchOneByEmail(email);
	}

	public String findSingleEmail(String email) {
		return fetchOneByEmail(email).getMetaData();
	}

	public ApplicationUser authenticate(String login, String password) {
		ApplicationUser au = new ApplicationUser();
		ApplicationUserRecord auRecord = sqlContext.fetchOne(Tables.APPLICATION_USER,
				Tables.APPLICATION_USER.EMAIL.eq(login).and(Tables.APPLICATION_USER.PASSWORD.eq(password)));
		try {
			if (null != auRecord) {
				au.setEmail(login);
				au.setPassword(password);
				au.setId(auRecord.getId());
				au.setIsActive(auRecord.getIsActive());
				au.setIsAdmin(auRecord.getIsAdmin());
				au.setLastUpdate(auRecord.getLastUpdate());
				au.setMetaData(auRecord.getMetaData());
				au.setName(auRecord.getName());
				return au;
			}
		} catch (Exception e) {
			// TODO: handle exception
		}
		return null;
	}

	public RoUsers getUtilisateur(ApplicationUser user) {
		// RoUtilisateurs utilisateur = new RoUtilisateurs();
		String u = extractLogin(user);
		List<RoUsers> roUtilisateursList = sqlContext.selectFrom(Tables.RO_USERS)
				.where(Tables.RO_USERS.USER.eq(u)).fetchInto(RoUsers.class);
		if (roUtilisateursList.size() == 1) {
			System.out.println("RoUtilisateur est " + roUtilisateursList.get(0));
			return roUtilisateursList.get(0);
		}
		return null;
	}

	// public List<schemas.tables.pojos.RoUtilisateurs> getListRoUtilisateur() {
	// return
	// sqlContext.selectFrom(Tables.RO_UTILISATEURS).fetchInto(schemas.tables.pojos.RoUtilisateurs.class);
	// }

	/*
	 * public schemas.tables.pojos.RoUtilisateurs getRoUtilisateur(ApplicationUser
	 * user) { String login = extractLogin(user);
	 * List<schemas.tables.pojos.RoUtilisateurs> roUtilisateursList =
	 * sqlContext.selectFrom(Tables.RO_UTILISATEURS)
	 * .where(Tables.RO_UTILISATEURS.UTILISATEUR.eq(login))
	 * .fetchInto(schemas.tables.pojos.RoUtilisateurs.class);
	 * schemas.tables.pojos.RoUtilisateurs roUtilisateurs = new
	 * schemas.tables.pojos.RoUtilisateurs(); for
	 * (schemas.tables.pojos.RoUtilisateurs roUtil : roUtilisateursList) {
	 * roUtilisateurs.setComptable(roUtil.getComptable());
	 * roUtilisateurs.setGrantedNumbering(roUtil.getGrantedNumbering());
	 * roUtilisateurs.setGrantedProcess(roUtil.getGrantedProcess());
	 * roUtilisateurs.setUtilisateurNomPrenom(roUtil.getUtilisateurNomPrenom());
	 * roUtilisateurs.setService(roUtil.getService());
	 * roUtilisateurs.setTypeUtilisateur(roUtil.getTypeUtilisateur());
	 * roUtilisateurs.setUtilisateur(roUtil.getUtilisateur());
	 * roUtilisateurs.setId(Integer.parseInt((roUtil.getId().toString()))); } if
	 * (roUtilisateursList.size() == 1) { return roUtilisateurs; } else { return
	 * null; } }
	 */

	public String extractLogin(ApplicationUser user) {
		String email = user.getEmail();
		int taille = email.length();
		int pos = 0;
		for (int i = 0; i < (taille - 1); i++) {
			if (email.charAt(i) == '@') {
				break;
			} else
				pos++;
		}
		String login = email.substring(0, pos).toUpperCase();
		return login;
	}

}
