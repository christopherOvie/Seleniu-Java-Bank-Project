package pages;

import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.remote.RemoteWebDriver;
import org.openqa.selenium.support.CacheLookup;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.FluentWait;

import io.cucumber.java.en.Then;

public class LoanApplicationPage {
	

	// Properties for locating elements
	private RemoteWebDriver driver;
	private FluentWait<RemoteWebDriver> wait;
	
	@FindBy(css = "#email")@CacheLookup
	private WebElement emailId;
	
	@FindBy(css = "#amount")@CacheLookup
	private WebElement loanRequested;
	
	@FindBy(id = "term")@CacheLookup
	private WebElement term;
	
	@FindBy(id = "income")@CacheLookup
	private WebElement incomeBeforeTax;
	
	@FindBy(id = "age")@CacheLookup
	private WebElement age;
	
	@FindBy(id = "submitButton")@CacheLookup
	private WebElement submit;
	
	@FindBy(xpath = "//*[contains(text(),' approved for a loan with U')]")@CacheLookup
	private WebElement congrats;
	
	@FindBy(css = "[placeholder='Enter loan amount you are looking for']")@CacheLookup
	private WebElement loanAmountError;
	
	@FindBy(xpath = "//*[contains(text(),'Select your loan term')]")@CacheLookup
	private WebElement loanTermError;
	
	
	// Constructor method for connecting to step definition classes and runner
		// classes
		public LoanApplicationPage(RemoteWebDriver driver, FluentWait<RemoteWebDriver> wait) {
			PageFactory.initElements(driver, this);
			this.driver = driver;
			this.wait = wait;
		}

	
	public void enterEmailId(String word) {
		wait.until(ExpectedConditions.visibilityOf(emailId)).sendKeys(word);
	}
	
	
	
//	public void i_enter(String word) {
//		wait.until(ExpectedConditions.visibilityOf(emailId)).sendKeys(word);
//	}
//	
	public void fillInApplicationForm(String word1, String word2, String word3, String word4, String word5) {
		wait.until(ExpectedConditions.visibilityOf(emailId)).sendKeys(word1);
		wait.until(ExpectedConditions.visibilityOf(loanRequested)).sendKeys(word2);
		wait.until(ExpectedConditions.visibilityOf(term)).sendKeys(word3);
		wait.until(ExpectedConditions.visibilityOf(incomeBeforeTax)).sendKeys(word4);
		wait.until(ExpectedConditions.visibilityOf(age)).sendKeys(word5);
	//	wait.until(ExpectedConditions.visibilityOf(submit)).click();
		
	}
	
	
	public void clickSubmitBtn() {
		wait.until(ExpectedConditions.visibilityOf(submit)).click();
	}
	
	
	 // Method to click on the element using JavaScript executor
    public void clickOnElementWithJavaScript() {
        JavascriptExecutor jsExecutor = (JavascriptExecutor) driver;
        jsExecutor.executeScript("arguments[0].click();", submit);
    }
	public boolean isCongratsDisplayed() {
		if (congrats.isDisplayed()) {
			return true;
		} else {
			return false;
		}
	}
	
	public boolean isLoanAmountErrorMessageDisplayed() {
		if (loanAmountError.isDisplayed()) {
			return true;
		} else {
			return false;
		}
	}
	
	public boolean isLoanTermErrorMessageDisplayed() {
		if (loanTermError.isDisplayed()) {
			return true;
		} else {
			return false;
		}
	}
	
	 public String getTextUsingJavascript() {
	        JavascriptExecutor jsExecutor = (JavascriptExecutor) driver;
	        return (String) jsExecutor.executeScript("return arguments[0].textContent", congrats);
	    }
	 
	    // Method to check if element is present using JavaScript Executor
	    public boolean isElementPresent() {
	        // Create a JavascriptExecutor object
	        JavascriptExecutor jsExecutor = (JavascriptExecutor) driver;

	        // Execute JavaScript to check if the element is present
	        Boolean isPresent = (Boolean) jsExecutor.executeScript(
	                "return document.evaluate(arguments[0], document, null, XPathResult.BOOLEAN_TYPE, null).booleanValue()",
	                congrats
	        );

	        // Return true if element is present, false otherwise
	        return isPresent;
	    }
	}
	
	
	


