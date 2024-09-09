package pages;

import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.Assert;

import java.time.Duration;

public class ScalingPage {
    WebDriver driver;
    WebDriverWait wait;
    @FindBy(xpath = "//label[@for='upload' and contains(@class,'py-1')]")
    public WebElement upload;

    @FindBy(xpath = "//label[@for='upload' and contains(@class,'py-1')]//following-sibling::button[1]")
    public WebElement download;

    @FindBy(css = "button.px-10.blue-btn.text-center")
    public WebElement processButton;

    @FindBy(xpath = "//img[@alt='input']")
    public WebElement imagePreview;

    @FindBy(xpath = "//button[@type='submit']")
    public WebElement continueWithEmail;

    @FindBy(xpath = "//div[@class='spinner z-10']")
    public WebElement spinner;

   By recaptchaIframe = By.xpath("//iframe[@title='recaptcha challenge expires in two minutes']");

// This function tests the scaling process and then downloads the image after successful scaling process.
// It is assumed that in real project, the captcha would be disabled by the development team so that we
// can automate the scaling process. Also, the user should already be logged in.
// For this assignment I have added waits and done the captcha and email login manually and then clicked
// on the download button.
// This is a flaky test case as it cannot be fully automated.
    public void scalingSuccessful(){
        JavascriptExecutor js = (JavascriptExecutor) driver;
        Assert.assertTrue(upload.isDisplayed());
        System.out.println("Upload Button visible");
        Assert.assertTrue(imagePreview.isDisplayed());
        try {
            wait = new WebDriverWait(driver, Duration.ofMinutes(2));
            js.executeScript("arguments[0].scrollIntoView(true);", processButton);
            js.executeScript("document.querySelector('button.px-10.blue-btn.text-center').click();");
            driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(60));
            if (driver.findElement(recaptchaIframe).isDisplayed()) {
                WebElement recaptchaIframe1 = wait.until(ExpectedConditions.presenceOfElementLocated(recaptchaIframe));
                driver.switchTo().frame(recaptchaIframe1);
                wait.until(ExpectedConditions.invisibilityOf(recaptchaIframe1));
                driver.switchTo().defaultContent();
            }
//            else {
//                wait.until(ExpectedConditions.visibilityOf(continueWithEmail));
//                if (continueWithEmail.isDisplayed())
//                    wait.until(ExpectedConditions.invisibilityOf(continueWithEmail));
//            }

        } catch (Exception e) {
            e.printStackTrace();
        }

        Assert.assertTrue(download.isEnabled());
        System.out.println("Download button visible");
        download.click();
    }
    public ScalingPage(WebDriver driver) {
        this.driver = driver;
        PageFactory.initElements(driver, this);
    }
}
