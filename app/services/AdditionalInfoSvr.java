package services;

import org.jooq.DSLContext;
import com.google.inject.Inject;

import schemas.public_.Tables;
import schemas.public_.tables.daos.AdditionalInfoDao;
import schemas.public_.tables.pojos.AdditionalInfo;
import schemas.public_.tables.records.AdditionalInfoRecord;
import schemas.public_.tables.records.NationalityDetailRecord;

public class AdditionalInfoSvr extends AdditionalInfoDao{
	@Inject
	DSLContext sqlContext;

	@Inject
	public AdditionalInfoSvr(DSLContext sqlContext) {
		super();
		this.setConfiguration(sqlContext.configuration());
	}

	public void save(AdditionalInfo additionalInfo) {
		// TODO Auto-generated method stub
		if (!fetchById(additionalInfo.getId()).isEmpty()) {
			super.update(additionalInfo);
		} else {
			super.insert(additionalInfo);
		}
	}
	
	public AdditionalInfoRecord findByStudentFk(String studentFk) {
		return sqlContext.fetchOne(Tables.ADDITIONAL_INFO, Tables.ADDITIONAL_INFO.STUDENT_FK.equal(studentFk));
	}
}
