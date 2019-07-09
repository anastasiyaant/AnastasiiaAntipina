package hw6.steps;

import cucumber.api.java.en.When;
import org.openqa.selenium.WebElement;

public class ActionSteps extends BaseStep {


    @When("I click on 'Service' button in Header")
    public void iClickHeaderMenuButton() {
        homePage.clickServiceHeaderMenu();
    }

    @When("I click 'Service' left menu button")
    public void iClickLeftMenuButton() {
        homePage.getServiceLeftButton().click();
    }

    @When("I click 'Different Elements' service menu button")
    public void iClickDifferentElementsButton() {
        diffPage.getDifferentElementsPageServiceHeaderMenuButton().click();
    }


    @When("I click on 'User Table' button in Service dropdown")
    public void iClickOnUserTableButton() {
        diffPage.getUserTablePageButtonFromServiceHeader().click();
    }

    @When("I select '(.*)' checkbox for '(.*)'")
    public void iSelectCheckboxForUser(String value, String name) {
        for (WebElement userName : userPage.getUsernames()) {
            if (userName.getText().equals(name)) {
                userPage.getCheckboxes().get(userPage.getUsernames().indexOf(userName)).click();
                break;
            }
        }
    }

    @When("I click on dropdown in column Type for user '(.*)'")
    public void iClickOnDropdownInColumnTypeForUser(String name) {
        for (WebElement userName : userPage.getUsernames()) {
            if (userName.getText().equals(name)) {
                userPage.getDropdowns().get(userPage.getUsernames().indexOf(userName)).click();
                break;
            }
        }
    }

}
