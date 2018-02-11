package interfaces;

import play.data.Form;
import schemas.public_.tables.pojos.AboutInstitution;

public interface About {
	
	public String save(Form<AboutInstitution> form, AboutInstitution aboutInstitution);

}
