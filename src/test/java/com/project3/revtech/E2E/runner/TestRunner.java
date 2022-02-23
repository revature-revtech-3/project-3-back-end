package com.project3.revtech.E2E.runner;

import com.project3.revtech.E2E.poms.*;
import io.cucumber.junit.Cucumber;
import io.cucumber.junit.CucumberOptions;
import org.junit.AfterClass;
import org.junit.BeforeClass;
import org.junit.runner.RunWith;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.ui.WebDriverWait;

import java.io.File;
import java.util.concurrent.TimeUnit;

@RunWith(Cucumber.class)
    @CucumberOptions(features = "classpath:features", glue = "com.project3.revtech.E2E.steps", plugin = {"pretty",
            "html:src/test/java/resources/reports/html-reports.html"})
    public class TestRunner {
    public static WebDriver driver;
    public static WebDriverWait explicitWait;
    public static WebDriverWait implicitWait;
    public static UserRegisterPOM userRegisterPOM;
    public static UserLoginPOM userLoginPOM;
    public static UserLogoutPOM userLogoutPOM;
    public static UserSearchProductsPOM userSearchProductsPOM;
    public static PutItemInCartPOM putItemInCartPOM;
    public static PurchaseDiscountedPOM purchaseDiscountedPOM;


    @BeforeClass
    public static void setup() {
        File file = new File("src/test/resources/chromedriver.exe");
        System.setProperty("webdriver.chrome.driver", file.getAbsolutePath());
        driver = new ChromeDriver();
        driver.manage().window().maximize();
        explicitWait = new WebDriverWait(driver, 10);
        implicitWait = new WebDriverWait(driver, 5);
        driver.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);
        userRegisterPOM = new UserRegisterPOM(driver);
        userLoginPOM = new UserLoginPOM(driver);
        userLogoutPOM = new UserLogoutPOM(driver);
        userSearchProductsPOM = new UserSearchProductsPOM(driver);
        putItemInCartPOM = new PutItemInCartPOM(driver);
        purchaseDiscountedPOM = new PurchaseDiscountedPOM(driver);

        System.out.println("Set up complete!");
    }

    @AfterClass
    public static void teardown(){
        driver.quit();
        System.out.println("teardown complete!");
    }
}


