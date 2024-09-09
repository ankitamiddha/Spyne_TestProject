package Listener;


import io.qameta.allure.Allure;
import org.openqa.selenium.OutputType;
import org.openqa.selenium.TakesScreenshot;
import org.testng.ITestListener;
import org.testng.ITestResult;
import base.Base;

import java.io.ByteArrayInputStream;

public class TestStatusListener extends Base implements ITestListener {

   @Override
    public void onTestFailure(ITestResult result) {
        System.out.println("Test case failed");
        try {
            FailedScreenshot(result.getName());
            Allure.addAttachment("Screenshot captured", new ByteArrayInputStream(((TakesScreenshot) driver).getScreenshotAs(OutputType.BYTES)));
        } catch (Exception e) {
            e.printStackTrace();
        }
    }
}