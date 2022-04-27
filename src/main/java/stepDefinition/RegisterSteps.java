package stepdefinitions;

import cucumber.api.java.en.And;
import cucumber.api.java.en.Then;
import cucumber.api.java.en.When;
import org.junit.jupiter.api.Assertions;
import pageobjects.RegisterPage;
import utils.TestContext;

import java.util.List;
import java.util.Map;

public class RegisterSteps {

    private RegisterPage registerPage;
    private TestContext context;

    public RegisterSteps(TestContext testContext) {
        context = testContext;
        registerPage = new RegisterPage(context.getWebDriverManager().getDriverul());
    }

    @When("^the register fields are populated with the following data:$")
    public void theRegisterFieldsArePopulatedWithTheFollowingData(Map<String, String> collectedRegisterDataMap) {
        String collectedFirstName = collectedRegisterDataMap.get("firstName");
        String collectedLastName = collectedRegisterDataMap.get("lastName");
        String collectedEmail = collectedRegisterDataMap.get("email");
        String collectedPhone = collectedRegisterDataMap.get("phoneNumber");
        String collectedPassword = collectedRegisterDataMap.get("password");
        String collectConfirmPassword = collectedRegisterDataMap.get("confirmPassword");

        registerPage.populateRegisterFormWithData(collectedFirstName, collectedLastName, collectedEmail,
                collectedPhone, collectedPassword, collectConfirmPassword);


    }

    @And("^privacyCheckBox is clicked$")
    public void privacycheckboxIsClicked() {
        registerPage.clickCheckBox();
    }

    @And("^Continue button is clicked$")
    public void continueButtonIsClicked() {
        registerPage.clickContinueBtn();
    }

    @Then("^the following key words are present within an error message$")
    public void theFollowingKeyWordsArePresentWithinAnErrorMessage(List<String> keyWordsList) {
        String displayedErrorMessage = registerPage.getTheErrorMessageText();

        for (int i = 0; i < keyWordsList.size(); i++) {
            boolean keyWordIsPresentWithinTheDisplayedMessage = displayedErrorMessage.contains(keyWordsList.get(i));
            Assertions.assertTrue(keyWordIsPresentWithinTheDisplayedMessage, "The keyword was not present within the error message");
        }

    }
}
