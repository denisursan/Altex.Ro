package testImplementation;

import io.cucumber.java.Before;
import io.cucumber.java.en.And;
import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;
import org.junit.BeforeClass;
import org.openqa.selenium.By;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.ui.WebDriverWait;
import utils.LogInPage;
import utils.MainPage;
import utils.Utils;

import java.util.List;
import java.util.Locale;
import java.util.concurrent.TimeUnit;

import static org.junit.jupiter.api.Assertions.assertTrue;

public class ImplementationSearchFieldFeature {
    BaseSetUp baseSetUp = new BaseSetUp(5);


    @Given("User accesses Altex site")
    public void userAccessesTheAltexSite() {
        baseSetUp.mainPage.openWebsite();
        baseSetUp.mainPage.backToMainPage();

    }

    @When("User inserts Laptop in the Search Field and clicks on the search button")
    public void userInsertsLaptopInTheSearchField() {
        String text = "laptop";
        baseSetUp.mainPage.getSearchFIeldBtn().sendKeys(text);
        baseSetUp.mainPage.getCautaBtn().click();
    }

    @Then("User receives laptop results")
    public void userReceivesLaptopResults() {
        WebElement ulElm = baseSetUp.driver.findElement(By.xpath("//*[@id=\"__next\"]/div[3]/main/div[2]/div[1]/div[2]/ul"));
        List<WebElement> liElements = ulElm.findElements(By.tagName("li"));
        assertTrue(baseSetUp.productsPage.findCategoryByText(liElements, "Laptop".toLowerCase(Locale.ROOT)));

    }

    @And("Close browser")
    public void closeBrowser() {
        // baseSetUp.driver.quit();
    }

    @When("User inserts Iphone in the Search Field and presses ENTER key")
    public void userInsertsIphoneInTheSearchFieldAndPressesENTERKey() {
        baseSetUp.mainPage.getSearchFIeldBtn().sendKeys("Iphone");
        baseSetUp.mainPage.getSearchFIeldBtn().sendKeys(Keys.ENTER);

    }

    @Then("User receives iphone results")
    public void userReceivesIphoneResults() {
        WebElement ulElm = baseSetUp.driver.findElement(By.xpath("//*[@id=\"__next\"]/div[3]/main/div[2]/div[1]/div[2]/ul"));
        List<WebElement> liElements = ulElm.findElements(By.tagName("li"));
        assertTrue(baseSetUp.productsPage.findCategoryByText(liElements, "Iphone".toLowerCase(Locale.ROOT)));
    }


    @When("User inserts Iphone in the Search Field and select the suggested product")
    public void userInsertsIphoneInTheSearchFieldAndSelectTheSuggestedProduct() {
        baseSetUp.mainPage.getSearchFIeldBtn().sendKeys("Iphone");
        baseSetUp.productsPage.getIphoneSuggestedProduct().click();

    }

    @Then("User is able to navigate to the selected product's page")
    public void userIsAbleToNavigateToTheSelectedProductSPage() {
        assertTrue(baseSetUp.productsPage.getIphoneProductNameDescription().isDisplayed());


    }

    @When("User inserts Anvelopa in the Search Field and select the suggested category product")
    public void userInsertsIphoneInTheSearchFieldAndSelectTheSuggestedCategoryProduct() {
        baseSetUp.mainPage.getSearchFIeldBtn().sendKeys("anvelopa");
        baseSetUp.productsPage.getAnvelopaCategorySuggested().click();
    }

    @Then("User is able to navigate to the selected product's category page")
    public void userIsAbleToNavigateToTheSelectedProductSCategoryPage() {
        WebElement ulElm = baseSetUp.driver.findElement(By.xpath("//*[@id=\"__next\"]/div[3]/main/div[2]/div[1]/div[2]/ul"));
        List<WebElement> liElements = ulElm.findElements(By.tagName("li"));
        assertTrue(baseSetUp.productsPage.findCategoryByText(liElements, "Anvelopa".toLowerCase(Locale.ROOT)));
    }
}
