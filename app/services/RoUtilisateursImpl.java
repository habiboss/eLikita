package services;

import java.util.List;
import javax.inject.Inject;
import org.jooq.DSLContext;
import com.google.inject.Singleton;

import schemas.public_.Tables;
import schemas.public_.tables.daos.RoUsersDao;
import schemas.public_.tables.records.RoUsersRecord;

@Singleton
public class RoUtilisateursImpl extends RoUsersDao {

	@Inject
	DSLContext sqlContext;

	@Inject
	public RoUtilisateursImpl(DSLContext sqlContext) {
		super();
		this.setConfiguration(sqlContext.configuration());
	}

	// findPosteComptable(user)
	public String findPosteComptable(String utilisateur) {
		System.out.println("yyyyyy" + utilisateur);
		String posteComptable = "";

		// RoUsers roUtilisateur = fetchOne(Tables.RO_USERS.USER,
		// (utilisateur.split("@")[0]).toUpperCase());
		RoUsersRecord roUtilisateur = sqlContext.fetchOne(Tables.RO_USERS, Tables.RO_USERS.USER.eq(utilisateur));

		// System.out.println("yyyyyy" + roUtilisateur.getUser());

		if (roUtilisateur != null)
			posteComptable = roUtilisateur.getComptable();
		// System.out.println("xxxxxxx" + posteComptable);
		return posteComptable;
	}

	// getRoUtilisateursByUtilisateur
	public RoUsersRecord getRoUtilisateursByUtilisateur(String utilisateur) {
		List<RoUsersRecord> roUtilisateursRecords = sqlContext.selectFrom(Tables.RO_USERS)
				.where(Tables.RO_USERS.USER.eq((utilisateur.split("@")[0]).toUpperCase())).fetch();
		if (roUtilisateursRecords.size() == 1)
			return roUtilisateursRecords.get(0);
		else
			return null;
	}

}