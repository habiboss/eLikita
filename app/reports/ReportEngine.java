/**
 * 
 */
package reports;

import java.io.File;
import java.util.logging.Level;
import org.eclipse.birt.core.exception.BirtException;
import org.eclipse.birt.core.framework.Platform;
import org.eclipse.birt.report.engine.api.EngineConfig;
import org.eclipse.birt.report.engine.api.IReportEngine;
import org.eclipse.birt.report.engine.api.IReportEngineFactory;
import play.Play;

/**
 * @author Aboubacar GAGERE
 *
 * @SkyTux
 */
public class ReportEngine {

	private static IReportEngineFactory factory = null;
	private static EngineConfig config = null;
	private static IReportEngine engine = null;
	
	//private static String engineHome= Play.application().configuration().getString("birt.engine.home");
	private static String engineHome = new File("").getAbsolutePath() + "/etats/birt-runtime/ReportEngine";
	
	//private static String rptDesingDirectory= Play.application().configuration().getString("birt.engine.rptdesign.directory");
	private static String rptDesingDirectory = new File("").getAbsolutePath() + "/etats/rptDesign/";
	
	//private static String rptDocDirectory= Play.application().configuration().getString("birt.engine.rptdoc.directory");
	private static String rptDocDirectory = new File("").getAbsolutePath() + "/etats/rptDoc/";
	
	//private static String etatDirectory= Play.application().configuration().getString("etat.directory");
	private static String etatDirectory = new File("").getAbsolutePath() + "/etats/lesEtats/";
	
	//private static String barcode_directory= Play.application().configuration().getString("barcode.directory");
	private static String barcode_directory = new File("").getAbsolutePath() + "/public/images/barcode/";
	
	/*---------------- db config------------------------*/
	@SuppressWarnings("deprecation")
	private static String url= Play.application().configuration().getString("rpdb.url");
	@SuppressWarnings("deprecation")
	private static String dbuser= Play.application().configuration().getString("rpdb.user");
	@SuppressWarnings("deprecation")
	private static String dbpass= Play.application().configuration().getString("rpdb.pass");
	
	public static IReportEngineFactory getReportEngineFactory(){
		
		if(factory == null){
			factory = (IReportEngineFactory) Platform.createFactoryObject(IReportEngineFactory.EXTENSION_REPORT_ENGINE_FACTORY);
		}else{
			return factory;
		}
		return factory;

	}
	
	public static EngineConfig getConf(){
		
		config = new EngineConfig();
		config.setEngineHome(getEngineHome());
		config.setLogConfig(null, Level.FINE);
		return config;
		
	}
	
	public static IReportEngine getRepEngine() throws BirtException{
		getConf();
		Platform.startup(getConf());
		getReportEngineFactory();
		if (engine==null) {
			engine = getReportEngineFactory().createReportEngine(getConf());
			engine.changeLogLevel(Level.WARNING);
			
					}else return engine;
		
		return engine;
		
	}
	
	public static IReportEngine releaseEngine(){
		return engine=null;
	}
	
	

	/**
	 * @return the factory
	 */
	public static IReportEngineFactory getFactory() {
		return factory;
	}

	/**
	 * @param factory the factory to set
	 */
	public static void setFactory(IReportEngineFactory factory) {
		ReportEngine.factory = factory;
	}

	/**
	 * @return the engineHome
	 */
	public static String getEngineHome() {
		return engineHome;
	}

	/**
	 * @param engineHome the engineHome to set
	 */
	public static void setEngineHome(String engineHome) {
		ReportEngine.engineHome = engineHome;
	}

	/**
	 * @return the rptDesingDirectory
	 */
	public static String getRptDesingDirectory() {
		return rptDesingDirectory;
	}

	/**
	 * @param rptDesingDirectory the rptDesingDirectory to set
	 */
	public static void setRptDesingDirectory(String rptDesingDirectory) {
		ReportEngine.rptDesingDirectory = rptDesingDirectory;
	}

	/**
	 * @return the rptDocDirectory
	 */
	public static String getRptDocDirectory() {
		return rptDocDirectory;
	}

	/**
	 * @param rptDocDirectory the rptDocDirectory to set
	 */
	public static void setRptDocDirectory(String rptDocDirectory) {
		ReportEngine.rptDocDirectory = rptDocDirectory;
	}

	/**
	 * @return the etatDirectory
	 */
	public static String getEtatDirectory() {
		return etatDirectory;
	}

	/**
	 * @param etatDirectory the etatDirectory to set
	 */
	public static void setEtatDirectory(String etatDirectory) {
		ReportEngine.etatDirectory = etatDirectory;
	}

	/**
	 * @return the url
	 */
	public static String getUrl() {
		return url;
	}

	/**
	 * @param url the url to set
	 */
	public static void setUrl(String url) {
		ReportEngine.url = url;
	}

	/**
	 * @return the dbuser
	 */
	public static String getDbuser() {
		return dbuser;
	}

	/**
	 * @param dbuser the dbuser to set
	 */
	public static void setDbuser(String dbuser) {
		ReportEngine.dbuser = dbuser;
	}

	/**
	 * @return the dbpass
	 */
	public static String getDbpass() {
		return dbpass;
	}

	/**
	 * @param dbpass the dbpass to set
	 */
	public static void setDbpass(String dbpass) {
		ReportEngine.dbpass = dbpass;
	}

	/**
	 * @return the config
	 */
	public static EngineConfig getConfig() {
		return config;
	}

	/**
	 * @param config the config to set
	 */
	public static void setConfig(EngineConfig config) {
		ReportEngine.config = config;
	}

	/**
	 * @param engine the engine to set
	 */
	public static void setEngine(IReportEngine engine) {
		ReportEngine.engine = engine;
	}

	public static String getBarcode_directory() {
		return barcode_directory;
	}

	public static void setBarcode_directory(String barcode_directory) {
		ReportEngine.barcode_directory = barcode_directory;
	}
	
	
}
