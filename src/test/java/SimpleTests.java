import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import utils.LogInPage;

public class SimpleTests {

    WebDriver driver;
    LogInPage logInPage;

    @BeforeEach
    public void setup() {
        System.setProperty("webdriver.chrome.driver", "src/main/resources/seleniumdriver/chromedriver/chromedriver 2");
        driver = new ChromeDriver();
        logInPage = new LogInPage(driver);
        driver.get("https://altex.ro/");
    }

    @Test
    public void checkMainPage(){
        System.out.println("ovidiu");

    }
}