package services;

import org.jooq.DSLContext;
import com.google.inject.Inject;
import schemas.public_.tables.daos.AdditionalInfoDao;
import schemas.public_.tables.pojos.AdditionalInfo;

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
}
