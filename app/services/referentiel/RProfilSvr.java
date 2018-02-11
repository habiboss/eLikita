package services.referentiel;

import java.util.ArrayList;
import java.util.List;
import java.util.stream.Collectors;
import javax.inject.Inject;
import org.jooq.DSLContext;
import schemas.referential.Tables;
import schemas.referential.tables.records.RProfilRecord;

public class RProfilSvr extends schemas.referential.tables.daos.RProfilDao{
	@Inject
	DSLContext sqlContext;

	@Inject
	public RProfilSvr(DSLContext sqlContext) {
		super();
		this.setConfiguration(sqlContext.configuration());
	}
	
	public List<schemas.referential.tables.pojos.RProfil> findByRProfil(String q) {
		// TODO Auto-generated method stub
		List<schemas.referential.tables.pojos.RProfil> rProfilLst = new ArrayList<schemas.referential.tables.pojos.RProfil>();
		org.jooq.Result<RProfilRecord> rProfilRecord = sqlContext
				.selectFrom(Tables.R_PROFIL).where(Tables.R_PROFIL.NAME_.like(q + "%"))
				.fetch();
		for (RProfilRecord rProfilRecords : rProfilRecord) {
			schemas.referential.tables.pojos.RProfil rProfils = new schemas.referential.tables.pojos.RProfil();
			rProfils.setId(rProfilRecords.getId());
			rProfils.setName_(rProfilRecords.getName_());
			rProfilLst.add(rProfils);
		}
		return rProfilLst;
	}

	public void save(schemas.referential.tables.pojos.RProfil rProfil) {
		// TODO Auto-generated method stub
		if (!fetchById(rProfil.getId()).isEmpty()) {
			super.update(rProfil);
		} else {
			super.insert(rProfil);
		}

	}

	public void delete(schemas.referential.tables.pojos.RProfil rProfil) {
		// TODO Auto-generated method stub
		try {
			this.deleteById(rProfil.getId());
		} catch (Exception e) {
			// TODO: handle exception
		}
	}

	public Boolean findByName_(String name_) {
		return !fetchByName_(name_).isEmpty();
	}

	public models.util.Page<schemas.referential.tables.pojos.RProfil> pageRProfil(int page,
			int pageSize, String value) {
		int from_index = (page < 1 ? 0 : page - 1) * pageSize;
		final List<schemas.referential.tables.pojos.RProfil> rProfil = findAll().stream()
				.filter(c -> c.getId().toString().contains(value) || c.getName_().contains(value))
				.collect(Collectors.toList());
		rProfil.sort((o1, o2) -> (o1.getId().compareTo(o2.getId())));
		final List<schemas.referential.tables.pojos.RProfil> result = rProfil.stream()
				.skip(from_index).limit(pageSize).collect(Collectors.toList());
		return new models.util.Page<schemas.referential.tables.pojos.RProfil>(result,
				rProfil.size(), page, pageSize);
	}
}
