package services;

import java.util.List;

import interfaces.IProfil;
import models.referentiel.RProfil;
import play.data.Form;
import play.db.jpa.JPA;

public class ProfilSvr implements IProfil{

	@Override
	public String save(Form<RProfil> form, RProfil rProfil) {
		// TODO Auto-generated method stub
		String codeProfil = form.field("codeProfil").value();
		String profilName = form.field("profilName").value();
		rProfil.setCodeProfil(codeProfil);
		rProfil.setProfilName(profilName);
		try {
			JPA.em().persist(rProfil);
		} catch (Exception e) {
			// TODO: handle exception
		}
		return null;
	}

	@Override
	public String update(RProfil rProfil) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public String delete(RProfil rProfil) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public List<RProfil> findList() {
		// TODO Auto-generated method stub
		String Querry_findList = "SELECT rProfil FROM RProfil rProfil ORDER BY rProfil.id";
		try {
			return JPA.em().createQuery(Querry_findList).getResultList();
		} catch (Exception e) {
			// TODO: handle exception
		}
		return null;
	}

	@Override
	public RProfil findById(Long id) {
		// TODO Auto-generated method stub
		return null;
	}

}
