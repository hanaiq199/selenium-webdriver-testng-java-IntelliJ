package webDriver;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.testng.annotations.AfterClass;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.Test;

import java.util.concurrent.TimeUnit;

public class Topic_03_Run_On_Multiple_Browser {
    WebDriver driver;
    String projectPath = System.getProperty("user.dir");



    @Test
    public void TC_01_Firefox() {
        System.setProperty("webdriver.gecko.driver", projectPath + "/browserDrivers/geckodriver");
        driver = new FirefoxDriver();
        driver.get("https://www.facebook.com/");
        driver.quit();
    }

    @Test
    public void TC_02_Chrome() {
        System.setProperty("webdriver.chrome.driver", projectPath + "/browserDrivers/chromedriver");
        driver = new ChromeDriver();
        driver.get("https://www.facebook.com/");
        driver.quit();
    }

    @Test
    public void TC_03_Edge() {

    }


}