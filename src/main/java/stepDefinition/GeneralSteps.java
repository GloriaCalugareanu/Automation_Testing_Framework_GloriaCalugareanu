package stepDefinition;

import contextManagers.TestContext;
import cucumber.api.PendingException;
import cucumber.api.java.en.Given;

public class GeneralSteps {
    private TestContext testContext;

    public GeneralSteps(TestContext context) {
        testContext = context;
    }

    @Given("^\"([^\"]*)\" is accessed$")
    public void isAccessed(String adresaURL) {
        testContext.getWebDriverManager().getActiveWebDriver().get(adresaURL);
    }
}
