package hw6.steps;

import cucumber.api.DataTable;
import cucumber.api.java.en.Then;
import hw6.hooks.TestContext;
import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;

import java.util.List;
import java.util.Map;
import java.util.stream.Collectors;

import static org.testng.Assert.assertEquals;
import static org.testng.Assert.assertTrue;

public class AssertionSteps extends BaseStep {

    @Then("User name should be '(.*)'")
    public void userNameShouldBe(String expectedUsername) {
        WebElement userNameWebElement = TestContext.getDriver().findElement(By.id("user-name"));
        assertEquals(userNameWebElement.getText(), expectedUsername);
    }

    @Then("'(User Table|Home Page)' page is opened")
    public void browserTitleShouldBe(String expectedTitle) {
        assertEquals(homePage.getPageTitle(), expectedTitle);
    }

    @Then("'([0-9]+)' pictures are exist on Home Page")
    public void picturesAreExist(int expectedCount) {
        List<WebElement> images = homePage.getImages();
        assertEquals(images.size(), expectedCount);
    }

    @Then("'([0-9]+)' texts under pictures are exist on Home Page")
    public void textUnderPicturesAreExist(int expectedCount) {
        List<WebElement> iconTextElements = homePage.getIconTextElements();
        assertEquals(iconTextElements.size(), expectedCount);
    }

    @Then("'([0-9]+)' texts above are exist on Home Page")
    public void textsAboveAreExist(int expectedCount) {
        WebElement mainHeaderTextUpper = homePage.getMainHeaderTextUpper();
        assertTrue(mainHeaderTextUpper.isDisplayed());
        WebElement mainHeaderTextDown = homePage.getMainHeaderTextDown();
        assertTrue(mainHeaderTextDown.isDisplayed());
    }

    @Then("Dropdown list should be displayed on Home Page")
    public void dropdownListShouldBe() {
        assertTrue(TestContext.getDriver().findElement(By.className("dropdown-menu")).isDisplayed());
    }

    @Then("Dropdown list on Home Page should have '([^\"]*)'")
    public void dropdownListShouldHave(List<String> items) {
        List<WebElement> serviceHeaders = homePage.getServiceHeaders();
        List<String> serviceHeadersList = serviceHeaders.
                stream()
                .map(WebElement::getText)
                .collect(Collectors.toList());
        items = items.stream().map(String::toUpperCase).collect(Collectors.toList());
        assertEquals(serviceHeadersList, items);
    }

    @Then("Dropdown left list should be displayed on Home Page")
    public void dropdownLeftListShouldBe() {
        assertTrue(TestContext.getDriver().findElement(By.className("sub")).isDisplayed());
    }

    @Then("Dropdown left list on Home Page should have '([^\"]*)'")
    public void dropdownLeftListShouldHave(List<String> items) {
        List<WebElement> serviceHeaders = homePage.getServiceLeftHeader();
        List<String> serviceHeadersList = serviceHeaders.
                stream()
                .map(WebElement::getText)
                .collect(Collectors.toList());
        assertEquals(serviceHeadersList, items);
    }

    @Then("'([0-9]+)' checkboxes are exist on Different Elements Page")
    public void checkboxesAreExist(int expectedCount) {
        List<WebElement> checkboxes = diffPage.getCheckboxes();
        assertEquals(checkboxes.size(), expectedCount);
    }

    @Then("'([0-9]+)' radios are exist on Different Elements Page")
    public void radiosAreExist(int expectedCount) {
        List<WebElement> radios = diffPage.getRadios();
        assertEquals(radios.size(), expectedCount);
    }

    @Then("'([0-9]+)' dropdowns are exist on Different Elements Page")
    public void dropdownsAreExist(int expectedCount) {
        List<WebElement> dropdowns = diffPage.getDropdowns();
        assertEquals(dropdowns.size(), expectedCount);
    }

    @Then("'([0-9]+)' buttons are exist on Different Elements Page")
    public void buttonsAreExist(int expectedCount) {
        WebElement buttonLeft = diffPage.getButtonLeft();
        WebElement buttonRight = diffPage.getButtonRight();
        assertTrue(isElementDisplayed(buttonLeft));
        assertTrue(isElementDisplayed(buttonRight));
    }

    @Then("right section should be on Different Elements Page")
    public void rightSectionShouldBe() {
        WebElement rightSection = diffPage.getRightSection();
        assertTrue(isElementDisplayed(rightSection));
    }

    @Then("left section should be on Different Elements Page")
    public void leftSectionShouldBe() {
        WebElement leftSection = diffPage.getLeftSectionDiffElPage();
        assertTrue(isElementDisplayed(leftSection));
    }

    @Then("I select checkboxes '([^\"]*)' on Different Elements Page")
    public void iSelectCheckbox(List<String> values) {
        for (String value : values) {
            diffPage.clickCheckbox(value);
        }
    }

    @Then("Individual log row and value corresponded to the status '(.*)' with condition '(.*)' on Different Elements Page")
    public void individualLogRowCorrespondedToTheStatus(String element, String condition) {
        WebElement logRowEl = diffPage.checkLogRow(element, condition);
        assertTrue(isElementDisplayed(logRowEl));
    }

    @Then("I select radio '(.*)' on Different Elements Page")
    public void iSelectRadio(String value) {
        diffPage.clickRadio(value);
    }


    @Then("I select dropdown '(.*)' on Different Elements Page")
    public void iSelectDropdown(String value) {
        diffPage.clickDropdown(value);
    }

    @Then("I unselect checkboxes '([^\"]*)' on Different Elements Page")
    public void iUnselectCheckbox(List<String> values) {
        for (String value : values) {
            diffPage.clickCheckbox(value);
        }
    }

    @Then("'([0-9]+)' NumberType Dropdowns are displayed on Users Table on User Table Page")
    public void countNumberTypeDropdownsAreDiaplayedOnUserPage(int expectedCount) {
        List<WebElement> dropdowns = userPage.getDropdowns();
        assertEquals(dropdowns.size(), expectedCount);

    }

    @Then("'([0-9]+)' User names are displayed on Users Table on User Table Page")
    public void countUserNamesAreDisplayedOnUserTable(int expectedCount) {
        List<WebElement> userNames = userPage.getUsernames();
        assertEquals(userNames.size(), expectedCount);
    }

    @Then("'([0-9]+)' Description images are displayed on Users Table on User Table Page")
    public void countDescriptionImagesAreDisplayedOnUserPage(int expectedCount) {
        List<WebElement> images = userPage.getImages();
        assertEquals(images.size(), expectedCount);
    }

    @Then("'([0-9]+)' Description texts under images are displayed on Users Table on User Table Page")
    public void countDescriptionTextsAreDisplayedOnUserPage(int expectedCount) {
        List<WebElement> desciptions = userPage.getTextsUnderImages();
        assertEquals(desciptions.size(), expectedCount);
    }

    @Then("'([0-9]+)' checkboxes are displayed on Users Table on User Table Page")
    public void countCheckBoxesAreDisplayedOnUserPage(int expectedCount) {
        List<WebElement> checkboxes = userPage.getCheckboxes();
        assertEquals(checkboxes.size(), expectedCount);
    }

    @Then("User table contains following values:")
    public void userTableContains(DataTable table) {
        List<Map<String, String>> tableAsMaps = table.asMaps(String.class, String.class);
        for (int i = 0; i < tableAsMaps.size(); i++) {
            assertEquals(userPage.getUsernames().get(i).getText(), tableAsMaps.get(i).get("User"));
        }
    }

    @Then("I log row has '([^\"]*)' text in log section")
    public void logRowValue(String value) {
        WebElement logRowEl = userPage.checkLogRow(value);
        assertTrue(isElementDisplayed(logRowEl));


    }

    @Then("droplist contains values")
    public void droplistContainsValues(List<String> values) {
        List<WebElement> actualValues = TestContext.getDriver().findElements(By.tagName("option"));
        List<String> actualValuesToString = actualValues.
                stream()
                .map(WebElement::getText)
                .collect(Collectors.toList());
        for (String actualValue : actualValuesToString) {
            assertTrue(values.contains(actualValue));
        }
    }
}
