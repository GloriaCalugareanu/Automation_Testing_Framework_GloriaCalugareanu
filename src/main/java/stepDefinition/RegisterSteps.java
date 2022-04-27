package stepDefinition;

import cucumber.api.java.en.And;
import cucumber.api.java.en.Then;
import cucumber.api.java.en.When;
import org.junit.jupiter.api.Assertions;
import pageobjects.RegisterPage;
import utils.TestContext;

import java.util.Map;
import java.util.List;


public class RegisterSteps {
    private RegisterPage registerPage;
    private TestContext context;

    public RegisterSteps(TestContext testContext) {
        context = testContext;

        registerPage = new RegisterPage(context.getWebDriverManager().getActiveWebDriver());
    }

    @When("^the register fields are populated with the following data:$")
    public void theRegisterFieldsArePopulatedWithTheFollowingData(Map<String, String> collectedDataFromFeatureFile) {
        String collectedFirstName = collectedDataFromFeatureFile.get("firstName");
        String collectedLastName = collectedDataFromFeatureFile.get("lastName");
        String collectedEmail = collectedDataFromFeatureFile.get("email");
        String collectedPhoneNumber = collectedDataFromFeatureFile.get("phoneNumber");
        String collectedPassword = collectedDataFromFeatureFile.get("password");
        String collectedConfirmPassword = collectedDataFromFeatureFile.get("confirmPassword");

        registerPage.populateRegisterFormWithData(collectedFirstName, collectedLastName, collectedEmail, collectedPhoneNumber, collectedPassword, collectedConfirmPassword);

    }

    @And("^privacyCheckBox is clicked$")
    public void privacycheckboxIsClicked() {
        registerPage.clickCheckBox();
    }

    @And("^continue button is clicked$")
    public void continueButtonIsClicked() {
        registerPage.clickContinueBtn();
    }


    @Then("^the following key word are present within an error message$")
    public void theFollowingKeyWordArePresentWithinAnErrorMessage(List<String> keyWordsList) {
        String displayedErrorMessage = registerPage.getTheErrorMessageText();

        for (int i = 0; i < keyWordsList.size(); i++) {
            boolean keyWordIsPresentWithinDisplayedMessage = displayedErrorMessage.contains(keyWordsList.get(i));
            Assertions.assertTrue(keyWordIsPresentWithinDisplayedMessage, "The keyword was not present within the error message ");

        }
    }
}
