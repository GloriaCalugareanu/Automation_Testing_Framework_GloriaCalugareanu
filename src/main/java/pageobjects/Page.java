package pageobjects;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public abstract class Page {
    public Page(WebDriver driver) {
        PageFactory.initElements(driver, this);
    }

    @FindBy(xpath = "//*[@id=\"top-links\"]/ul/li[2]/a/i")
    private WebElement myAccountIcon;

    @FindBy(xpath = "//*[@id=\"top-links\"]/ul/li[2]/ul/li[1]/a")
    private WebElement registerBtn;

    @FindBy(xpath = "//*[@id=\"search\"]/input")
    private WebElement searchInputField;

    @FindBy(xpath = "//*[@id=\"search\"]/span/button")
    private WebElement searchBtn;

    public void navigateToRegisterPageViaHeader() {
        myAccountIcon.click();
        registerBtn.click();
    }

    public void performSearchFor(String valoareCautata) {
        searchInputField.sendKeys(valoareCautata);
        searchBtn.click();
    }

    public void clearSearchField() {
        searchInputField.clear();
    }
}