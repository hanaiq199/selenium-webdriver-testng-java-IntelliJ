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

public class Topic_04_Browser_Element_Method {
    WebDriver driver;
    String projectPath = System.getProperty("user.dir");

    @BeforeClass
    public void beforeClass() {
        System.setProperty("webdriver.chrome.driver", projectPath + "/browserDrivers/chromedriver");
        driver = new ChromeDriver();
        driver.manage().timeouts().implicitlyWait(30, TimeUnit.SECONDS);
    }

    @Test
    public void TC_01_Browser() {
        // Action lên browser: open browser, open url, refresh, back, forward, maximize, minimize, fullscreen ....

        //Lấy dữ liệu ra từ browser: get url, get title, get source page, get position, get location

        //Các hàm thao tác với browser thông qua biến driver

        // hàm nào để tương tác 100% là void, không cần trả về
        // action mở URL
        //driver.get("https://www.facebook.com");

        // hàm nào lấy dữ liệu ra để verify (đúng/ sai/ bằng với mong muốn hay không) - 100% phải trả về dữ liệu

        // Mở một page URL
        driver.get("https://www.facebook.com");

        // Đóng trình duyệt nếu chỉ có 1 tab
        // Đóng acive tab nếu như trình duyệt đang có nhiều tab
        driver.close();

        // Đóng hết cả trình duyệt, không quan tâm tab/ window
        driver.quit();

        //Trả về URL của page hiện tại
        driver.getCurrentUrl();

        //Trả về page source code (HTML/ CSS/ JS/ ...)
        //Verify tương đối
        driver.getPageSource();

        //Trả về title của page hiện tại
        driver.getTitle();

        //Trả về window id của tab hiện tại
        driver.getWindowHandle();

        //Trả về window id của tất cả các tab
        driver.getWindowHandles();

        // Chờ cho element được tìm thấy trong 15s
        driver.manage().timeouts().implicitlyWait(15, TimeUnit.SECONDS);

        driver.manage().window().maximize();
    }

    @Test
    public void TC_02_Element() {
        //Các hàm thao tác với element thông qua biến element
        WebElement emailTextbox = driver.findElement(By.id("email"));

        emailTextbox.clear();
        emailTextbox.sendKeys("hana@gmail.com");
        emailTextbox.click();
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