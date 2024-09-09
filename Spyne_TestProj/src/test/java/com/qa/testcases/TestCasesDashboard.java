package com.qa.implementation;

import base.Base;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.Assert;
import org.testng.annotations.Test;
import pages.DashboardPage;
import utils.Utils;

import java.awt.*;
import java.io.File;
import java.time.Duration;

public class TestCasesDashboard extends Base {
    DashboardPage dp;
    WebDriverWait wait;

//    TC001 - checks current url and elements present on page like - Get a demo button, spyne logo, pagetitle
    @Test(enabled = false)
    public void checkBasicDetails() {
        dp = new DashboardPage(driver);
        String actualUrl = driver.getCurrentUrl();
        String actualTitle = driver.getTitle();
        Assert.assertEquals(actualTitle, "AI Image Upscaler: Upscale Your Image Quality with AI For Free");
        Assert.assertEquals(actualUrl, "https://www.spyne.ai/image-upscaler");
        dp.verifyDashboardUIField();
        System.out.println("---PASSED---");
    }


//  TC002 - File upload functionality - jpg format
    @Test(enabled = false)
    public void validFileUpload() throws AWTException {
        dp = new DashboardPage(driver);
        String validImage = new File("src/main/resources/Sample-jpg-image.jpg").getAbsolutePath();
        Utils.clickUpload(validImage);
        wait = new WebDriverWait(driver, Duration.ofSeconds(30));
        wait.until(ExpectedConditions.urlToBe("https://www.spyne.ai/image-upscaler/result"));
        String currentUrl = driver.getCurrentUrl();
        Assert.assertEquals(currentUrl, "https://www.spyne.ai/image-upscaler/result");
        dp.fetchScalingOptions();
        System.out.println("Upload successful");
    }

// TC003 - Invalid file format validation
    @Test(enabled = false)
    public void invalidFileUpload() throws AWTException {
        dp = new DashboardPage(driver);
        String invalidImage = new File("src/main/resources/New Text Document.txt").getAbsolutePath();
        Utils.clickUpload(invalidImage);
        dp.errorMessageInvalidFormat();
    }




}
