package services.referentiel;

import java.util.ArrayList;
import java.util.List;
import java.util.stream.Collectors;

import javax.inject.Inject;
import org.jooq.DSLContext;

import schemas.referential.Tables;
import schemas.referential.tables.records.RUserRecord;

public class RUserSvr extends schemas.referential.tables.daos.RUserDao{
	@Inject
	DSLContext sqlContext;

	@Inject
	public RUserSvr(DSLContext sqlContext) {
		super();
		this.setConfiguration(sqlContext.configuration());
	}
	
	public List<schemas.referential.tables.pojos.RUser> findByRUser(String q) {
		// TODO Auto-generated method stub
		List<schemas.referential.tables.pojos.RUser> rUserLst = new ArrayList<schemas.referential.tables.pojos.RUser>();
		org.jooq.Result<RUserRecord> rUserRecord = sqlContext.selectFrom(Tables.R_USER)
				.where(Tables.R_USER.NAME_.like(q + "%")).fetch();
		for (RUserRecord rUserRecords : rUserRecord) {
			schemas.referential.tables.pojos.RUser rUsers = new schemas.referential.tables.pojos.RUser();
			rUsers.setId(rUserRecords.getId());
			rUsers.setName_(rUserRecords.getName_());
			rUserLst.add(rUsers);
		}
		return rUserLst;
	}

	public void save(schemas.referential.tables.pojos.RUser RUser) {
		// TODO Auto-generated method stub
		if (!fetchById(RUser.getId()).isEmpty()) {
			super.update(RUser);
		} else {
			super.insert(RUser);
		}

	}

	public void delete(schemas.referential.tables.pojos.RUser RUser) {
		// TODO Auto-generated method stub
		try {
			this.deleteById(RUser.getId());
		} catch (Exception e) {
			// TODO: handle exception
		}
	}

	public Boolean findByOutcome(String outcome) {
		return !fetchByName_(outcome).isEmpty();
	}

	public models.util.Page<schemas.referential.tables.pojos.RUser> pageRUser(int page, int pageSize,
			String value) {
		int from_index = (page < 1 ? 0 : page - 1) * pageSize;
		final List<schemas.referential.tables.pojos.RUser> rUser = findAll().stream()
				.filter(c -> c.getId().toString().contains(value) || c.getName_().contains(value))
				.collect(Collectors.toList());
		rUser.sort((o1, o2) -> (o1.getId().compareTo(o2.getId())));
		final List<schemas.referential.tables.pojos.RUser> result = rUser.stream().skip(from_index)
				.limit(pageSize).collect(Collectors.toList());
		return new models.util.Page<schemas.referential.tables.pojos.RUser>(result, rUser.size(), page,
				pageSize);
	}
}
