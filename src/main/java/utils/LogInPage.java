package utils;
import lombok.Getter;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
@Getter
public class LogInPage {
    WebDriver driver;
    public LogInPage(WebDriver driver) {
        this.driver = driver;
        PageFactory.initElements(driver, this);
    }
    @FindBy(xpath = "//*[@id=\"__next\"]/div[3]/main/div[2]/div/div/form/div[3]/button/div/div/div")
    private WebElement logInBtn;
    @FindBy(xpath = "//*[@id=\"__next\"]/div[2]/div[1]/div/div/div[2]/div[3]/div[1]/div/div[2]/div/form/div[3]/span/button/div/div/div")
    private WebElement autentificareBtn;
    @FindBy(xpath = "//*[@id=\"__next\"]/div[2]/div[1]/div/div/div[2]/div[3]/div[1]/a/div[3]/span")
    private WebElement contulMeuButton;
    @FindBy(xpath = "//*[@id=\"__next\"]/div[2]/div[1]/div/div/div[2]/div[3]/div[1]/div/div[2]/div/form/div[3]/span/button/div/div/div")
    private WebElement autentificareButton;
    @FindBy(xpath = "//*[@id=\"__next\"]/div[2]/div[1]/div/div/div[2]/div[3]/div[1]/div/div[2]/div/div/a")
    private WebElement recuperareParolaBtn;
    @FindBy(xpath = "//*[@id=\"__next\"]/div[2]/div[1]/div/div/div[2]/div[3]/div[1]/div/div[2]/div/form/div[3]/div/a/div/div/div")
    private WebElement inregistrareBtn;
    @FindBy(xpath = "//*[@id=\"__next\"]/div[3]/main/div[2]/div/div/form/input[1]")
    private WebElement emailFieldFromAMDejaCont;
    @FindBy(xpath = "//*[@id=\"__next\"]/div[3]/main/div[2]/div/div/form/input[2]")
    private WebElement passwordFieldFromAMDejaCont;
    @FindBy(xpath = "//*[@id=\"__next\"]/div[3]/main/div[2]/div/div/form/div[3]/button/div/div/div")
    private WebElement LogheazateinContBtnFromAmDejaContSection;


    public void insertEmailAndPassword(String email, String pass) {
        contulMeuButton.click();
        WebElement username = driver.findElement(By.xpath("//*[@id=\"__next\"]/div[2]/div[1]/div/div/div[2]/div[3]/div[1]/div/div[2]/div/form/input[1]"));
        username.sendKeys(email);
        WebElement password = driver.findElement(By.xpath("//*[@id=\"__next\"]/div[2]/div[1]/div/div/div[2]/div[3]/div[1]/div/div[2]/div/form/input[2]"));
        password.sendKeys(pass);
        autentificareButton.click();
    }

    public void insertValidUsernameAndPasswordinAmDejaContsection(String email, String pass){
        emailFieldFromAMDejaCont.sendKeys(email);
        passwordFieldFromAMDejaCont.sendKeys(pass);
        LogheazateinContBtnFromAmDejaContSection.click();
    }
}