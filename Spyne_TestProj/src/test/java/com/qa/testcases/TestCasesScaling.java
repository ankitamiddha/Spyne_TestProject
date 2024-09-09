package com.qa.testcases;

import base.Base;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.annotations.Test;
import pages.ScalingPage;
import utils.Utils;

import java.awt.*;
import java.io.File;
import java.time.Duration;

public class TestCasesScaling extends Base {

    ScalingPage scalingPage;
    WebDriverWait wait;
    TestCasesDashboard testCasesDashboard = new TestCasesDashboard();
    JavascriptExecutor js = (JavascriptExecutor) driver;

// TC004 - Verify the scaling process is successful. Verify the buttons, Upload button, Process button
// and Download button are present.
// Pre-requisite - user should be logged in to perform scaling process.
    @Test(priority = 2)
    public void verifyScalingProcess() throws AWTException {
        testCasesDashboard.validFileUpload();
        scalingPage = new ScalingPage(driver);
        driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(60));
        scalingPage.scalingSuccessful();
        System.out.println("Process button visible");
        System.out.println("Up_Scaling of photo is complete");
    }

// TC002 - Test the functionality of upload of png image format
// TC005 - Test functionality of Upload button on scaling screen
// TC006 - Download image
    @Test(priority = 1)
    public void uploadButton() throws AWTException {
        testCasesDashboard.validFileUpload();
        scalingPage = new ScalingPage(driver);
        String validImage = new File("src/main/resources/sample-png.png").getAbsolutePath();
        Utils.clickUpload(validImage);

    }
}
