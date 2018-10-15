package services.referentiel;

import java.util.ArrayList;
import java.util.List;
import javax.inject.Inject;
import org.jooq.DSLContext;
import schemas.referential.tables.daos.RCampusDao;
import schemas.referential.tables.pojos.RCampus;
import schemas.referential.tables.records.RCampusRecord;

public class RCampusSvr extends RCampusDao{
	@Inject
	DSLContext sqlContext;
	
	@Inject
	public RCampusSvr(DSLContext sqlContext) {
		super();
		this.setConfiguration(sqlContext.configuration());
	}
	
	public List<RCampus> findByRCampus(String q) {
		// TODO Auto-generated method stub
		List<RCampus> rCampusLst = new ArrayList<RCampus>();
		org.jooq.Result<RCampusRecord> rCampusRecord = sqlContext
				.selectFrom(schemas.referential.tables.RCampus.R_CAMPUS).where(schemas.referential.tables.RCampus.R_CAMPUS.NAME_.like(q + "%"))
				.fetch();
		for (RCampusRecord rCampusRecords : rCampusRecord) {
			RCampus rCampus = new RCampus();
			rCampus.setId(rCampusRecords.getId());
			rCampus.setName_(rCampusRecords.getName_());
			rCampusLst.add(rCampus);
		}
		return rCampusLst;
	}

}
