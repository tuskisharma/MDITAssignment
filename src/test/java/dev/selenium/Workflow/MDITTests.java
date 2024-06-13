package dev.selenium.Workflow;


import com.aventstack.extentreports.ExtentReports;
import com.aventstack.extentreports.ExtentTest;
import com.aventstack.extentreports.reporter.ExtentSparkReporter;
import dev.selenium.Pages.ExcelReadData;
import dev.selenium.Pages.HomePage;
import dev.selenium.Pages.LoginPage;
import io.github.bonigarcia.wdm.WebDriverManager;
import org.apache.commons.io.FileUtils;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.core.Logger;
import org.openqa.selenium.*;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.AfterTest;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.Test;

import java.io.File;
import java.io.IOException;
import java.time.Duration;
import java.util.Set;


public class MDITTests {
    ExtentTest test;
    ExtentReports extent = new ExtentReports();
    ExtentSparkReporter spark = new
            ExtentSparkReporter("target/Spark/Spark.html");
    private static Logger logger = (Logger) LogManager.getLogger();


    WebDriver driver;

    @BeforeTest
    public void setup() throws IOException {
        WebDriverManager.firefoxdriver().setup();
        driver = new FirefoxDriver();
        extent.attachReporter(spark);
        driver.get("https://www.techcanvass.com/");
        driver.manage().window().maximize();
        driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(60));
        logger.info("Browser Opened");
    }

    @Test(priority = 0)
    public void getTitle() throws IOException {
        test = extent.createTest("HomePageTitle");
        String str=driver.getTitle();
        logger.info("The title of the home page is "+str);
        test.pass("Printing the HomePage Title in console");
    }
    @Test(priority = 1)
    public void getCourses() throws InterruptedException {
        HomePage hp = new HomePage(driver);
        test = extent.createTest("CourseList");
        hp.mouseOverCourses();
        test.pass("Mouseover the dropdown");

    }

    @Test(priority = 2)
    public void getBacourses() {
        HomePage hp = new HomePage(driver);
        test = extent.createTest("List of BA courses");
        hp.getBACourses();
        test.pass("Printing the List of BA Courses only");
    }

    @Test(priority = 3)
    public void login() {
        LoginPage lp = new LoginPage(driver);
        lp.Homelogin();
    }

    @Test(priority = 4)
    public void loginInvalidCredentials() throws InterruptedException {
        String originalWindow = driver.getWindowHandle();

        // Get all window handles
        Set<String> windowHandles = driver.getWindowHandles();

        // Iterate through the window handles to find the new tab
        for (String windowHandle : windowHandles) {
            if (!windowHandle.equals(originalWindow)) {
                driver.switchTo().window(windowHandle);
                break;
            }
        }
        logger.info("Title of the new tab: " + driver.getTitle());
        LoginPage lp = new LoginPage(driver);
        lp.login("tushar235553@gmail.com", "24356");
        Thread.sleep(1000);
        Alert al = driver.switchTo().alert();
        String s = al.getText();
        logger.info(s);
        al.accept();
    }
    @Test(priority = 5)
    public void readDataFromExcel() throws IOException {
        ExcelReadData rd = new ExcelReadData();
        rd.ExcelReadData();
    }
    @AfterTest
    public void tearDown() {
        extent.flush();
        driver.quit();
    }

    @AfterMethod
    public void reportOfTheTests() throws IOException, InterruptedException {
        File scrfile = ((TakesScreenshot) driver).getScreenshotAs(OutputType.FILE);
        String pathOfSS = "Screenshots/screenshots" + System.currentTimeMillis() + ".jpg";
        File dest = new File(pathOfSS);
        FileUtils.copyFile(scrfile, dest);
        ExtentTest test = extent.createTest("Screen capture");
        test.addScreenCaptureFromPath(pathOfSS);
    }
}
