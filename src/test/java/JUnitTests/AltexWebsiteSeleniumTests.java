package JUnitTests;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import utils.*;

import java.util.concurrent.TimeUnit;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertTrue;

public class AltexWebsiteSeleniumTests {
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
        utils.scrollToBottomOfThePage();
        mainPage.getDespreNoiBtn().click();
        WebElement altexBrandRomanesc = driver.findElement(By.xpath("//*[@id=\"__next\"]/div[3]/main/div[1]/ol/li[2]/strong"));
        assertTrue(altexBrandRomanesc.isDisplayed());

    }

    @Test
    public void checkBranduriDisponibileBtnWorks() {
        utils.scrollToBottomOfThePage();
        mainPage.getBranduriDisponibileBtn().click();
        WebElement branduriDisponibileMessage = driver.findElement(By.xpath("//*[@id=\"__next\"]/div[3]/main/div[2]/h1"));
        assertTrue(branduriDisponibileMessage.isDisplayed());
    }

    @Test
    public void checkThatCariereBtnWorks() {
        utils.scrollToBottomOfThePage();
        mainPage.getCariereBtn().click();
        WebElement locuriDeMuncaAltexMessage = driver.findElement(By.xpath("//*[@id=\"__next\"]/div[3]/main/div[1]/ol/li[2]/strong"));
        assertTrue(locuriDeMuncaAltexMessage.isDisplayed());
    }

    @Test
    public void checkIfTheUserCanNavigateToDeDouaOriDiferenta() {
        mainPage.getDeDouaOriDiferentaBtn().click();
        WebElement douaOriDiferentaTitle = driver.findElement(By.xpath("//*[@id=\"__next\"]/div[3]/main/div[2]/div/div[1]/section/div/div/div/h1"));
        assertTrue(douaOriDiferentaTitle.isDisplayed());
    }

    @Test
    public void checkIfUserCanNavigateToMainPageBYPressingOnAltexLogo() {
        productCategories.getTelefoaneTablete().click();
        productCategories.getTelefoane().click();
        mainPage.getAltexLogoBtn().click();
        assertTrue(productCategories.getElectrocasniceMariInProduse().isDisplayed());

    }

    @Test
    public void checkIfUserCanAddAProductInTheBasketFromOferteleZileiCategory() throws InterruptedException {
        WebElement firstProductFromOferteleZilei = driver.findElement(By.xpath("//*[@id=\"oferte-zilnice\"]/div/div/div/div/div[1]/a/div/img"));
        ((JavascriptExecutor) driver).executeScript("arguments[0].scrollIntoView(true);", firstProductFromOferteleZilei);
        Thread.sleep(2500);
        firstProductFromOferteleZilei.click();
        productsPage.getAdaugaInCosBtnFromProductPage().click();
        WebElement productInCart = driver.findElement(By.xpath("/html/body/div[2]/div[2]/div[2]/div[1]/ul/li/div/div/div[1]/ul/li/div[2]/h2/a"));
        Thread.sleep(2000);
        assertTrue(productInCart.isDisplayed());
    }

    @Test
    public void checkBranduriBtnFromMainMenu() {
        mainPage.getBranduriBtnFromMainMenu().click();
        WebElement branduriDisponibileMessage = driver.findElement(By.xpath("//*[@id=\"__next\"]/div[3]/main/div[2]/h1"));
        assertTrue(branduriDisponibileMessage.isDisplayed());
    }

    @Test
    public void checkFinantareBtnFromMainMenu() {
        mainPage.getFinantareBtnFromMainMenu().click();
        mainPage.getCarduriDeCreditBtnFromMainMenu().click();
        WebElement sistemDeRAteCuCarduriDeCreditMessage = driver.findElement(By.xpath("//*[@id=\"__next\"]/div[3]/main/div[1]/ol/li[2]/strong"));
        assertTrue(sistemDeRAteCuCarduriDeCreditMessage.isDisplayed());
    }

    @Test
    public void checkLegoAddFromMainPage() {
        utils.scrollToBottomOfThePage();
        mainPage.getLegoAddBtn().click();
        WebElement LegoStrongMessage = driver.findElement(By.xpath("//*[@id=\"__next\"]/div[3]/main/div[1]/ol/li[2]/strong"));
        assertTrue(LegoStrongMessage.isDisplayed());
    }

    @Test
    public void checkHuaweiAddFromMainPage() {
        utils.scrollToBottomOfThePage();
        mainPage.getHuaweiAddBtn().click();
        WebElement huaweiStrongMessage = driver.findElement(By.xpath("//*[@id=\"__next\"]/div[3]/main/div[1]/ol/li[2]/strong"));
        assertTrue(huaweiStrongMessage.isDisplayed());
    }

}

