import managers.WebDriverManager;
import net.jodah.failsafe.internal.util.Assert;
import org.junit.jupiter.api.*;
import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import pageobjects.HomePage;
import pageobjects.Register;


public class TestJunitRunner {
    WebDriverManager webDriverManagerObiect = new WebDriverManager("Chrome");

    @BeforeAll

    @BeforeEach
    public void configureTestPreconditions() {
        webDriverManagerObiect.getActiveWebDriver().get("https://demo.opencart.com/");
    }

    @AfterEach
    public void tearDownActivities() {
        webDriverManagerObiect.getActiveWebDriver().close();
        webDriverManagerObiect.getActiveWebDriver().quit();
    }


    @Test
    @DisplayName("The Registration page can be accessed from navigation bar")
    public void registerPageIsOpened() {
        HomePage homePage = new HomePage(webDriverManagerObiect.getActiveWebDriver());
        homePage.navigateToRegisterPageViaHeader();

        boolean containsCorrectUrlEndpoint = webDriverManagerObiect.getActiveWebDriver().getCurrentUrl().contains("/index.php?route=account/register");
        Assertions.assertTrue(containsCorrectUrlEndpoint, "The Actual url does not contain the correct endpoint");
    }

    @Test
    @DisplayName("Correct error message is displayed when trying to create a user without checking the privacy policy")
    public void anErrorMessageIsDisplayedWhenCreatingAnAccountWithoutAcceptingThePrivacyPolicy() {
        HomePage homePage = new HomePage(webDriverManagerObiect.getActiveWebDriver());
        homePage.navigateToRegisterPageViaHeader();

        Register registerPage = new Register(webDriverManagerObiect.getActiveWebDriver());
        registerPage.populateRegisterFormWithData("Tacic", "SpangeBob", "spangebob@gmail.com", "78989878798", "Creative123", "Creative123");
        registerPage.clickContinueBtn();

        WebElement errorMessageForLackOfPrivacy = webDriverManagerObiect.getActiveWebDriver().findElement(By.xpath("//*[@id=\"account-register\"]/div[1]"));

        String expectedErrorText = "Warning: You must agree to the Privacy Policy!";
        String actualErrorText = errorMessageForLackOfPrivacy.getText();

        Assertions.assertEquals(expectedErrorText, actualErrorText, "The error message is not correct, please check the actual result");
    }

}