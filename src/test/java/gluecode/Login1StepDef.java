package gluecode;

import java.util.Map;

//import java.util.Map;

import org.apache.xmlbeans.impl.xb.xsdschema.ListDocument.List;
import org.openqa.selenium.OutputType;
import org.openqa.selenium.remote.RemoteWebDriver;
import org.openqa.selenium.support.ui.FluentWait;
import org.testng.Assert;

import io.cucumber.datatable.DataTable;
import io.cucumber.java.Scenario;
import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;
import pages.AccountPage;
import pages.LoansPage;
import pages.LoginPage;
import utilities.ExcelFileUtility;
import utilities.WebSiteUtility;

public class Login1StepDef {
	WebSiteUtility su;
	RemoteWebDriver driver;
	FluentWait<RemoteWebDriver> wait;
	Scenario se;
	LoginPage lp;
	AccountPage ap;
	LoansPage lnp;
	Shared sh;
	
	public Login1StepDef(Shared sh) {
		this.sh = sh;
		this.se = sh.se;
		
	}

	@Given("open {string} browser")
	public void method1(String bn) throws Exception {
		su = new WebSiteUtility();
		sh.driver = su.openBrowser(bn); // important to create shared driver
		this.driver = sh.driver; // important to assign shared driver to local driver
		wait = su.defineWait(driver);
		lp = new LoginPage(driver, wait);
		ap = new AccountPage(driver, wait);
		lnp= new LoansPage(driver, wait);

	}

	@When("launch site")
	public void method2() throws Exception {
		su.launchSite(sh.driver);
	}

	@Then("page should be contain required fileds")
	public void method4() {
		if (lp.areAllElementsDisplayed()) {
			se.log("page is loaded with required fields");
		} else {
			se.log("page is not loaded with required fields");
			Assert.fail();
		}
	}

	@When("fill fields with {string} and {string}")
	public void fill_fields_with_and(String x, String y) {
//		lp.fillUserName(x);
//		lp.fillPassword(y);
		lp.fillUserNameAndPassword(x, y);
		se.log(x +"entered");
		se.log(y +"entered");
	}

	@When("click on sign in and agree to private policy")
	public void click_on_sign_in_and_agree_to_private_policy() throws InterruptedException {
		lp.clickOnSignIn();
		se.log("click sign in");
		lp.clickAgreePrivatePolicy();
		se.log("clickAgreePrivatePolicy");
		Thread.sleep(5000);
	
	}

//	@Then("{string} msg should be displayed in account page")
//	public void msg_should_be_displayed_in_account_page(String msg) {
//
//		if (ap.isWelcomeDisplayed()) {
//			se.log(msg + " is  displayed");
//		} else {
//			se.log(msg + " is not displayed");
//		}
//
//	}

	@Then("title should contain {string}")
	public void title_should_contain(String title) {
		if (driver.getTitle().contains(title)) {
			se.log("title is correct");
		} else {
			se.log("title is incorrect because it is " + driver.getTitle());
			Assert.fail();
		}
	}
	@When("I attempt to apply for a  loan")
	public void i_attempt_to_apply_for_a_loan() {
	   ap.clickOnApplyForLoan();
	   
	   
	}

@When("I click on apply for a loan on loans page")
public void i_click_on_apply_for_a_loan_on_loans_page() throws InterruptedException {
	 ap.clickOnApplyForLoan();
	 Thread.sleep(3000);
	lnp.clickOnApplyForLoanButton();
}

@When("I apply for a loan")
public void i_apply_for_a_loan() {
	///lnp.clickOnApplyForLoanButton();
}
	


@When("login by taking test data from excel file")
public void login_by_taking_test_data_from_excel_file() throws Exception {
	//open excel file, get rows count, and create result column
			ExcelFileUtility eu=new ExcelFileUtility(
					      "src\\test\\resources\\testdatafiles\\testdata1.xlsx");
			eu.openSheet("Sheet2");
			int n=eu.getRowsCount();
			eu.createResultColumn(n);
			try 
			{
				//iterate through from 2nd row to last row for data driven
				for(int i=1;i<n;i++) //skip 1st row(index=0) due names of columns
				{
					lp.fillUserName(eu.getCellValue(i,0));
				//	Thread.sleep(3000);
					lp.fillPassword(eu.getCellValue(i,1));
					
					//get data
//					else     src\\test\\resources\\testdatafiles\\testdata1.xlsx
//					{
//						eu.setCellValue(i,n,"Registration test case is failed for "+eu.getCellValue(i,3));
//						se.log("Registration test case is failed for "+eu.getCellValue(i,3));
//						byte[] s=driver.getScreenshotAs(OutputType.BYTES);
//						se.attach(s,"image/png","wrong page screen shot");
//						Assert.fail();
//					}
				}
			}
			catch(Exception e)
			{
				e.printStackTrace();
			}
			//save and close excel file
			eu.saveAndCloseExcel();
	
}

@When("do successful login by giving valid data in {string}")
public void do_successful_login_by_giving_valid_data_in(String bn,DataTable dt) throws InterruptedException {
	//data is passed as a list
	java.util.List<Map<String, String>> arr=dt.asMaps();
	
	for(int i=0;i<arr.size();i++)
	{
//		lp.fillUserName(arr.get(i).get("un"));
//		lp.fillPassword(arr.get(i).get("pwd"));
//		if(lp.areAllElementsDisplayed())
//		{
//			lp.fillUserName(arr.get(i).get("un"));
//		}
//		if(lp.areAllElementsDisplayed())
//		{
//			lp.fillPassword(arr.get(i).get("pwd"));
//		}
		
		lp.fillUserName(arr.get(i).get("un"));
		lp.fillPassword(arr.get(i).get("pwd"));
		
		//Thread.sleep(5000);
		/*if(ap.isWelcomeDisplayed())
		{
			se.log("Login is successful in "+bn);
		}
		else
		{
			se.log("Login is not successful in "+bn);
			byte[] s=driver.getScreenshotAs(OutputType.BYTES);
			se.attach(s,"image/png","wrong page screen shot");
			Assert.fail();
		}*/
//		rp.fillUserName(arr.get(i).get("un"));
//		if(arr.get(i).get("email").equals("random-email"))
//		{
//			rp.fillEmailID(RandomUtility.generateRandomEmail()); 
//		}
//		rp.fillPassword(arr.get(i).get("pwd"));
//		rp.fillConfirmPassword(arr.get(i).get("pwd")); //password and confirm password should be same
//		rp.clickOnTerms();
//		rp.clickOnCreate();
//		if(cp.isConfirmationMsgDisplayed())
//		{
//			se.log("Registration is successful in "+bn);
//		}
//		else
//		{
//			se.log("Registration is not successful in "+bn);
//			byte[] s=driver.getScreenshotAs(OutputType.BYTES);
//			se.attach(s,"image/png","wrong page screen shot");
//			Assert.fail();
		}
	}
	
	
	
	
	
  
//}







	@Then("close site")
	public void close_site() {
		driver.quit();
	}

}
