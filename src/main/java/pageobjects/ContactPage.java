package pageobjects;

import org.openqa.selenium.WebDriver;

public class ContactPage extends Page {
    public ContactPage(WebDriver driver) {
        super(driver);
    }

    private final String ENDPOINT = "/index.php?route=information/contact";

    public ContactPage goToPage() {
        driver.get(BASE_URL + ENDPOINT);
        return this;
    }

    public String getENDPOINT() {
        return ENDPOINT;
    }
}
