package test_implementation;

import io.github.bonigarcia.wdm.WebDriverManager;
import org.apache.commons.io.FileUtils;
import org.apache.log4j.Logger;
import org.openqa.selenium.OutputType;
import org.openqa.selenium.TakesScreenshot;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.edge.EdgeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.testng.annotations.*;

import java.io.File;
import java.io.FileReader;
import java.io.IOException;
import java.time.Duration;
import java.util.Date;
import java.util.Properties;
import java.util.concurrent.TimeUnit;

public class Base {
    public static WebDriver driver;

    private static final Logger log = Logger.getLogger(Base.class);

// The setup method instantiates the Webdriver object on the basis of browser parameter, launches the
// browser, maximizes it and load the url from the properties file.
    @Parameters("browser")
    @BeforeMethod
    public void setup(String browser) throws IOException {
        log.info("------------Tests Started-------------");
        if (browser.equalsIgnoreCase("chrome")) {

            WebDriverManager.chromedriver().setup();
            driver = new ChromeDriver();
            driver.manage().window().maximize();
            driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(30));
            getProperties(driver);


        }
//        if (browser.equalsIgnoreCase("edge")){
//
//            WebDriverManager.edgedriver().setup();
//            driver = new EdgeDriver();
//            driver.manage().window().maximize();
//            driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(30));
//            getProperties(driver);
//        }
//        if (browser.equalsIgnoreCase("firefox")){
//
//            WebDriverManager.firefoxdriver().setup();
//            driver = new FirefoxDriver();
//            driver.manage().window().maximize();
//            driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(30));
//            getProperties(driver);
//        }
    }

// This function quits the driver after all the tests are completed.
//    @AfterTest
//    public void teardown(){
//        driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(30));
//        driver.quit();
//        log.info("-------------Test Ended------------");
//
//    }
// This function is used to fetch the configuration properties from the properties file for the project. Currently
//  it is fetching the URL of the webpage
    public void getProperties(WebDriver driver) throws IOException {
        Properties properties = new Properties();
        properties.load(new FileReader("src/main/resources/config.properties"));
        driver.get(properties.getProperty("URL"));
    }
//    This function captures the screenshots of any webpage. It is being called in the TestStatusListener class
// to capture the screenshots onFailure of any test case and attach those screenshots to the Allure Report.
    public void FailedScreenshot (String testMethodName) {
        File srcFile  = ((TakesScreenshot) driver).getScreenshotAs(OutputType.FILE);
        Date date  = new Date();
        String TimeStamp =date.toString().replace(":", "_").replace(" ", "_");
        System.out.println(TimeStamp);
        try {
            String file = new File("screenshots/"+ testMethodName +"_"+TimeStamp+ ".jpg").getAbsolutePath();
            System.out.println(file);
            FileUtils.copyFile(srcFile, new File(file));
        } catch (IOException e) {
            e.printStackTrace();
        }
    }
}