package services.referentiel;

import java.util.List;
import java.util.stream.Collectors;
import javax.inject.Inject;
import org.jooq.DSLContext;
import schemas.referential.tables.daos.RAttendanceTypeDao;

public class RAttendanceTypeSvr extends RAttendanceTypeDao{
	@Inject
	DSLContext sqlContext;
	
	@Inject
	public RAttendanceTypeSvr(DSLContext sqlContext) {
		super();
		this.setConfiguration(sqlContext.configuration());
	}
	
	
	public void save(schemas.referential.tables.pojos.RAttendanceType rAttendanceType) {
		// TODO Auto-generated method stub
		if (!fetchById(rAttendanceType.getId()).isEmpty()) {
			super.update(rAttendanceType);
		} else {
			super.insert(rAttendanceType);
		}
	}

	
	public void delete(schemas.referential.tables.pojos.RAttendanceType rAttendanceType) {
		// TODO Auto-generated method stub
		try {
			this.deleteById(rAttendanceType.getId());
		} catch (Exception e) {
			// TODO: handle exception
		}
	}
	
	public Boolean findByTitle(Long title) {
		return !fetchById(title).isEmpty();
	}

	public models.util.Page<schemas.referential.tables.pojos.RAttendanceType> pageRAttendanceType(int page, int pageSize, String value) {
		int from_index = (page < 1 ? 0 : page - 1) * pageSize;
		final List<schemas.referential.tables.pojos.RAttendanceType> rAttendanceType = findAll().stream()
				.filter(c -> c.getId().toString().contains(value) || c.getName_().contains(value))
				.collect(Collectors.toList());
		rAttendanceType.sort((o1, o2) -> (o1.getId().compareTo(o2.getId())));
		final List<schemas.referential.tables.pojos.RAttendanceType> result = rAttendanceType.stream().skip(from_index).limit(pageSize)
				.collect(Collectors.toList());
		return new models.util.Page<schemas.referential.tables.pojos.RAttendanceType>(result, rAttendanceType.size(), page, pageSize);
	}
}
