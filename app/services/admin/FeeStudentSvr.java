package services.admin;

import java.util.List;
import java.util.stream.Collectors;
import javax.inject.Inject;
import org.jooq.DSLContext;
import schemas.administrator.tables.daos.FeeStudentDao;
import schemas.administrator.tables.pojos.FeeStudent;

public class FeeStudentSvr extends FeeStudentDao{
	@Inject
	DSLContext sqlContext;

	@Inject
	public FeeStudentSvr(DSLContext sqlContext) {
		super();
		this.setConfiguration(sqlContext.configuration());
	}
	
/*	public List<FeeStudent> findByRUserType(String q) {
		// TODO Auto-generated method stub
		List<FeeStudent> RUserTypeLst = new ArrayList<FeeStudent>();
		org.jooq.Result<RUserTypeRecord> RUserTypeRecord = sqlContext.selectFrom(Tables.R_USER_TYPE)
				.where(Tables.R_USER_TYPE.USER_TYPE.like(q + "%")).fetch();
		for (RUserTypeRecord RUserTypeRecords : RUserTypeRecord) {
			FeeStudent RUserTypes = new FeeStudent();
			RUserTypes.setId(RUserTypeRecords.getId());
			RUserTypes.setUserType(RUserTypeRecords.getUserType());
			RUserTypeLst.add(RUserTypes);
		}
		return RUserTypeLst;
	}*/

	public void save(FeeStudent feeStudent, String id) {
		// TODO Auto-generated method stub
		if (!fetchById(feeStudent.getId()).isEmpty()) {
			super.update(feeStudent);
		} else {
			feeStudent.setStudentFk(id);
			super.insert(feeStudent);
		}

	}

	public void delete(FeeStudent feeStudent) {
		// TODO Auto-generated method stub
		try {
			this.deleteById(feeStudent.getId());
		} catch (Exception e) {
			// TODO: handle exception
		}
	}

	public models.util.Page<FeeStudent> pageFeeStudent(int page, int pageSize,
			String value) {
		int from_index = (page < 1 ? 0 : page - 1) * pageSize;
		final List<FeeStudent> feeStudent = findAll().stream()
				.filter(c -> c.getId().toString().contains(value) || c.getDiscountFk().contains(value))
				.collect(Collectors.toList());
		feeStudent.sort((o1, o2) -> (o1.getId().compareTo(o2.getId())));
		final List<FeeStudent> result = feeStudent.stream().skip(from_index)
				.limit(pageSize).collect(Collectors.toList());
		return new models.util.Page<FeeStudent>(result, feeStudent.size(), page,
				pageSize);
	}
}
