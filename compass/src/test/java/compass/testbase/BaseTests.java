package compass.testbase;




import com.aventstack.extentreports.ExtentReports;
import com.aventstack.extentreports.ExtentTest;
import com.aventstack.extentreports.Status;
import com.aventstack.extentreports.markuputils.ExtentColor;
import com.aventstack.extentreports.markuputils.Markup;
import com.aventstack.extentreports.markuputils.MarkupHelper;
import com.aventstack.extentreports.reporter.ExtentSparkReporter;
import com.aventstack.extentreports.reporter.configuration.Theme;

import compass.core.Constants;
import io.github.bonigarcia.wdm.WebDriverManager;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.testng.ITestResult;
import org.testng.annotations.*;

import java.lang.reflect.Method;
import java.time.Duration;

public class BaseTests {
	public static WebDriver driver;
	public ExtentSparkReporter htmlReport;
	public static ExtentReports extentreports;
	public static ExtentTest logger;

	@BeforeTest
	public void beforeTestMethods() {
		htmlReport = new ExtentSparkReporter("./extentreports/report.html");
		htmlReport.config().setEncoding("utf-8");
		htmlReport.config().setDocumentTitle("Amarr Automation Report");
		htmlReport.config().setTheme(Theme.DARK);
		extentreports = new ExtentReports();
		extentreports.attachReporter(htmlReport);

	}

	@BeforeMethod
	@Parameters(value = "browserName")
	public void beforeMethodsMethod(@Optional String browserName, Method testMethod) {
		logger = extentreports.createTest(testMethod.getName());
		setupDriver("chrome");
		driver.manage().window().maximize();
		driver.get(Constants.url);
		driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(10));
	}

	@AfterMethod
	public void afterMethodsMethod(ITestResult result) {
		if (result.getStatus() == ITestResult.SUCCESS) {
			String methodName = result.getMethod().getMethodName();
			String logTest = "Test case " + methodName + " Passed";
			Markup m = MarkupHelper.createLabel(logTest, ExtentColor.GREEN);
			logger.log(Status.PASS, m);
		} else if (result.getStatus() == ITestResult.FAILURE) {
			String methodName = result.getMethod().getMethodName();
			String logTest = "Test case " + methodName + " Failed";
			Markup m = MarkupHelper.createLabel(logTest, ExtentColor.RED);
			logger.log(Status.FAIL, m);
		} else if (result.getStatus() == ITestResult.SKIP) {
			String methodName = result.getMethod().getMethodName();
			String logTest = "Test case " + methodName + " Skipped";
			Markup m = MarkupHelper.createLabel(logTest, ExtentColor.YELLOW);
			logger.log(Status.SKIP, m);
		}
		driver.quit();
	}

	@AfterTest
	public void afterTestMethod() {

		extentreports.flush();
	}

	public void setupDriver(String browserName) {

		if (browserName.equalsIgnoreCase("chrome")) {
			WebDriverManager.chromedriver().setup();
			driver = new ChromeDriver();
		} else if (browserName.equalsIgnoreCase("firefox")) {
			WebDriverManager.firefoxdriver().setup();
			driver = new FirefoxDriver();
		} else {
			WebDriverManager.chromedriver().setup();
			driver = new ChromeDriver();
		}

	}

}
