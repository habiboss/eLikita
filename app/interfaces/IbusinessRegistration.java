package interfaces;

import models.InstitutionDetail;

public interface IbusinessRegistration {
	
	public String save(InstitutionDetail institution);
	
	public String update(InstitutionDetail institution);
	
	public String delete(InstitutionDetail institution);

}
