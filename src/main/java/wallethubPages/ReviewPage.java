package wallethubPages;


import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.Assert;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.interactions.Actions;

public class ReviewPage {
    private WebDriver driver;
    private WebDriverWait wait;

    private By starContainerLocator = By.xpath("//review-star[@class='rvs-svg']");
    private By policyTypeLocator = By.xpath("//span[normalize-space()='Select...']");
    private By policyHealthLocator = By.xpath("//li[text()='Health Insurance']");
    private By policyReviewLocator = By.xpath("//textarea[@placeholder='Write your review...']");
    private By submitLocator = By.xpath("//div[normalize-space()='Submit']");
    private By reviewConfirmationLocator = By.xpath("//h4[normalize-space()='Your review has been posted.']");
    private By continueBtnLocator = By.xpath("//div[@class='btn rvc-continue-btn']");
    private By reviewTextLocator = By.xpath("//div[@class='rvtab-ci-content with-links text-select rvtac-ci-cexp']");

    public ReviewPage(WebDriver driver, WebDriverWait wait) {
        this.driver = driver;
        this.wait = wait;
    }

    public void hoverStars() {
        WebElement starContainer = wait.until(ExpectedConditions.visibilityOfElementLocated(starContainerLocator));
        WebElement[] stars = starContainer.findElements(By.tagName("svg")).toArray(new WebElement[0]);
        Actions actions = new Actions(driver);
        actions.clickAndHold(stars[3]).build().perform();
        stars[3].click();
    }

    public void selectPolicyType() {
        WebElement policyType = driver.findElement(policyTypeLocator);
        policyType.click();
    }

    public void selectHealthPolicy() {
        WebElement policyHealth = driver.findElement(policyHealthLocator);
        wait.until(ExpectedConditions.elementToBeClickable(policyHealth));
        policyHealth.click();
    }

    public void enterReview(String reviewText) {
        WebElement policyReview = driver.findElement(policyReviewLocator);
        wait.until(ExpectedConditions.elementToBeClickable(policyReview));
        policyReview.clear();
        policyReview.sendKeys(reviewText);
    }

    public void submitReview() {
        WebElement submit = wait.until(ExpectedConditions.elementToBeClickable(submitLocator));
        submit.click();
    }

    public void verifyReviewConfirmation() {
        WebElement reviewConfirmation = wait.until(ExpectedConditions.visibilityOfElementLocated(reviewConfirmationLocator));
        WebElement continueBtn = wait.until(ExpectedConditions.elementToBeClickable(continueBtnLocator));

        Assert.assertEquals(reviewConfirmation.getText(), "Your review has been posted.");
        continueBtn.click();
    }

    public String getReviewText() {
        return wait.until(ExpectedConditions.elementToBeClickable(reviewTextLocator)).getText();
    }
}

