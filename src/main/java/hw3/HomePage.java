package hw3;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;

import java.util.List;

public class HomePage extends BasePage{
    @FindBy(id = "user-icon")
    private WebElement userIcon;
    @FindBy(id = "name")
    private WebElement loginNameTextField;
    @FindBy(css = "#password")
    private WebElement password;
    @FindBy(xpath = "//button[@id='login-button']")
    private WebElement loginButton;
    @FindBy(css = "div.benefit-icon")
    protected List<WebElement> images;
    @FindBy(css = "span.benefit-txt")
    protected List<WebElement> iconTextElements;
    @FindBy(name = "main-title")
    protected WebElement mainHeaderTextUpper;
    @FindBy(name = "jdi-text")
    protected WebElement mainHeaderTextDown;
    @FindBy(id = "iframe")
    protected WebElement iframe;
    @FindBy(id = "epam_logo")
    protected WebElement epamLogo;
    @FindBy(css = "[class='text-center']")
    protected WebElement subHeader;
    @FindBy(linkText = "JDI GITHUB")
    protected WebElement link;


    public HomePage(WebDriver driver){
        super(driver);
    }


    public void login(String login, String password) {
        userIcon.click();
        loginNameTextField.sendKeys(login);
        this.password.sendKeys(password);
        loginButton.click();
    }

    public List<WebElement> getImages(){
        return images;
    }

    public List<WebElement> getIconTextElements(){
        return iconTextElements;
    }

    public WebElement getMainHeaderTextUpper() {
        return mainHeaderTextUpper;
    }

    public WebElement getMainHeaderTextDown() {
        return mainHeaderTextDown;
    }

    public WebElement getIframe() {
        return iframe;
    }

    public void  switchToIframe(){
        driver.switchTo().frame(iframe);
    }

    public WebElement getEpamLogo() {
        return epamLogo;
    }

    public String getSubHeader(){
        return subHeader.getText();
    }
    public String getLink(){
        return link.getText();
    }
}