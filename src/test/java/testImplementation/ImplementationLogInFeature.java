package testImplementation;
import io.cucumber.java.en.And;
import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;
import java.util.concurrent.TimeUnit;
import static org.junit.jupiter.api.Assertions.assertTrue;

public class ImplementationLogInFeature {

    public ImplementationLogInFeature(){}

    BaseSetUp baseSetUp = new BaseSetUp(0);

    @Given("^User accesses Altex website$")
    public void userAccessesAltexWebsite() {
        baseSetUp.mainPage.openWebsite();
        baseSetUp.mainPage.backToMainPage();
    }

    @When("^I enter valid username and valid password$")
    public void iEnterValidUsernameAndValidPassword() {
        baseSetUp.logInPage.insertValidUsernameAndPassword();
        baseSetUp.driver.manage().timeouts().implicitlyWait(6, TimeUnit.SECONDS);
    }

    @Then("^The user is able to LogIn$")
    public void theUserIsAbleToLogIn() {
        assertTrue(baseSetUp.mainPage.getComenzileMeleBtn().isDisplayed());
    }

    @And("^Closes browser$")
    public void closesBrowser() {
        //  driver.quit();
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
    public void theUserIsAbleToLogOut() {

        assertTrue(baseSetUp.mainPage.getLogOutBtn().isDisplayed());
    }
}




