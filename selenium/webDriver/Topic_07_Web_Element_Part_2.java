package webDriver;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.testng.Assert;
import org.testng.annotations.AfterClass;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.Test;

import java.util.concurrent.TimeUnit;

public class Topic_07_Web_Element_Part_2 {
    WebDriver driver;
    String projectPath = System.getProperty("user.dir");

    @BeforeClass
    public void beforeClass() {
        System.setProperty("webdriver.gecko.driver", projectPath + "/browserDrivers/geckodriver");
        driver = new FirefoxDriver();
        driver.manage().timeouts().implicitlyWait(30, TimeUnit.SECONDS);
    }

    @Test
    public void TC_01_isDisplayed() {
        driver.get("https://automationfc.github.io/basic-form/index.html");

        WebElement emailTextbox = driver.findElement(By.xpath("//input[@id='mail']"));
        if (emailTextbox.isDisplayed()){
            System.out.println("Email textbox is displayed");
            emailTextbox.sendKeys("Automation Testing");
        } else {
            System.out.println("Email textbox is not displayed");
        }

        WebElement ageUnder18radio = driver.findElement(By.id("under_18"));
        if (ageUnder18radio.isDisplayed()){
            System.out.println("Age under 18 is displayed");
            ageUnder18radio.click();
        } else {
            System.out.println("Age under 18 is not displayed");
        }

        WebElement education = driver.findElement(By.id("edu"));
        if (education.isDisplayed()){
            System.out.println("Education is displayed");
            education.sendKeys("Automation Testing");
        } else{
            System.out.println("Education is not displayed");
        }

        WebElement name = driver.findElement(By.xpath("//h5[text()='Name: User5']"));
        if (name.isDisplayed()){
            System.out.println("Name is displayed");
        } else{
            System.out.println("Name is not displayed");
        }

    }

    @Test
    public void TC_02_Enable_Disable() {
        driver.get("https://automationfc.github.io/basic-form/index.html");

        WebElement emailTextbox = driver.findElement(By.id("email"));
        if (emailTextbox.isEnabled()){
            System.out.println("Email is enable");
        } else{
            System.out.println("Email is disable");
        }

        WebElement ageUnder18radio = driver.findElement(By.id("under_18"));
        if (ageUnder18radio.isEnabled()){
            System.out.println("Age under 18 is enable");
        } else {
            System.out.println("Age under 18 is disable");
        }

        WebElement education = driver.findElement(By.id("edu"));
        if (education.isEnabled()){
            System.out.println("Education is enable");
        } else{
            System.out.println("Education is disable");
        }

        WebElement job1 = driver.findElement(By.id("job1"));
        if (job1.isEnabled()){
            System.out.println("Job 1 is enable");
        } else{
            System.out.println("Job 1 is disable");
        }

        WebElement job2 = driver.findElement(By.id("job2"));
        if (job2.isEnabled()){
            System.out.println("Job 2 is enable");
        } else{
            System.out.println("Job 2 is disable");
        }

        WebElement interest_development = driver.findElement(By.id("development"));
        if (interest_development.isEnabled()){
            System.out.println("Interest development checkbox is enable");
        } else{
            System.out.println("Interest development checkbox is disable");
        }

        WebElement slider1 = driver.findElement(By.id("slider-1"));
        if (slider1.isEnabled()){
            System.out.println("Slider 1 is enable");
        } else{
            System.out.println("Slider 1 is disable");
        }
    }

    @Test
    public void TC_03_Selected() {
        driver.get("https://automationfc.github.io/basic-form/index.html");


    }

    @Test
    public void TC_04_MailChimp() {
        driver.get("https://login.mailchimp.com/signup/");

        driver.findElement(By.id("email")).sendKeys("hana1992@gmail.com");
        driver.findElement(By.id("new_username")).sendKeys("Hana");

        WebElement passwordTextbox = driver.findElement(By.id("new_password"));
        WebElement signupBtn = driver.findElement(By.id("create-account"));


        //1 Lower-case
        passwordTextbox.sendKeys("a");
        //Expected
        Assert.assertTrue(driver.findElement(By.xpath("//li[@class='lowercase-char completed']")).isEnabled());
        Assert.assertFalse(signupBtn.isEnabled());
        sleepInSecond(3);

        // 2 Upper case
        passwordTextbox.clear();
        passwordTextbox.click();
        passwordTextbox.sendKeys("AUTO");
        Assert.assertTrue(driver.findElement(By.xpath("//li[@class='uppercase-char completed']")).isDisplayed());
        Assert.assertFalse(signupBtn.isEnabled());
        sleepInSecond(3);

        // 3 Number
        passwordTextbox.clear();
        passwordTextbox.click();
        passwordTextbox.sendKeys("1234");
        Assert.assertTrue(driver.findElement(By.xpath("//li[@class='number-char completed']")).isDisplayed());
        Assert.assertFalse(signupBtn.isEnabled());
        sleepInSecond(3);

        // 4 special char
        passwordTextbox.clear();
        passwordTextbox.click();
        passwordTextbox.sendKeys("!@#$%");
        Assert.assertTrue(driver.findElement(By.xpath("//li[@class='special-char completed']")).isDisplayed());
        //Assert.assertTrue(driver.findElement(By.xpath("//li[text()='One special character']")).isDisplayed());
        Assert.assertFalse(signupBtn.isEnabled());
        sleepInSecond(3);

        // 5 eight char
        passwordTextbox.clear();
        passwordTextbox.click();
        passwordTextbox.sendKeys("12345678");
        Assert.assertTrue(driver.findElement(By.xpath("//li[@class='8-char completed']")).isDisplayed());
        Assert.assertFalse(signupBtn.isEnabled());
        sleepInSecond(3);

        // 6 combine
        passwordTextbox.clear();
        passwordTextbox.click();
        passwordTextbox.sendKeys("Auto123!@#");
        Assert.assertTrue(driver.findElement(By.xpath("//h4[text()=\"Your password is secure and you're all set!\"]")).isDisplayed());
        Assert.assertTrue(signupBtn.isEnabled());
        sleepInSecond(3);
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