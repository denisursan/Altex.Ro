package utils;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class FilterDropDownButtons {
    WebDriver driver;
    public FilterDropDownButtons(WebDriver driver){
        this.driver= driver;
        PageFactory.initElements(driver,this);
    }

    @FindBy(xpath = "//*[@id=\"__next\"]/div[3]/main/div[2]/div[1]/div[2]/div[1]/div/div/div/div[1]/div[1]/div/select")
     WebElement sorteazaDupaBtn;

    public void takePriceFromProductsList(){

    }





}
