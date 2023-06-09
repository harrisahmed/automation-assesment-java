package facebookautomation;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;
import Pages.LoginPage;
import Pages.HomePage;

public class FacebookAutomationTest {
    private static final String FB_LOGIN_URL = "https://www.facebook.com/";
    private static final String FB_EMAIL = "";
    private static final String FB_PASSWORD = "";
    private static final String STATUS_MESSAGE = "Hello World";

    private WebDriver driver;

    public FacebookAutomationTest() {
        ChromeOptions options = new ChromeOptions();
        options.addArguments("--disable-notifications");
        System.setProperty("webdriver.chrome.driver", "./drivers/chromedriver.exe");
        driver = new ChromeDriver(options);
    }

    public void loginToFacebook() {
        driver.get(FB_LOGIN_URL);
        LoginPage loginPage = new LoginPage(driver);
        loginPage.enterEmail(FB_EMAIL);
        loginPage.enterPassword(FB_PASSWORD);
        loginPage.clickLoginButton();
    }

    public void postStatusMessage() {
        HomePage homePage = new HomePage(driver);
        homePage.clickStatusField();
        homePage.enterStatusMessage(STATUS_MESSAGE);
        homePage.clickPostButton();
    }

    public void closeBrowser() {
        driver.quit();
    }

    public static void main(String[] args) {
    	FacebookAutomationTest automation = new FacebookAutomationTest();
        automation.loginToFacebook();
        automation.postStatusMessage();
        automation.closeBrowser();
    }
}


