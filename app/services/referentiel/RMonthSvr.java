package services.referentiel;

import java.util.ArrayList;
import java.util.List;
import javax.inject.Inject;
import org.jooq.DSLContext;
import schemas.referential.Tables;
import schemas.referential.tables.daos.RMonthDao;
import schemas.referential.tables.records.RMonthRecord;

public class RMonthSvr extends RMonthDao{
	@Inject
	DSLContext sqlContext;

	@Inject
	public RMonthSvr(DSLContext sqlContext) {
		super();
		this.setConfiguration(sqlContext.configuration());
	}
	
	public List<schemas.referential.tables.pojos.RMonth> findByRMonth(String q) {
		// TODO Auto-generated method stub
		List<schemas.referential.tables.pojos.RMonth> rMonthLst = new ArrayList<schemas.referential.tables.pojos.RMonth>();
		org.jooq.Result<RMonthRecord> rMonthRecord = sqlContext.selectFrom(Tables.R_MONTH)
				.where(Tables.R_MONTH.MONTH_.like(q + "%")).fetch();
		for (RMonthRecord rMonthRecords : rMonthRecord) {
			schemas.referential.tables.pojos.RMonth rMonths = new schemas.referential.tables.pojos.RMonth();
			rMonths.setId(rMonthRecords.getId());
			rMonths.setMonth_(rMonthRecords.getMonth_());
			rMonthLst.add(rMonths);
		}
		return rMonthLst;
	}
}
