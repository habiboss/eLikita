package services;

import java.util.ArrayList;
import java.util.List;
import java.util.stream.Collectors;
import javax.inject.Inject;
import org.jooq.DSLContext;

import models.dto.AboutInstitutionDTO;
import models.dto.AssignmentDTO;
import schemas.public_.*;
import schemas.public_.tables.daos.AboutInstitutionDao;
import schemas.public_.tables.records.AboutInstitutionRecord;
import services.admin.LogInfoSvr;
import services.referentiel.RCountrySvr;
import services.referentiel.RLevelSvr;
import services.referentiel.RYearSvr;
import schemas.public_.tables.pojos.AboutInstitution;

public class AboutInstitutionSvr extends AboutInstitutionDao {
	
	@Inject
	DSLContext sqlContext;
	@Inject
	LogInfoSvr logInfoSvr;
	@Inject
	RCountrySvr rCountrySvr;
	@Inject
	RLevelSvr rLevelSvr;
	@Inject
	RYearSvr rYearSvr;
	@Inject
	public AboutInstitutionSvr(DSLContext sqlContext) {
		super();
		this.setConfiguration(sqlContext.configuration());
	}	

	public void save(AboutInstitution aboutInstitution) {
		// TODO Auto-generated method stub
		if (!fetchById(aboutInstitution.getId()).isEmpty()) {
			logInfoSvr.save(aboutInstitution.getCode(), aboutInstitution.getInstitutionName(), "UPDATE OF INSTITUTION");
			super.update(aboutInstitution);
		} else {
			logInfoSvr.save(aboutInstitution.getCode(), aboutInstitution.getInstitutionName(), "SAVE OF INSTITUTION");
			super.insert(aboutInstitution);
		}
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
	
	public AboutInstitutionRecord x() {
		AboutInstitutionRecord aboutInstitutionRecord = sqlContext.selectFrom(Tables.ABOUT_INSTITUTION).fetchOne();	
		return aboutInstitutionRecord;
	}
	
	public AboutInstitutionDTO fetchOneAboutInstitutionDTO (Long aboutInstitutionPK) {
		AboutInstitutionDTO aboutInstitutionDTO =  new AboutInstitutionDTO();
		aboutInstitutionDTO.setAddress(fetchOneById(aboutInstitutionPK).getAddress());
		aboutInstitutionDTO.setBusiness_name(rLevelSvr.fetchOneById(fetchOneById(aboutInstitutionPK).getBusinessCategory()).getLevel());
		aboutInstitutionDTO.setBusinessCategory(fetchOneById(aboutInstitutionPK).getBusinessCategory());
		aboutInstitutionDTO.setCampus(fetchOneById(aboutInstitutionPK).getCampus());
		aboutInstitutionDTO.setCity(fetchOneById(aboutInstitutionPK).getCity());
		aboutInstitutionDTO.setCode(fetchOneById(aboutInstitutionPK).getCode());
		aboutInstitutionDTO.setCountry_name(rCountrySvr.fetchOneById(fetchOneById(aboutInstitutionPK).getCountryFk()).getName_());
		aboutInstitutionDTO.setCountryFk(fetchOneById(aboutInstitutionPK).getCountryFk());
		aboutInstitutionDTO.setDescription(fetchOneById(aboutInstitutionPK).getDescription());
		aboutInstitutionDTO.setEmail(fetchOneById(aboutInstitutionPK).getEmail());
		aboutInstitutionDTO.setId(fetchOneById(aboutInstitutionPK).getId());
		aboutInstitutionDTO.setInstitutionName(fetchOneById(aboutInstitutionPK).getInstitutionName());
		aboutInstitutionDTO.setOwnerFname(fetchOneById(aboutInstitutionPK).getOwnerFname());
		aboutInstitutionDTO.setOwnerLname(fetchOneById(aboutInstitutionPK).getOwnerLname());
		aboutInstitutionDTO.setPhoneNo(fetchOneById(aboutInstitutionPK).getPhoneNo());
		aboutInstitutionDTO.setPostcode(fetchOneById(aboutInstitutionPK).getPostcode());
		aboutInstitutionDTO.setRegion(fetchOneById(aboutInstitutionPK).getRegion());
		aboutInstitutionDTO.setWebsite(fetchOneById(aboutInstitutionPK).getWebsite());
		aboutInstitutionDTO.setYear_name(rYearSvr.fetchOneById(fetchOneById(aboutInstitutionPK).getYearEstablished()).getYear_());
		aboutInstitutionDTO.setYearEstablished(fetchOneById(aboutInstitutionPK).getYearEstablished());
		
		return aboutInstitutionDTO;
}

}
