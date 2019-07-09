package hw6.steps.Exercise2;

import cucumber.api.java.en.Given;
import hw6.hooks.TestContext;
import hw6.steps.BaseStep;

public class GivenSteps extends BaseStep {
    @Given("I am on the JDI Index Page")
    public void iAmOnTheGdiIndexPage() {
        TestContext.getDriver().get("https://epam.github.io/JDI/index.html");
    }
}
