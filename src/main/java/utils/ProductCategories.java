package utils;

import lombok.Getter;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

@Getter
public class ProductCategories {
    WebDriver driver;

    public ProductCategories(WebDriver driver) {
        this.driver = driver;
        PageFactory.initElements(driver, this);

    }

    @FindBy(xpath = "//*[@id=\"__next\"]/div[2]/div[2]/div[2]/ul/li[1]/ul/li[5]/a")
    private WebElement electrocasniceMariInProduse;

    @FindBy(xpath = "//*[@id=\"__next\"]/div[2]/div[2]/div[2]/ul/li[1]/ul/li[5]/div/ul/li[9]/a/img")
    private WebElement cuptoareCuMicrounde;

    @FindBy(xpath = "//*[@id=\"__next\"]/div[2]/div[2]/div[2]/ul/li[1]/ul/li[1]/a")
    private WebElement telefoaneTablete;

    @FindBy(xpath = "//*[@id=\"__next\"]/div[3]/main/div[2]/div[1]/div[2]/ul/li[1]/div/div[2]/div[1]/div[2]/div[1]/div/div/div/div/button/div/div[2]/div")
    private WebElement adaugaInCosCuptorCUMicrounde;

    @FindBy(xpath = "//*[@id=\"__next\"]/div[2]/div[2]/div[2]/ul/li[1]/ul/li[1]/div/div/ul/li[1]/a")
    private WebElement telefoane;

    @FindBy(xpath = "//*[@id=\"__next\"]/div[3]/main/div[2]/div[1]/div[2]/ul/li[1]/div/div[2]/div[1]/div[3]/div[1]/div/div/div/div/button/div/div[2]/div")
    private WebElement adaugaInCosTelefon1;

    @FindBy(xpath = "//*[@id=\"__next\"]/div[3]/main/div[2]/div[1]/div[2]/ul/li[2]/div/div[2]/div[1]/div[3]/div[1]/div/div/div/div/button/div/div[2]/div")
    private WebElement adaugaInCosTelefon2;

    @FindBy(xpath = "//*[@id=\"__next\"]/div[3]/main/div[2]/div[1]/div[2]/ul/li[3]/div/div[2]/div[1]/div[3]/div[1]/div/div/div/div/button/div/div[2]/div")
    private WebElement adaugaInCosTelefon3;

    @FindBy(xpath = "//*[@id=\"checkout\"]/div/section/div/div[1]/ul/li[1]/div/div/div[1]/ul/li/div[2]/h2/a")
    private WebElement product1FromBasket;

    @FindBy(xpath = "//*[@id=\"checkout\"]/div/section/div/div[1]/ul/li[2]/div/div/div[1]/ul/li/div[2]/h2/a")
    private WebElement product2FromBasket;

    @FindBy(xpath = "//*[@id=\"checkout\"]/div/section/div/div[1]/ul/li[3]/div/div/div[1]/ul/li/div[2]/h2/a")
    private WebElement product3FromBasket;

    @FindBy(xpath = "//*[@id=\"__next\"]/div[2]/div[1]/div/div/div[2]/div[3]/div[2]/div/div[2]/ul/div[1]/li/div/div[1]/a")
    private WebElement product1FromBasketDropDown;

    @FindBy(xpath = "//*[@id=\"__next\"]/div[2]/div[1]/div/div/div[2]/div[3]/div[2]/div/div[2]/ul/div[2]/li/div/div[1]/a")
    private WebElement product2FromBasketDropDown;

    @FindBy(xpath = "//*[@id=\"__next\"]/div[2]/div[1]/div/div/div[2]/div[3]/div[2]/div/div[2]/ul/div[3]/li/div/div[1]/a")
    private WebElement product3FromBasketDropDown;

    public boolean checkIfProductsArePresentInTheBasket() {
        if (product1FromBasket.isDisplayed() && product2FromBasket.isDisplayed() && product3FromBasket.isDisplayed()) {

            return true;
        }

        return false;

    }

    public boolean checkIfProductsArePresentInTheDropDownBasket() {
        if (product1FromBasketDropDown.isDisplayed() && product2FromBasketDropDown.isDisplayed() && product3FromBasketDropDown.isDisplayed()) {

            return true;
        }

        return false;

    }

}
