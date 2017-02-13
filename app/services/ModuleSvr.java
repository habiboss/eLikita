package services;

import java.util.List;

import interfaces.IModule;
import models.Module;
import play.db.jpa.JPA;

public class ModuleSvr implements IModule{

	@Override
	public String save(Module module) {
		// TODO Auto-generated method stub
		try {
			JPA.em().persist(module);
		} catch (Exception e) {
			// TODO: handle exception
		}
		return null;
	}

	@Override
	public String update(Module module) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public String delete(Module module) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public List<Module> findList() {
		// TODO Auto-generated method stub
		String Querry_findList = "SELECT module FROM Module module ORDER BY module.id";
		try {
			return JPA.em().createQuery(Querry_findList).getResultList();
		} catch (Exception e) {
			// TODO: handle exception
		}
		

		return null;
	}

	@Override
	public Module findById(Long id) {
		// TODO Auto-generated method stub
		String Querry_findbyId = "SELECT module FROM Module module WHERE module.id =:id";
		try {
			return (Module) JPA.em().createQuery(Querry_findbyId).getSingleResult();
		} catch (Exception e) {
			// TODO: handle exception
		}
		return null;
	}


}
