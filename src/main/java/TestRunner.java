import managers.WebDriverManager;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;

public class TestRunner {
    public static void main(String[] args) {

        WebDriverManager fireFoxDriverManager=new WebDriverManager("firefox");
        fireFoxDriverManager.getActiveWebDriver().get("https://www.google.com/");
        fireFoxDriverManager.getActiveWebDriver().close();
        fireFoxDriverManager.getActiveWebDriver().quit();


        WebDriverManager webDriverManagerObject=new WebDriverManager("Chrome");
        webDriverManagerObject.getActiveWebDriver().get("https://www.google.com/");
        webDriverManagerObject.getActiveWebDriver().close();
        webDriverManagerObject.getActiveWebDriver().quit();

    }
}
