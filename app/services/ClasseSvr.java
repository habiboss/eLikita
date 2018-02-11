package services;

import java.util.List;
import java.util.stream.Collectors;
import javax.inject.Inject;
import org.jooq.DSLContext;
import schemas.public_.tables.daos.ClasseDao;
import schemas.public_.tables.pojos.Classe;

public class ClasseSvr extends ClasseDao{
	@Inject
	DSLContext sqlContext;
	
	@Inject
	public ClasseSvr(DSLContext sqlContext) {
		super();
		this.setConfiguration(sqlContext.configuration());
	}
	
	//@Override
	public void save(Classe classe) {
		// TODO Auto-generated method stub
		if (findByNumber(classe.getId())) {
			super.update(classe);
		} else {
			super.insert(classe);
		}
	}

	//@Override
	public void delete(Classe classe) {
		// TODO Auto-generated method stub
		try {
			this.deleteById(classe.getId());
		} catch (Exception e) {
			// TODO: handle exception
		}
	}
	
	public Boolean findByNumber(Long title) {
		return !fetchById(title).isEmpty();
	}

	public models.util.Page<Classe> pageClasse(int page, int pageSize, String value) {
		int from_index = (page < 1 ? 0 : page - 1) * pageSize;
		final List<Classe> classe = findAll().stream()
				.filter(c -> c.getId().toString().contains(value) || c.getName_().contains(value))
				.collect(Collectors.toList());
		classe.sort((o1, o2) -> (o1.getId().compareTo(o2.getId())));
		final List<Classe> result = classe.stream().skip(from_index).limit(pageSize)
				.collect(Collectors.toList());
		return new models.util.Page<Classe>(result, classe.size(), page, pageSize);
	}
	
}
