package services;

import org.jooq.DSLContext;
import com.google.inject.Inject;
import schemas.public_.Tables;
import schemas.public_.tables.daos.ContactDetailDao;
import schemas.public_.tables.pojos.ContactDetail;
import schemas.public_.tables.records.ContactDetailRecord;
 
public class ContactSvr extends ContactDetailDao{
	@Inject
	DSLContext sqlContext;
	
	@Inject
	public ContactSvr(DSLContext sqlContext) {
		super();
		this.setConfiguration(sqlContext.configuration());
	}
	 
	public void save(ContactDetail contact) {
		// TODO Auto-generated method stub
		
		super.insert(contact);
	}
	
	public ContactDetailRecord findByStudentFk(String studentFk) {
		return sqlContext.fetchOne(Tables.CONTACT_DETAIL, Tables.CONTACT_DETAIL.STUDENT_FK.equal(studentFk));
	}





}
