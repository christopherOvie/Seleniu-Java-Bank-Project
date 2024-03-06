package pages;

import org.openqa.selenium.WebElement;
import org.openqa.selenium.remote.RemoteWebDriver;
import org.openqa.selenium.support.CacheLookup;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.FluentWait;

public class LoansPage {
	// Properties for locating elements
	private RemoteWebDriver driver;
	private FluentWait<RemoteWebDriver> wait;
	
	
	@FindBy(css = "[class='form-button'] div  button:nth-child(1)")@CacheLookup
	private WebElement loans;
	
	
	public LoansPage(RemoteWebDriver driver, FluentWait<RemoteWebDriver> wait) {
		PageFactory.initElements(driver, this);
		this.driver = driver;
		this.wait = wait;
	}
	
	
	public void clickOnApplyForLoanButton() {
		wait.until(ExpectedConditions.visibilityOf(loans)).click();
	}


}
