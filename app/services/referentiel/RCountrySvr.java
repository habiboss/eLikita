package services.referentiel;

import javax.inject.Inject;
import java.util.ArrayList;
import java.util.List;
import java.util.stream.Collectors;
import schemas.referential.Tables;
import schemas.referential.tables.daos.RCountryDao;
import schemas.referential.tables.pojos.RCountry;
import schemas.referential.tables.records.RCountryRecord;
import org.jooq.DSLContext;

public class RCountrySvr extends RCountryDao{
	@Inject
	DSLContext sqlContext;

	@Inject
	public RCountrySvr(DSLContext sqlContext) {
		super();
		this.setConfiguration(sqlContext.configuration());
	}
	
	public List<RCountry> findByRCountry(String q) {
		// TODO Auto-generated method stub
		List<RCountry> rCountryLst = new ArrayList<RCountry>();
		org.jooq.Result<RCountryRecord> rCountryRecord = sqlContext.selectFrom(Tables.R_COUNTRY)
				.where(Tables.R_COUNTRY.NAME_.like(q + "%")).fetch();
		for (RCountryRecord roComptesRecords : rCountryRecord) {
			RCountry rCountries = new RCountry();
			rCountries.setName_(roComptesRecords.getName_());
			rCountries.setNicename(roComptesRecords.getNicename());
			rCountries.setNumcode(roComptesRecords.getNumcode());
			rCountries.setPhonecode(roComptesRecords.getPhonecode());
			rCountries.setId(roComptesRecords.getId());
			rCountryLst.add(rCountries);
		}
		return rCountryLst;
	}
	
	public RCountryRecord findOneByRCountry(Long r_countryID) {
		// TODO Auto-generated method stub
 		RCountryRecord rCountryRecord = sqlContext.fetchOne(Tables.R_COUNTRY, Tables.R_COUNTRY.ID.eq(r_countryID));
 		
 
		return rCountryRecord;
	}

	public void save(schemas.referential.tables.pojos.RCountry rCountry) {
		// TODO Auto-generated method stub
		if (findByName(rCountry.getName_())) {
			super.update(rCountry);
		} else {
			super.insert(rCountry);
		}

	}

	public void delete(schemas.referential.tables.pojos.RCountry rCountry) {
		// TODO Auto-generated method stub
		try {
			this.deleteById(rCountry.getId());
		} catch (Exception e) {
			// TODO: handle exception
		}
	}

	public Boolean findByName(String name) {
		return !fetchByName_(name).isEmpty();
	}

	public models.util.Page<schemas.referential.tables.pojos.RCountry> pageRCountry(int page,
			int pageSize, String value) {
		int from_index = (page < 1 ? 0 : page - 1) * pageSize;
		final List<schemas.referential.tables.pojos.RCountry> rCountry = findAll().stream()
				.filter(c -> c.getId().toString().contains(value) || c.getName_().contains(value))
				.collect(Collectors.toList());
		rCountry.sort((o1, o2) -> (o1.getId().compareTo(o2.getId())));
		final List<schemas.referential.tables.pojos.RCountry> result = rCountry.stream()
				.skip(from_index).limit(pageSize).collect(Collectors.toList());
		return new models.util.Page<schemas.referential.tables.pojos.RCountry>(result,
				rCountry.size(), page, pageSize);
	}
}
