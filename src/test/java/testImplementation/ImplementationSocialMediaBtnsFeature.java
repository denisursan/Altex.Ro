package testImplementation;

import io.cucumber.java.en.And;
import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;
import org.openqa.selenium.JavascriptExecutor;

import java.util.Iterator;
import java.util.Set;

import static org.junit.jupiter.api.Assertions.assertEquals;

public class ImplementationSocialMediaBtnsFeature {

    BaseSetUp baseSetUp = new BaseSetUp(5);


    @Given("Open website")
    public void userAccessesTheAltexSite() throws InterruptedException {
        baseSetUp.mainPage.openWebsite();
        baseSetUp.mainPage.backToMainPage();



    }

    @When("User clicks on Facebook button")
    public void userClicksOnFacebookButton() {
        baseSetUp.utils.scrollToElement();
        baseSetUp.socialMediaButtons.getFacebookBtn().click();
    }

    @Then("The user is able to navigate on Facebook page")
    public void theUserIsAbleToNavigateOnFacebookPage() {
        baseSetUp.socialMediaButtons.openFacebookTab();
        String title = "Altex Romania - Home | Facebook";
        String actualTitle = baseSetUp.driver.getTitle();
        assertEquals(actualTitle, title);
    }

    @And("Close the page")
    public void closeThePage() {
        baseSetUp.driver.quit();
    }

    @When("User clicks on Twitter button")
    public void userClicksOnTwitterButton() {
        baseSetUp.utils.scrollToElement();
        baseSetUp.socialMediaButtons.getTwitterBtn().click();
    }

    @Then("The user is able to navigate on Twitter page")
    public void theUserIsAbleToNavigateOnTwitterPage() throws InterruptedException {
        baseSetUp.socialMediaButtons.openTwitterTab();
        Thread.sleep(3000);
        String title = "ALTEX (@AltexRO) / Twitter";
        String actualtitle = baseSetUp.driver.getTitle();
        assertEquals(actualtitle, title);

    }


    @When("User clicks on LinkedIn button")
    public void userClicksOnLinkedInButton() {
        baseSetUp.utils.scrollToElement();
        baseSetUp.socialMediaButtons.getLinkedInBtn().click();

    }

    @Then("The user is able to navigate on LinkedIn page")
    public void theUserIsAbleToNavigateOnLinkedInPage() {
        baseSetUp.socialMediaButtons.openLinkedInTab();
        String title = "ALTEX Romania | LinkedIn";
        assertEquals(title, baseSetUp.driver.getTitle());


    }

    @When("User clicks on Youtube button")
    public void userClicksOnYoutubeButton() {
        baseSetUp.utils.scrollToElement();
        baseSetUp.socialMediaButtons.getYoutubeBtn().click();
    }

    @Then("The user is able to navigate on Youtube page")
    public void theUserIsAbleToNavigateOnYoutubePage() {
        baseSetUp.socialMediaButtons.openYoutubeInTab();
        String title = "ALTEX Romania - YouTube";
        assertEquals(title,baseSetUp.driver.getTitle());



    }
}
