package testImplementation;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import utils.LogInPage;
import utils.MainPage;
import java.util.concurrent.TimeUnit;

public class BaseSetUp {
    MainPage mainPage;
    WebDriver driver;
    LogInPage logInPage;

    BaseSetUp(int wait) {
        System.setProperty("webdriver.chrome.driver", "src/main/resources/seleniumdriver/chromedriver/chromedriver 2");
        driver = new ChromeDriver();
        driver.manage().window().maximize();
        driver.manage().timeouts().implicitlyWait(wait, TimeUnit.SECONDS);
        logInPage= new LogInPage(driver);
        mainPage = new MainPage(driver);
    }
}
