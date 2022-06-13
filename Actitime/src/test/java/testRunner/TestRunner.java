package testRunner;

import org.junit.runner.RunWith;

import io.cucumber.junit.Cucumber;
import io.cucumber.junit.CucumberOptions;

@RunWith(Cucumber.class)
@CucumberOptions
(
features = "src/main/resources/features",
glue="com.actitime.Login",
plugin = {"pretty","html:target/cucumberReport.html"},
monochrome = true
		)
public class TestRunner {

}
