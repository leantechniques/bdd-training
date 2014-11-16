package co.leantechniques;

import cucumber.api.CucumberOptions;
import cucumber.api.junit.Cucumber;
import org.junit.runner.RunWith;

@RunWith(Cucumber.class)
@CucumberOptions(
        strict = true,    // Fail when not implemented
        tags = "~@WIP",   // Don't run scenarios that are Work In Progress.
        format = {"pretty", "html:target/cucumber"}
)
public class CucumberTest {
}
