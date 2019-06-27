package hw3;

import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;

public class HomePage {
    @FindBy(id = "user-icon")
    private WebElement userIcon;
    @FindBy(id = "name")
    private WebElement loginNameTextField;
    @FindBy(css = "#password")
    private WebElement password;
    @FindBy(xpath = "//button[@id='login-button']")
    private WebElement loginButton;

    public void login(String login, String password) {
        userIcon.click();
        loginNameTextField.sendKeys(login);
        this.password.sendKeys(password);
        loginButton.click();
    }
}
