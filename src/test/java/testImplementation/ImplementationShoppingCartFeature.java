package testImplementation;

import io.cucumber.java.en.And;
import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;
import lombok.Getter;
import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;

import javax.sql.rowset.WebRowSet;
import java.util.List;
import java.util.Locale;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertTrue;

@Getter
public class ImplementationShoppingCartFeature {
    BaseSetUp baseSetUp = new BaseSetUp(5);

    @Given("User accesses the Altex site")
    public void userAccessesTheAltexSite() {
        baseSetUp.mainPage.openWebsite();
        baseSetUp.mainPage.backToMainPage();

    }

    @When("User searches for a product and clicks on Cauta btn")
    public void userSearchesForAProductAndClicksOnCautaBtn() {
        String text = "televizor";
        baseSetUp.mainPage.getSearchFIeldBtn().sendKeys(text);
    }

    @And("Clicks on a product from the suggested list")
    public void clicksOnAProductFromTheSuggestedList() {
        baseSetUp.productsPage.getFirstElementFromSearchFieldSuggestedList().click();
    }

    @And("Clicks on a product from the by clicking on Adauga in cos btn")
    public void clicksOnAdaugaInCosBtn() {
        baseSetUp.utilsButtons.getAdaugaInCosbtn().click();
    }

    @Then("User clicks on Vezi cosul btn")
    public void userClickOnVeziCosulBtn() throws InterruptedException {
        Thread.sleep(3000);
        baseSetUp.utilsButtons.getVeziCosulbtn().click();
        baseSetUp.productsPage.getAssertProductDisplayedInTheShoppingCart().isDisplayed();

    }

    @And("Closes the browser")
    public void closesTheBrowser() {
        baseSetUp.driver.quit();
    }

    @And("Clicks on Inapoi btn")
    public void clicksOnInapoiBtn() {
        baseSetUp.utilsButtons.getInapoiButton().click();
    }

    @Then("User clicks on Cosul meu btn and then on X button")
    public void userClicksOnCosulMeuBtnAndThenOnXButton() throws InterruptedException {
        Thread.sleep(3000);
        baseSetUp.mainPage.getCosulMeubtn().click();
        Thread.sleep(3000);
        baseSetUp.utilsButtons.getCosulMeuXbtn().click();
    }

    @Then("User clicks on + sign 2 times and on - one time in order to increase and decrese the quantity of the products")
    public void userClickOnSignInOrderToIncreaseTheQuantityOfTheProducts() throws InterruptedException {
        baseSetUp.utilsButtons.getIncreaseNumberOfItemsBtnFromCosulMeu().click();
        baseSetUp.utilsButtons.getIncreaseNumberOfItemsBtnFromCosulMeu().click();
        baseSetUp.utilsButtons.getDereaseNumberOfItemsBtnFromCosulMeu().click();
        Thread.sleep(3000);
        int counter = baseSetUp.utilsButtons.getNumberOfItemsFromTheBasket();
        assertEquals(counter, 2);

    }
}
