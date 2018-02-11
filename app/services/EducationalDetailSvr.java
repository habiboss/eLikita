package services;

import javax.inject.Inject;
import org.jooq.DSLContext;
import schemas.public_.tables.daos.EducationalDetailDao;
import schemas.public_.tables.pojos.EducationalDetail;

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
}
