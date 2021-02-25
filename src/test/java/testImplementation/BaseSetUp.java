package testImplementation;
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

    BaseSetUp(int wait) {
        System.setProperty("webdriver.chrome.driver", "src/main/resources/seleniumdriver/chromedriver/chromedriver.exe");
        driver = new ChromeDriver();
        driver.manage().window().maximize();
        driver.manage().timeouts().implicitlyWait(wait, TimeUnit.SECONDS);
        logInPage= new LogInPage(driver);
        mainPage = new MainPage(driver);
        productsPage= new ProductsPage(driver);
        utilsButtons = new UtilsButtons(driver);
        utilsButtons = new UtilsButtons(driver);
    }
}
