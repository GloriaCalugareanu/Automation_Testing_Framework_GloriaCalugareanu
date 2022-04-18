package managers;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;

import java.util.Locale;

public class WebDriverManager {
    public WebDriverManager(String browserType) {
        this.browserType = browserType;
    }


    private WebDriver activeWebDriver;


    private String browserType;

    private void initializeDriver() {
        if (browserType.toUpperCase(Locale.ROOT).equals("CHROME")) {
            System.setProperty("webdriver.chrome.driver","src/main/resources/Drivers/chromedriver.exe");
            activeWebDriver = new ChromeDriver();
        } else if (browserType.toUpperCase(Locale.ROOT).equals( "FIREFOX")) {
            System.setProperty("webdriver.gecko.driver","src/main/resources/Drivers/geckodriver.exe");
            activeWebDriver = new FirefoxDriver();
        }else {
            System.out.println("Nu esista un astfel de browser");
        }
    }

    public WebDriver getActiveWebDriver() {
        if (activeWebDriver == null){
            System.out.println("Se intializeaza browser-ul dorit");
            initializeDriver();
    }
        return this.activeWebDriver;
    }
}
