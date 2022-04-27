package stepdefinitions;

import cucumber.api.java.en.When;
import pageobjects.HomePage;
import utils.TestContext;

public class HomeSteps {
    private TestContext context;
    private HomePage homePage;

    public HomeSteps(TestContext testContext) {
        context = testContext;
        homePage = new HomePage(context.getWebDriverManager().getDriverul());
    }


    @When("^user clicks on register buttons from navigation bar$")
    public void userClicksOnRegisterButtonsFromNavigationBar() {
        homePage.navigateToRegisterPageViaHeader();
    }

}
