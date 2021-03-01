package JUnitTests;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.Select;
import testImplementation.BaseSetUp;
import utils.*;

import java.util.List;
import java.util.Locale;
import java.util.concurrent.TimeUnit;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertTrue;

public class Tests {
    String price;
    MainPage mainPage;
    WebDriver driver;
    LogInPage logInPage;
    ProductsPage productsPage;
    UtilsButtons utilsButtons;
    Utils utils;
    ProductCategories productCategories;
    SocialMediaButtons socialMediaButtons;

    @BeforeEach
    public void setup() {
        System.setProperty("webdriver.chrome.driver", "src/main/resources/seleniumdriver/chromedriver/chromedriver 2");
        driver = new ChromeDriver();
        driver.manage().window().maximize();
        driver.get("https://altex.ro/");
        driver.manage().timeouts().implicitlyWait(5, TimeUnit.SECONDS);
        logInPage = new LogInPage(driver);
        mainPage = new MainPage(driver);
        productsPage = new ProductsPage(driver);
        utilsButtons = new UtilsButtons(driver);
        utils = new Utils(driver);
        productCategories = new ProductCategories(driver);
        socialMediaButtons = new SocialMediaButtons(driver);

    }

    @Test
    public void checkDespreNoiBtn() {
        utils.scrollToElement();
        mainPage.getDespreNoiBtn().click();
        WebElement altexBrandRomanesc = driver.findElement(By.xpath("//*[@id=\"__next\"]/div[3]/main/div[1]/ol/li[2]/strong"));
        assertTrue(altexBrandRomanesc.isDisplayed());

    }

    @Test
    public void checkBranduriDisponibileBtnWorks() {
        utils.scrollToElement();
        mainPage.getBranduriDisponibileBtn().click();
        WebElement branduriDisponibileMessage = driver.findElement(By.xpath("//*[@id=\"__next\"]/div[3]/main/div[2]/h1"));
        assertTrue(branduriDisponibileMessage.isDisplayed());
    }

    @Test
    public void checkThatCariereBtnWorks(){
        utils.scrollToElement();
        mainPage.getCariereBtn().click();
        WebElement locuriDeMuncaAltexMessage= driver.findElement(By.xpath("//*[@id=\"__next\"]/div[3]/main/div[1]/ol/li[2]/strong"));
        assertTrue(locuriDeMuncaAltexMessage.isDisplayed());
    }

    @Test
    public void checkIfTheUserCanNavigateToDeDouaOriDiferenta(){
        mainPage.getDeDouaOriDiferentaBtn().click();
        WebElement douaOriDiferentaTitle= driver.findElement(By.xpath("//*[@id=\"__next\"]/div[3]/main/div[2]/div/div[1]/section/div/div/div/h1"));
        assertTrue(douaOriDiferentaTitle.isDisplayed());
    }
    @Test
    public void checkIfUserCanNavigateToMainPageBYPressingOnAltexLogo() {
        productCategories.getTelefoaneTablete().click();
        productCategories.getTelefoane().click();
        mainPage.getAltexLogoBtn().click();
        assertTrue(productCategories.getElectrocasniceMariInProduse().isDisplayed());

    }


}

