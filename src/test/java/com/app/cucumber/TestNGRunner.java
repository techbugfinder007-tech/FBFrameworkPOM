package com.app.cucumber;


import io.cucumber.testng.AbstractTestNGCucumberTests;
import io.cucumber.testng.CucumberOptions;

@CucumberOptions(
        features = "src/test/java/com/app/cucumber",     // Path to feature files
        glue = "com.app.stepdefinations",        // Step Definition package
        plugin = {
                "pretty",
                "html:target/cucumber-reports.html"
        },
        monochrome = true                  // Cleaner console output
        //tags = "@smoke"                          // Run specific tagged tests
)
public class TestNGRunner extends AbstractTestNGCucumberTests {
	
	
}