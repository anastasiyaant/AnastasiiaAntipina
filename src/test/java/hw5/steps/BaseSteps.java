package hw5.steps;

import io.qameta.allure.Step;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.testng.asserts.SoftAssert;

import java.util.ArrayList;
import java.util.List;

import static org.testng.AssertJUnit.assertEquals;

public class BaseSteps {
    protected WebDriver driver;

    public BaseSteps(WebDriver driver) {
        this.driver = driver;
    }

    @Step("Check that elements have proper text")
    public void checkElementsHaveProperText(List<WebElement> topMenuElements, List<String> headerMenuTitle) {

        List<String> actualHeaderMenuTitle = new ArrayList<>();
        List<String> headerMenuTitleLower = new ArrayList<>();
        for (WebElement topMenuElement : topMenuElements) {
            actualHeaderMenuTitle.add(topMenuElement.getText().toLowerCase());
        }
        for (String header : headerMenuTitle) {
            headerMenuTitleLower.add(header.toLowerCase());
        }
        assertEquals(actualHeaderMenuTitle, headerMenuTitleLower);
    }
    @Step("Check that that service subcategory is right")
    public void checkServiceSubcategoryEquals(List<WebElement> serviceHeaders, List<String> serviceHeaderTitles) {
        List<String> actualServiceHeaderTitles = new ArrayList<>();
        for (WebElement serviceHeader : serviceHeaders) {
            actualServiceHeaderTitles.add(serviceHeader.getText().toLowerCase());
        }
        SoftAssert sa = new SoftAssert();
        for (String serviceHeaderTitle : serviceHeaderTitles) {
            sa.assertTrue(actualServiceHeaderTitles.contains(serviceHeaderTitle));
        }
        sa.assertAll();
    }

    @Step("Check that left service subcategory is right")
    public void checkLeftServiceSubcategoryEquals(List<WebElement> serviceLeftHeaders, List<String> serviceLeftHeaderTitles) {
        List<String> actualServiceLeftHeaderTitles = new ArrayList<>();
        for (WebElement serviceLeftHeader : serviceLeftHeaders) {
            actualServiceLeftHeaderTitles.add(serviceLeftHeader.getText().toLowerCase());
        }
        SoftAssert sa = new SoftAssert();
        for (String serviceLeftHeaderTitle : serviceLeftHeaderTitles) {
            sa.assertTrue(actualServiceLeftHeaderTitles.contains(serviceLeftHeaderTitle));
        }
        sa.assertAll();
    }

    @Step("Check that element is displayed")
    public boolean isElementDisplayed(WebElement element) {
        return element.isDisplayed();
    }
}
