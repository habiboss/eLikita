package controllers;

import org.eclipse.birt.core.exception.BirtException;
import com.google.inject.Inject;
import models.util.EnvVarbl;
import schemas.public_.tables.pojos.AdditionalInfo;
import schemas.public_.tables.pojos.AddressDetail;
import schemas.public_.tables.pojos.ContactDetail;
import schemas.public_.tables.pojos.EducationalDetail;
import schemas.public_.tables.pojos.EmergencyContact;
import schemas.public_.tables.pojos.NationalityDetail;
import schemas.public_.tables.pojos.StudentDetail;
import schemas.public_.tables.pojos.UploadDocument;
import play.data.Form;
import play.data.FormFactory;
import play.db.jpa.Transactional;
import play.mvc.Controller;
import play.mvc.Result;
import reports.ReportStudent;
import services.AdditionalInfoSvr;
import services.AddressSvr;
import services.ContactSvr;
import services.EducationalDetailSvr;
import services.EmergencyContactSvr;
import services.NationalityDetailSvr;
import services.StudentSrv;
import views.html.admin.*;

public class StudentCtrl extends Controller {

	@Inject
	FormFactory formFactory;
	@Inject
	StudentSrv studentSrv;
	@Inject
	AddressSvr addressSvr;
	@Inject
	ContactSvr contactSvr;
	@Inject
	EmergencyContactSvr emergencyContactSvr;
	@Inject
	AdditionalInfoSvr additionalInfoSvr;
	@Inject
	EducationalDetailSvr educationalDetailSvr;
	@Inject
	NationalityDetailSvr nationalityDetailSvr;

	public Result show(String subAction, Long studentPK, String ui_code) {
		StudentDetail studentDetail = new StudentDetail();
		String viewMode = "";
		int page = 0;
		String filter = "";
		if (null == studentPK || studentPK == 0L) {
			studentDetail = new StudentDetail();
			viewMode = subAction;// EnvVarbl.VIEW_MODE_R_CLASS;
			return ok(studentRegistration.render(studentSrv.pageStudentDetail(page, EnvVarbl.pageSize, filter), filter,
					new StudentDetail(), viewMode, ui_code));
		} else if (EnvVarbl.VIEW_MODE_EDIT.equals(subAction)) {
			studentDetail = studentSrv.fetchOneById(studentPK);
			viewMode = EnvVarbl.VIEW_MODE_EDIT;
		} else if (EnvVarbl.VIEW_MODE_DELETE.equals(subAction)) {
			studentDetail = studentSrv.fetchOneById(studentPK);
			viewMode = EnvVarbl.VIEW_MODE_DELETE;
		} else {
			viewMode = EnvVarbl.VIEW_MODE_VIEW;
			studentDetail = studentSrv.fetchOneById(studentPK);
		}
		return ok(studentRegistration.render(studentSrv.pageStudentDetail(page, EnvVarbl.pageSize, filter), filter,
				studentDetail, viewMode, ui_code));
	}

	public Result save() {
		final String viewMode = formFactory.form().bindFromRequest().get("viewMode");
		final String studentPK = formFactory.form().bindFromRequest().get("studentPK-key");
		final String studentCode = formFactory.form().bindFromRequest().get("studentPK-code");
		String errorMessage = "";
		Form<StudentDetail> uForm = formFactory.form(StudentDetail.class).bindFromRequest();
		Form<AddressDetail> uFormAddress = formFactory.form(AddressDetail.class).bindFromRequest();
		Form<ContactDetail> uFormContact = formFactory.form(ContactDetail.class).bindFromRequest();
		Form<EmergencyContact> uFormEmergencyContact = formFactory.form(EmergencyContact.class).bindFromRequest();
		Form<AdditionalInfo> uFormAdditionalInfo = formFactory.form(AdditionalInfo.class).bindFromRequest();
		Form<EducationalDetail> uFormEducationalDetail = formFactory.form(EducationalDetail.class).bindFromRequest();
		Form<NationalityDetail> uFormNationalityDetail = formFactory.form(NationalityDetail.class).bindFromRequest();
		Form<UploadDocument> uFormUploadDocument = formFactory.form(UploadDocument.class).bindFromRequest();

		if (uForm.hasErrors()) {
			flash("ERROR", "Saisie erronée.");
			// return badRequest(versementChequeTier.render(new VersementCheque(),
			// ViewType.VIEW_MODE_CREATE, generalDTOImpl.getRoIdentifiantInfo(0L,
			// EnvironmentalVariables.TIER)));
		}
		StudentDetail studentDetail = uForm.get();
		AddressDetail addressDetail = uFormAddress.get();
		ContactDetail contactDetail = uFormContact.get();
		EmergencyContact emergencyContact = uFormEmergencyContact.get();
		AdditionalInfo additionalInfo = uFormAdditionalInfo.get();
		EducationalDetail educationalDetail = uFormEducationalDetail.get();
		NationalityDetail nationalityDetail = uFormNationalityDetail.get();
		UploadDocument uploadDocument = uFormUploadDocument.get();
		
		String uicode = uForm.field("codeui").value();

		if (EnvVarbl.VIEW_MODE_EDIT.equals(viewMode)) {
			studentDetail.setId(Long.parseLong(studentPK));
			// studentDetail.setCode(studentCode);
			// errorMessage = courseSvr.validate(versementCheque, false);
			studentSrv.save(studentDetail);

			flash("SUCCESS", "Course modifier.");
			// return redirect(routes.StudentCtrl.show(EnvVarbl.VIEW_MODE_CREATE,
			// EnvVarbl.pageInit));
		}
		//////////////CONTACT DETAIL///////////////////////////////////////
		if (EnvVarbl.VIEW_MODE_STD_CONTACT_DETAIL.equals(viewMode)) {
			// errorMessage = courseSvr.validate(versementCheque, true);
			addressSvr.save(addressDetail);
		    return redirect(routes.StudentCtrl.show(EnvVarbl.VIEW_MODE_STD_NATIONALITY_DETAIL, EnvVarbl.pageInit, addressDetail.getStudentFk()));
		}
		//////////////NATIONALITY & VISA DETAIL///////////////////////////////
		if (EnvVarbl.VIEW_MODE_STD_NATIONALITY_DETAIL.equals(viewMode)) {
			// errorMessage = courseSvr.validate(versementCheque, true);
		    nationalityDetailSvr.save(nationalityDetail);
		    return redirect(routes.StudentCtrl.show(EnvVarbl.VIEW_MODE_STD_ADDITIONAL_DETAIL, EnvVarbl.pageInit, nationalityDetail.getStudentFk()));
		}
		//////////////ADDITIONAL DETAIL///////////////////////////////////////
		if (EnvVarbl.VIEW_MODE_STD_ADDITIONAL_DETAIL.equals(viewMode)) {
			// errorMessage = courseSvr.validate(versementCheque, true);
		    additionalInfoSvr.save(additionalInfo);
		    return redirect(routes.StudentCtrl.show(EnvVarbl.VIEW_MODE_STD_BCKGRD_EDUCATION_DETAIL, EnvVarbl.pageInit, additionalInfo.getStudentFk()));
		}
		//////////////EMERGENCY CONTACT/////////////////////////////////////
		if (EnvVarbl.VIEW_MODE_S_EMERGCY.equals(viewMode)) {
			// errorMessage = courseSvr.validate(versementCheque, true);
		    emergencyContactSvr.save(emergencyContact);
		    return redirect(routes.StudentCtrl.show(EnvVarbl.VIEW_MODE_STD_ADDITIONAL_DETAIL, EnvVarbl.pageInit, emergencyContact.getStudentFk()));
		}
		//////////////EDUCATIONAL BACKGROUND////////////////////////////////
		if (EnvVarbl.VIEW_MODE_STD_BCKGRD_EDUCATION_DETAIL.equals(viewMode)) {
			// errorMessage = courseSvr.validate(versementCheque, true);
		    educationalDetailSvr.save(educationalDetail);
		    return redirect(routes.StudentCtrl.show(EnvVarbl.VIEW_MODE_STD_NATIONALITY_DETAIL, EnvVarbl.pageInit, educationalDetail.getStudentFk()));
		}
		
		if (null != errorMessage) {
			flash("ERROR", errorMessage);
			// return badRequest(versementChequeTier.render(versementCheque,
			// ViewType.VIEW_MODE_CREATE,
			// generalDTOImpl.getRoIdentifiantInfo(versementCheque.getId(),
			// EnvironmentalVariables.TIER)));
		}
		studentSrv.save(studentDetail);
		// addressSvr.save(addressDetail);
		// contactSvr.save(contactDetail);

		flash("SUCCESS", "Course enregistré.");
		return redirect(routes.StudentCtrl.show(EnvVarbl.VIEW_MODE_STD_CONTACT_DETAIL, EnvVarbl.pageInit, uicode));
	}

	public Result delete(Long studentPK) {
		StudentDetail studentDetail = studentSrv.fetchOneById(studentPK);
		studentSrv.delete(studentDetail);
		flash("SUCCESS", "La " + "" + " a été supprimé.");
		return redirect(routes.StudentCtrl.show(EnvVarbl.VIEW_MODE_CREATE, EnvVarbl.pageInit, ""));
	}

	public Result list(int page, String filter) {
		String viewMode = "";
		return ok(studentManagement.render(studentSrv.pageStudentDetail(page, EnvVarbl.pageSize, filter), filter,
				viewMode));
	}
	
	public Result imprimerStudentInfo(Long studentId){
		//String userId = generateUserCode();
		try {
			ReportStudent.executeReportStudent(studentId);
		} catch (BirtException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		return ok(new java.io.File(reports.ReportEngine.getEtatDirectory().concat("student_info").concat(studentId.toString()).concat(".pdf")));
	}

}
