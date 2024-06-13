package dev.selenium.Utils;

import com.aventstack.extentreports.ExtentReports;
import com.aventstack.extentreports.ExtentTest;
import com.aventstack.extentreports.reporter.ExtentSparkReporter;
import org.openqa.selenium.OutputType;
import org.openqa.selenium.TakesScreenshot;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.support.PageFactory;

import java.io.File;

public class ExtentUtils {
    WebDriver driver;
    public ExtentUtils(WebDriver driver) {
        this.driver = driver;
        PageFactory.initElements(driver, this);
    }
    ExtentReports extent = new ExtentReports();
    ExtentSparkReporter spark = new ExtentSparkReporter("target/Spark/Spark.html");
    ExtentTest test;
    File scrfile=((TakesScreenshot)driver).getScreenshotAs(OutputType.FILE);
    String pathOfSS="Screenshots/screenshots"+System.currentTimeMillis()+".jpg";
}
