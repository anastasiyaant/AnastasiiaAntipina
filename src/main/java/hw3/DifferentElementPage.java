package hw3;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

import javax.naming.ldap.PagedResultsControl;
import java.util.List;
import java.util.PrimitiveIterator;

public class DifferentElementPage extends  BasePage{
    @FindBy(className = "label-checkbox")
    private List<WebElement> checkboxes;
    @FindBy(className = "label-radio")
    private List<WebElement> radios;
    @FindBy(className = "colors")
    private List<WebElement> dropdowns;
    @FindBy(name = "Default Button")
    private WebElement buttonLeft;
    @FindBy(css = "input[value='Button']")
    private WebElement buttonRight;
    @FindBy(name = "log-sidebar")
    private WebElement rightSection;
    @FindBy(className = "sidebar-menu")
    private WebElement leftSection;




    public DifferentElementPage(WebDriver driver){
        super(driver);
    }

    public void clickServiceHeaderMenu(){
        headerMenuService.click();
    }

    public void clickDiffElemPageServiceHeaderMenu(){
        differentElementsPageServiceHeaderMenuButton.click();
    }
}
