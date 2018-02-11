package services;

import java.util.ArrayList;
import java.util.List;
import java.util.stream.Collectors;
import javax.inject.Inject;
import org.jooq.DSLContext;
import interfaces.About;
import play.data.Form;
import schemas.public_.*;
import schemas.public_.tables.daos.AboutInstitutionDao;
import schemas.public_.tables.records.AboutInstitutionRecord;
import schemas.public_.tables.pojos.AboutInstitution;

public class AboutInstitutionSvr extends AboutInstitutionDao implements About{
	
	@Inject
	DSLContext sqlContext;
	
	@Inject
	public AboutInstitutionSvr(DSLContext sqlContext) {
		super();
		this.setConfiguration(sqlContext.configuration());
	}
	

	@Override
	public String save(Form<AboutInstitution> form, AboutInstitution aboutInstitution) {
		// TODO Auto-generated method stub
		try {
			aboutInstitution = form.get();
			//JPA.em().persist(aboutInstitution);
		} catch (Exception e) {
			// TODO: handle exception
		}
		return "Success";
	}
	
	public models.util.Page<schemas.public_.tables.pojos.AboutInstitution> pageInstitution(int page, int pageSize, String value) {
		int from_index = (page < 1 ? 0 : page - 1) * pageSize;
		final List<AboutInstitution> institution = findAll().stream()
				.filter(c -> c.getId().toString().contains(value) || c.getInstitutionName().contains(value))
				.collect(Collectors.toList());
		institution.sort((o1, o2) -> (o1.getId().compareTo(o2.getId())));
		final List<AboutInstitution> result = institution.stream().skip(from_index).limit(pageSize)
				.collect(Collectors.toList());
		return new models.util.Page<AboutInstitution>(result, institution.size(), page, pageSize);
	}
	
	public List<AboutInstitution> findByInstitution(String q) {
		// TODO Auto-generated method stub
		List<AboutInstitution> institutionLst = new ArrayList<AboutInstitution>();
		org.jooq.Result<AboutInstitutionRecord> institutionRecord = sqlContext.selectFrom(Tables.ABOUT_INSTITUTION)
				.where(Tables.ABOUT_INSTITUTION.INSTITUTION_NAME.like(q + "%")).fetch();
		for (AboutInstitutionRecord institutionRecords : institutionRecord) {
			AboutInstitution institution = new AboutInstitution();
			institution.setInstitutionName(institutionRecords.getInstitutionName());
			institution.setId(institutionRecords.getId());
			institutionLst.add(institution);
		}
		return institutionLst;
	}
	
	public String x(Long id) {
		AboutInstitutionRecord aboutInstitutionRecord = sqlContext.fetchOne(Tables.ABOUT_INSTITUTION, Tables.ABOUT_INSTITUTION.ID.equal(id));	
		return "Nom de L'institution: " + aboutInstitutionRecord.getInstitutionName() + " Country: " + aboutInstitutionRecord.getCountry() + 
				" City: " + aboutInstitutionRecord.getCity() + " Address: " + aboutInstitutionRecord.getAddress() + " Region: " + aboutInstitutionRecord.getRegion();
	}

}
