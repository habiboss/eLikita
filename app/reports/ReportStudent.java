package reports;

import org.eclipse.birt.core.exception.BirtException;
import org.eclipse.birt.core.framework.Platform;
import org.eclipse.birt.report.engine.api.IRenderTask;
import org.eclipse.birt.report.engine.api.IReportDocument;
import org.eclipse.birt.report.engine.api.IReportRunnable;
import org.eclipse.birt.report.engine.api.IRunTask;
import org.eclipse.birt.report.engine.api.PDFRenderOption;
import org.eclipse.core.internal.registry.RegistryProviderFactory;

public class ReportStudent {
 	public static void executeReportStudent(Long userCode) throws BirtException{
		//IReportEngine engine = null;
		//EngineConfig config = null;
		try {
			/*config = new EngineConfig();
			config.setEngineHome(ReportEngine.getEngineHome());
			config.setLogConfig(null, Level.FINE);*/

			//Platform.startup(ReportEngine.getConfig());
			//ReportEngine.getReportEngineFactory();
			/*engine = ReportEngine.getReportEngineFactory().createReportEngine(ReportEngine.getConfig());
			engine.changeLogLevel(Level.WARNING);*/

		} catch (Exception ex) {
			ex.printStackTrace();
		}
		IReportRunnable design = null;
		design = ReportEngine.getRepEngine().openReportDesign(ReportEngine.getRptDesingDirectory()+"student_info.rptdesign");
		// Create task to run the report - use the task to execute and run the
		// report,
		IRunTask task = ReportEngine.getRepEngine().createRunTask(design);
//		task.setParameterValue("paramJournee", paramJournee);
//		System.out.println("username avant est "+username);
//		task.setParameterValue("paramUserName", username);
//		System.out.println("username apres est "+username);
		task.setParameterValue("param_student_id", userCode);
		task.setParameterValue("dbUrl", ReportEngine.getUrl());
		task.setParameterValue("dbUsername", ReportEngine.getDbuser());
		task.setParameterValue("dbPwd", ReportEngine.getDbpass());
		// Create rptdocument
		task.run(ReportEngine.getRptDocDirectory()+"LE.rptdocument");

		// Open rptdocument
		IReportDocument rptdoc = ReportEngine.getRepEngine()
				.openReportDocument(ReportEngine.getRptDocDirectory()+"LE.rptdocument");
		// Get the top level TOC Node

		// Create Render Task
		IRenderTask rtask = ReportEngine.getRepEngine().createRenderTask(rptdoc);

		PDFRenderOption options = new PDFRenderOption();

		// Set ouptut location
//		options.setOutputFileName(ReportEngine.getEtatDirectory().concat(rptQuittance).concat("_=_").concat(username).concat("_=_").concat(userCode).concat(".pdf"));
		options.setOutputFileName(ReportEngine.getEtatDirectory().concat("student_info").concat(userCode.toString()).concat(".pdf"));
		
		// Set output format
		options.setOutputFormat("pdf");
		rtask.setRenderOption(options);

		rtask.render();

		task.close();

		ReportEngine.getRepEngine().destroy();
		Platform.shutdown();
		RegistryProviderFactory.releaseDefault();
		ReportEngine.releaseEngine();
	//	engine = null;
		//System.out.println("Finished");
	}
}
