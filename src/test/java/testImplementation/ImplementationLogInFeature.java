package testImplementation;

import io.cucumber.java.Before;
import io.cucumber.java.en.And;
import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;
import lombok.Getter;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.ui.WebDriverWait;
import utils.LogInPage;
import utils1.MainPage;
import utils.Utils;

import java.util.concurrent.TimeUnit;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertTrue;

@Getter
public class ImplementationLogInFeature {

    BaseSetUp baseSetUp = new BaseSetUp(5);

    @Given("User accesses Altex Website")
    public void userAccessesAltexWebsite() {
        // mainPage.openWebsite();
        baseSetUp.driver.get("https://altex.ro/");
        baseSetUp.mainPage.backToMainPage();

    }

    @When("I enter valid username and valid password")
    public void iEnterValidUsernameAndValidPassword() throws InterruptedException {
        baseSetUp.logInPage.insertValidUsernameAndPassword();
        Thread.sleep(6000);
    }

    @Then("The user is able to LogIn")
    public void theUserIsAbleToLogIn() throws InterruptedException {
        WebElement comenzileMele = baseSetUp.driver.findElement(By.xpath("//*[@id=\"__next\"]/div[2]/div[1]/div/div/div[2]/div[3]/div[1]/div/div[2]/div/ul/li[4]/a"));
        assertTrue(comenzileMele.isDisplayed());
    }

    @And("Closes browser")
    public void closesBrowser() {
        //  driver.quit();
    }


    @When("I enter valid username and invalid password")
    public void iEnterValidUsernameAndInvalidPassword() {
        baseSetUp.logInPage.inserUsernameAndInvalidPassword();
    }

    @Then("The user is not able to LogIn")
    public void theUserIsNotAbleToLogIn() {
        WebElement autentificareButton = baseSetUp.driver.findElement(By.xpath("//*[@id=\"__next\"]/div[2]/div[1]/div/div/div[2]/div[3]/div[1]/div/div[2]/div/form/div[3]/span/button/div/div/div"));
        assertTrue(autentificareButton.isDisplayed());
    }


    @When("I enter invalid username and valid password")
    public void iEnterInvalidUsernameAndValidPassword() {
        baseSetUp.logInPage.inserInvalidUsernameAndValidPassword();
    }

    @And("The user is able to Log Out")
    public void theUserIsAbleToLogOut() {
        WebElement logOutButton = baseSetUp.driver.findElement(By.xpath("//*[@id=\"__next\"]/div[2]/div[1]/div/div/div[2]/div[3]/div[1]/div/div[2]/div/ul/li[11]/a"));
        logOutButton.click();

        WebElement LogInButton = baseSetUp.driver.findElement(By.xpath("//*[@id=\"__next\"]/div[3]/main/div[2]/div/div/form/div[3]/button/div/div/div"));
        assertTrue(LogInButton.isDisplayed());

        WebElement emailField =baseSetUp.driver.findElement(By.xpath("//*[@id=\"__next\"]/div[3]/main/div[2]/div/div/form/input[1]"));
        assertTrue(emailField.isDisplayed());

    }

}




