package pageobjects;

import org.openqa.selenium.WebDriver;

public class HomePage extends Page {
    public HomePage(WebDriver driver) {
        super(driver);
    }

    private final String ENDPOINT = "/index.php?route=common/home";

    public HomePage goToPage() {
        driver.get(BASE_URL + ENDPOINT);
        return this;
    }

    public String getENDPOINT(){
        return ENDPOINT;
    }
}
