package hw6.steps;

import cucumber.api.java.en.Given;
import hw4.utils.User;
import hw6.hooks.TestContext;

import java.util.List;

public class GivenSteps extends BaseStep {
    @Given("I am on Home Page")
    public void iAmOnTheGdiIndexPage() {
        TestContext.getDriver().get("https://epam.github.io/JDI/index.html");
    }

    @Given("I login as")
    public void iLoginAs(List<User> users) {
        User user = users.get(0);
        homePage.userIconClick();
        homePage.fillLoginTextField(user.getUserName());
        homePage.fillPasswordTextField(user.getPassword());
        homePage.loginButtonClick();
    }

}
