package pages;

import lombok.Getter;
import lombok.Setter;
import org.openqa.selenium.*;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.Assert;
import java.time.Duration;
import java.util.List;

@Getter
@Setter
public class DashboardPage {
   WebDriver driver;
    WebDriverWait wait;
    @FindBy(xpath = "//button[contains(text(),'Get a Demo')]")
    public WebElement getaDemoButton;

    @FindBy(xpath="//*[@href='https://www.spyne.ai/']")
    public WebElement logo;

    @FindBy(xpath = "//button[contains(@class,'py-3 rounded-2xl')]")
    public List<WebElement> scalingOptions;

// This function checks that different resizing options are present on the screen - https://www.spyne.ai/image-upscaler/result
    public void fetchScalingOptions(){
        for(WebElement webElement: scalingOptions)
            Assert.assertTrue(webElement.isDisplayed());
    }

    public void errorMessageInvalidFormat(){

           wait = new WebDriverWait(driver, Duration.ofSeconds(30));
           WebElement errorMessage = wait.until(ExpectedConditions.visibilityOfElementLocated(By.cssSelector(".error-Message")));
           Assert.assertTrue(errorMessage.isDisplayed(), "Error message for invalid file format is not displayed");
    }

// This function verifies different UI elements on the webpage - https://www.spyne.ai/image-upscaler
    public void verifyDashboardUIField(){
        try {
            Assert.assertTrue(getaDemoButton.isDisplayed());
            Assert.assertTrue(logo.isDisplayed());
        }catch (StaleElementReferenceException e){
            Assert.assertTrue(getaDemoButton.isDisplayed());
            Assert.assertTrue(logo.isDisplayed());

        }

    }

    public DashboardPage(WebDriver driver) {
        this.driver = driver;
        PageFactory.initElements(driver, this);
    }

}
