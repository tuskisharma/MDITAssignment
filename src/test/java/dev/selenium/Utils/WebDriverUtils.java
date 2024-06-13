package dev.selenium.Utils;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.edge.EdgeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;

import java.io.IOException;

public class WebDriverUtils {
    public WebDriverUtils(WebDriver driver) throws IOException {
        this.driver = driver;
    }

    public WebDriver driver;

    public void DriverSelection( String name){
        switch (name) {
            case "chrome":

                driver = new ChromeDriver();
                break;
            case "firefox":
                driver = new FirefoxDriver();
                break;
            case "Edge":
                driver = new EdgeDriver();
                break;
            default:
                System.out.println("No webdriver selected");
        }
    }
}
