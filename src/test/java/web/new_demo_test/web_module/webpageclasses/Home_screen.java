package web.new_demo_test.web_module.webpageclasses;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.How;
import com.utilities.BaseClass;
import com.relevantcodes.extentreports.ExtentReports;
import com.relevantcodes.extentreports.ExtentTest;

@SuppressWarnings("unused")
public class Home_screen extends BaseClass {
	
	public static String primaryInfo  = "{\"user_id\":85,\"executed_user_id\":85,\"is_generate\":false,\"is_execute\":false,\"is_web\":true,\"project_url\":\"https://www.devrabbit.com/\",\"report_upload_url\":\"https://smartqe.io:443/UploadReportFile\",\"project_name\":\"new_demo_test\",\"project_description\":\"desc\",\"project_id\":406,\"module_name\":\"web_module\",\"module_description\":\"desc\",\"sub_module_id\":0,\"module_id\":676,\"testcase_name\":\"tc\",\"testcase_id\":570,\"testset_id\":0,\"executed_timestamp\":342652443,\"browser_type\":\"chrome\",\"testcase_overwrite\":true,\"client_timezone_id\":\"Asia/Calcutta\"}";

	public static String projectName = "new_demo_test";
	public WebDriver driver;
	public ExtentReports reports;
	public ExtentTest test;
	public static final int datasetsLength = 1;

	public Home_screen(WebDriver driver) {
		this.driver = driver;
	}

	@FindBy(how = How.XPATH, using = "//a[contains(text(),'Services')]")	
	private WebElement	Services_401497a;
	public String clkaServices_401497() {
		waitForExpectedElement(driver, Services_401497a);		
		String text = Services_401497a.getText();
		Services_401497a.click();
		return text;
	}

}