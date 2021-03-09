package testImplementation;
import io.cucumber.java.en.And;
import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;
import java.util.concurrent.TimeUnit;
import static org.junit.jupiter.api.Assertions.assertTrue;
public class ImplementationLogInFeature {

    BaseSetUp baseSetUp = new BaseSetUp(7);
    @Given("^User accesses Altex website$")
    public void userAccessesAltexWebsite() {
        baseSetUp.mainPage.openWebsite();
        baseSetUp.mainPage.backToMainPage();
    }
    @When("^I enter valid username and valid password$")
    public void iEnterValidUsernameAndValidPassword() {
        baseSetUp.logInPage.insertValidUsernameAndPassword();
    }
    @Then("^The user is able to LogIn$")
    public void theUserIsAbleToLogIn() throws InterruptedException {
        Thread.sleep(3000);
        assertTrue(baseSetUp.mainPage.getComenzileMeleBtn().isDisplayed());
        Thread.sleep(3000);
    }
    @And("Closes browser")
    public void closesBrowser() {
       baseSetUp.driver.quit();
    }
    @When("I enter valid username and invalid password$")
    public void iEnterValidUsernameAndInvalidPassword() {
        baseSetUp.logInPage.inserUsernameAndInvalidPassword();
    }
    @Then("The user is not able to LogIn$")
    public void theUserIsNotAbleToLogIn() {
        assertTrue(baseSetUp.logInPage.getAutentificareBtn().isDisplayed());
    }
    @When("^I enter invalid username and valid password$")
    public void iEnterInvalidUsernameAndValidPassword() {
        baseSetUp.logInPage.inserInvalidUsernameAndValidPassword();
    }
    @And("^The user is able to Log Out$")
    public void theUserIsAbleToLogOut() throws InterruptedException {
        Thread.sleep(9000);
        baseSetUp.mainPage.getLogOutBtn().click();
    }
    @And("User clicks on back button")
    public void userClicksOnBackButton() {
        baseSetUp.driver.navigate().refresh();
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

    @Then("User enters valid username and valid password")
    public void userEntersValidUsernameAndValidPassword() {
        baseSetUp.logInPage.insertValidUsernameAndPasswordinAmDejaContsection();

    }

   @And("User is able to Log In")
    public void userIsAbleToLogIn() {
        baseSetUp.logInPage.getContulMeuButton().click();
       assertTrue(baseSetUp.mainPage.getComenzileMeleBtn().isDisplayed());
    }
}