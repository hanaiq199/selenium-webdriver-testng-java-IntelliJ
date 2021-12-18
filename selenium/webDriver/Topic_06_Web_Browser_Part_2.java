package webDriver;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.Assert;
import org.testng.annotations.AfterClass;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.Test;

import java.util.List;
import java.util.concurrent.TimeUnit;

public class Topic_06_Web_Browser_Part_2 {
    WebDriver driver;
    String projectPath = System.getProperty("user.dir");

    @BeforeClass
    public void beforeClass() {
        System.setProperty("webdriver.chrome.driver", projectPath + "/browserDrivers/chromedriver");
        driver = new ChromeDriver();
        driver.manage().timeouts().implicitlyWait(30, TimeUnit.SECONDS);

    }

    @Test
    public void TC_01_Verify_URL() {
        driver.get("http://live.techpanda.org");

        driver.findElement(By.xpath("//div[@class='footer']//a[@title='My Account']")).click();
        Assert.assertEquals(driver.getCurrentUrl(),"http://live.techpanda.org/index.php/customer/account/login/");

        driver.findElement(By.xpath("//a[@title='Create an Account']")).click();;
        Assert.assertEquals(driver.getCurrentUrl(),"http://live.techpanda.org/index.php/customer/account/create/");

    }

    @Test
    public void TC_02_Verify_Title() {
        driver.get("http://live.techpanda.org");

        driver.findElement(By.xpath("//div[@class='footer']//a[@title='My Account']")).click();
        Assert.assertEquals(driver.getTitle(),"Customer Login");

        driver.findElement(By.xpath("//a[@title='Create an Account']")).click();
        Assert.assertEquals(driver.getTitle(),"Create New Customer Account");
    }

    @Test
    public void TC_03_Navigate_Function() {
        driver.get("http://live.techpanda.org");
        driver.findElement(By.xpath("//div[@class='footer']//a[@title='My Account']")).click();
        driver.findElement(By.xpath("//a[@title='Create an Account']")).click();
        Assert.assertEquals(driver.getCurrentUrl(),"http://live.techpanda.org/index.php/customer/account/create/");

        driver.navigate().back();
        Assert.assertEquals(driver.getCurrentUrl(),"http://live.techpanda.org/index.php/customer/account/login/");

        driver.navigate().forward();
        Assert.assertEquals(driver.getTitle(),"Create New Customer Account");
    }

    @Test
    public void TC_04_Get_Page_Source_Code() {
        driver.get("http://live.techpanda.org");
        driver.findElement(By.xpath("//div[@class='footer']//a[@title='My Account']")).click();

        String loginPageSource = driver.getPageSource();
        Assert.assertTrue(loginPageSource.contains("Login or Create an Account"));

        driver.findElement(By.xpath("//a[@title='Create an Account']")).click();
        String createPageSource = driver.getPageSource();
        Assert.assertTrue(createPageSource.contains("Create an Account"));
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