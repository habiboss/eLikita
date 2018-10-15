package services;

import java.util.ArrayList;
import java.util.List;
import java.util.stream.Collectors;
import javax.inject.Inject;
import org.jooq.DSLContext;
import models.dto.BatchDTO;
import schemas.public_.Tables;
import schemas.public_.tables.daos.BatchDao;
import schemas.public_.tables.pojos.Batch;
import schemas.public_.tables.records.BatchRecord;

public class BatchSvr extends BatchDao{

	@Inject
	DSLContext sqlContext;
	@Inject
	CourseSvr courseSvr;
	
	@Inject
	public BatchSvr(DSLContext sqlContext) {
		super();
		this.setConfiguration(sqlContext.configuration());
	}
	
	public List<Batch> findByBatch(String q) {
		// TODO Auto-generated method stub
		List<Batch> batchLst = new ArrayList<Batch>();
		org.jooq.Result<BatchRecord> batchRecord = sqlContext
				.selectFrom(schemas.public_.tables.Batch.BATCH).where(schemas.public_.tables.Batch.BATCH.BATCH_NAME.like(q + "%"))
				.fetch();
		for (BatchRecord batchRecords : batchRecord) {
			Batch batch = new Batch();
			batch.setId(batchRecords.getId());
			batch.setBatchName(batchRecords.getBatchName());
			batchLst.add(batch);
		}
		return batchLst;
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

	public models.util.Page<BatchDTO> pageBatch(int page, int pageSize, String value) {
		int from_index = (page < 1 ? 0 : page - 1) * pageSize;
		final List<BatchDTO> batch = batchDTOList().stream()
				.filter(c -> c.getId().toString().contains(value) || c.getBatchName().contains(value))
				.collect(Collectors.toList());
		batch.sort((o1, o2) -> (o1.getId().compareTo(o2.getId())));
		final List<BatchDTO> result = batch.stream().skip(from_index).limit(pageSize)
				.collect(Collectors.toList());
		return new models.util.Page<BatchDTO>(result, batch.size(), page, pageSize);
	}
	
	public List<BatchDTO> batchDTOList () {
		List<Batch> batchLst = findAll();
 		List<BatchDTO> batchDTOLst = new ArrayList<>();
 			for(Batch batch: batchLst) {
 				BatchDTO batchDTO = new BatchDTO();
 				batchDTO.setId(batch.getId());
 				batchDTO.setBatchName(batch.getBatchName());
 				batchDTO.setCourseFk(batch.getCourseFk());
 				batchDTO.setCourseTitle(courseSvr.fetchOneById(batch.getCourseFk()).getTitle());
 				batchDTO.setEndDate(batch.getEndDate());
 				batchDTO.setMaxStudent(batch.getMaxStudent());
  				batchDTO.setStartDate(batch.getStartDate());
  				batchDTOLst.add(batchDTO);
 			}
		return batchDTOLst;
	}
	
	public BatchDTO fetchOneBatchDTO(Long batchPK) {
		BatchDTO batchDTO = new BatchDTO();
			batchDTO.setId(fetchOneById(batchPK).getId());
			batchDTO.setBatchName(fetchOneById(batchPK).getBatchName());
			batchDTO.setCourseFk(fetchOneById(batchPK).getCourseFk());
			batchDTO.setCourseTitle(courseSvr.fetchOneById(fetchOneById(batchPK).getCourseFk()).getTitle());
			batchDTO.setEndDate(fetchOneById(batchPK).getEndDate());
			batchDTO.setMaxStudent(fetchOneById(batchPK).getMaxStudent());
			batchDTO.setStartDate(fetchOneById(batchPK).getStartDate());
		return batchDTO;
	}
	
	public List<BatchDTO> getBatchByCourse(Long coursePK) {
		List<Batch> batchLst = sqlContext.selectFrom(Tables.BATCH).where(Tables.BATCH.COURSE_FK.eq(coursePK)).fetchInto(Batch.class);
		List<BatchDTO> batchDTOLst = new ArrayList<>();
		for(Batch batch: batchLst) {
				BatchDTO batchDTO = new BatchDTO();
				batchDTO.setId(batch.getId());
				batchDTO.setBatchName(batch.getBatchName());
				batchDTO.setCourseFk(batch.getCourseFk());
				batchDTO.setCourseTitle(courseSvr.fetchOneById(batch.getCourseFk()).getTitle());
				batchDTO.setEndDate(batch.getEndDate());
				batchDTO.setMaxStudent(batch.getMaxStudent());
				batchDTO.setStartDate(batch.getStartDate());
				batchDTOLst.add(batchDTO);
			}
		return batchDTOLst;
	}

}
