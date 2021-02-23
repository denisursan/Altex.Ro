package utils;

import lombok.Getter;
import lombok.experimental.FieldDefaults;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

@Getter
public class UtilsButtons {
    WebDriver driver;

    public UtilsButtons(WebDriver driver) {
        this.driver = driver;
        PageFactory.initElements(driver, this);
    }

    @FindBy(xpath = "//*[@id=\"__next\"]/div[3]/main/div/div[2]/div[1]/div[2]/div[2]/div/div/div[4]/div/div[1]/div[1]/div/div/button/div/div[2]/div")
    private WebElement adaugaInCosbtn;

    @FindBy(xpath = "/html/body/div[2]/div[2]/div[3]/a/div/div/div")
    private WebElement veziCosulbtn;

    @FindBy(xpath = "/html/body/div[2]/div[2]/div[3]/div/button/div/div/div")
    private WebElement inapoiButton;

    @FindBy(xpath = "//*[@id=\"__next\"]/div[2]/div[1]/div/div/div[2]/div[3]/div[2]/div/div[2]/ul/div/li/div/div[3]/button")
    private WebElement cosulMeuXbtn;

    @FindBy(xpath = "//*[@id=\"checkout\"]/div/section/div/div[1]/ul/li/div/div/div[2]/div/button[2]")
    private WebElement increaseNumberOfItemsBtnFromCosulMeu;

    @FindBy(xpath = "//*[@id=\"checkout\"]/div/section/div/div[1]/ul/li/div/div/div[2]/div/button[1]")
    private WebElement dereaseNumberOfItemsBtnFromCosulMeu;

    @FindBy(xpath = "//*[@id=\"checkout\"]/div/section/div/div[1]/ul/li/div/div/div[2]/div/div")
    private WebElement numberOfElementsFromBasket;

    public int getNumberOfItemsFromTheBasket(){
        return Integer.parseInt(numberOfElementsFromBasket.getAttribute("class"));

    }

}
