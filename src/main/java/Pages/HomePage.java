package Pages;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.support.ui.ExpectedConditions;

public class HomePage extends BasePage {
	private By clickStatusField = By.xpath("//div[@class='xi81zsa x1lkfr7t xkjl1po x1mzt3pk xh8yej3 x13faqbe']");
    private By statusField = By.xpath("//div[@class='_1mf _1mj']");
    private By postButton = By.xpath("//div[@aria-label='Post']");

    public HomePage(WebDriver driver) {
        super(driver);
    }
    
    public void clickStatusField() {
    	wait.until(ExpectedConditions.visibilityOfElementLocated(clickStatusField)).click();
    }

	public void enterStatusMessage(String message) {
        wait.until(ExpectedConditions.visibilityOfElementLocated(statusField)).sendKeys(message);
    }

    public void clickPostButton() {
        driver.findElement(postButton).click();
    }
}
