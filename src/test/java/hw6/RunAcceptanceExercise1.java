package hw6;

import cucumber.api.CucumberOptions;
import cucumber.api.testng.AbstractTestNGCucumberTests;

@CucumberOptions(
        features = {"classpath:hw6"},
        glue = {"classpath:hw6"},
        tags = {"@exercise1"}
)
public class RunAcceptanceExercise1 extends AbstractTestNGCucumberTests {
}
