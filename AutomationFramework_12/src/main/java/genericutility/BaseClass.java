package genericutility;

import java.io.IOException;
import java.time.Duration;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.edge.EdgeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.BeforeSuite;
import org.testng.annotations.Optional;
import org.testng.annotations.Parameters;

import com.aventstack.extentreports.ExtentReports;
import com.aventstack.extentreports.ExtentTest;
import com.aventstack.extentreports.reporter.ExtentSparkReporter;

import objectrepository.HomePage;
import objectrepository.loginPage;
import objectrepository.welcomePage;

public class BaseClass {
	public static ExtentReports extReport;
	public WebDriver driver;
	public static ExtentTest test;
	public static WebDriver sdriver;

	public javaUtility jUtil = new javaUtility();
	public webDriverUtility wutil = new webDriverUtility();
	public FileUtility futil = new FileUtility();
	public ExcelUtility eUtil = new ExcelUtility();

	public welcomePage wp;
	public loginPage lp;
	public HomePage hp;

	@BeforeSuite
	public void reportConfig() {
		ExtentSparkReporter spark = new ExtentSparkReporter("./HTML_reports/ExtentReports_" + jUtil.getSystemTime());
		extReport = new ExtentReports();
		extReport.attachReporter(spark);
	}

	@Parameters("Browser")
	@BeforeClass
	public void launchtheBrowser(@Optional("chrome") String browserName) throws IOException {
		if (browserName.equalsIgnoreCase("chrome")) {
			driver = new ChromeDriver();
		}

		else if (browserName.equalsIgnoreCase("Firefox")) {
			driver = new FirefoxDriver();
		} else if (browserName.equalsIgnoreCase("Edge")) {
			driver = new EdgeDriver();
		}
sdriver=driver;
		wutil.maximizeWindow(driver);
		driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(20));
		driver.get(futil.getDataFromProperty("url"));

	}

	@BeforeMethod
	public void login() throws IOException {

		wp = new welcomePage(driver);
		wp.getLoginLink().click();
		lp = new loginPage(driver);
		lp.getEmailTextField().sendKeys(futil.getDataFromProperty("email"));
		lp.getPasswordTextField().sendKeys(futil.getDataFromProperty("Password"));
		lp.getLoginButton().click();
	}

	@AfterMethod
	public void reportBackup() {
		extReport.flush();

	}

}
