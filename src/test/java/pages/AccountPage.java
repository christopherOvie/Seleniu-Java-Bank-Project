package pages;

import org.openqa.selenium.WebElement;
import org.openqa.selenium.remote.RemoteWebDriver;
import org.openqa.selenium.support.CacheLookup;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.FluentWait;

public class AccountPage {
	// Properties for locating elements
	private RemoteWebDriver driver;
	private FluentWait<RemoteWebDriver> wait;

	@FindBy(xpath = "//h3[contains(text(),' Welcome! ')]")@CacheLookup
	private WebElement welcome;
	@FindBy(id = "applyForLoan")@CacheLookup
	private WebElement applyForLoan;
	@FindBy(id = "applyForLoan")@CacheLookup
	private WebElement loan;

	// Constructor method for connecting to step definition classes and runner
	// classes

	public AccountPage(RemoteWebDriver driver, FluentWait<RemoteWebDriver> wait) {
		PageFactory.initElements(driver, this);
		this.driver = driver;
		this.wait = wait;
	}

	// Operational methods
	public boolean isWelcomeDisplayed() {
		if (welcome.isDisplayed()) {
			return true;
		} else {
			return false;
		}
	}
	
	public void clickOnApplyForLoan() {
		wait.until(ExpectedConditions.visibilityOf(applyForLoan)).click();
	}

}
