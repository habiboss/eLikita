package services.referentiel;

import java.util.ArrayList;
import java.util.List;
import java.util.stream.Collectors;

import javax.inject.Inject;

import org.jooq.DSLContext;

import schemas.referential.Tables;
import schemas.referential.tables.daos.RTeachOutcomeDao;
import schemas.referential.tables.records.RTeachOutcomeRecord;

public class RTeachOutcomeSvr extends RTeachOutcomeDao {
	@Inject
	DSLContext sqlContext;

	@Inject
	public RTeachOutcomeSvr(DSLContext sqlContext) {
		super();
		this.setConfiguration(sqlContext.configuration());
	}

	public List<schemas.referential.tables.pojos.RTeachOutcome> findByRTeachOutcome(String q) {
		// TODO Auto-generated method stub
		List<schemas.referential.tables.pojos.RTeachOutcome> rTeachOutcomeLst = new ArrayList<schemas.referential.tables.pojos.RTeachOutcome>();
		org.jooq.Result<RTeachOutcomeRecord> rTeachOutcomeRecord = sqlContext.selectFrom(Tables.R_TEACH_OUTCOME)
				.where(Tables.R_TEACH_OUTCOME.OUTCOME.like(q + "%")).fetch();
		for (RTeachOutcomeRecord rTeachOutcomeRecords : rTeachOutcomeRecord) {
			schemas.referential.tables.pojos.RTeachOutcome rTeachOutcomes = new schemas.referential.tables.pojos.RTeachOutcome();
			rTeachOutcomes.setId(rTeachOutcomeRecords.getId());
			rTeachOutcomes.setOutcome(rTeachOutcomeRecords.getOutcome());
			rTeachOutcomeLst.add(rTeachOutcomes);
		}
		return rTeachOutcomeLst;
	}

	public void save(schemas.referential.tables.pojos.RTeachOutcome rTeachOutcome) {
		// TODO Auto-generated method stub
		if (!fetchById(rTeachOutcome.getId()).isEmpty()) {
			super.update(rTeachOutcome);
		} else {
			super.insert(rTeachOutcome);
		}

	}

	public void delete(schemas.referential.tables.pojos.RTeachOutcome rTeachOutcome) {
		// TODO Auto-generated method stub
		try {
			this.deleteById(rTeachOutcome.getId());
		} catch (Exception e) {
			// TODO: handle exception
		}
	}

	public Boolean findByOutcome(String outcome) {
		return !fetchByOutcome(outcome).isEmpty();
	}

	public models.util.Page<schemas.referential.tables.pojos.RTeachOutcome> pageRTeachOutcome(int page, int pageSize,
			String value) {
		int from_index = (page < 1 ? 0 : page - 1) * pageSize;
		final List<schemas.referential.tables.pojos.RTeachOutcome> rTeachOutcome = findAll().stream()
				.filter(c -> c.getId().toString().contains(value) || c.getOutcome().contains(value))
				.collect(Collectors.toList());
		rTeachOutcome.sort((o1, o2) -> (o1.getId().compareTo(o2.getId())));
		final List<schemas.referential.tables.pojos.RTeachOutcome> result = rTeachOutcome.stream().skip(from_index)
				.limit(pageSize).collect(Collectors.toList());
		return new models.util.Page<schemas.referential.tables.pojos.RTeachOutcome>(result, rTeachOutcome.size(), page,
				pageSize);
	}
}
