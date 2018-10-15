package services.utils;

import java.util.List;
import javax.inject.Inject;
import org.jooq.DSLContext;
import schemas.public_.tables.pojos.ApplicationDetail;
import services.AboutInstitutionSvr;
import services.admin.ApplicationDetailSvr;

public class GenerateCode {
	@Inject
	DSLContext sqlContext;
	@Inject
	AboutInstitutionSvr aboutInstitutionSvr;
	@Inject
	ApplicationDetailSvr applicationDetailSvr;
	
    public String getCodeApplicationDetail() {
    	List<ApplicationDetail> applicationDetails = applicationDetailSvr.findAll();
        int codeExiste = 0;
		if (applicationDetails.size() == 0) {
			return "100";
		} else {	
			for(ApplicationDetail applicationDetail : applicationDetails) {			
				final String code = applicationDetail.getCode();
 				codeExiste = Math.max(codeExiste, Integer.parseInt(code));
			}
			
			String codeString = String.valueOf(codeExiste+1);
			return  codeString;
		}
    }
}
