package services;

import javax.inject.Inject;
import org.jooq.DSLContext;

import schemas.public_.Tables;
import schemas.public_.tables.daos.EducationalDetailDao;
import schemas.public_.tables.pojos.EducationalDetail;
import schemas.public_.tables.records.ContactDetailRecord;
import schemas.public_.tables.records.EducationalDetailRecord;

public class EducationalDetailSvr extends EducationalDetailDao{
	@Inject
	DSLContext sqlContext;

	@Inject
	public EducationalDetailSvr(DSLContext sqlContext) {
		super();
		this.setConfiguration(sqlContext.configuration());
	}
	
	public void save(EducationalDetail educationalDetail) {
		// TODO Auto-generated method stub
		if (!fetchById(educationalDetail.getId()).isEmpty()) {
			super.update(educationalDetail);
		} else {
			super.insert(educationalDetail);
		}

	}
	
	public EducationalDetailRecord findByStudentFk(String studentFk) {
		return sqlContext.fetchOne(Tables.EDUCATIONAL_DETAIL, Tables.EDUCATIONAL_DETAIL.STUDENT_FK.equal(studentFk));
	}
}
