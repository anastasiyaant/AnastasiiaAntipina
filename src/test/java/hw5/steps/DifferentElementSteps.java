package hw5.steps;

import hw3.DifferentElementPage;
import hw3.steps.BaseSteps;
import hw5.base.TestProvider;
import io.qameta.allure.Step;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;

import java.util.List;

import static hw3.enums.ServiceHeaderTitles.getServiceHeaderTitlesStringList;
import static org.testng.Assert.assertEquals;
import static org.testng.Assert.assertTrue;

public class DifferentElementSteps extends BaseSteps {
    private DifferentElementPage diffElPage;

    public DifferentElementSteps(WebDriver driver) {
        super(driver);
        TestProvider.getInstance().setDriver(driver);
        diffElPage = new DifferentElementPage(driver);
    }

    @Step("Check service subcategory")
    public void checkServiceSubcategory() {
        diffElPage.getHeaderMenuService().click();
        List<WebElement> serviceHeaders = diffElPage.getServiceHeaders();
        List<String> serviceHeaderTitles = getServiceHeaderTitlesStringList();
        checkServiceSubcategoryEquals(serviceHeaders, serviceHeaderTitles);
    }

    @Step("Check left service subcategory")
    public void checkLeftServiceSubcategory() {
        diffElPage.getServiceLeftButton().click();
        List<WebElement> serviceLeftHeaders = diffElPage.getServiceLeftHeader();
        List<String> serviceLeftHeaderTitles = getServiceHeaderTitlesStringList();
        checkLeftServiceSubcategoryEquals(serviceLeftHeaders, serviceLeftHeaderTitles);
    }

    @Step("Open Different Elements Page")
    public void openDifElPage() {
        diffElPage.getHeaderMenuService().click();
        diffElPage.getDifferentElementsPageServiceHeaderMenuButton().click();
    }

    @Step("Check Different Element Page interface")
    public void checkInterfaceDiffELPAge(int boxesCount, int radiosCount, int dropdownsCount) {
        List<WebElement> checkboxes = diffElPage.getCheckboxes();
        List<WebElement> radios = diffElPage.getRadios();
        List<WebElement> dropdowns = diffElPage.getDropdowns();
        WebElement buttonLeft = diffElPage.getButtonLeft();
        WebElement buttonRight = diffElPage.getButtonRight();
        assertEquals(checkboxes.size(), boxesCount);
        assertEquals(radios.size(), radiosCount);
        assertEquals(dropdowns.size(), dropdownsCount);
        assertTrue(isElementDisplayed(buttonLeft));
        assertTrue(isElementDisplayed(buttonRight));
    }

    @Step("Check right section")
    public void checkRightSection() {
        WebElement rightSection = diffElPage.getRightSection();
        assertTrue(isElementDisplayed(rightSection));
    }

    @Step("Check left section")
    public void checkLeftSection() {
        WebElement leftSection = diffElPage.getLeftSectionDiffElPage();
        assertTrue(isElementDisplayed(leftSection));
    }

    @Step("Select checkbox")
    public void selectCheckbox(String name) {
        diffElPage.clickCheckbox(name);

    }

    @Step("Check log row")
    public void checkLogRow(String element, String condition) {
        WebElement logRowEl = diffElPage.checkLogRow(element, condition);
        assertTrue(isElementDisplayed(logRowEl));
    }

    @Step("Select radio")
    public void selectRadio(String name) {
        diffElPage.clickRadio(name);

    }

    @Step("Select dropdown")
    public void selectDropdown(String name) {
        diffElPage.clickDropdown(name);

    }

    @Step("Unselect checkbox")
    public void unselectCheckbox(String name) {
        selectCheckbox(name);
        diffElPage.checkUnselectedCheckbox(name);
    }


}
