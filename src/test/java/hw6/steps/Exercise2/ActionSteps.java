package hw6.steps.Exercise2;

import cucumber.api.java.en.When;
import hw4.utils.User;
import hw6.steps.BaseStep;

import java.util.List;

public class ActionSteps extends BaseStep{



    @When("I login as")
    public void iLoginAs(List<User> users){
        User user = users.get(0);
        homePage.userIconClick();
        homePage.fillLoginTextField(user.getUserName());
        homePage.fillPasswordTextField(user.getPassword());
        homePage.loginButtonClick();
    }



}
