package hw3.steps;

import hw3.DifferentElementPage;
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
        diffElPage = new DifferentElementPage(driver);
    }

    public void checkServiceSubcategory() {
        diffElPage.getHeaderMenuService().click();
        List<WebElement> serviceHeaders = diffElPage.getServiceHeaders();
        List<String> serviceHeaderTitles = getServiceHeaderTitlesStringList();
        checkServiceSubcategoryEquals(serviceHeaders, serviceHeaderTitles);
    }

    public void checkLeftServiceSubcategory() {
        diffElPage.getServiceLeftButton().click();
        List<WebElement> serviceLeftHeaders = diffElPage.getServiceLeftHeader();
        List<String> serviceLeftHeaderTitles = getServiceHeaderTitlesStringList();
        checkLeftServiceSubcategoryEquals(serviceLeftHeaders, serviceLeftHeaderTitles);
    }

    public void openDifElpage() {
        diffElPage.getHeaderMenuService().click();
        diffElPage.getDifferentElementsPageServiceHeaderMenuButton().click();
    }

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

    public void checkRightSection() {
        WebElement rightSection = diffElPage.getRightSection();
        assertTrue(isElementDisplayed(rightSection));
    }

    public void checkLeftSection() {
        WebElement leftSection = diffElPage.getLeftSectionDiffElPage();
        assertTrue(isElementDisplayed(leftSection));
    }

    public void selectCheckbox(String name) {
        diffElPage.clickCheckbox(name);

    }

    public void checkLogRow(String element, String condition) {
        WebElement logRowEl = diffElPage.checkLogRow(element, condition);
        assertTrue(isElementDisplayed(logRowEl));
    }

    public void selectRadio(String name) {
        diffElPage.clickRadio(name);

    }

    public void selectDropdown(String name) {
        diffElPage.clickDropdown(name);

    }

    public void unselectCheckbox(String name) {
        selectCheckbox(name);
        diffElPage.checkUnselectedCheckbox(name);
    }
}
