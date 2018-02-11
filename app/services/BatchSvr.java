package services;

import java.util.List;
import java.util.stream.Collectors;
import javax.inject.Inject;
import org.jooq.DSLContext;
import schemas.public_.tables.daos.BatchDao;
import schemas.public_.tables.pojos.Batch;

public class BatchSvr extends BatchDao{

	@Inject
	DSLContext sqlContext;
	
	@Inject
	public BatchSvr(DSLContext sqlContext) {
		super();
		this.setConfiguration(sqlContext.configuration());
	}
	
	//@Override
	public void save(Batch batch) {
		// TODO Auto-generated method stub
		if (!fetchById(batch.getId()).isEmpty()) {
			super.update(batch);
		} else {
			super.insert(batch);
		}
	}

	//@Override
	public void delete(Batch batch) {
		// TODO Auto-generated method stub
		try {
			this.deleteById(batch.getId());
		} catch (Exception e) {
			// TODO: handle exception
		}
	}
	
	public Boolean findByTitle(Long title) {
		return !fetchById(title).isEmpty();
	}

	public models.util.Page<Batch> pageBatch(int page, int pageSize, String value) {
		int from_index = (page < 1 ? 0 : page - 1) * pageSize;
		final List<Batch> batch = findAll().stream()
				.filter(c -> c.getId().toString().contains(value) || c.getBatchName().contains(value))
				.collect(Collectors.toList());
		batch.sort((o1, o2) -> (o1.getId().compareTo(o2.getId())));
		final List<Batch> result = batch.stream().skip(from_index).limit(pageSize)
				.collect(Collectors.toList());
		return new models.util.Page<Batch>(result, batch.size(), page, pageSize);
	}

}
