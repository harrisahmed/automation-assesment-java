package wallethubPages;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.WebDriverWait;

public class LoginPage {
    private WebDriver driver;
    private WebDriverWait wait;

    private By loginLinkLocator = By.xpath("//li/a[contains(text(),'Login')]");
    private By emailInputLocator = By.xpath("//input[@type='text' and contains(@placeholder,'Email')]");
    private By passwordInputLocator = By.xpath("//input[@type='password' and contains(@placeholder,'Password')]");
    private By loginButtonLocator = By.xpath("//button//span[contains(text(),'Login')]");

    public LoginPage(WebDriver driver, WebDriverWait wait) {
        this.driver = driver;
        this.wait = wait;
    }

    public void clickLogin() {
        WebElement clickLogin = driver.findElement(loginLinkLocator);
        clickLogin.click();
    }

    public void enterEmail(String email) {
        WebElement userEmail = driver.findElement(emailInputLocator);
        userEmail.sendKeys(email);
    }

    public void enterPassword(String password) {
        WebElement userPass = driver.findElement(passwordInputLocator);
        userPass.sendKeys(password);
    }

    public void clickLoginButton() {
        WebElement loginBtn = driver.findElement(loginButtonLocator);
        loginBtn.click();
    }
}

