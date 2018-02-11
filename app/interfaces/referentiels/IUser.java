package interfaces.referentiels;

import java.util.List;

import models.referentiel.RUser;
import play.data.Form;

public interface IUser {
	
	public String save(Form<RUser> form, RUser user);
	
	public String update(RUser user);
	
	public String delete(RUser user);
	
	public List<RUser> findList();
	

}
