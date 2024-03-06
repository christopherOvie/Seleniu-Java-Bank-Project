package gluecode;

import org.openqa.selenium.WebElement;
import org.openqa.selenium.remote.RemoteWebDriver;
import org.openqa.selenium.support.CacheLookup;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.ui.FluentWait;

import io.cucumber.java.Scenario;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;
import pages.AccountPage;
import pages.LoanApplicationPage;
import pages.LoansPage;
import pages.LoginPage;
import utilities.WebSiteUtility;

public class LoanApplicationStepDef {
	WebSiteUtility su;
	RemoteWebDriver driver;
	FluentWait<RemoteWebDriver> wait;
	Scenario se;
	LoginPage lp;
	AccountPage ap;
	LoansPage lnp;
	LoanApplicationPage lap;
	

	public LoanApplicationStepDef(Shared sh) {
		this.driver=sh.driver;
		this.se=sh.se;
		this.wait=new FluentWait<RemoteWebDriver>(this.driver);
		this.lap=new LoanApplicationPage(this.driver,wait);
		this.ap=new AccountPage(this.driver,wait);
	}

	@Then("{string} msg should be displayed in account page")
	public void msg_should_be_displayed_in_account_page(String msg) {

		if (ap.isWelcomeDisplayed()) {
			se.log(msg + " is  displayed");
		} else {
			se.log(msg + " is not displayed");
		}

	}

	
	@Then("related msg should be displayed as per {string}")
	public void related_msg_should_be_displayed_as_per(String criteria) {
	   if(criteria.equals("email_blank")&&lap.isElementPresent()) {
		   se.log("test passed");
	   }
	   if(criteria.equals("loanAmount_blank")&&lap.isLoanAmountErrorMessageDisplayed()){
		   se.log("test passed");
	   }
	   if(criteria.equals("loanTerm_blank")&&lap.isLoanTermErrorMessageDisplayed()){
		   se.log("loan Term error msg is displayed");
	   }
	}
	


	
	@Then("fill fields with {string} ,{string} ,{string}, {string} and {string}")
	public void fill_fields_with_and_and(String a, String b, String c, String d, String e) throws InterruptedException {
	   lap.fillInApplicationForm(a, b, c, d, e);
	   Thread.sleep(5000);
	   
	}

	@When("I click on submit loan application")
	public void i_click_on_submit_loan_application() {
		lap.clickOnElementWithJavaScript();
	}

	

}
