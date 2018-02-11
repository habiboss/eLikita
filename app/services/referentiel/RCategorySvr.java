package services.referentiel;

import java.util.ArrayList;
import java.util.List;
import java.util.stream.Collectors;

import javax.inject.Inject;

import org.jooq.DSLContext;

import schemas.referential.Tables;
import schemas.referential.tables.daos.RCategoryDao;
import schemas.referential.tables.records.RCategoryRecord;

public class RCategorySvr extends RCategoryDao{
	@Inject
	DSLContext sqlContext;

	@Inject
	public RCategorySvr(DSLContext sqlContext) {
		super();
		this.setConfiguration(sqlContext.configuration());
	}
	
	public List<schemas.referential.tables.pojos.RCategory> findByRCategory(String q) {
		// TODO Auto-generated method stub
		List<schemas.referential.tables.pojos.RCategory> rCategoryLst = new ArrayList<schemas.referential.tables.pojos.RCategory>();
		org.jooq.Result<RCategoryRecord> rCategoryRecord = sqlContext
				.selectFrom(Tables.R_CATEGORY).where(Tables.R_CATEGORY.NAME.like(q + "%"))
				.fetch();
		for (RCategoryRecord rCategoryRecords : rCategoryRecord) {
			schemas.referential.tables.pojos.RCategory rCategories = new schemas.referential.tables.pojos.RCategory();
			rCategories.setId(rCategoryRecords.getId());
			rCategories.setName(rCategoryRecords.getName());
			rCategoryLst.add(rCategories);
		}
		return rCategoryLst;
	}

	public void save(schemas.referential.tables.pojos.RCategory rCategory) {
		// TODO Auto-generated method stub
		if (!fetchById(rCategory.getId()).isEmpty()) {
			super.update(rCategory);
		} else {
			super.insert(rCategory);
		}

	}

	public void delete(schemas.referential.tables.pojos.RCategory rCategory) {
		// TODO Auto-generated method stub
		try {
			this.deleteById(rCategory.getId());
		} catch (Exception e) {
			// TODO: handle exception
		}
	}

	public Boolean findByName(String name) {
		return !fetchByName(name).isEmpty();
	}

	public models.util.Page<schemas.referential.tables.pojos.RCategory> pageRCategory(int page,
			int pageSize, String value) {
		int from_index = (page < 1 ? 0 : page - 1) * pageSize;
		final List<schemas.referential.tables.pojos.RCategory> rCategory = findAll().stream()
				.filter(c -> c.getId().toString().contains(value) || c.getName().contains(value))
				.collect(Collectors.toList());
		rCategory.sort((o1, o2) -> (o1.getId().compareTo(o2.getId())));
		final List<schemas.referential.tables.pojos.RCategory> result = rCategory.stream()
				.skip(from_index).limit(pageSize).collect(Collectors.toList());
		return new models.util.Page<schemas.referential.tables.pojos.RCategory>(result,
				rCategory.size(), page, pageSize);
	}
}
