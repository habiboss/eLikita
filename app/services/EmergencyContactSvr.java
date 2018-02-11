package services;

import javax.inject.Inject;
import org.jooq.DSLContext;
import schemas.public_.tables.daos.EmergencyContactDao;
import schemas.public_.tables.pojos.EmergencyContact;
import schemas.public_.tables.pojos.StudentDetail;

public class EmergencyContactSvr extends EmergencyContactDao{
	@Inject
	DSLContext sqlContext;
	
	@Inject
	public EmergencyContactSvr(DSLContext sqlContext) {
		super();
		this.setConfiguration(sqlContext.configuration());
	}
	
	public Long save(EmergencyContact emergencyContact) {
		// TODO Auto-generated method stub
		if (!fetchById(emergencyContact.getId()).isEmpty()) {
			super.update(emergencyContact);
		} else {
			//emergencyContact.getStudentFk("xxxxxx");
			super.insert(emergencyContact);
		}
		// return studentDetail.getId();
		return null;
	}
}
