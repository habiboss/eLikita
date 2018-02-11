package services.referentiel;

import java.util.List;
import java.util.stream.Collectors;
import javax.inject.Inject;
import org.jooq.DSLContext;
import schemas.referential.tables.daos.RSyllabusDao;
import schemas.referential.tables.pojos.RSyllabus;

public class RSyllabusNameSvr extends RSyllabusDao{
	@Inject
	DSLContext sqlContext;
	
	@Inject
	public RSyllabusNameSvr(DSLContext sqlContext) {
		super();
		this.setConfiguration(sqlContext.configuration());
	}
	
	
	public void save(RSyllabus rSyllabus) {
		// TODO Auto-generated method stub
		if (!fetchById(rSyllabus.getId()).isEmpty()) {
			super.update(rSyllabus);
		} else {
			super.insert(rSyllabus);
		}
	}

	
	public void delete(RSyllabus rSyllabus) {
		// TODO Auto-generated method stub
		try {
			this.deleteById(rSyllabus.getId());
		} catch (Exception e) {
			// TODO: handle exception
		}
	}
	
	public Boolean findByTitle(Long title) {
		return !fetchById(title).isEmpty();
	}

	public models.util.Page<RSyllabus> pageRSyllabus(int page, int pageSize, String value) {
		int from_index = (page < 1 ? 0 : page - 1) * pageSize;
		final List<RSyllabus> rSyllabus = findAll().stream()
				.filter(c -> c.getId().toString().contains(value) || c.getName_().contains(value))
				.collect(Collectors.toList());
		rSyllabus.sort((o1, o2) -> (o1.getId().compareTo(o2.getId())));
		final List<RSyllabus> result = rSyllabus.stream().skip(from_index).limit(pageSize)
				.collect(Collectors.toList());
		return new models.util.Page<RSyllabus>(result, rSyllabus.size(), page, pageSize);
	}
}
