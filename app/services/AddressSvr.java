package services;

import org.jooq.DSLContext;
import com.google.inject.Inject;
import schemas.public_.tables.daos.AddressDetailDao;
import schemas.public_.tables.pojos.AddressDetail;

public class AddressSvr extends AddressDetailDao{

	@Inject
	DSLContext sqlContext;
	
	@Inject
	public AddressSvr(DSLContext sqlContext) {
		super();
		this.setConfiguration(sqlContext.configuration());
	}
	
	//@Override
	public void save(AddressDetail addressDetail) {
		// TODO Auto-generated method stub
		/*String postCode = form.field("postCode").value();
		String presentAddress = form.field("presentAddress").value();
		String permanentAddress = form.field("permanentAddress").value();
		String country = form.field("country").value();
		String city = form.field("city").value();
		String region = form.field("region").value();
		String validUntil = form.field("validUntil").value();
		
		addressDetail.setPostcode(postCode);
		addressDetail.setPresentAddress(presentAddress);
		addressDetail.setPermanentAddress(permanentAddress);
		addressDetail.setCountry(country);
		addressDetail.setCity(city);
		addressDetail.setRegion(region);
		addressDetail.setValidUntil(new Date());*/
		super.insert(addressDetail);
		
		
		
	}


}
