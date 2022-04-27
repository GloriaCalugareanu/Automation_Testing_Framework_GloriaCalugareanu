package managers;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;
import org.openqa.selenium.firefox.FirefoxDriver;

import java.time.Duration;
import java.util.Locale;

public class WebDriverManager {
    public WebDriverManager(String browserType) {
        this.browserType = browserType;
    }

    private WebDriver driverul;

    private String browserType;

    private void initializareDriver() {
        if (browserType.toUpperCase(Locale.ROOT).equals("CHROME")) {
            System.setProperty("webdriver.chrome.driver", "src/main/resources/drivers/chromedriver.exe");
            ChromeOptions chromeOptions = new ChromeOptions();
            chromeOptions.addArguments("start-maximized");
            chromeOptions.addArguments("incognito");
            driverul = new ChromeDriver(chromeOptions);
        } else if (browserType.toUpperCase(Locale.ROOT).equals("FIREFOX")) {
            System.setProperty("webdriver.gecko.driver", "src/main/resources/drivers/geckodriver.exe");
            driverul = new FirefoxDriver();
        } else {
            System.out.println("Nu exista un astfel de browser implementat!");
        }
        driverul.manage().timeouts().implicitlyWait(Duration.ofSeconds(5));
        driverul.manage().timeouts().pageLoadTimeout(Duration.ofSeconds(30));
    }

    public WebDriver getDriverul() {
        if (driverul == null) {
            System.out.println("Se initializeaza browser-ul dorit");
            initializareDriver();
        }
        return this.driverul;
    }
}
