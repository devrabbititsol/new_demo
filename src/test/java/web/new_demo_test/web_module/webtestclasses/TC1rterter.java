package web.new_demo_test.web_module.webtestclasses;
import org.apache.log4j.Logger;
import org.apache.log4j.PropertyConfigurator;
import org.openqa.selenium.support.PageFactory;
import org.testng.ITestResult;
import org.testng.annotations.Test;
import com.relevantcodes.extentreports.ExtentReports;
import com.relevantcodes.extentreports.ExtentTest;
import com.relevantcodes.extentreports.LogStatus;
import com.configurations.Constants;
import com.configurations.ExtentConfigurations;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.Parameters;
import web.new_demo_test.web_module.webpageclasses.Home_screen;
import web.new_demo_test.web_module.webpageclasses.Services_screen;
import com.utilities.BaseClass;
import com.utilities.ConfigFilesUtility;
import com.utilities.Utilities;
import org.json.JSONObject;

@SuppressWarnings("unused")
public class TC1rterter extends BaseClass {
	ExtentReports reports;
	ExtentTest test;
	ITestResult result;
	private Logger logger;
	private ConfigFilesUtility configFileObj;
	private String browserName = "chrome";
	public boolean isElementDispalyed = false;
	public static final int datasetsLength = 1;

	public TC1rterter() throws Exception {
		PropertyConfigurator.configure("log4j.properties");
		logger = Logger.getLogger(TC1rterter.class);
		configFileObj = new ConfigFilesUtility();
		configFileObj.loadPropertyFile("tc1rterter.properties");
	}

	@BeforeTest
	@Parameters("browser")
	public void browserName(String browser) throws Exception {
		browserName = browser;
		reports = ExtentConfigurations.getExtentInstance(reportsPath, projectPath, Home_screen.projectName);
		test = reports.startTest(setTestcaseName(browserName, "TC1rterter"));
	}

	
	public void setUP() throws Exception {
		String primaryInfo = Home_screen.primaryInfo;
		Constants.PRIMARY_INFO = primaryInfo;
		driver = launchBrowser(browserName, configFileObj);
		printSuccessLogAndReport(test, logger, "Browser Name : " + browserName);
	}

	public void Home_screenTest(int i) throws Exception {

	 try{
		Constants.TOTAL_TC = Constants.TOTAL_TC + 1;
		Constants.IS_TESTCASE = true; Constants.iS_WEB = true;
		int datasetScreencount = 1;
		Home_screen objHome_screen = PageFactory.initElements(driver, Home_screen.class);
		testLogHeader(test, "Verify Home_screen page");
		String text1 = objHome_screen.clkaServices_401497();
		if(text1.equalsIgnoreCase(configFileObj.getProperty("Services"+ i + datasetScreencount))){
			printSuccessLogAndReport(test, logger,  "Clicked on : " + configFileObj.getProperty("Services"+ i + datasetScreencount));
			printSuccessLogAndReport(test, logger,  "Validated Link Text : " + configFileObj.getProperty("Services"+ i + datasetScreencount));
		} else {
			printFailureLogAndReport(test, logger,  "Link Text is not displayed  : " + configFileObj.getProperty("Services"+ i + datasetScreencount));
		}

	   } catch (Exception e) {
		  isElementDispalyed = false;
		  printFailureLogAndReport(test, logger,  "Element is not found" + e.getLocalizedMessage());
		}
	}
	

	public void Services_screenTest(int i) throws Exception {

	 try{
		Constants.TOTAL_TC = Constants.TOTAL_TC + 1;
		Constants.IS_TESTCASE = true; Constants.iS_WEB = true;
		int datasetScreencount = 2;
		Services_screen objServices_screen = PageFactory.initElements(driver, Services_screen.class);
		testLogHeader(test, "Verify Services_screen page");
		String text1 = objServices_screen.clkaTechnology_401736();
		if(text1.equalsIgnoreCase(configFileObj.getProperty("Technology"+ i + datasetScreencount))){
			printSuccessLogAndReport(test, logger,  "Clicked on : " + configFileObj.getProperty("Technology"+ i + datasetScreencount));
			printSuccessLogAndReport(test, logger,  "Validated Link Text : " + configFileObj.getProperty("Technology"+ i + datasetScreencount));
		} else {
			printFailureLogAndReport(test, logger,  "Link Text is not displayed  : " + configFileObj.getProperty("Technology"+ i + datasetScreencount));
		}

	   } catch (Exception e) {
		  isElementDispalyed = false;
		  printFailureLogAndReport(test, logger,  "Element is not found" + e.getLocalizedMessage());
		}
	}
	
	@Test
	public void screensTest() throws Exception {
		for(int datasets = 1; datasets <= Services_screen.datasetsLength; datasets++) {
			isElementDispalyed = true;			
			setUP();
			if(isElementDispalyed) { Home_screenTest(datasets);}
			if(isElementDispalyed) { Services_screenTest(datasets);}
			tearDown();
		}	}

	
	public void tearDown() throws Exception {
		reports.endTest(test);
		reports.flush();
		driver.quit();
	}
}