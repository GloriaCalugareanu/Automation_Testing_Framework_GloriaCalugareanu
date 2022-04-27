package stepdefinitions;

import cucumber.api.java.en.Given;
import cucumber.api.java.en.Then;
import org.junit.jupiter.api.Assertions;
import pageobjects.Page;
import utils.TestContext;

public class GeneralSteps {

    private TestContext context;

    public GeneralSteps(TestContext testContext) {
        this.context = testContext;
    }


    @Then("^\"([^\"]*)\" is present within the current url$")
    public void isPresentWithinTheCurrentUrl(String keyWord) {
        boolean containsCorrectUrlEndpoint = context.getWebDriverManager().getDriverul().getCurrentUrl().contains(keyWord);
        Assertions.assertTrue(containsCorrectUrlEndpoint, "The Actual url does not contain the correct endpoint");
    }

    @Given("^\"([^\"]*)\" is accessed$")
    public void isAcceesed(String pageName) {
        Page.navigateToPage(pageName, context.getWebDriverManager().getDriverul());
    }

    @Then("^Correct \"([^\"]*)\" endpoint is displayed$")
    public void correctEndpointIsDisplayed(String pageName) {
        String expectedUrlEndpoint = Page.pageContainsCorrectEndpoint(pageName, context.getWebDriverManager().getDriverul());
        String valoareaActualaEndpoint = context.getWebDriverManager().getDriverul().getCurrentUrl();

        Assertions.assertTrue(valoareaActualaEndpoint.contains(expectedUrlEndpoint), "The ENDPOINT defined in the " +
                "pageObject of " + pageName + " page is not present within the current URL address:" + valoareaActualaEndpoint);
    }
}
