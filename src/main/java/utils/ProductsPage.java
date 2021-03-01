package utils;

import lombok.Getter;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

import java.util.List;
import java.util.Locale;

@Getter
public class ProductsPage {
    WebDriver driver;

    public ProductsPage(WebDriver driver) {
        this.driver = driver;
        PageFactory.initElements(driver, this);
    }

    @FindBy(xpath = "//*[@id=\"__next\"]/div[3]/main/div[1]/ol/li[2]/strong")
    WebElement rezultateCautareLaptopBtn;

    @FindBy(xpath = "//*[@id=\"__next\"]/div[2]/div[1]/div/div/div[2]/div[4]/form/div/div[1]/div[3]/div[1]/div[2]/ul/li[1]/div[2]")
    WebElement iphoneSuggestedProduct;

    @FindBy(xpath = "//*[@id=\"__next\"]/div[3]/main/div/div[1]/ol/li[4]/strong")
    WebElement iphoneProductNameDescription;

    @FindBy(xpath = "//*[@id=\"__next\"]/div[2]/div[1]/div/div/div[2]/div[4]/form/div/div[1]/div[3]/div[1]/div[1]/div/ul/li[1]")
    private WebElement anvelopaCategorySuggested;

    @FindBy(xpath = "//*[@id=\"__next\"]/div[2]/div[1]/div/div/div[2]/div[4]/form/div/div[1]/div[3]/div[1]/div[2]/ul/li[1]/div[2]")
    public WebElement firstElementFromSearchFieldSuggestedList;

    @FindBy(xpath = "/html/body/div[2]/div[2]/div[3]/a/div/div/div")
    private WebElement assertProductDisplayedInTheShoppingCart;

    @FindBy(xpath = "//*[@id=\"__next\"]/div[3]/main/div/div[2]/div[1]/div[2]/div[2]/div/div/div[4]/div/div[1]/div[1]/div/div/button/div/div[2]/div")
    private WebElement adaugaInCosBtnFromProductPage;

    public boolean findCategoryByText(List<WebElement> liElements, String text) {
        for (WebElement element : liElements) {
            if (element.getText().toLowerCase(Locale.ROOT).contains(text)) {
                return true;
            }
        }
        return false;
    }


}

