package hw4;

import com.codeborne.selenide.ElementsCollection;
import com.codeborne.selenide.SelenideElement;
import hw4.enums.Menu;
import org.openqa.selenium.By;
import org.openqa.selenium.support.FindBy;

import static com.codeborne.selenide.Selenide.*;

public class HomePage {
    @FindBy(css = "#user-name")
    private SelenideElement userName;
    @FindBy(xpath = "//*[@class='dropdown-menu']/li")
    protected ElementsCollection serviceHeaders;
    @FindBy(xpath = "//*[@class='menu-title' and contains(@index, 3)]")
    protected SelenideElement serviceLeftButton;
    @FindBy(xpath = "//*[@class='sub']/li")
    protected ElementsCollection serviceLeftHeader;
    @FindBy(xpath = "//*[@class='dropdown-menu']/li/a[text()='Table with pages']")
    protected SelenideElement tableWithPagesButton;


    public HomePage() {
        page(this);
    }

    public SelenideElement getUserName() {
        return userName;
    }

    public void login(String login, String password) {
        $(By.id("user-icon")).click();
        $(By.id("name")).sendKeys(login);
        $("#password").sendKeys(password);
        $(By.xpath("//button[@id='login-button']")).click();
    }


    public ElementsCollection getServiceHeaders() {
        return serviceHeaders;
    }

    public SelenideElement getServiceLeftButton() {
        return serviceLeftButton;
    }

    public ElementsCollection getServiceLeftHeader() {
        return serviceLeftHeader;
    }

    public void clickButton(SelenideElement element){
        element.click();
    }

    public SelenideElement getTableWithPagesButton() {
        return tableWithPagesButton;
    }

    public SelenideElement getMenuItem(Menu menuElement){
        return $(By.linkText(menuElement.getName()));
    }
}
