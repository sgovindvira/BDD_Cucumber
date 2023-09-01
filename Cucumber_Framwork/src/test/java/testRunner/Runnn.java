package testRunner;

import io.cucumber.testng.AbstractTestNGCucumberTests;
import io.cucumber.testng.CucumberOptions;

@CucumberOptions(



		//features = ".//Features/Customer.feature",  -------------->//single feature
		//features = ".//Features/",  ---------------------> // Run all features files


		features = {".//Features/LoginFeature.feature",".//Features/Customer.feature"},//------------> Selected feature files
		glue="StepDefinitions1",
		dryRun = false,
		monochrome = true,

		//tags = "@regression and @Sanity", 
		//tags = "@regression or @Sanity",   
		//tags = "@regression and @sanity",
		//tags = "@regression and not @sanity", 
		tags = "@three",



		//plugin = {"pretty","html:target/cucumber-Reports/reports1.html"},
		//plugin = {"pretty","json:target/cucumber-Reports/reports_json.html"}
		plugin={"com.aventstack.extentreports.cucumber.adapter.ExtentCucumberAdapter:"}




		)


		public class Runnn extends AbstractTestNGCucumberTests{

}
