package dev.selenium.Pages;

import dev.selenium.Utils.WaitUtils;
import org.apache.poi.xssf.usermodel.XSSFCell;
import org.apache.poi.xssf.usermodel.XSSFRow;
import org.apache.poi.xssf.usermodel.XSSFSheet;
import org.apache.poi.xssf.usermodel.XSSFWorkbook;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.PageFactory;

import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;

public class LoginPage {
    WebDriver driver;
    public LoginPage(WebDriver driver) {
        this.driver = driver;
        PageFactory.initElements(driver, this);
    }
    By loginbtn= By.id("loginbtn0");
    By usernameBy= By.name("txtLoginid");

    By passwordBy =By.name("txtpassword");

    By loginBy=By.name("btnLogin");

    public void login(String username, String password){
        driver.findElement(usernameBy).sendKeys(username);
        driver.findElement(passwordBy).sendKeys(password);
        driver.findElement(loginBy).click();
    }

        public void Homelogin(){
            WebElement lg=driver.findElement(loginbtn);
            lg.click();
        }

    }

