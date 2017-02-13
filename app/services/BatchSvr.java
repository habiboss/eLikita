package services;

import java.util.List;

import interfaces.IBatch;
import models.Batch;
import models.Course;
import play.db.jpa.JPA;

public class BatchSvr implements IBatch{

	//@Override
	public String save(Batch batch, Long courseId) {
		// TODO Auto-generated method stub
		batch.course = new CourseSvr().findById(courseId);
		try {
			JPA.em().persist(batch);
		} catch (Exception e) {
			// TODO: handle exception
			e.toString();
		}
		return "sucess";
	}

	@Override
	public String update(Batch batch) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public String delete(Batch batch) {
		// TODO Auto-generated method stub
		return null;
	}

	//@Override
	public List<Batch> findList() {
		// TODO Auto-generated method stub
		String Querry_findList = "SELECT batch FROM Batch batch ORDER BY batch.id";
		try {
			return JPA.em().createQuery(Querry_findList).getResultList();
		} catch (Exception e) {
			// TODO: handle exception
		}
		return null;
	}

	//@Override
	public Batch findById(Long id) {
		// TODO Auto-generated method stub
				String Querry_findbyId = "SELECT batch FROM Batch batch WHERE batch.id = :id ORDER BY batch.id";
				try {
					return (Batch) JPA.em().createQuery(Querry_findbyId).setParameter("id", id).getSingleResult();
				} catch (Exception e) {
					// TODO: handle exception
				}
				return null;
			}

}
