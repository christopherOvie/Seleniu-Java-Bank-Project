package gluecode;

import org.openqa.selenium.remote.RemoteWebDriver;

import io.cucumber.java.After;
import io.cucumber.java.AfterStep;
import io.cucumber.java.Before;
import io.cucumber.java.BeforeStep;
import io.cucumber.java.Scenario;

public class Shared {
	public RemoteWebDriver driver; //to contact web pages in browser
	public Scenario se; //to generate common reports
	public int stepno;
	public static int scenariono=1; //start with 1st scenario
	
	@Before
	public void method1(Scenario s) //before every scenario by taking that scenario information
	{
		this.se=s;
		if(se.getName()!="")
		{
			se.log(se.getName()+" is started");
		}
		else
		{
			se.log("Scenario:"+scenariono+" is started");
		}
		stepno=1; //set to 1 before going into steps of each scenario
	}
	
	@BeforeStep
	public void method2(Scenario s) //before every step
	{
		se.log("Step-"+stepno+" is started");
	}
	
	@AfterStep
	public void method3(Scenario s) //after every step
	{
		se.log("Step-"+stepno+" is completed");
		stepno++;
	}
	@After
	public void method4(Scenario s) //after every scenario
	{
		if(se.getName()!="")
		{
			se.log(s.getName()+" is completed with status:"+s.getStatus().name());
		}
		else
		{
			se.log("Scenario:"+scenariono+" is completed with status:"+s.getStatus().name());
		}
		scenariono++; //for next scenario
	}
	
}
