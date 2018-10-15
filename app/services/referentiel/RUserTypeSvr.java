package services.referentiel;

import java.util.ArrayList;
import java.util.List;
import java.util.stream.Collectors;
import javax.inject.Inject;
import org.jooq.DSLContext;
import schemas.referential.Tables;
import schemas.referential.tables.daos.RUserTypeDao;
import schemas.referential.tables.records.RUserTypeRecord;

public class RUserTypeSvr extends RUserTypeDao{
	@Inject
	DSLContext sqlContext;

	@Inject
	public RUserTypeSvr(DSLContext sqlContext) {
		super();
		this.setConfiguration(sqlContext.configuration());
	}
	
	public List<schemas.referential.tables.pojos.RUserType> findByRUserType(String q) {
		// TODO Auto-generated method stub
		List<schemas.referential.tables.pojos.RUserType> RUserTypeLst = new ArrayList<schemas.referential.tables.pojos.RUserType>();
		org.jooq.Result<RUserTypeRecord> RUserTypeRecord = sqlContext.selectFrom(Tables.R_USER_TYPE)
				.where(Tables.R_USER_TYPE.USER_TYPE.like(q + "%")).fetch();
		for (RUserTypeRecord RUserTypeRecords : RUserTypeRecord) {
			schemas.referential.tables.pojos.RUserType RUserTypes = new schemas.referential.tables.pojos.RUserType();
			RUserTypes.setId(RUserTypeRecords.getId());
			RUserTypes.setUserType(RUserTypeRecords.getUserType());
			RUserTypeLst.add(RUserTypes);
		}
		return RUserTypeLst;
	}

	public void save(schemas.referential.tables.pojos.RUserType RUserType) {
		// TODO Auto-generated method stub
		if (!fetchById(RUserType.getId()).isEmpty()) {
			super.update(RUserType);
		} else {
			super.insert(RUserType);
		}

	}

	public void delete(schemas.referential.tables.pojos.RUserType RUserType) {
		// TODO Auto-generated method stub
		try {
			this.deleteById(RUserType.getId());
		} catch (Exception e) {
			// TODO: handle exception
		}
	}

	public models.util.Page<schemas.referential.tables.pojos.RUserType> pageRUserType(int page, int pageSize,
			String value) {
		int from_index = (page < 1 ? 0 : page - 1) * pageSize;
		final List<schemas.referential.tables.pojos.RUserType> RUserType = findAll().stream()
				.filter(c -> c.getId().toString().contains(value) || c.getUserType().contains(value))
				.collect(Collectors.toList());
		RUserType.sort((o1, o2) -> (o1.getId().compareTo(o2.getId())));
		final List<schemas.referential.tables.pojos.RUserType> result = RUserType.stream().skip(from_index)
				.limit(pageSize).collect(Collectors.toList());
		return new models.util.Page<schemas.referential.tables.pojos.RUserType>(result, RUserType.size(), page,
				pageSize);
	}
}
