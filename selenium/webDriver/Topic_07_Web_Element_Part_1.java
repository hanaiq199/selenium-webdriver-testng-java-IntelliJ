package webDriver;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.Assert;
import org.testng.annotations.AfterClass;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.Test;

import java.util.concurrent.TimeUnit;

public class Topic_07_Web_Element_Part_1 {
    WebDriver driver;
    String projectPath = System.getProperty("user.dir");

    @BeforeClass
    public void beforeClass() {
        System.setProperty("webdriver.chrome.driver", projectPath + "/browserDrivers/chromedriver");
        driver = new ChromeDriver();
        driver.manage().timeouts().implicitlyWait(30, TimeUnit.SECONDS);
        driver.get("http://live.techpanda.org/index.php/customer/account/login/");
    }

    @Test
    public void TC_01() {
        // Hàm tìm 1 element (số ít) - trả về 1
        // Chỉ dùng duy nhất 1 lần
        // driver.findElement(By.id("email")).sendKeys("hanaiq1992@gmail.com");

        // Dùng lại nhiều lần cùng một thời điểm liên tiếp nhau
        // WebElement emailTextbox = driver.findElement(By.id("email"));
        // emailTextbox.clear();
       //  emailTextbox.sendKeys("hanaiq1992@gmail.com");

        WebElement element = driver.findElement(By.id("email"));

        // Xoá dữ liệu ở field text editable
        element.clear();

        // Nhập dữ liệu vào filed editable
        element.sendKeys("hanaiq1992@gmail.com");

        // So sánh text
        // element.getAttribute("placeholder");
        Assert.assertEquals(element.getAttribute("placeholder"),"Search entire store here...");

        // Gui: lấy ra thuộc tính CSS
       // element.getCssValue();

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