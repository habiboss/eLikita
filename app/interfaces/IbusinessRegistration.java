package interfaces;

import models.Institution;

public interface IbusinessRegistration {
	
	public String save(Institution institution);
	
	public String update(Institution institution);
	
	public String delete(Institution institution);

}
