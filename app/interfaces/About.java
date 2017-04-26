package interfaces;

import models.AboutInstitution;
import play.data.Form;

public interface About {
	
	public String save(Form<AboutInstitution> form, AboutInstitution aboutInstitution);

}
