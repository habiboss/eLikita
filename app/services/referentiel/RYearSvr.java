package services.referentiel;

import java.util.ArrayList;
import java.util.List;
import javax.inject.Inject;
import org.jooq.DSLContext;
import schemas.referential.Tables;
import schemas.referential.tables.daos.RYearDao;
import schemas.referential.tables.records.RYearRecord;

public class RYearSvr extends RYearDao{
	@Inject
	DSLContext sqlContext;

	@Inject
	public RYearSvr(DSLContext sqlContext) {
		super();
		this.setConfiguration(sqlContext.configuration());
	}
	
	public List<schemas.referential.tables.pojos.RYear> findByRYear(String q) {
		// TODO Auto-generated method stub
		List<schemas.referential.tables.pojos.RYear> rYearLst = new ArrayList<schemas.referential.tables.pojos.RYear>();
		org.jooq.Result<RYearRecord> rYearRecord = sqlContext.selectFrom(Tables.R_YEAR)
				.where(Tables.R_YEAR.YEAR_.like(q + "%")).fetch();
		for (RYearRecord rYearRecords : rYearRecord) {
			schemas.referential.tables.pojos.RYear rYears = new schemas.referential.tables.pojos.RYear();
			rYears.setId(rYearRecords.getId());
			rYears.setYear_(rYearRecords.getYear_());
			rYearLst.add(rYears);
		}
		return rYearLst;
	}
}
