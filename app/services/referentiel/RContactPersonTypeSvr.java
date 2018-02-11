package services.referentiel;

import java.util.ArrayList;
import java.util.List;
import java.util.stream.Collectors;

import javax.inject.Inject;

import org.jooq.DSLContext;

import schemas.referential.Tables;
import schemas.referential.tables.daos.RContactPersonTypeDao;
import schemas.referential.tables.records.RContactPersonTypeRecord;

public class RContactPersonTypeSvr extends RContactPersonTypeDao{
	@Inject
	DSLContext sqlContext;

	@Inject
	public RContactPersonTypeSvr(DSLContext sqlContext) {
		super();
		this.setConfiguration(sqlContext.configuration());
	}
	
	public List<schemas.referential.tables.pojos.RContactPersonType> findByRContactPersonType(String q) {
		// TODO Auto-generated method stub
		List<schemas.referential.tables.pojos.RContactPersonType> rContactPersonTypeLst = new ArrayList<schemas.referential.tables.pojos.RContactPersonType>();
		org.jooq.Result<RContactPersonTypeRecord> rContactPersonTypeRecord = sqlContext
				.selectFrom(Tables.R_CONTACT_PERSON_TYPE).where(Tables.R_CONTACT_PERSON_TYPE.TYPE_NAME.like(q + "%"))
				.fetch();
		for (RContactPersonTypeRecord rContactPersonTypeRecords : rContactPersonTypeRecord) {
			schemas.referential.tables.pojos.RContactPersonType rContactPersonTypes = new schemas.referential.tables.pojos.RContactPersonType();
			rContactPersonTypes.setId(rContactPersonTypeRecords.getId());
			rContactPersonTypes.setTypeName(rContactPersonTypeRecords.getTypeName());
			rContactPersonTypeLst.add(rContactPersonTypes);
		}
		return rContactPersonTypeLst;
	}

	public void save(schemas.referential.tables.pojos.RContactPersonType rContactPersonType) {
		// TODO Auto-generated method stub
		if (!fetchById(rContactPersonType.getId()).isEmpty()) {
			super.update(rContactPersonType);
		} else {
			super.insert(rContactPersonType);
		}

	}

	public void delete(schemas.referential.tables.pojos.RContactPersonType rContactPersonType) {
		// TODO Auto-generated method stub
		try {
			this.deleteById(rContactPersonType.getId());
		} catch (Exception e) {
			// TODO: handle exception
		}
	}

	public Boolean findByTypeName(String name) {
		return !fetchByTypeName(name).isEmpty();
	}

	public models.util.Page<schemas.referential.tables.pojos.RContactPersonType> pageRContactPersonType(int page,
			int pageSize, String value) {
		int from_index = (page < 1 ? 0 : page - 1) * pageSize;
		final List<schemas.referential.tables.pojos.RContactPersonType> rContactPersonType = findAll().stream()
				.filter(c -> c.getId().toString().contains(value) || c.getTypeName().contains(value))
				.collect(Collectors.toList());
		rContactPersonType.sort((o1, o2) -> (o1.getId().compareTo(o2.getId())));
		final List<schemas.referential.tables.pojos.RContactPersonType> result = rContactPersonType.stream()
				.skip(from_index).limit(pageSize).collect(Collectors.toList());
		return new models.util.Page<schemas.referential.tables.pojos.RContactPersonType>(result,
				rContactPersonType.size(), page, pageSize);
	}
}
