package services.referentiel;

import java.util.ArrayList;
import java.util.List;
import java.util.stream.Collectors;
import javax.inject.Inject;
import org.jooq.DSLContext;
import schemas.referential.Tables;
import schemas.referential.tables.daos.RAttendanceOutcomeDao;
import schemas.referential.tables.records.RAttendanceOutcomeRecord;

public class RAttendanceOutcomeSvr extends RAttendanceOutcomeDao {
	
	@Inject
	DSLContext sqlContext;

	@Inject
	public RAttendanceOutcomeSvr(DSLContext sqlContext) {
		super();
		this.setConfiguration(sqlContext.configuration());
	}

	public List<schemas.referential.tables.pojos.RAttendanceOutcome> findByOutcome(String q) {
		// TODO Auto-generated method stub
		List<schemas.referential.tables.pojos.RAttendanceOutcome> rAttendanceOutcomeLst = new ArrayList<schemas.referential.tables.pojos.RAttendanceOutcome>();
		org.jooq.Result<RAttendanceOutcomeRecord> rAttendanceOutcomeRecord = sqlContext
				.selectFrom(Tables.R_ATTENDANCE_OUTCOME).where(Tables.R_ATTENDANCE_OUTCOME.OUTCOME.like(q + "%"))
				.fetch();
		for (RAttendanceOutcomeRecord rAttendanceOutcomeRecords : rAttendanceOutcomeRecord) {
			schemas.referential.tables.pojos.RAttendanceOutcome rattendanceOutcomes = new schemas.referential.tables.pojos.RAttendanceOutcome();
			rattendanceOutcomes.setId(rAttendanceOutcomeRecords.getId());
			rattendanceOutcomes.setOutcome(rAttendanceOutcomeRecords.getOutcome());
			rAttendanceOutcomeLst.add(rattendanceOutcomes);
		}
		return rAttendanceOutcomeLst;
	}

	public void save(schemas.referential.tables.pojos.RAttendanceOutcome rAttendanceOutcome) {
		// TODO Auto-generated method stub
		if (!fetchById(rAttendanceOutcome.getId()).isEmpty()) {
			super.update(rAttendanceOutcome);
		} else {
			super.insert(rAttendanceOutcome);
		}

	}

	public void delete(schemas.referential.tables.pojos.RAttendanceOutcome rAttendanceOutcome) {
		// TODO Auto-generated method stub
		try {
			this.deleteById(rAttendanceOutcome.getId());
		} catch (Exception e) {
			// TODO: handle exception
		}
	}

	public Boolean findByOutcomes(String outcome) {
		return !fetchByOutcome(outcome).isEmpty();
	}

	public models.util.Page<schemas.referential.tables.pojos.RAttendanceOutcome> pageRAttendanceOutcome(int page,
			int pageSize, String value) {
		int from_index = (page < 1 ? 0 : page - 1) * pageSize;
		final List<schemas.referential.tables.pojos.RAttendanceOutcome> rAttendanceOutcome = findAll().stream()
				.filter(c -> c.getId().toString().contains(value) || c.getOutcome().contains(value))
				.collect(Collectors.toList());
		rAttendanceOutcome.sort((o1, o2) -> (o1.getId().compareTo(o2.getId())));
		final List<schemas.referential.tables.pojos.RAttendanceOutcome> result = rAttendanceOutcome.stream()
				.skip(from_index).limit(pageSize).collect(Collectors.toList());
		return new models.util.Page<schemas.referential.tables.pojos.RAttendanceOutcome>(result,
				rAttendanceOutcome.size(), page, pageSize);
	}
}
