import managers.WebDriverManager;
import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;

public class TestRunner {
    public static void main(String[] args) throws InterruptedException {

        WebDriverManager webDriverManagerObiect = new WebDriverManager("Chrome");
        webDriverManagerObiect.getDriverul().get("https://demo.opencart.com/");

        WebElement myAccountIcon = webDriverManagerObiect.getDriverul().findElement(By.xpath("//*[@id=\"top-links\"]/ul/li[2]/a/i"));
        myAccountIcon.click();

        WebElement registerBtn = webDriverManagerObiect.getDriverul().findElement(By.xpath("//*[@id=\"top-links\"]/ul/li[2]/ul/li[1]/a"));
        registerBtn.click();

        // Actiuni asupra paginii de Registration
        WebElement firstNameInputField = webDriverManagerObiect.getDriverul().findElement(By.xpath("//*[@id=\"input-firstname\"]"));
        WebElement lastNameInputField = webDriverManagerObiect.getDriverul().findElement(By.xpath("//*[@id=\"input-lastname\"]"));
        WebElement emailInputField = webDriverManagerObiect.getDriverul().findElement(By.xpath("//*[@id=\"input-email\"]"));
        WebElement phoneInputFIeld = webDriverManagerObiect.getDriverul().findElement(By.cssSelector("#input-telephone"));
        WebElement passwordInput = webDriverManagerObiect.getDriverul().findElement(By.id("input-password"));
        WebElement confirmPasswordInputField = webDriverManagerObiect.getDriverul().findElement(By.xpath("//*[@id=\"input-confirm\"]"));
        WebElement continueBtn = webDriverManagerObiect.getDriverul().findElement(By.xpath("//*[@id=\"content\"]/form/div/div/input[2]"));

        firstNameInputField.sendKeys("Charls");
        lastNameInputField.sendKeys("Smith");
        emailInputField.sendKeys("emailderas@gmail.com");
        phoneInputFIeld.sendKeys("067717171");
        passwordInput.sendKeys("HardPass123321");
        confirmPasswordInputField.sendKeys("ABC");
        confirmPasswordInputField.clear();
        confirmPasswordInputField.sendKeys("HardPass123321");


        continueBtn.click();

        webDriverManagerObiect.getDriverul().close();
        webDriverManagerObiect.getDriverul().quit();
    }
}
