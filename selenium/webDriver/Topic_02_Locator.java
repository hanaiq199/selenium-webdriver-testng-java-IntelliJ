package webDriver;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.annotations.AfterClass;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.Test;

import java.util.concurrent.TimeUnit;

public class Topic_02_Locator {
    WebDriver driver;
    String projectPath = System.getProperty("user.dir");

    @BeforeClass
    public void beforeClass() {
        System.setProperty("webdriver.chrome.driver", projectPath + "/browserDrivers/chromedriver");

        //Khởi tạo driver lên
        driver = new ChromeDriver();

        //Set thời gian để tìm được element
        driver.manage().timeouts().implicitlyWait(20, TimeUnit.SECONDS);

        //Mở trang facebook lên
        driver.get("https://www.facebook.com");

    }

    @Test
    public void TC_01() {
        driver.findElement(By.id("email")).sendKeys("hana@gmail.com");
        sleepInSecond(3);

        driver.findElement(By.name("pass")).sendKeys("123456");
        sleepInSecond(3);
    }

    @Test
    public void TC_02() {

    }

    @AfterClass
    public void afterClass() {
        driver.quit();
    }

    public void sleepInSecond(long second){
        try {
            Thread.sleep(second * 1000);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
    }
}