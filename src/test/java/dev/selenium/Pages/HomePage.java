package dev.selenium.Pages;

import dev.selenium.Utils.WaitUtils;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.core.Logger;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.PageFactory;

import java.util.List;

public class HomePage {
    public HomePage(WebDriver driver) {
        this.driver = driver;
        PageFactory.initElements(driver, this);
    }
    private static Logger logger = (Logger) LogManager.getLogger();

    WebDriver driver;

    By AllcoursesDropdown = By.id("dropdownMenuButton");
    By Bacourses = By.id("navbarDropdownMenuLink1");
    By listOfBaCourses= By.xpath("//ul[@class='BA']/div/div/div/li");

    public void mouseOverCourses() throws InterruptedException {
        Actions ac = new Actions(driver);
        WaitUtils wait = new WaitUtils(driver);
        WebElement dropdown = driver.findElement(AllcoursesDropdown);
        ac.moveToElement(dropdown).build().perform();
        //wait.explicitWait(10,"dropdownMenuButton");

    }public void getBACourses() {
        List<WebElement> wb=driver.findElements(listOfBaCourses);
        for (WebElement we:wb){
            String st= we.getText().trim();
            if (st.isEmpty()){
                break;
            }
            logger.info(st);
        }


    }
}


