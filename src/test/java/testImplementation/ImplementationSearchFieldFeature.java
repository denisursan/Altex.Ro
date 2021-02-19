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
import utils.MainPage;
import utils.Utils;

import java.util.concurrent.TimeUnit;

import static org.junit.jupiter.api.Assertions.assertTrue;

public class ImplementationSearchFieldFeature {
    BaseSetUp baseSetUp = new BaseSetUp(0);


    @Given("User accesses Altex site")
    public void userAccessesTheAltexSite() {
        baseSetUp.mainPage.openWebsite();
        baseSetUp.mainPage.backToMainPage();

    }

    @When("User inserts Laptop in the Search Field")
    public void userInsertsLaptopInTheSearchField() {
        String text = "Laptop";
       //   baseSetUp.mainPage.SearchFieldInput(text);
    }

    @Then("User receives laptop results")
    public void userReceivesLaptopResults() {
        // WebElement rezultateCautare = driver.findElement(By.xpath("//*[@id=\"__next\"]/div[3]/main/div[2]/div[1]/div[1]/h1"));
        //assertTrue(rezultateCautare.isDisplayed());
    }

    @And("Close browser")
    public void closeBrowser() {
        //  driver.quit();
    }
}
