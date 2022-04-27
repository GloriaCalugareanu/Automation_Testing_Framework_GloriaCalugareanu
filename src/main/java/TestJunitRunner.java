import managers.WebDriverManager;
import org.junit.jupiter.api.*;
import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import pageobjects.HomePage;
import pageobjects.RegisterPage;

public class TestJunitRunner {
    WebDriverManager webDriverManagerObiect = new WebDriverManager("Chrome");

    @BeforeAll

    @BeforeEach
    public void configureTestPreconditions() {
        webDriverManagerObiect.getDriverul().get("https://demo.opencart.com/");
    }

    @AfterEach
    public void tearDownActivities() {
        webDriverManagerObiect.getDriverul().close();
        webDriverManagerObiect.getDriverul().quit();
    }


    @Test
    @DisplayName("The Registration page can be accessed from navigation bar")
    public void registerPageIsOpened() {
        HomePage homePage = new HomePage(webDriverManagerObiect.getDriverul());
        homePage.navigateToRegisterPageViaHeader();

        boolean containsCorrectUrlEndpoint = webDriverManagerObiect.getDriverul().getCurrentUrl().contains("/index.php?route=account/register");
        Assertions.assertTrue(containsCorrectUrlEndpoint, "The Actual url does not contain the correct endpoint");
    }

    @Test
    @DisplayName("Correct error message is displayed when trying to create a user without checking the privacy policy")
    public void anErrorMessageIsDisplayedWhenCreatingAnAccountWithoutAcceptingThePrivacyPolicy() {
        HomePage homePage = new HomePage(webDriverManagerObiect.getDriverul());
        homePage.navigateToRegisterPageViaHeader();

        RegisterPage registerPage = new RegisterPage(webDriverManagerObiect.getDriverul());
        registerPage.populateRegisterFormWithData("Tacic", "SpangeBob", "spangebob@gmail.com", "78989878798", "Creative123", "Creative123");
        registerPage.clickContinueBtn();

        WebElement errorMessageForLackOfPrivacy = webDriverManagerObiect.getDriverul().findElement(By.xpath("//*[@id=\"account-register\"]/div[1]"));

        String expectedErrorText = "Warning: You must agree to the Privacy Policy!";
        String actualErrorText = errorMessageForLackOfPrivacy.getText();

        Assertions.assertEquals(expectedErrorText, actualErrorText, "The error message is not correct, please check the actual result");
    }

}
