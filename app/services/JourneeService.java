package services;

import java.sql.Timestamp;
import java.util.Calendar;
import java.util.Date;
import java.util.List;
import org.joda.time.DateTime;
import org.jooq.DSLContext;
import com.google.inject.Inject;
import com.google.inject.Singleton;
import schemas.administrator.*;
import schemas.administrator.tables.pojos.Journee;
import schemas.administrator.tables.records.JourneeRecord;

@Singleton
public class JourneeService extends schemas.administrator.tables.daos.JourneeDao {
	
	@Inject
	DSLContext sqlContext;
	
	
	
	@Inject
    public JourneeService(DSLContext sqlContext) {
        super();
        this.setConfiguration(sqlContext.configuration());
    }
	
		
	public void ouvrirJournee(String jour, String email){
		schemas.administrator.tables.pojos.Journee journee = new schemas.administrator.tables.pojos.Journee();
		List<Journee> journeeList = sqlContext.selectFrom(Tables.JOURNEE)
				.where(Tables.JOURNEE.OWNER.eq(email))
				.fetchInto(Journee.class);
		for(Journee j : journeeList){
			j.setEtat(false);
			super.update(j);
		}
//		JourneeRecord j = sqlContext.fetchOne(Tables.JOURNEE,
//				Tables.JOURNEE.OWNER.eq(email)
//				.and(Tables.JOURNEE.JOURNEE_.eq(jour)));
		
		if(null!=journeeExiste(email, jour)){
			System.out.println("Journée réouverte!");
			journee= (Journee) fetchOne(Tables.JOURNEE.JOURNEE_, jour);
			journee.setEtat(true);
			journee.setLastUpdate(new Timestamp(Calendar.getInstance().getTimeInMillis()));
			super.update(journee);
		}else{
			System.out.println("Journée ouverte!");
			journee.setEtat(true);
			journee.setJournee(jour);
			journee.setOwner(email);
			journee.setLastUpdate(new Timestamp(Calendar.getInstance().getTimeInMillis()));
			super.insert(journee);
			
		}
	}
	
	public String getCurrentJournee(String email){
		JourneeRecord j = sqlContext.fetchOne(Tables.JOURNEE,
				Tables.JOURNEE.OWNER.eq(email)
				.and(Tables.JOURNEE.ETAT.eq(true)));
		try {
			if(null!=j){
				return j.getJournee();
			}
		} catch (Exception e) {
			// TODO: handle exception
		}
		return null;

	}
	
	public String journeeExiste(String owner, String journee){
		String result = null;
		JourneeRecord jr = sqlContext.fetchOne(Tables.JOURNEE,
				Tables.JOURNEE.OWNER.eq(owner)
				.and(Tables.JOURNEE.JOURNEE_.eq(journee)));
		try {
			if(null!=jr){
				result = "journee existe";
				return result;
			}
		} catch (Exception e) {
			// TODO: handle exception
		}
		return result;
	}
	
	public int getJourAnnee() {
		DateTime now = DateTime.now();
		return now.getDayOfYear();

	}
	
	public void fermerJournee(String owner, String jour){
		Journee journee = new Journee(); 
		try {
			System.out.println("jour est "+jour);
			if(null!=journeeExiste(owner, jour)){
				System.out.println("Fermeture de la journée!");
				
				List<Journee> jList = sqlContext.selectFrom(Tables.JOURNEE)
						.where(Tables.JOURNEE.JOURNEE_.eq(jour)).and(Tables.JOURNEE.OWNER.eq(owner))
						.fetchInto(Journee.class);
				if (jList.size() == 1) {
					journee = jList.get(0);
				}
				
				//System.out.println("Fermeture de la journée!"+journee.getId());
				//System.out.println("journée en cours  de fermeture!");
				journee.setEtat(false);
				super.update(journee);
				System.out.println("journée fermée!");
			}
		} catch (Exception e) {
			// TODO: handle exception
		}
	}
	
	


}
