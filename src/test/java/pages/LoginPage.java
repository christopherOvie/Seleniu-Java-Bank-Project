package pages;

import org.openqa.selenium.WebElement;
import org.openqa.selenium.remote.RemoteWebDriver;
import org.openqa.selenium.support.CacheLookup;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.FluentWait;
import org.testng.Assert;

import io.cucumber.java.en.Then;

public class LoginPage {

	// Properties for locating elements
	private RemoteWebDriver driver;
	private FluentWait<RemoteWebDriver> wait;
	@FindBy(name = "username")
	@CacheLookup
	private WebElement uname;
	@FindBy(name = "password")
	@CacheLookup
	private WebElement pwd;
	@FindBy(xpath = "//button[contains(text(),'Sign In')]")
	@CacheLookup
	private WebElement signin;
	@FindBy(xpath = "//button[contains(text(),'I agree to the Privacy Policy')]")
	@CacheLookup
	private WebElement agreePrivatePolicy;

	// Constructor method for connecting to step definition classes and runner
	// classes
	public LoginPage(RemoteWebDriver driver, FluentWait<RemoteWebDriver> wait) {
		PageFactory.initElements(driver, this);
		this.driver = driver;
		this.wait = wait;
	}

	// Operational methods to operate. and observe elements

	public boolean areAllElementsDisplayed() {
		if (uname.isDisplayed() && pwd.isDisplayed()) {
			return (true);
		} else {
			return (false);
		}
	}

	public void fillUserName(String word) {
		wait.until(ExpectedConditions.visibilityOf(uname)).sendKeys(word);
	}

	public void fillPassword(String word) {
		wait.until(ExpectedConditions.visibilityOf(pwd)).sendKeys(word);
	}

	public void fillUserNameAndPassword(String word1, String word2) {
		wait.until(ExpectedConditions.visibilityOf(uname)).sendKeys(word1);
		wait.until(ExpectedConditions.visibilityOf(pwd)).sendKeys(word2);
	}
	
	
	public void clickOnSignIn() {
		wait.until(ExpectedConditions.visibilityOf(signin)).click();
	}

	public void clickAgreePrivatePolicy() {
		wait.until(ExpectedConditions.visibilityOf(agreePrivatePolicy)).click();
	}

//	public boolean isUserNameDisplayed() {
//		// TODO Auto-generated method stub
//		return false;
//	}

}
