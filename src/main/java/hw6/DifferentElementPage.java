package hw6;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;

import java.util.List;

public class DifferentElementPage extends BasePage {
    private static DifferentElementPage instance;
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
    private WebElement leftSectionDiffElPage;


    public DifferentElementPage(WebDriver driver) {
        super(driver);
    }

    public void clickServiceHeaderMenu() {
        headerMenuService.click();
    }

    public void clickDiffElemPageServiceHeaderMenu() {
        differentElementsPageServiceHeaderMenuButton.click();
    }

    public List<WebElement> getCheckboxes() {
        return checkboxes;
    }

    public List<WebElement> getRadios() {
        return radios;
    }

    public List<WebElement> getDropdowns() {
        return dropdowns;
    }

    public WebElement getButtonLeft() {
        return buttonLeft;
    }

    public WebElement getButtonRight() {
        return buttonRight;
    }

    public WebElement getRightSection() {
        return rightSection;
    }

    public WebElement getLeftSectionDiffElPage() {
        return leftSectionDiffElPage;
    }

    public void clickCheckbox(String name) {
        getCheckboxByName(name).click();
    }

    public WebElement getCheckboxByName(String name) {
        return driver.findElement(By.xpath("//label[contains(string(), '" + name + "')]/input"));
    }


    public void clickRadio(String name) {
        getRadioByName(name).click();
    }

    public WebElement getRadioByName(String name) {
        return driver.findElement(By.xpath("//*[@class='label-radio' and contains(.,'" + name + "')]//input"));
    }

    public void clickDropdown(String name) {
        getDropdownByName(name).click();
    }

    public WebElement getDropdownByName(String name) {
        return driver.findElement(By.xpath("//option[contains(text(), '" + name + "')]"));
    }


    public static DifferentElementPage getInstanse(WebDriver driver) {
        if (instance == null) {
            instance = new DifferentElementPage(driver);
        }
        return instance;
    }

    public static void killInstance() {
        instance = null;
    }

}
