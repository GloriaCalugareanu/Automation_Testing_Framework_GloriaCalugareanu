import managers.WebDriverManager;
import pageobjects.HomePage;
import pageobjects.RegisterPage;


public class TestRunner {
    public static void main(String[] args) {
        WebDriverManager webDriverManagerObiect = new WebDriverManager("Chrome");
        webDriverManagerObiect.getActiveWebDriver().get("https://demo.opencart.com/");

        HomePage homePage = new HomePage(webDriverManagerObiect.getActiveWebDriver());
        homePage.navigateToRegisterPageViaHeader();

        RegisterPage registerPage = new RegisterPage(webDriverManagerObiect.getActiveWebDriver());
        registerPage.populateRegisterFormWithData("Charls", "Smith", "emailadres@gmail.com", "067717845", "HardPass123321", "HardPass123321");
        registerPage.clickContinueBtn();

        registerPage.performSearchFor("Apple");
        registerPage.clearSearchField();
        registerPage.performSearchFor("Samsung");

        webDriverManagerObiect.getActiveWebDriver().get("https://www.google.com/");
        webDriverManagerObiect.getActiveWebDriver().close();
    }
}