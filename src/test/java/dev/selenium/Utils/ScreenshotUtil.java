package dev.selenium.Utils;

import org.apache.commons.io.FileUtils;
import org.openqa.selenium.OutputType;
import org.openqa.selenium.TakesScreenshot;

import java.io.File;
import java.io.IOException;

public class ScreenshotUtil {

    public void getScreenshot(Object driver, String filepathname) throws IOException {
        TakesScreenshot screenshot = (TakesScreenshot) driver;
        File screenshotFile = screenshot.getScreenshotAs(OutputType.FILE);
        File destinationFile = new File(filepathname);
        FileUtils.copyFile(screenshotFile, destinationFile);
    }
}
