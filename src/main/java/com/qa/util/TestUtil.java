package com.qa.util;

import com.qa.base.TestBase;
import org.openqa.selenium.OutputType;
import org.openqa.selenium.TakesScreenshot;

import java.io.File;
import java.io.IOException;

import static repackage.Repackage.copyFile;

public class TestUtil extends TestBase {
    public static long PAGE_LOAD_TIMEOUT=20;
    public static long IMPLICIT=10;

    public void switchToFrame(){
        driver.switchTo().frame("mainpanel");
    }



    public static void takeScreenshotAtEndOfTest() throws IOException {
        File scrFile = ((TakesScreenshot) driver).getScreenshotAs(OutputType.FILE);
        String currentDir = System.getProperty("user.dir");
        copyFile(scrFile, new File(currentDir + "/screenshots/" + System.currentTimeMillis() + ".png"));
    }
}
