package testImplementation;
<<<<<<< HEAD

import io.cucumber.java.Before;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.ui.WebDriverWait;
import utils.LogInPage;
import utils.Utils;
import utils1.MainPage;
=======
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import utils.LogInPage;
import utils.MainPage;
import utils.ProductsPage;
>>>>>>> Branch-Denis

import java.util.concurrent.TimeUnit;

public class BaseSetUp {
<<<<<<< HEAD
    WebDriver driver;
    Utils utils;
    MainPage mainPage;
    LogInPage logInPage;


    BaseSetUp(int wait){
           System.setProperty("webdriver.chrome.driver", "src/main/resources/seleniumdriver/chromedriver/chromedriver 2");
           driver = new ChromeDriver();
           driver.manage().window().maximize();
           utils = new Utils(driver);
           driver.manage().timeouts().implicitlyWait(wait, TimeUnit.SECONDS);
           mainPage = new MainPage(driver);
           logInPage = new LogInPage(driver);

       }
   }

    MainPage mainPage;
    WebDriver driver;
    LogInPage logInPage;
    ProductsPage productsPage;

    BaseSetUp(int wait) {
        System.setProperty("webdriver.chrome.driver", "src/main/resources/seleniumdriver/chromedriver/chromedriver 2");
        driver = new ChromeDriver();
        driver.manage().window().maximize();
        driver.manage().timeouts().implicitlyWait(wait, TimeUnit.SECONDS);
        logInPage= new LogInPage(driver);
        mainPage = new MainPage(driver);
        productsPage= new ProductsPage(driver);
    }
}

