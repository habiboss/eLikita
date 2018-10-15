package services.admin;

import javax.inject.Inject;
import org.jooq.DSLContext;
import schemas.administrator.tables.daos.LogInfoDao;
import schemas.administrator.tables.pojos.LogInfo;

public class LogInfoSvr extends LogInfoDao{
	@Inject
	DSLContext sqlContext;

	@Inject
	public LogInfoSvr(DSLContext sqlContext) {
		super();
		this.setConfiguration(sqlContext.configuration());
	}
	
	public void save(String code, String logName, String description) {
		// TODO Auto-generated method stub
		LogInfo logInfo = new LogInfo();
		    logInfo.setCode(code);
		    logInfo.setLogName(logName);
		    logInfo.setDescription(description);
			super.insert(logInfo);

	}
}
