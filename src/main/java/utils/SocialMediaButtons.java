package utils;


import lombok.Getter;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

import java.util.Iterator;
import java.util.Set;

@Getter
public class SocialMediaButtons {
    WebDriver driver;

    public SocialMediaButtons(WebDriver driver) {
        this.driver = driver;
        PageFactory.initElements(driver, this);

    }


    @FindBy(xpath = "//*[@id=\"__next\"]/div[4]/div[2]/div[1]/div[4]/div/div[2]/div[2]/a[1]")
    WebElement facebookBtn;

    @FindBy(xpath = "//*[@id=\"__next\"]/div[4]/div[2]/div[1]/div[4]/div/div[2]/div[2]/a[2]")
    WebElement twitterBtn;

    @FindBy(xpath = "//*[@id=\"__next\"]/div[4]/div[2]/div[1]/div[4]/div/div[2]/div[2]/a[3]")
    WebElement linkedInBtn;

    @FindBy(xpath = "//*[@id=\"__next\"]/div[4]/div[2]/div[1]/div[4]/div/div[2]/div[2]/a[4]")
    WebElement youtubeBtn;


    public void openFacebookTab() {
        String currentWindowHandle = driver.getWindowHandle();
        Set<String> allWindowHandles = driver.getWindowHandles();
        Iterator iter = allWindowHandles.iterator();
        while (iter.hasNext()) {
            String windowHandle = (String) iter.next();
            // Thread.sleep(3000);
            driver.switchTo().window(windowHandle);
            if (driver.getTitle().equals("Altex Romania - Home | Facebook")) {
                break;
            }
        }
    }


    public void openTwitterTab() {
        String currentWindowHandle = driver.getWindowHandle();
        Set<String> allWindowHandles = driver.getWindowHandles();
        Iterator iter = allWindowHandles.iterator();
        while (iter.hasNext()) {
            String windowHandle = (String) iter.next();
            // Thread.sleep(3000);
            driver.switchTo().window(windowHandle);
            if (driver.getTitle().equals("ALTEX (@AltexRO) / Twitter")) {
                break;
            }
        }
    }

    public void openLinkedInTab() {
        String currentWindowHandle = driver.getWindowHandle();
        Set<String> allWindowHandles = driver.getWindowHandles();
        Iterator iter = allWindowHandles.iterator();
        while (iter.hasNext()) {
            String windowHandle = (String) iter.next();
            // Thread.sleep(3000);
            driver.switchTo().window(windowHandle);
            if (driver.getTitle().equals("(9) ALTEX Romania: Overview | LinkedIn")) {
                break;
            }
        }
    }

    public void openYoutubeInTab() {
        String currentWindowHandle = driver.getWindowHandle();
        Set<String> allWindowHandles = driver.getWindowHandles();
        Iterator iter = allWindowHandles.iterator();
        while (iter.hasNext()) {
            String windowHandle = (String) iter.next();
            // Thread.sleep(3000);
            driver.switchTo().window(windowHandle);
            if (driver.getTitle().equals("ALTEX Romania - YouTube")) {
                break;

            }
        }
    }
}