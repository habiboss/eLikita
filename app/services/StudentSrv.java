package services;

import java.util.List;
import java.util.stream.Collectors;
import org.jooq.DSLContext;
import com.google.inject.Inject;
import schemas.public_.*;
import schemas.public_.tables.pojos.StudentDetail;
import schemas.public_.tables.records.StudentDetailRecord;

public class StudentSrv extends schemas.public_.tables.daos.StudentDetailDao {
	@Inject
	DSLContext sqlContext;

	@Inject
	public StudentSrv(DSLContext sqlContext) {
		super();
		this.setConfiguration(sqlContext.configuration());
	}

	// @Override
	public Long save(StudentDetail studentDetail) {
		// TODO Auto-generated method stub
		if (findByTitle(studentDetail.getId())) {
			super.update(studentDetail);
		} else {
			studentDetail.setCodeUi("xxxxxx");
			studentDetail.setStatus("UNAPPROVED");
			super.insert(studentDetail);
		}
		// return studentDetail.getId();
		return null;
	}

	// @Override
	public void delete(StudentDetail studentDetail) {
		// TODO Auto-generated method stub
		try {
			this.deleteById(studentDetail.getId());
		} catch (Exception e) {
			// TODO: handle exception
		}
	}

	// @Override
	public List<StudentDetail> findList() {
		// TODO Auto-generated method stub
		try {
			return findAll();
		} catch (Exception e) {
			// TODO: handle exception
		}
		return null;
	}

	public Boolean findByTitle(Long title) {
		return !fetchById(title).isEmpty();
	}

	public models.util.Page<StudentDetail> pageStudentDetail(int page, int pageSize, String value) {
		int from_index = (page < 1 ? 0 : page - 1) * pageSize;
		final List<StudentDetail> studentDetail = findAll().stream()
				.filter(c -> c.getId().toString().contains(value) || c.getFirstName().contains(value))
				.collect(Collectors.toList());
		studentDetail.sort((o1, o2) -> (o1.getId().compareTo(o2.getId())));
		final List<StudentDetail> result = studentDetail.stream().skip(from_index).limit(pageSize)
				.collect(Collectors.toList());
		return new models.util.Page<StudentDetail>(result, studentDetail.size(), page, pageSize);
	}

	public StudentDetailRecord findByCodeUI(String codeUI) {
		return sqlContext.fetchOne(Tables.STUDENT_DETAIL, Tables.STUDENT_DETAIL.CODE_UI.equal(codeUI));
	}
}
