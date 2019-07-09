package hw6;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

import java.util.List;

public abstract class BasePage {
    @FindBy(xpath = "//*[@class='uui-navigation nav navbar-nav m-l8']/li")
    protected List<WebElement> topMenuElements;
    @FindBy(name = "navigation-sidebar")
    protected WebElement leftSection;
    @FindBy(className = "footer-bg")
    protected WebElement footer;
    @FindBy(xpath = "//*[@class='menu-title' and contains(@index, 3)]")
    protected WebElement serviceLeftButton;
    @FindBy(xpath = "//*[@class='sub']/li")
    protected List<WebElement> serviceLeftHeader;
    @FindBy(className = "dropdown-toggle")
    protected WebElement headerMenuService;
    @FindBy(xpath = "//*[@class='dropdown-menu']/li/a[text()='Different elements']")
    protected WebElement differentElementsPageServiceHeaderMenuButton;
    @FindBy(xpath = "//*[@class='dropdown-menu']/li")
    protected List<WebElement> serviceHeaders;

    @FindBy(id = "user-name")
    protected WebElement fullUserName;


    protected WebDriver driver;

    protected BasePage(WebDriver driver) {
        this.driver = driver;
        PageFactory.initElements(driver, this);
    }

    public void clickServiceHeaderMenu() {
        headerMenuService.click();
    }

    public void clickDiffElemPageServiceHeaderMenu() {
        differentElementsPageServiceHeaderMenuButton.click();
    }

    public String getPageTitle() {
        return driver.getTitle();
    }

    public String getFullUserName() {
        return fullUserName.getText();
    }

    public List<WebElement> getTopMenuElements() {
        return topMenuElements;
    }

    public void switchToOriginalWindow() {
        driver.switchTo().defaultContent();
    }

    public WebElement getLeftSection() {
        return leftSection;
    }

    public WebElement getFooter() {
        return footer;
    }

    public WebElement getHeaderMenuService() {
        return headerMenuService;
    }

    public List<WebElement> getServiceHeaders() {
        return serviceHeaders;
    }

    public WebElement getServiceLeftButton() {
        return serviceLeftButton;
    }

    public List<WebElement> getServiceLeftHeader() {
        return serviceLeftHeader;
    }

    public WebElement getDifferentElementsPageServiceHeaderMenuButton() {
        return differentElementsPageServiceHeaderMenuButton;
    }
}