package hw3.steps;

import hw3.DifferentElementPage;
import org.omg.PortableServer.SERVANT_RETENTION_POLICY_ID;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.testng.asserts.SoftAssert;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

import static hw3.enums.ServiceHeaderTitles.getServiceHeaderTitlesStringList;

public class DifferentElementSteps extends BaseSteps{
    private DifferentElementPage diffElPage;
    public DifferentElementSteps(WebDriver driver){
        super(driver);
        diffElPage=new DifferentElementPage(driver);
    }

    public void checkServiceSubcategory(){
        diffElPage.getHeaderMenuService().click();
        List<WebElement> serviceHeaders = diffElPage.getServiceHeaders();
        List<String> serviceHeaderTitles = getServiceHeaderTitlesStringList();
        checkServiceSubcategoryEquals(serviceHeaders, serviceHeaderTitles);
    }
    public void checkLeftServiceSubcategory(){
        diffElPage.getServiceLeftButton().click();
        List<WebElement> serviceLeftHeaders = diffElPage.getServiceLeftHeader();
        List<String> serviceLeftHeaderTitles = getServiceHeaderTitlesStringList();
        checkLeftServiceSubcategoryEquals(serviceLeftHeaders, serviceLeftHeaderTitles);
    }
    public void openDifElpage(){
        diffElPage.getHeaderMenuService().click();
        diffElPage.getDifferentElementsPageServiceHeaderMenuButton().click();
    }
}
