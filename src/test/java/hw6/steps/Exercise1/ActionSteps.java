package hw6.steps.Exercise1;

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

    @When("I click 'Service' header menu button")
    public void iClickHeaderMenuButton(){
        homePage.clickServiceHeaderMenu();
    }

    @When("I click 'Service' left menu button")
    public void iClickLeftMenuButton(){homePage.getServiceLeftButton().click();}

    @When("I click 'Different Elements' service menu button")
    public void iClickDifferentElementsButton(){
        diffPage.getDifferentElementsPageServiceHeaderMenuButton().click();
    }



}
