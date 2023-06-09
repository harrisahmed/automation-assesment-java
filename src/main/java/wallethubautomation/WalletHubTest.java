package wallethubautomation;


import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.Assert;

import wallethubPages.LoginPage;
import wallethubPages.ReviewPage;

public class WalletHubTest {
    private static final String WH_LOGIN_URL = "https://wallethub.com/join/light";
    static String subUrls = "https://wallethub.com/profile/13732055i";
    private static final String WH_EMAIL = "";
    private static final String WH_PASSWORD = "";
    private static final String USER_REVEIW = "Lorem Ipsumis simply dummy text of the printing and typesetting industry. Lorem Ipsum has been the industry's standard dummy test.";

    private WebDriver driver;
    private WebDriverWait wait;
    private ReviewPage reviewPage;

    public WalletHubTest() {
        ChromeOptions options = new ChromeOptions();
        options.addArguments("--disable-notifications");
        System.setProperty("webdriver.chrome.driver", "./drivers/chromedriver.exe");
        driver = new ChromeDriver(options);
        wait = new WebDriverWait(driver, 10);
        reviewPage = new ReviewPage(driver, wait);
    }

    public void loginToWallethub() {
        driver.get(WH_LOGIN_URL);
        LoginPage loginPage = new LoginPage(driver, wait);
        loginPage.clickLogin(); 
        loginPage.enterEmail(WH_EMAIL);
        loginPage.enterPassword(WH_PASSWORD);
        loginPage.clickLoginButton();
    }

    public void hoverStars() throws InterruptedException {
        Thread.sleep(5000);
        driver.navigate().to(subUrls);
        Thread.sleep(5000);
        reviewPage.hoverStars();
    }

    public void postReview() {
        reviewPage.selectPolicyType();
        reviewPage.selectHealthPolicy();
        reviewPage.enterReview(USER_REVEIW);
        reviewPage.submitReview();
        reviewPage.verifyReviewConfirmation();
    }

    public void verifyReview() {
        String expectedReview = reviewPage.getReviewText();
        if (USER_REVEIW.equals(expectedReview)) {
            Assert.assertEquals(USER_REVEIW, expectedReview, "Assertion passed: Review matches the expected value");
        } else {
            Assert.assertEquals(USER_REVEIW, expectedReview, "Assertion failed: Review does not match the expected value");
        }
    }

    public void closeBrowser() {
        driver.quit();
    }

    public static void main(String[] args) throws InterruptedException {

        WalletHubTest automation = new WalletHubTest();
        automation.loginToWallethub();
        automation.hoverStars();
        automation.postReview();
        automation.verifyReview();
        automation.closeBrowser();
    }
}
