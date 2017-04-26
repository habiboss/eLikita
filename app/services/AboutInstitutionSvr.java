package services;

import interfaces.About;
import models.AboutInstitution;
import play.data.Form;
import play.db.jpa.JPA;

public class AboutInstitutionSvr implements About{

	@Override
	public String save(Form<AboutInstitution> form, AboutInstitution aboutInstitution) {
		// TODO Auto-generated method stub
		String institutionName = form.field("InstitutionName").value();
		String institutionID = form.field("codeId").value();
		try {
			aboutInstitution.setInstitutionName(institutionName);
			aboutInstitution.setCodeId(institutionID);
			JPA.em().persist(aboutInstitution);
		} catch (Exception e) {
			// TODO: handle exception
		}
		return null;
	}

}
