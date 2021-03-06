package testImplementation;

import io.cucumber.java.en.And;
import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;
import org.openqa.selenium.By;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

import static org.junit.jupiter.api.Assertions.assertTrue;

public class ImplementationLogInFeature {

    BaseSetUp baseSetUp = new BaseSetUp(7);
    WebDriverWait wait = new WebDriverWait(baseSetUp.driver, 8);

    @Given("^User accesses Altex website$")
    public void userAccessesAltexWebsite() {
        baseSetUp.mainPage.openWebsite();
        baseSetUp.mainPage.backToMainPage();
    }

    @When("^I enter valid email (.*) and valid password (.*)$")
    public void iEnterValidUsernameAndValidPassword(String email, String pass) {
        baseSetUp.logInPage.insertEmailAndPassword(email, pass);
    }

    @Then("^The user is able to LogIn$")
    public void theUserIsAbleToLogIn() {
        wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath("//*[@id=\"__next\"]/div[2]/div[1]/div/div/div[2]/div[3]/div[1]/div/div[2]/div/ul/li[4]/a")));
        assertTrue(baseSetUp.mainPage.getComenzileMeleBtn().isDisplayed());
    }

    @And("Closes browser")
    public void closesBrowser() {
        baseSetUp.driver.quit();
    }

    @When("^I enter valid email (.*) and invalid password (.*)$")
    @When("^I enter invalid email (.*) and valid password (.*)")
    public void iEnterValidUsernameAndInvalidPassword(String email, String password) {
        baseSetUp.logInPage.insertEmailAndPassword(email, password);
    }

    @Then("The user is not able to LogIn$")
    public void theUserIsNotAbleToLogIn() {
        assertTrue(baseSetUp.logInPage.getAutentificareBtn().isDisplayed());
    }


    @And("^The user is able to Log Out$")
    public void theUserIsAbleToLogOut()  {
        wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath("//*[@id=\"__next\"]/div[2]/div[1]/div/div/div[2]/div[3]/div[1]/div/div[2]/div/ul/li[11]/a")));
        baseSetUp.mainPage.getLogOutBtn().click();
    }

    @And("User clicks on back button")
    public void userClicksOnBackButton() throws InterruptedException {
        // ((IJavaScriptExecutor)webDriver).ExecuteScript("history.go(-1);", new Object[0]);
        // wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath("//*[@id=\"__next\"]/div[2]/div[1]/div/div/div[2]/div[3]/div[1]/div/div[2]/div/form/div[3]/span/button/div/div/div")));
        Thread.sleep(3000);
        baseSetUp.driver.navigate().back();
    }

    @And("The user is not able to LogIn back")
    public void theUserIsNotAbleToLogInBack() {
        baseSetUp.logInPage.getContulMeuButton().click();
        assertTrue(baseSetUp.logInPage.getAutentificareButton().isDisplayed());
    }

    @When("User clicks Contul meu btn")
    public void userClicksContulMeuBtn() {
        baseSetUp.logInPage.getContulMeuButton().click();

    }

    @And("User clicks on Inregistrare btn")
    public void userClicksOnInregistrareBtn() {
        baseSetUp.logInPage.getInregistrareBtn().click();
    }

    @Then("^When I enter valid email (.*) and valid password (.*)$")
    public void userEntersValidUsernameAndValidPassword(String email,String password) {
        baseSetUp.logInPage.insertValidUsernameAndPasswordinAmDejaContsection(email,password);

    }

    @And("User is able to Log In")
    public void userIsAbleToLogIn(){
        wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath("//*[@id=\"__next\"]/div[2]/div[1]/div/div/div[2]/div[3]/div[1]/a/div[3]/span")));
        baseSetUp.logInPage.getContulMeuButton().click();
        assertTrue(baseSetUp.mainPage.getComenzileMeleBtn().isDisplayed());
    }
}