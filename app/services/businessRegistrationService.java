package services;

import interfaces.IbusinessRegistration;
import models.InstitutionDetail;
import play.db.jpa.JPA;


public class businessRegistrationService implements IbusinessRegistration{

	public String save(InstitutionDetail institution) {
		
		try {
			JPA.em().persist(institution);
			
		} catch (Exception e) {
		}
		return null;
	}

	@Override
	public String update(InstitutionDetail institution) {
		InstitutionDetail institutionNew = new InstitutionDetail().findById(institution.getId());
		institutionNew.setAddress(institution.getABN());
		institutionNew.setAddress(institution.getAddress());
		institutionNew.setAddress(institution.getBusinessEmail());
		institutionNew.setAddress(institution.getBusinessName());
		institutionNew.setAddress(institution.getBusinessPhone());
		institutionNew.setAddress(institution.getBusinessSize());
		institutionNew.setAddress(institution.getBusinessWebsite());
		institutionNew.setAddress(institution.getCity());
		institutionNew.setAddress(institution.getCountry());
		institutionNew.setAddress(institution.getCurrentAdvertisement());
		institutionNew.setAddress(institution.getEmail());
		institutionNew.setAddress(institution.getFax());
		institutionNew.setAddress(institution.getFirstName());
		institutionNew.setAddress(institution.getIndustry());
		institutionNew.setAddress(institution.getLastName());
		institutionNew.setAddress(institution.getPhone());
		institutionNew.setAddress(institution.getPostcode());
		institutionNew.setAddress(institution.getState());
		institutionNew.setAddress(institution.getStatus());
		
		try {
			JPA.em().persist(institutionNew);
		} catch (Exception e) {
		}
		
		return null;
	}

	@Override
	public String delete(InstitutionDetail institution) {
		return null;
	}

}
