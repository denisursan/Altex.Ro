package testRunner;
import io.cucumber.junit.Cucumber;
import io.cucumber.junit.CucumberOptions;
import org.junit.runner.RunWith;
@RunWith(Cucumber.class)
@CucumberOptions(
        features = {"/Users/ursandenis/Documents/Altex.Ro.Project/src/test/java/featuresBDD/LogIn.feature","/Users/ursandenis/Documents/Altex.Ro.Project/src/test/java/featuresBDD/SearchField.feature"},
        plugin = { "json:target/cucumber.json", "pretty", "html:target/cucumber-reports" },
        glue = "testImplementation",
        tags = "@SimpleTest"
)
public class TestRunner {
}