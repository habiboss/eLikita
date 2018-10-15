package services.referentiel;

import java.util.ArrayList;
import java.util.List;
import java.util.stream.Collectors;
import javax.inject.Inject;
import org.jooq.DSLContext;
import schemas.referential.Tables;
import schemas.referential.tables.daos.RDesignationDao;
import schemas.referential.tables.records.RDesignationRecord;

public class RDesignationSvr extends RDesignationDao{
	@Inject
	DSLContext sqlContext;

	@Inject
	public RDesignationSvr(DSLContext sqlContext) {
		super();
		this.setConfiguration(sqlContext.configuration());
	}
	
	public List<schemas.referential.tables.pojos.RDesignation> findByRDesignation(String q) {
		// TODO Auto-generated method stub
		List<schemas.referential.tables.pojos.RDesignation> RDesignationLst = new ArrayList<schemas.referential.tables.pojos.RDesignation>();
		org.jooq.Result<RDesignationRecord> RDesignationRecord = sqlContext.selectFrom(Tables.R_DESIGNATION)
				.where(Tables.R_DESIGNATION.DESIGNATION.like(q + "%")).fetch();
		for (RDesignationRecord RDesignationRecords : RDesignationRecord) {
			schemas.referential.tables.pojos.RDesignation RDesignations = new schemas.referential.tables.pojos.RDesignation();
			RDesignations.setId(RDesignationRecords.getId());
			RDesignations.setDesignation(RDesignationRecords.getDesignation());
			RDesignationLst.add(RDesignations);
		}
		return RDesignationLst;
	}

	public void save(schemas.referential.tables.pojos.RDesignation RDesignation) {
		// TODO Auto-generated method stub
		if (!fetchById(RDesignation.getId()).isEmpty()) {
			super.update(RDesignation);
		} else {
			super.insert(RDesignation);
		}

	}

	public void delete(schemas.referential.tables.pojos.RDesignation RDesignation) {
		// TODO Auto-generated method stub
		try {
			this.deleteById(RDesignation.getId());
		} catch (Exception e) {
			// TODO: handle exception
		}
	}

	public models.util.Page<schemas.referential.tables.pojos.RDesignation> pageRDesignation(int page, int pageSize,
			String value) {
		int from_index = (page < 1 ? 0 : page - 1) * pageSize;
		final List<schemas.referential.tables.pojos.RDesignation> RDesignation = findAll().stream()
				.filter(c -> c.getId().toString().contains(value) || c.getDesignation().contains(value))
				.collect(Collectors.toList());
		RDesignation.sort((o1, o2) -> (o1.getId().compareTo(o2.getId())));
		final List<schemas.referential.tables.pojos.RDesignation> result = RDesignation.stream().skip(from_index)
				.limit(pageSize).collect(Collectors.toList());
		return new models.util.Page<schemas.referential.tables.pojos.RDesignation>(result, RDesignation.size(), page,
				pageSize);
	}
}
