package testImplementation;

import JUnitTests.Tests;
import org.junit.jupiter.api.Test;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import utils.*;

import java.util.concurrent.TimeUnit;

public class BaseSetUp {
    MainPage mainPage;
    WebDriver driver;
    LogInPage logInPage;
    ProductsPage productsPage;
    UtilsButtons utilsButtons;
    Utils utils;
    ProductCategories productCategories;
    SocialMediaButtons socialMediaButtons;

    public BaseSetUp(int wait) {
        System.setProperty("webdriver.chrome.driver", "src/main/resources/seleniumdriver/chromedriver/chromedriver 2");
        driver = new ChromeDriver();
        driver.manage().window().maximize();
        driver.manage().timeouts().implicitlyWait(wait, TimeUnit.SECONDS);
        logInPage = new LogInPage(driver);
        mainPage = new MainPage(driver);
        productsPage = new ProductsPage(driver);
        utilsButtons = new UtilsButtons(driver);
        utils = new Utils(driver);
        productCategories = new ProductCategories(driver);
        socialMediaButtons = new SocialMediaButtons(driver);
    }
}
