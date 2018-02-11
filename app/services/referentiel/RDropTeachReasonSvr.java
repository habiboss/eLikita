package services.referentiel;

import java.util.ArrayList;
import java.util.List;
import java.util.stream.Collectors;
import javax.inject.Inject;
import org.jooq.DSLContext;
import schemas.referential.Tables;
import schemas.referential.tables.daos.RDropTeachReasonDao;
import schemas.referential.tables.records.RDropTeachReasonRecord;

public class RDropTeachReasonSvr extends RDropTeachReasonDao{
	@Inject
	DSLContext sqlContext;

	@Inject
	public RDropTeachReasonSvr(DSLContext sqlContext) {
		super();
		this.setConfiguration(sqlContext.configuration());
	}
	
	public List<schemas.referential.tables.pojos.RDropTeachReason> findByRDropTeachReason(String q) {
		// TODO Auto-generated method stub
		List<schemas.referential.tables.pojos.RDropTeachReason> rDropTeachReasonLst = new ArrayList<schemas.referential.tables.pojos.RDropTeachReason>();
		org.jooq.Result<RDropTeachReasonRecord> rDropTeachReasonRecord = sqlContext
				.selectFrom(Tables.R_DROP_TEACH_REASON).where(Tables.R_DROP_TEACH_REASON.REASON.like(q + "%"))
				.fetch();
		for (RDropTeachReasonRecord rDropTeachReasonRecords : rDropTeachReasonRecord) {
			schemas.referential.tables.pojos.RDropTeachReason rDropTeachReasons = new schemas.referential.tables.pojos.RDropTeachReason();
			rDropTeachReasons.setId(rDropTeachReasonRecords.getId());
			rDropTeachReasons.setReason(rDropTeachReasonRecords.getReason());
			rDropTeachReasonLst.add(rDropTeachReasons);
		}
		return rDropTeachReasonLst;
	}

	public void save(schemas.referential.tables.pojos.RDropTeachReason rDropTeachReason) {
		// TODO Auto-generated method stub
		if (!fetchById(rDropTeachReason.getId()).isEmpty()) {
			super.update(rDropTeachReason);
		} else {
			super.insert(rDropTeachReason);
		}

	}

	public void delete(schemas.referential.tables.pojos.RDropTeachReason rDropTeachReason) {
		// TODO Auto-generated method stub
		try {
			this.deleteById(rDropTeachReason.getId());
		} catch (Exception e) {
			// TODO: handle exception
		}
	}

	public Boolean findByReason(String reason) {
		return !fetchByReason(reason).isEmpty();
	}

	public models.util.Page<schemas.referential.tables.pojos.RDropTeachReason> pageRDropTeachReason(int page,
			int pageSize, String value) {
		int from_index = (page < 1 ? 0 : page - 1) * pageSize;
		final List<schemas.referential.tables.pojos.RDropTeachReason> rDropTeachReason = findAll().stream()
				.filter(c -> c.getId().toString().contains(value) || c.getReason().contains(value))
				.collect(Collectors.toList());
		rDropTeachReason.sort((o1, o2) -> (o1.getId().compareTo(o2.getId())));
		final List<schemas.referential.tables.pojos.RDropTeachReason> result = rDropTeachReason.stream()
				.skip(from_index).limit(pageSize).collect(Collectors.toList());
		return new models.util.Page<schemas.referential.tables.pojos.RDropTeachReason>(result,
				rDropTeachReason.size(), page, pageSize);
	}
}
