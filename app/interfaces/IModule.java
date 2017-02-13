package interfaces;

import java.util.List;

import models.Module;

public interface IModule {
	
	public String save (Module module);
	
	public String update(Module module);
	
	public String delete(Module module);
	
	public List<Module> findList();
	
	public Module findById(Long id);

}
