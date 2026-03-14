package TESTCASE;

import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.jspecify.annotations.Nullable;

import com.aventstack.extentreports.ExtentReports;
import com.aventstack.extentreports.ExtentTest;
import com.aventstack.extentreports.Status;
import com.aventstack.extentreports.reporter.ExtentSparkReporter;

import static org.testng.Assert.assertEquals;

import java.awt.Desktop;
import java.io.File;
import java.io.FileReader;
import java.io.IOException;
import java.net.URI;
import java.net.URL;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.text.SimpleDateFormat;
import java.time.Duration;
import java.time.LocalDate;
import java.time.format.DateTimeFormatter;
import java.util.Calendar;
import java.util.Comparator;
import java.util.Date;
import java.util.Optional;
import java.util.Properties;
import java.util.concurrent.TimeUnit;

import org.apache.commons.lang3.RandomStringUtils;
import org.openqa.selenium.By;
import org.openqa.selenium.OutputType;
import org.openqa.selenium.PageLoadStrategy;
import org.openqa.selenium.Platform;
import org.openqa.selenium.TakesScreenshot;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;
import org.openqa.selenium.edge.EdgeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.remote.DesiredCapabilities;
import org.openqa.selenium.remote.RemoteWebDriver;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.Assert;
import org.testng.ITestResult;
import org.testng.annotations.AfterClass;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.AfterSuite;
import org.testng.annotations.AfterTest;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.Parameters;

import io.github.bonigarcia.wdm.WebDriverManager;
import io.github.bonigarcia.wdm.config.WebDriverManagerException;
import utils.ExtentReportManager;
public class Baseclass {
	public static WebDriver driver;
	public static final String demoUrl ="https://demo-gcd.omnna.live/index.php";
	public static final String SSUrl = "https://ss-gcd.omnna.live/index.php";
	public Properties p;
	public static Logger logger;
	protected ExtentTest test;
	public static ExtentReports extent = new ExtentReports();
	ExtentSparkReporter spark = new ExtentSparkReporter("./Report/demo4Report/Golf Automation-" + TimeStamp() + ".html");
	ExtentTest testt = extent.createTest("Login");
	public static WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(10));

	@BeforeClass
	@Parameters({"os", "br"})
	public void setup(String os, String br) throws InterruptedException, IOException {
		FileReader file=new FileReader("./src//main//resources//config.properties");
		p=new Properties();
		p.load(file);
		logger=LogManager.getLogger(this.getClass());
		if(p.getProperty("execution_env").equalsIgnoreCase("remote"))
		{
			DesiredCapabilities capabilities=new DesiredCapabilities();
			
			//os
			if(os.equalsIgnoreCase("windows"))
			{
				capabilities.setPlatform(Platform.WIN11);
			}
			else if(os.equalsIgnoreCase("linux"))
			{
				capabilities.setPlatform(Platform.LINUX);
				
			}
			else if (os.equalsIgnoreCase("mac"))
			{
				capabilities.setPlatform(Platform.MAC);
			}
			else
			{
				System.out.println("No matching os");
				return;
			}
			
			//browser
			switch(br.toLowerCase())
			{
			case "chrome": capabilities.setBrowserName("chrome"); break;
			case "edge": capabilities.setBrowserName("MicrosoftEdge"); break;
			case "firefox": capabilities.setBrowserName("firefox"); break;
			default: System.out.println("No matching browser"); return;
			}
			
			driver=new RemoteWebDriver(new URL("http://localhost:4444/wd/hub"),capabilities);
		}
		
				
		if(p.getProperty("execution_env").equalsIgnoreCase("local"))
		{

			switch(br.toLowerCase())
			{
			case "chrome" : driver=new ChromeDriver(); break;
			case "edge" : driver=new EdgeDriver(); break;
			case "firefox": driver=new FirefoxDriver(); break;
			default : System.out.println("Invalid browser name.."); return;
			}
		}
		
		
		
//		ChromeOptions opt = new ChromeOptions();
//		opt.setPageLoadStrategy(PageLoadStrategy.NORMAL);
//		opt.addArguments("--remote-allow-origins=*");
//		o pt.addArguments("--disable-blink-features=AutomationControlled");
//		
//		 WebDriverManager.chromedriver().setup();
//		driver = new ChromeDriver();
//		logger.info("Chrome browser opened successfully");
//		testt.info("Chrome browser opened successfully");

//	 
//	WebDriverManager.firefoxdriver().setup();
//	driver = new FirefoxDriver();
//	//System.setProperty(FirefoxDriver.SystemProperty.BROWSER_LOGFILE,"null");
//	
//	System.out.println("Firefox browser opened successfully");
//	

		driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(10));
		driver.manage().timeouts().pageLoadTimeout(Duration.ofSeconds(100));
		driver.manage().timeouts().scriptTimeout(Duration.ofSeconds(10));

		driver.manage().window().maximize();

		logger.info("Browser window maximized successfully");

		driver.manage().deleteAllCookies();

		// Demo4 server url with login code
		driver.get(p.getProperty("demoUrl"));
		logger.info("Website is running on " + driver.getCurrentUrl());
		testt.info("Website is running on " + driver.getCurrentUrl());

		Thread.sleep(1000);
		String expUrl="Green Team Holdings, LLC. - ENV: demo-gcd";
		boolean actUrl=driver.getTitle().contains(expUrl);
		if(actUrl==true) {
			logger.info("Title verified successfully");
			testt.info("Title verified successfully");
			Assert.assertTrue(true);
		}
		else {
			logger.info("Title not verified");
			testt.info("Title not verified");
			Assert.assertTrue(false);
		}
		
		// driver.findElement(By.xpath("//input[@id='procdSave']")).click();
		// Thread.sleep(1000);
		WebElement username = driver.findElement(By.id("user_name"));
		username.sendKeys(p.getProperty("username"));
		logger.info("Entered username is: " + username.getAttribute("value"));
		testt.info("Entered password is: " + username.getAttribute("value"));

		// Thread.sleep(1000);
		WebElement password = driver.findElement(By.id("user_password"));
		password.sendKeys(p.getProperty("password"));
		testt.info("Entered password is: " + password.getAttribute("value"));

		// Thread.sleep(1000);
		driver.findElement(By.name("Login")).click();
		logger.info("Login completed");

		testt.info("Login button clicked successfully");
		testt.log(Status.PASS, "Login completed");

	}

	@BeforeTest
	public void beforeTest() {
		extent.attachReporter(spark);
		
	}
	
	@AfterTest
	public void afterTest() {
		testt.assignAuthor("Shyam");
		testt.assignDevice("Windows 11 device");
		testt.assignCategory("Golf regression testcase");
		extent.flush();
		
	}
	
	public String captureScreen(String tname) throws IOException {

		String timeStamp = new SimpleDateFormat("yyyyMMddhhmmss").format(new Date());
				
		TakesScreenshot takesScreenshot = (TakesScreenshot) driver;
		File sourceFile = takesScreenshot.getScreenshotAs(OutputType.FILE);
		
		String targetFilePath=System.getProperty("user.dir")+"\\screenshots\\" + tname + "_" + timeStamp + ".png";
		File targetFile=new File(targetFilePath);
		
		sourceFile.renameTo(targetFile);
			
		return targetFilePath;

	}
	@AfterClass
	public void TearDown() {
		// Create the Logout test here so it is recorded last in the Extent report
		ExtentTest testtg = extent.createTest("Logout");
		try {
			driver.quit();
			testtg.info("Logout completed");
		} catch (Exception e) {
			// ensure any driver quit issues are logged in report but do not fail
			testtg.warning("Exception during teardown: " + e.getMessage());
			if (logger != null) {
				logger.warn("Exception during TearDown", e);
			}
		}
		// flush latest status to the report
		extent.flush();
	}

	public String randomestring() {
		String generatedstring = RandomStringUtils.randomAlphabetic(5);
		return (generatedstring);
	}

	public static String randomeNum() {
		String generatedString2 = RandomStringUtils.randomNumeric(12);
		return (generatedString2);
	}

	public static String randomeNumFive() {
		String generatedString2 = RandomStringUtils.randomNumeric(5);
		return (generatedString2);
	}

	public static String randomeNumThree() {
		String generatedString2 = RandomStringUtils.randomNumeric(3);
		return (generatedString2);
	}

	public static String TimeStamp() {
		Calendar cal = Calendar.getInstance();
		java.util.Date time = cal.getTime();
		String timestamp = time.toString().replace(":", "".replace(" ", ""));
		return timestamp;
	}

	public static String date() throws Exception {

		// Printing Today's date by calling
		// java.time.LocalDate.now() function
		LocalDate localDate = LocalDate.now();// For reference
		DateTimeFormatter formatter = DateTimeFormatter.ofPattern("dd LLLL yyyy");
		String formattedString = localDate.format(formatter);
		return formattedString;
	}
	
	@AfterSuite(alwaysRun = true)
	public void openReportInBrowser() {
		try {
			// Ensure Extent writes latest results to disk before opening
			extent.flush();
			// Look for Extent report files in the Report/demo4Report folder under project root
			Path reportDir = Paths.get(System.getProperty("user.dir"), "Report", "demo4Report");
			if (!Files.exists(reportDir) || !Files.isDirectory(reportDir)) {
				logger.warn("Extent report directory not found: " + reportDir.toString());
				return;
			}

			Optional<Path> latestHtml = Files.list(reportDir)
				.filter(p -> p.toString().toLowerCase().endsWith(".html"))
				.max(Comparator.comparingLong(p -> p.toFile().lastModified()));

			if (!latestHtml.isPresent()) {
				logger.warn("No HTML report found in: " + reportDir.toString());
				return;
			}

			Path report = latestHtml.get().toAbsolutePath();
			logger.info("Opening Extent report: " + report.toString());

			boolean opened = false;
			if (Desktop.isDesktopSupported()) {
				Desktop desktop = Desktop.getDesktop();
				try {
					if (desktop.isSupported(Desktop.Action.BROWSE)) {
						desktop.browse(report.toUri());
						opened = true;
					} else if (desktop.isSupported(Desktop.Action.OPEN)) {
						desktop.open(report.toFile());
						opened = true;
					}
				} catch (IOException ioe) {
					// continue to fallback if Desktop fails
					logger.warn("Desktop API failed to open report, falling back to OS command", ioe);
				}
			}

			if (!opened) {
				String os = System.getProperty("os.name").toLowerCase();
				try {
					if (os.contains("win")) {
						new ProcessBuilder("cmd", "/c", "start", "\"\"", report.toString()).start();
					} else if (os.contains("mac")) {
						new ProcessBuilder("open", report.toString()).start();
					} else {
						new ProcessBuilder("xdg-open", report.toString()).start();
					}
					opened = true;
				} catch (Exception ex) {
					if (logger != null) {
						logger.error("Failed to open Extent report using OS command", ex);
					} else {
						ex.printStackTrace();
					}
				}
			}

		} catch (Exception e) {
			if (logger != null) {
				logger.error("Failed to locate or open Extent report", e);
			} else {
				e.printStackTrace();
			}
		}
	}
}