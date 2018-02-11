package services.referentiel;

import java.util.ArrayList;
import java.util.List;
import java.util.stream.Collectors;

import javax.inject.Inject;

import org.jooq.DSLContext;

import schemas.referential.Tables;
import schemas.referential.tables.daos.RFeeDao;
import schemas.referential.tables.records.RFeeRecord;

public class RFeeSvr extends RFeeDao{
	@Inject
	DSLContext sqlContext;

	@Inject
	public RFeeSvr(DSLContext sqlContext) {
		super();
		this.setConfiguration(sqlContext.configuration());
	}
	
	public List<schemas.referential.tables.pojos.RFee> findByRFee(String q) {
		// TODO Auto-generated method stub
		List<schemas.referential.tables.pojos.RFee> rFeeLst = new ArrayList<schemas.referential.tables.pojos.RFee>();
		org.jooq.Result<RFeeRecord> rFeeRecord = sqlContext
				.selectFrom(Tables.R_FEE).where(Tables.R_FEE.FEE_TYPE.like(q + "%"))
				.fetch();
		for (RFeeRecord rFeeRecords : rFeeRecord) {
			schemas.referential.tables.pojos.RFee rFees = new schemas.referential.tables.pojos.RFee();
			rFees.setId(rFeeRecords.getId());
			rFees.setFeeType(rFeeRecords.getFeeType());
			rFeeLst.add(rFees);
		}
		return rFeeLst;
	}

	public void save(schemas.referential.tables.pojos.RFee rFee) {
		// TODO Auto-generated method stub
		if (!fetchById(rFee.getId()).isEmpty()) {
			super.update(rFee);
		} else {
			super.insert(rFee);
		}

	}

	public void delete(schemas.referential.tables.pojos.RFee rFee) {
		// TODO Auto-generated method stub
		try {
			this.deleteById(rFee.getId());
		} catch (Exception e) {
			// TODO: handle exception
		}
	}

	public Boolean findByFeeType(String feeType) {
		return !fetchByFeeType(feeType).isEmpty();
	}

	public models.util.Page<schemas.referential.tables.pojos.RFee> pageRFee(int page,
			int pageSize, String value) {
		int from_index = (page < 1 ? 0 : page - 1) * pageSize;
		final List<schemas.referential.tables.pojos.RFee> rFee = findAll().stream()
				.filter(c -> c.getId().toString().contains(value) || c.getFeeType().contains(value))
				.collect(Collectors.toList());
		rFee.sort((o1, o2) -> (o1.getId().compareTo(o2.getId())));
		final List<schemas.referential.tables.pojos.RFee> result = rFee.stream()
				.skip(from_index).limit(pageSize).collect(Collectors.toList());
		return new models.util.Page<schemas.referential.tables.pojos.RFee>(result,
				rFee.size(), page, pageSize);
	}
}
