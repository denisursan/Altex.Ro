package utils;

import lombok.Getter;
import org.openqa.selenium.By;
import org.openqa.selenium.NoSuchElementException;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

@Getter
public class MainPage {

    WebDriver driver;

    public MainPage(WebDriver driver) {
        this.driver = driver;
        PageFactory.initElements(driver, this);

    }

    @FindBy(xpath = "//*[@id=\"page-promo\"]/header/div/div[1]/div/nav/div/div[1]/a")
    private WebElement inapoiLaSiteBtn;

    @FindBy(xpath = "//*[@id=\"__next\"]/div[2]/div[1]/div/div/div[2]/div[3]/div[1]/div/div[2]/div/ul/li[4]/a")
    private WebElement comenzileMeleBtn;

    @FindBy(xpath = "//*[@id=\"__next\"]/div[2]/div[1]/div/div/div[2]/div[3]/div[1]/div/div[2]/div/ul/li[11]/a")
    private WebElement logOutBtn;

    @FindBy(xpath = "//*[@id=\"__next\"]/div[2]/div[1]/div/div/div[2]/div[4]/form/div/div[1]/input")
    private WebElement searchFIeldBtn;

    @FindBy(xpath = "//*[@id=\"__next\"]/div[2]/div[1]/div/div/div[2]/div[4]/form/div/div[2]/button/div/div/div")
    private WebElement cautaBtn;

    @FindBy(xpath = "//*[@id=\"__next\"]/div[2]/div[1]/div/div/div[2]/div[3]/div[2]/a/div[3]")
    private WebElement cosulMeubtn;

    @FindBy(xpath = "//*[@id=\"notice-cookie-block\"]/div/div[2]/button")
    private WebElement acceptaBtn;


    public void openWebsite() {
        driver.get("https://altex.ro/");
    }

    public void backToMainPage() {
        try {
            WebElement backToSiteBtn = driver.findElement(By.xpath("//*[@id=\"page-promo\"]/header/div/div[1]/div/nav/div/div[1]/a"));
            backToSiteBtn.click();
        }
        catch(NoSuchElementException e) {
            e.printStackTrace();
        }
    }


    public void SearchFieldInput(String text) {
        WebElement searchField = driver.findElement(By.xpath("//*[@id=\"__next\"]/div[2]/div[1]/div/div/div[2]/div[4]/form/div/div[1]/input"));
        searchField.sendKeys(text);
    }

    public void acceptaButton() {
        if (acceptaBtn.isDisplayed()) {
            acceptaBtn.click();
        }
    }
}
