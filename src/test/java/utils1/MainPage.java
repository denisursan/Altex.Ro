package utils1;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.PageFactory;

public class MainPage {

    WebDriver driver;

    public MainPage(WebDriver driver){
        this.driver=driver;
        PageFactory.initElements(driver,this);

    }

    public void openWebsite(){
        driver.get("https://altex.ro/");
    }

    public void backToMainPage(){
        WebElement inapoiLaSite= driver.findElement(By.xpath("//*[@id=\"page-promo\"]/header/div/div[1]/div/nav/div/div[1]/a"));
        if(inapoiLaSite.isDisplayed()){
            inapoiLaSite.click();
        }
    }

    public void SearchFieldInput(String text){
        WebElement searchField = driver.findElement(By.xpath("//*[@id=\"__next\"]/div[2]/div[1]/div/div/div[2]/div[4]/form/div/div[1]/input"));
        searchField.sendKeys(text);
    }
}
