package services.referentiel;

import java.util.ArrayList;
import java.util.List;
import java.util.stream.Collectors;

import javax.inject.Inject;

import org.jooq.DSLContext;

import schemas.referential.Tables;
import schemas.referential.tables.daos.RLevelDao;
import schemas.referential.tables.records.RLevelRecord;

public class RLevelSvr extends RLevelDao{
	@Inject
	DSLContext sqlContext;

	@Inject
	public RLevelSvr(DSLContext sqlContext) {
		super();
		this.setConfiguration(sqlContext.configuration());
	}
	
	public List<schemas.referential.tables.pojos.RLevel> findByRLevel(String q) {
		// TODO Auto-generated method stub
		List<schemas.referential.tables.pojos.RLevel> rLevelLst = new ArrayList<schemas.referential.tables.pojos.RLevel>();
		org.jooq.Result<RLevelRecord> rLevelRecord = sqlContext
				.selectFrom(Tables.R_LEVEL).where(Tables.R_LEVEL.LEVEL.like(q + "%"))
				.fetch();
		for (RLevelRecord rLevelRecords : rLevelRecord) {
			schemas.referential.tables.pojos.RLevel rLevels = new schemas.referential.tables.pojos.RLevel();
			rLevels.setId(rLevelRecords.getId());
			rLevels.setLevel(rLevelRecords.getLevel());
			rLevelLst.add(rLevels);
		}
		return rLevelLst;
	}

	public void save(schemas.referential.tables.pojos.RLevel rLevel) {
		// TODO Auto-generated method stub
		if (!fetchById(rLevel.getId()).isEmpty()) {
			super.update(rLevel);
		} else {
			super.insert(rLevel);
		}

	}

	public void delete(schemas.referential.tables.pojos.RLevel rLevel) {
		// TODO Auto-generated method stub
		try {
			this.deleteById(rLevel.getId());
		} catch (Exception e) {
			// TODO: handle exception
		}
	}

	public Boolean findByFeeType(String level) {
		return !fetchByLevel(level).isEmpty();
	}

	public models.util.Page<schemas.referential.tables.pojos.RLevel> pageRLevel(int page,
			int pageSize, String value) {
		int from_index = (page < 1 ? 0 : page - 1) * pageSize;
		final List<schemas.referential.tables.pojos.RLevel> rLevel = findAll().stream()
				.filter(c -> c.getId().toString().contains(value) || c.getLevel().contains(value))
				.collect(Collectors.toList());
		rLevel.sort((o1, o2) -> (o1.getId().compareTo(o2.getId())));
		final List<schemas.referential.tables.pojos.RLevel> result = rLevel.stream()
				.skip(from_index).limit(pageSize).collect(Collectors.toList());
		return new models.util.Page<schemas.referential.tables.pojos.RLevel>(result,
				rLevel.size(), page, pageSize);
	}
}
