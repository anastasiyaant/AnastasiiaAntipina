package hw3.steps;

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

    public void checkElementsHaveProperText(List<WebElement> topMenuElements, List<String> headerMenuTitle) {

        List<String> actualHeaderMenuTitle = new ArrayList<>();
        List<String> headerMenuTitleLower = new ArrayList<>();
        for (WebElement topMenuElement : topMenuElements) {
            actualHeaderMenuTitle.add(topMenuElement.getText().toLowerCase());
        }
        for (String header:headerMenuTitle){
            headerMenuTitleLower.add(header.toLowerCase());
        }
        assertEquals(actualHeaderMenuTitle, headerMenuTitleLower);
    }
    public void checkServiceSubcategoryEquals(List<WebElement>  serviceHeaders, List<String> serviceHeaderTitles){
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
    public void checkLeftServiceSubcategoryEquals(List<WebElement>  serviceLeftHeaders, List<String> serviceLeftHeaderTitles){
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

    public boolean isElementDisplayed(WebElement element) {
        return element.isDisplayed();
    }
}
