package services.referentiel;

import java.util.ArrayList;
import java.util.List;
import javax.inject.Inject;
import org.jooq.DSLContext;
import schemas.referential.Tables;
import schemas.referential.tables.daos.RStatusDao;
import schemas.referential.tables.records.RStatusRecord;

public class RStatusSvr extends RStatusDao{
	@Inject
	DSLContext sqlContext;

	@Inject
	public RStatusSvr(DSLContext sqlContext) {
		super();
		this.setConfiguration(sqlContext.configuration());
	}
	
	public List<schemas.referential.tables.pojos.RStatus> findByRStatus(String q) {
		// TODO Auto-generated method stub
		List<schemas.referential.tables.pojos.RStatus> rStatusLst = new ArrayList<schemas.referential.tables.pojos.RStatus>();
		org.jooq.Result<RStatusRecord> rStatusRecord = sqlContext.selectFrom(Tables.R_STATUS)
				.where(Tables.R_STATUS.STATUS.like(q + "%")).fetch();
		for (RStatusRecord rStatusRecords : rStatusRecord) {
			schemas.referential.tables.pojos.RStatus rStatuss = new schemas.referential.tables.pojos.RStatus();
			rStatuss.setId(rStatusRecords.getId());
			rStatuss.setStatus(rStatusRecords.getStatus());
			rStatusLst.add(rStatuss);
		}
		return rStatusLst;
	}
}
