package services.referentiel;

import java.util.ArrayList;
import java.util.List;
import java.util.stream.Collectors;
import javax.inject.Inject;
import org.jooq.DSLContext;
import schemas.referential.Tables;
import schemas.referential.tables.daos.RClassTypeDao;
import schemas.referential.tables.records.RClassTypeRecord;

public class RClassTypeSvr extends RClassTypeDao{
	@Inject
	DSLContext sqlContext;

	@Inject
	public RClassTypeSvr(DSLContext sqlContext) {
		super();
		this.setConfiguration(sqlContext.configuration());
	}
	
	public List<schemas.referential.tables.pojos.RClassType> findByRClassType(String q) {
		// TODO Auto-generated method stub
		List<schemas.referential.tables.pojos.RClassType> RClassTypeLst = new ArrayList<schemas.referential.tables.pojos.RClassType>();
		org.jooq.Result<RClassTypeRecord> rClassTypeRecord = sqlContext
				.selectFrom(Tables.R_CLASS_TYPE).where(Tables.R_CLASS_TYPE.NAME.like(q + "%"))
				.fetch();
		for (RClassTypeRecord rClassTypeRecords : rClassTypeRecord) {
			schemas.referential.tables.pojos.RClassType rClassTypes = new schemas.referential.tables.pojos.RClassType();
			rClassTypes.setId(rClassTypeRecords.getId());
			rClassTypes.setName(rClassTypeRecords.getName());
			RClassTypeLst.add(rClassTypes);
		}
		return RClassTypeLst;
	}

	public void save(schemas.referential.tables.pojos.RClassType RClassType) {
		// TODO Auto-generated method stub
		if (!fetchById(RClassType.getId()).isEmpty()) {
			super.update(RClassType);
		} else {
			super.insert(RClassType);
		}

	}

	public void delete(schemas.referential.tables.pojos.RClassType RClassType) {
		// TODO Auto-generated method stub
		try {
			this.deleteById(RClassType.getId());
		} catch (Exception e) {
			// TODO: handle exception
		}
	}

	public Boolean findByName(String name) {
		return !fetchByName(name).isEmpty();
	}

	public models.util.Page<schemas.referential.tables.pojos.RClassType> pageRClassType(int page,
			int pageSize, String value) {
		int from_index = (page < 1 ? 0 : page - 1) * pageSize;
		final List<schemas.referential.tables.pojos.RClassType> rClassType = findAll().stream()
				.filter(c -> c.getId().toString().contains(value) || c.getName().contains(value))
				.collect(Collectors.toList());
		rClassType.sort((o1, o2) -> (o1.getId().compareTo(o2.getId())));
		final List<schemas.referential.tables.pojos.RClassType> result = rClassType.stream()
				.skip(from_index).limit(pageSize).collect(Collectors.toList());
		return new models.util.Page<schemas.referential.tables.pojos.RClassType>(result,
				rClassType.size(), page, pageSize);
	}
}
