import cucumber.api.CucumberOptions;
import cucumber.api.SnippetType;
import cucumber.api.junit.Cucumber;
import org.junit.runner.RunWith;

@RunWith(Cucumber.class)
@CucumberOptions(
        features = "src/main/java/features",
        glue = "stepDefinition",
        snippets = SnippetType.CAMELCASE,
        tags = {"@ExecutaAcestTC"},
        plugin = {"pretty", "html:target/cucumberreports"}
)
public class CucumberTestRunner {
}