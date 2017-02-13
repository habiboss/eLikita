package interfaces;

import java.util.List;

import models.Batch;

public interface IBatch {
	
	public String save(Batch batch, Long courseId);
	
	public String update(Batch batch);
	
	public String delete(Batch batch);
	
	public List<Batch> findList();
	
	public Batch findById(Long id);

}
