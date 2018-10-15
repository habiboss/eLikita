package services.referentiel;

import java.util.ArrayList;
import java.util.List;
import java.util.stream.Collectors;
import javax.inject.Inject;
import org.jooq.DSLContext;
import schemas.referential.Tables;
import schemas.referential.tables.daos.RDepartmentDao;
import schemas.referential.tables.records.RDepartmentRecord;

public class RDepartmentSvr extends RDepartmentDao{
	@Inject
	DSLContext sqlContext;

	@Inject
	public RDepartmentSvr(DSLContext sqlContext) {
		super();
		this.setConfiguration(sqlContext.configuration());
	}
	
	public List<schemas.referential.tables.pojos.RDepartment> findByRDepartment(String q) {
		// TODO Auto-generated method stub
		List<schemas.referential.tables.pojos.RDepartment> RDepartmentLst = new ArrayList<schemas.referential.tables.pojos.RDepartment>();
		org.jooq.Result<RDepartmentRecord> RDepartmentRecord = sqlContext.selectFrom(Tables.R_DEPARTMENT)
				.where(Tables.R_DEPARTMENT.DEPARTMENT.like(q + "%")).fetch();
		for (RDepartmentRecord RDepartmentRecords : RDepartmentRecord) {
			schemas.referential.tables.pojos.RDepartment RDepartments = new schemas.referential.tables.pojos.RDepartment();
			RDepartments.setId(RDepartmentRecords.getId());
			RDepartments.setDepartment(RDepartmentRecords.getDepartment());
			RDepartmentLst.add(RDepartments);
		}
		return RDepartmentLst;
	}

	public void save(schemas.referential.tables.pojos.RDepartment RDepartment) {
		// TODO Auto-generated method stub
		if (!fetchById(RDepartment.getId()).isEmpty()) {
			super.update(RDepartment);
		} else {
			super.insert(RDepartment);
		}

	}

	public void delete(schemas.referential.tables.pojos.RDepartment RDepartment) {
		// TODO Auto-generated method stub
		try {
			this.deleteById(RDepartment.getId());
		} catch (Exception e) {
			// TODO: handle exception
		}
	}

	public models.util.Page<schemas.referential.tables.pojos.RDepartment> pageRDepartment(int page, int pageSize,
			String value) {
		int from_index = (page < 1 ? 0 : page - 1) * pageSize;
		final List<schemas.referential.tables.pojos.RDepartment> RDepartment = findAll().stream()
				.filter(c -> c.getId().toString().contains(value) || c.getDepartment().contains(value))
				.collect(Collectors.toList());
		RDepartment.sort((o1, o2) -> (o1.getId().compareTo(o2.getId())));
		final List<schemas.referential.tables.pojos.RDepartment> result = RDepartment.stream().skip(from_index)
				.limit(pageSize).collect(Collectors.toList());
		return new models.util.Page<schemas.referential.tables.pojos.RDepartment>(result, RDepartment.size(), page,
				pageSize);
	}
}
