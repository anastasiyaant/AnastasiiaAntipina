package hw6;


import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;

import java.util.List;

public class UserPage extends BasePage {
    private static UserPage instance;

    @FindBy(tagName = "select")
    protected List<WebElement> dropdowns;
    @FindBy(xpath = "//td/img")
    protected List<WebElement> images;
    @FindBy(css = "#user-table > tbody > tr > td a")
    protected List<WebElement> usernames;
    @FindBy(css = "[class = 'user-descr'] > span")
    protected List<WebElement> textsUnderImages;
    @FindBy(css = "[type='checkbox']")
    protected List<WebElement> checkboxes;

    public UserPage(WebDriver driver) {
        super(driver);
    }

    public static UserPage getInstanse(WebDriver driver) {
        if (instance == null) {
            instance = new UserPage(driver);
        }
        return instance;
    }

    public static void killInstance() {
        instance = null;
    }

    public List<WebElement> getDropdowns() {
        return dropdowns;
    }

    public List<WebElement> getImages() {
        return images;
    }

    public List<WebElement> getUsernames() {
        return usernames;
    }

    public List<WebElement> getTextsUnderImages() {
        return textsUnderImages;
    }

    public List<WebElement> getCheckboxes() {
        return checkboxes;
    }
}
