package hw3;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

import javax.naming.ldap.PagedResultsControl;
import java.util.PrimitiveIterator;

public class DifferentElementPage {
    private WebDriver driver;
    @FindBy(className = "dropdown-toggle")
    private WebElement headerMenuService;
    @FindBy(xpath = "//*[@class='dropdown-menu']/li/a[text()='Different elements']")
    private WebElement differentElementsPageServiceHeaderMenu;

    public DifferentElementPage(WebDriver driver){
        this.driver = driver;
        PageFactory.initElements(driver, this);
    }

    public void clickServiceHeaderMenu(){
        headerMenuService.click();
    }

    public void clickDiffElemPageServiceHeaderMenu(){
        differentElementsPageServiceHeaderMenu.click();
    }
}
