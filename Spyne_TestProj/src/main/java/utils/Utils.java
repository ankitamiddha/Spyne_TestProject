package utils;

import base.Base;
import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

import java.time.Duration;

public class Utils extends Base {

    static WebDriverWait wait;

    // This function uploads a jpeg  or png image from the Upload an image button
    public static void  clickUpload(String pathname) {

        WebElement element;
        try{
            wait = new WebDriverWait(driver, Duration.ofSeconds(40));
            element = wait.until(ExpectedConditions.presenceOfElementLocated(By.cssSelector("input[type='file']")));
            element.sendKeys(pathname);

        }catch (Exception e){
            wait = new WebDriverWait(driver, Duration.ofSeconds(40));
            element = wait.until(ExpectedConditions.presenceOfElementLocated(By.cssSelector("input[type='file']")));
            element.sendKeys(pathname);
        }
        driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(60));
    }


}
