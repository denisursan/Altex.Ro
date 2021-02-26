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

    @FindBy(xpath = "//*[@id=“__next”]/div[3]/main/div[2]/div/div/form/div[3]/button/div/div/div")
    private WebElement logInBtn;

    @FindBy(xpath = "//*[@id=\"__next\"]/div[2]/div[1]/div/div/div[2]/div[3]/div[1]/div/div[2]/div/form/div[3]/span/button/div/div/div")
    private WebElement autentificareBtn;


    public void insertValidUsernameAndPassword() {
        WebElement contulMeuButton = driver.findElement(By.xpath("//*[@id=\"__next\"]/div[2]/div[1]/div/div/div[2]/div[3]/div[1]/a/div[3]/span"));
        contulMeuButton.click();
        WebElement username = driver.findElement(By.xpath("//*[@id=\"__next\"]/div[2]/div[1]/div/div/div[2]/div[3]/div[1]/div/div[2]/div/form/input[1]"));
        username.sendKeys("rovidyu@yahoo.com");
        WebElement password = driver.findElement(By.xpath("//*[@id=\"__next\"]/div[2]/div[1]/div/div/div[2]/div[3]/div[1]/div/div[2]/div/form/input[2]"));
        password.sendKeys("RRO_12345");
        WebElement autentificareButton = driver.findElement(By.xpath("//*[@id=\"__next\"]/div[2]/div[1]/div/div/div[2]/div[3]/div[1]/div/div[2]/div/form/div[3]/span/button/div/div/div"));
        autentificareButton.click();
    }

    public void inserUsernameAndInvalidPassword() {
        WebElement contulMeuButton = driver.findElement(By.xpath("//*[@id=\"__next\"]/div[2]/div[1]/div/div/div[2]/div[3]/div[1]/a/div[3]/span"));
        contulMeuButton.click();
        WebElement username = driver.findElement(By.xpath("//*[@id=\"__next\"]/div[2]/div[1]/div/div/div[2]/div[3]/div[1]/div/div[2]/div/form/input[1]"));
        username.sendKeys("rovidyu@yahoo.com");
        WebElement password = driver.findElement(By.xpath("//*[@id=\"__next\"]/div[2]/div[1]/div/div/div[2]/div[3]/div[1]/div/div[2]/div/form/input[2]"));
        password.sendKeys("RRO_6523");
        WebElement autentificareButton = driver.findElement(By.xpath("//*[@id=\"__next\"]/div[2]/div[1]/div/div/div[2]/div[3]/div[1]/div/div[2]/div/form/div[3]/span/button/div/div/div"));
        autentificareButton.click();
    }

    public void inserInvalidUsernameAndValidPassword() {
        WebElement contulMeuButton = driver.findElement(By.xpath("//*[@id=\"__next\"]/div[2]/div[1]/div/div/div[2]/div[3]/div[1]/a/div[3]/span"));
        contulMeuButton.click();
        WebElement username = driver.findElement(By.xpath("//*[@id=\"__next\"]/div[2]/div[1]/div/div/div[2]/div[3]/div[1]/div/div[2]/div/form/input[1]"));
        username.sendKeys("rovidyu@gmail.com");
        WebElement password = driver.findElement(By.xpath("//*[@id=\"__next\"]/div[2]/div[1]/div/div/div[2]/div[3]/div[1]/div/div[2]/div/form/input[2]"));
        password.sendKeys("RRO_12345");
        WebElement autentificareButton = driver.findElement(By.xpath("//*[@id=\"__next\"]/div[2]/div[1]/div/div/div[2]/div[3]/div[1]/div/div[2]/div/form/div[3]/span/button/div/div/div"));
        autentificareButton.click();
    }

    public void insertValidUsernameAndPasswordInAmDejaCont() {
        WebElement username = driver.findElement(By.xpath("//*[@id=\"__next\"]/div[3]/main/div[2]/div/div/form/input[1]"));
        username.sendKeys("rovidyu@yahoo.com");
        WebElement password = driver.findElement(By.xpath("//*[@id=\"__next\"]/div[3]/main/div[2]/div/div/form/input[2]"));
        password.sendKeys("RRO_12345");
        WebElement logheazateInContbtn = driver.findElement(By.xpath("//*[@id=\"__next\"]/div[3]/main/div[2]/div/div/form/div[3]/button/div/div/div"));
        logheazateInContbtn.click();
    }


}

