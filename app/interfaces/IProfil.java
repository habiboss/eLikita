package interfaces;

import java.util.List;

import models.referentiel.RProfil;
import play.data.Form;

public interface IProfil {
	
    public String save(Form<RProfil> form, RProfil rProfil);
	
	public String update(RProfil rProfil);
	
	public String delete(RProfil rProfil);
	
	public List<RProfil> findList();
	
	public RProfil findById(Long id);

}
