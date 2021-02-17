package testImplementation;

import io.cucumber.java.Before;
import io.cucumber.java.en.And;
import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;
import org.junit.jupiter.api.BeforeEach;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import utils.Utils;

import static org.junit.jupiter.api.Assertions.assertTrue;

public class ImplementationLogInFeature {
    WebDriver driver;
    Utils utils;

    @Before
    public void setup() {
        System.setProperty("webdriver.chrome.driver", "src/main/resources/seleniumdriver/chromedriver/chromedriver.exe");
        driver = new ChromeDriver();
        driver.manage().window().maximize();
        utils = new Utils(driver);
    }

    @Given("User accesses https://altex.ro/")
    public void userAccessesWwwAltexRo() {
        driver.get("https://altex.ro/");

    }

    @When("I enter valid username and valid password")
    public void iEnterValidUsernameAndValidPassword() throws InterruptedException {
        utils.inserUsernameAndPassword();
        Thread.sleep(6000);
    }

    @Then("The user is able to LogIn")
    public void theUserIsAbleToLogIn() {
        WebElement userButton = driver.findElement(By.xpath("//*[@id=\"__next\"]/div[2]/div[1]/div/div/div[2]/div[3]/div[1]/a/div[3]/span"));
        userButton.click();
        WebElement logInUserValidationButton = driver.findElement(By.xpath("//*[@id=\"__next\"]/div[2]/div[1]/div/div/div[2]/div[3]/div[1]/div/div[2]/div/ul/li[1]/a"));
        logInUserValidationButton.click();

    }

    @And("Closes browser")
    public void closesBrowser() {
        driver.quit();
    }


}
