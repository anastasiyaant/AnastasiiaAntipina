// TODO package name should be in lower case
package hw2.base;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.BeforeSuite;

import java.nio.file.Paths;

import static org.testng.Assert.assertEquals;
import static org.testng.Assert.assertTrue;
import static org.testng.AssertJUnit.assertFalse;

public class BaseClass {

    protected WebDriver driver;

    @BeforeSuite
    public void setUpDriverPath() {
        System.setProperty("webdriver.chrome.driver",
                Paths.get("driver/chromedriver.exe").toAbsolutePath().toString());
    }

    @BeforeMethod
    public void setUp() {
        driver = new ChromeDriver();
        driver.get("https://epam.github.io/JDI");
        login("epam", "1234");
    }

    @AfterMethod
    public void tearDown() {
        driver.close();
    }

    // TODO Why do you set suffix Test for the method
    // It was by mistake, fixed it
    protected void login(String login, String password) {
        driver.findElement(By.id("user-icon")).click();
        driver.findElement(By.id("name")).sendKeys(login);
        driver.findElement(By.cssSelector("#password")).sendKeys(password);
        driver.findElement(By.xpath("//button[@id='login-button']")).click();
        //Assert User name in the left-top side of screen that user is loggined
        assertEquals(driver.findElement(By.id("user-name")).getText(), "PITER CHAILOVSKII");
    }

    protected void checkOpenPageTitle(String title) {
        assertEquals(driver.getTitle(), title);
    }

    protected void selectCheckbox(String name) {
        driver.findElement(By.xpath("//label[contains(string(), '" + name + "')]/input")).click();
    }

    protected void logRow(String option, String condition) {
        WebElement logRowEl = driver.findElement(By.xpath("//ul[@class='panel-body-list logs']//li[contains(string(),'"
                + option + "')" + "and contains(text(), '" + condition + "')]"));
        // TODO What do you try to check this line?
        // Is element with correct value displayed on the site or not.
        // Additionally got WebElement.isDisplayed in separated method
        assertTrue(isElementDisplayed(logRowEl));
    }

    protected void selectRadio(String name) {
        WebElement radio = driver.findElement(By.xpath("//*[@class='label-radio' and contains(.,'" + name + "')]//input"));
        radio.click();
    }

    protected void selectOption(String name) {
        WebElement option = driver.findElement(By.xpath("//option[contains(text(), '" + name + "')]"));
        option.click();
    }

    protected void checkUnselectedCheckbox(String name) {
        selectCheckbox(name);
        assertFalse(driver.findElement(By.xpath("//label[contains(string(), '" + name + "')]/input")).isSelected());
    }

    protected String getElementText(WebElement element){
        return element.getText();
    }

    protected boolean isElementDisplayed(WebElement element){
        return element.isDisplayed();
    }
}
