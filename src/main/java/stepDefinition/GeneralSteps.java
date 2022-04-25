package stepDefinition;

import utils.TestContext;
import cucumber.api.java.en.Given;
import cucumber.api.java.en.Then;
import org.junit.jupiter.api.Assertions;

public class GeneralSteps {
    private TestContext context;

    public GeneralSteps(TestContext testContext) {
        this.context = testContext;
    }

    @Given("^\"([^\"]*)\" is accessed$")
    public void isAccessed(String adresaURL) {
        context.getWebDriverManager().getActiveWebDriver().get(adresaURL);
    }

    @Then("^\"([^\"]*)\" is present within the current url$")
    public void isPresentWithinTheCurrentUrl(String keyWord) {
        boolean containsCorrectUrlEndpoint = context.getWebDriverManager().getActiveWebDriver().getCurrentUrl().contains(keyWord);
        Assertions.assertTrue(containsCorrectUrlEndpoint, "The Actual url does not contain the correct endpoint");
    }
}
