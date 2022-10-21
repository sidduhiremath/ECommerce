package com.TestRunner;



import org.junit.runner.RunWith;

import cucumber.api.CucumberOptions;
import cucumber.api.junit.Cucumber;

@RunWith(Cucumber.class)
@CucumberOptions(
features = { "src\\test\\java\\com\\Features"}
,glue={"com.StepDefinition"}
,monochrome=true
//,dryRun=false
,plugin= {"pretty","json:target/cucumber.json","com.cucumber.listener.ExtentCucumberFormatter:target/report.html"} //to generate different types of reporting
)
public class Runner {

}


