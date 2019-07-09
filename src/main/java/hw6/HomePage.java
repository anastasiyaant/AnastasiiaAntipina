package hw6;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;

import java.util.List;

public class HomePage extends BasePage {
    private static HomePage instanse;

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


    public HomePage(WebDriver driver) {
        super(driver);
    }

    public void userIconClick() {
        userIcon.click();
    }

    public void fillLoginTextField(String username) {
        loginNameTextField.sendKeys(username);
    }

    public void fillPasswordTextField(String password) {
        this.password.sendKeys(password);
    }

    public void loginButtonClick() {

        loginButton.click();
    }

    public List<WebElement> getImages() {
        return images;
    }

    public List<WebElement> getIconTextElements() {
        return iconTextElements;
    }

    public WebElement getMainHeaderTextUpper() {
        return mainHeaderTextUpper;
    }

    public WebElement getMainHeaderTextDown() {
        return mainHeaderTextDown;
    }


    public static HomePage getInstanse(WebDriver driver) {
        if (instanse == null) {
            instanse = new HomePage(driver);
        }
        return instanse;
    }

    public static void killInstance() {
        instanse = null;
    }
}
