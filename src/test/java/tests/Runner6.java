package tests;

import io.cucumber.testng.AbstractTestNGCucumberTests;
import io.cucumber.testng.CucumberOptions;

@CucumberOptions(
		features={"src\\test\\resources\\features"},
		glue={"gluecode"},
		monochrome=true,
		plugin={"pretty",
				"html:target/mycucumber.html",
				"io.qameta.allure.cucumber7jvm.AllureCucumber7Jvm"}
		)
public class Runner6 extends AbstractTestNGCucumberTests
{
	//install scoop CLI
	//install allure CLI
	//discussion about allure reports   
}











