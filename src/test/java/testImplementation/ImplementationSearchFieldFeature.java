package testImplementation;

import io.cucumber.java.Before;
import io.cucumber.java.en.And;
import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;
import org.junit.BeforeClass;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.ui.WebDriverWait;
import utils.LogInPage;
import utils1.MainPage;
import utils.Utils;

import java.util.concurrent.TimeUnit;

import static org.junit.jupiter.api.Assertions.assertTrue;

public class ImplementationSearchFieldFeature {
    WebDriver driver;
    Utils utils;
    WebDriverWait wait;
    MainPage mainPage;
    LogInPage logInPage;

    @BeforeClass
    public void setup() {
        System.setProperty("webdriver.chrome.driver", "src/main/resources/seleniumdriver/chromedriver/chromedriver.exe");
        driver = new ChromeDriver();
        driver.manage().window().maximize();
        utils = new Utils(driver);
        wait = new WebDriverWait(driver, 10);
        driver.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);
        mainPage = new MainPage(driver);
        logInPage = new LogInPage(driver);

    }

    @Given("User accesses the Altex Website")
    public void userAccessesTheAltexWebsite() {
        mainPage.openWebsite();
        mainPage.backToMainPage();
    }

    @When("User inserts Laptop in the Search Field")
    public void userInsertsLaptopInTheSearchField() {
        String text = "Laptop";
        mainPage.SearchFieldInput(text);
    }

    @Then("User receives laptop results")
    public void userReceivesLaptopResults() {
        WebElement rezultateCautare = driver.findElement(By.xpath("//*[@id=\"__next\"]/div[3]/main/div[2]/div[1]/div[1]/h1"));
        assertTrue(rezultateCautare.isDisplayed());
    }

    @And("Close browser")
    public void closeBrowser() {
        //  driver.quit();
    }


}
