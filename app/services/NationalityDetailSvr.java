package services;

import javax.inject.Inject;

import org.jooq.DSLContext;

import schemas.public_.Tables;
import schemas.public_.tables.daos.NationalityDetailDao;
import schemas.public_.tables.pojos.NationalityDetail;
import schemas.public_.tables.records.AddressDetailRecord;
import schemas.public_.tables.records.NationalityDetailRecord;

public class NationalityDetailSvr extends NationalityDetailDao{
	@Inject
	DSLContext sqlContext;

	@Inject
	public NationalityDetailSvr(DSLContext sqlContext) {
		super();
		this.setConfiguration(sqlContext.configuration());
	}
	
	public void save(NationalityDetail nationalityDetail) {
		// TODO Auto-generated method stub
		if (!fetchById(nationalityDetail.getId()).isEmpty()) {
			super.update(nationalityDetail);
		} else {
			super.insert(nationalityDetail);
		}

	}
	
	public NationalityDetailRecord findByStudentFk(String studentFk) {
		return sqlContext.fetchOne(Tables.NATIONALITY_DETAIL, Tables.NATIONALITY_DETAIL.STUDENT_FK.equal(studentFk));
	}
}
