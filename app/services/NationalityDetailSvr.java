package services;

import javax.inject.Inject;

import org.jooq.DSLContext;

import schemas.public_.tables.daos.NationalityDetailDao;
import schemas.public_.tables.pojos.NationalityDetail;

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
}
