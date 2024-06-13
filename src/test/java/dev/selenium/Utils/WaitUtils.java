package dev.selenium.Utils;

import org.openqa.selenium.By;
import org.openqa.selenium.NoSuchElementException;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.FluentWait;
import org.openqa.selenium.support.ui.Wait;
import org.openqa.selenium.support.ui.WebDriverWait;

import java.time.Duration;

public class WaitUtils {
    public WaitUtils(WebDriver driver) {
        this.driver = driver;
    }

    WebDriver driver;
    public void implicitWait(long timeInUnits){
        driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(timeInUnits));
    }
    public void explicitWait(long timeInUnits, String valueOfPath){
        WebDriverWait wait=new WebDriverWait(driver,Duration.ofSeconds(timeInUnits));
        wait.until(d->driver.findElement(By.xpath(valueOfPath)).isDisplayed());
    }
    public void fluentWait(long timeInUnits, long timeUnitInMilliseconds, String valueOfPath){
        Wait<WebDriver> wait=new FluentWait<WebDriver>(driver)
                .withTimeout(Duration.ofSeconds(timeInUnits))
                .pollingEvery(Duration.ofMillis(timeUnitInMilliseconds))
                .ignoring(NoSuchElementException.class);
        wait.until(ExpectedConditions.visibilityOfElementLocated(By.name(valueOfPath)));
    }


}
