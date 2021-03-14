package testImplementation;

import io.cucumber.java.en.And;
import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;
import lombok.Getter;
import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebElement;

import java.util.List;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertTrue;

@Getter
public class ImplementationShoppingCartFeature {
    BaseSetUp baseSetUp = new BaseSetUp(5);
    String productName;
    JavascriptExecutor js = (JavascriptExecutor) baseSetUp.driver;

    @Given("User accesses the Altex site")
    public void userAccessesTheAltexSite() {
        baseSetUp.mainPage.openWebsite();
        baseSetUp.mainPage.backToMainPage();
        baseSetUp.mainPage.getAcceptaBtn().click();
    }

    @When("User searches for a product and clicks on Cauta btn")
    public void userSearchesForAProductAndClicksOnCautaBtn() {
        String text = "televizor";
        baseSetUp.mainPage.getSearchFIeldBtn().sendKeys(text);
    }

    @And("Clicks on a product from the suggested list")
    public void clicksOnAProductFromTheSuggestedList() {
        WebElement firstElement = baseSetUp.productsPage.getFirstElementFromSearchFieldSuggestedList();
        productName = firstElement.getText();
        firstElement.click();
    }

    @And("Clicks on a product from the by clicking on Adauga in cos btn")
    public void clicksOnAdaugaInCosBtn() {
        js.executeScript("arguments[0].scrollIntoView(true);", baseSetUp.utilsButtons.getAdaugaInCosbtn());
        baseSetUp.utilsButtons.getAdaugaInCosbtn().click();
    }

    @Then("User clicks on Vezi cosul btn")
    public void userClickOnVeziCosulBtn() throws InterruptedException {
        baseSetUp.utils.scrollToBottomOfThePage();
        baseSetUp.utilsButtons.getVeziCosulbtn().click();
        baseSetUp.productsPage.getAssertProductDisplayedInTheShoppingCart().isDisplayed();

    }

    @And("Closes the browser")
    public void closesTheBrowser() {
        baseSetUp.driver.quit();
    }

    @And("Clicks on Inapoi btn")
    public void clicksOnInapoiBtn() throws InterruptedException {
        js.executeScript("arguments[0].scrollIntoView(true);", baseSetUp.utilsButtons.getInapoiBtnFromBasket());
        baseSetUp.utilsButtons.getInapoiBtnFromBasket().click();
    }

    @Then("User clicks on Cosul meu btn and then on X button")
    public void userClicksOnCosulMeuBtnAndThenOnXButton() throws InterruptedException {
        js.executeScript("arguments[0].scrollIntoView(true);", baseSetUp.mainPage.getCosulMeubtn());
        baseSetUp.mainPage.getCosulMeubtn().click();
        js.executeScript("arguments[0].scrollIntoView(true);", baseSetUp.utilsButtons.getCosulMeuXbtn());
        baseSetUp.utilsButtons.getCosulMeuXbtn().click();
    }

    @Then("User clicks on + sign 2 times and on - one time in order to increase and decrese the quantity of the products")
    public void userClickOnSignInOrderToIncreaseTheQuantityOfTheProducts() throws InterruptedException {
        baseSetUp.utilsButtons.getIncreaseNumberOfItemsBtnFromCosulMeu().click();
        Thread.sleep(3000);
        baseSetUp.utilsButtons.getIncreaseNumberOfItemsBtnFromCosulMeu().click();
        Thread.sleep(3000);
        baseSetUp.utilsButtons.getDecreaseNumberOfItemsBtnFromCosulMeu().click();
        Thread.sleep(3000);
        js.executeScript("arguments[0].scrollIntoView(true);", baseSetUp.utilsButtons.getDecreaseNumberOfItemsBtnFromCosulMeu());
        List<WebElement> cartItems = baseSetUp.driver.findElements(By.className("Cart-itemContainer"));
        for (WebElement cartItem :
                cartItems) {
            String cartItemText = cartItem.findElement(By.className("Media-link")).getText();
            if (cartItemText.contains(productName)) {
                WebElement quantity = cartItem.findElement(By.className("Cart-column--qty"));
                String value = quantity.findElement(By.className("u-space-p-5")).getText();
                assertEquals("2", value);
            }
        }
    }

    @When("User clicks on Cosul meu btn")
    public void userClicksOnCosulMeuBtn() {
        baseSetUp.mainPage.getCosulMeubtn().click();
    }

    @Then("User is prompted with a message saying that Nu exista produse and is not able to access the basket")
    public void userIsPromptedWithAMessageSayingThatNuExistaProduseAndIsNotAbleToAccessTheBasket() {
        baseSetUp.utilsButtons.getNuExistaProduseInCosMessage().isDisplayed();
    }


    @When("User navigates to Produse tab -> Electrocanice mari -> Uscatoare de rufe and adds a random product to the basket")
    public void userNavigatesToProduseTabElectrocaniceMariMasiniDeSpalatRufeAndAddsARandomProductToTheBasket() {
        baseSetUp.productCategories.getElectrocasniceMariInProduse().click();
        baseSetUp.productCategories.getCuptoareCuMicrounde().click();
        baseSetUp.productCategories.getAdaugaInCosCuptorCUMicrounde().click();
    }

    @And("User clicks on the Vezi cosul button")
    public void userClicksOnTheVeziCosulButton() throws InterruptedException {
        baseSetUp.utilsButtons.getVeziCosulbtn().click();
    }

    @And("User clicks on Acasa button located in the top left corner")
    public void userClicksOnAcasaButtonLocatedInTheTopLeftCorner() {
        baseSetUp.utilsButtons.getAcasaBtn().click();
    }

    @And("User clicks on Cosul meu button and a drop down opens")
    public void userClicksOnCosulMeuButtonAndADropDownOpens() {
        baseSetUp.mainPage.getCosulMeubtn().click();
    }

    @Then("User clicks on Vezi cosul button")
    public void userClicksOnVeziCosulButton() {
        baseSetUp.utilsButtons.getVeziCosulFromCosulMeu().click();
        baseSetUp.utilsButtons.getCosTitleFromBasket().isDisplayed();

    }

    @When("User navigates to telefoane and adds three products in the basket")
    public void userNavigatesToTelefoaneAndAddsProductsInTheBasket() throws InterruptedException {
        baseSetUp.productCategories.getTelefoaneTablete().click();
        baseSetUp.productCategories.getTelefoane().click();
        baseSetUp.productCategories.getAdaugaInCosTelefon1().click();
        js.executeScript("arguments[0].scrollIntoView(true);", baseSetUp.utilsButtons.getInapoiBtnFromBasket());
        baseSetUp.utilsButtons.getInapoiBtnFromBasket().click();
        baseSetUp.productCategories.getAdaugaInCosTelefon2().click();
        js.executeScript("arguments[0].scrollIntoView(true);", baseSetUp.utilsButtons.getInapoiBtnFromBasket());
        baseSetUp.utilsButtons.getInapoiBtnFromBasket().click();
        baseSetUp.productCategories.getAdaugaInCosTelefon3().click();
        js.executeScript("arguments[0].scrollIntoView(true);", baseSetUp.utilsButtons.getInapoiBtnFromBasket());
        baseSetUp.utilsButtons.getInapoiBtnFromBasket().click();

    }

    @And("User clicks on Cosul meu btn and then on Vezi cosul meu btn")
    public void userClickOnButtonAndADropDownOpens() {
        baseSetUp.mainPage.getCosulMeubtn().click();
        baseSetUp.utilsButtons.getVeziCosulFromCosulMeu().click();
    }

    @Then("User must see the added products in the basket")
    public void userMustSeeTheAddedProductsInTheBasket() {
        assertTrue(baseSetUp.productCategories.checkIfProductsArePresentInTheBasket());

    }

    @Then("User must see the added products in the drop-down basket")
    public void userMustSeeTheAddedProductsInTheDropDownBasket() {
        assertTrue(baseSetUp.productCategories.checkIfProductsArePresentInTheDropDownBasket());
    }
}
