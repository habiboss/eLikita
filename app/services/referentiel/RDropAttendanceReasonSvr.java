package services.referentiel;

import java.util.ArrayList;
import java.util.List;
import java.util.stream.Collectors;
import javax.inject.Inject;
import org.jooq.DSLContext;
import schemas.referential.Tables;
import schemas.referential.tables.daos.RDropAttendanceReasonDao;
import schemas.referential.tables.records.RDropAttendanceReasonRecord;

public class RDropAttendanceReasonSvr extends RDropAttendanceReasonDao {
	@Inject
	DSLContext sqlContext;

	@Inject
	public RDropAttendanceReasonSvr(DSLContext sqlContext) {
		super();
		this.setConfiguration(sqlContext.configuration());
	}

	public List<schemas.referential.tables.pojos.RDropAttendanceReason> findByRDropAttendanceReason(String q) {
		// TODO Auto-generated method stub
		List<schemas.referential.tables.pojos.RDropAttendanceReason> rDropAttendanceReasonLst = new ArrayList<schemas.referential.tables.pojos.RDropAttendanceReason>();
		org.jooq.Result<RDropAttendanceReasonRecord> rDropAttendanceReasonRecord = sqlContext
				.selectFrom(Tables.R_DROP_ATTENDANCE_REASON).where(Tables.R_DROP_ATTENDANCE_REASON.REASON.like(q + "%"))
				.fetch();
		for (RDropAttendanceReasonRecord rDropAttendanceReasonRecords : rDropAttendanceReasonRecord) {
			schemas.referential.tables.pojos.RDropAttendanceReason rDropAttendanceReasons = new schemas.referential.tables.pojos.RDropAttendanceReason();
			rDropAttendanceReasons.setId(rDropAttendanceReasonRecords.getId());
			rDropAttendanceReasons.setReason(rDropAttendanceReasonRecords.getReason());
			rDropAttendanceReasonLst.add(rDropAttendanceReasons);
		}
		return rDropAttendanceReasonLst;
	}

	public void save(schemas.referential.tables.pojos.RDropAttendanceReason rDropAttendanceReason) {
		// TODO Auto-generated method stub
		if (!fetchById(rDropAttendanceReason.getId()).isEmpty()) {
			super.update(rDropAttendanceReason);
		} else {
			super.insert(rDropAttendanceReason);
		}

	}

	public void delete(schemas.referential.tables.pojos.RDropAttendanceReason rDropAttendanceReason) {
		// TODO Auto-generated method stub
		try {
			this.deleteById(rDropAttendanceReason.getId());
		} catch (Exception e) {
			// TODO: handle exception
		}
	}

	public Boolean findByReason(String reason) {
		return !fetchByReason(reason).isEmpty();
	}

	public models.util.Page<schemas.referential.tables.pojos.RDropAttendanceReason> pageRDropAttendanceReason(int page,
			int pageSize, String value) {
		int from_index = (page < 1 ? 0 : page - 1) * pageSize;
		final List<schemas.referential.tables.pojos.RDropAttendanceReason> rDropAttendanceReason = findAll().stream()
				.filter(c -> c.getId().toString().contains(value) || c.getReason().contains(value))
				.collect(Collectors.toList());
		rDropAttendanceReason.sort((o1, o2) -> (o1.getId().compareTo(o2.getId())));
		final List<schemas.referential.tables.pojos.RDropAttendanceReason> result = rDropAttendanceReason.stream()
				.skip(from_index).limit(pageSize).collect(Collectors.toList());
		return new models.util.Page<schemas.referential.tables.pojos.RDropAttendanceReason>(result,
				rDropAttendanceReason.size(), page, pageSize);
	}
}
