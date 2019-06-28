
package hw3.base;

import hw3.HomePage;
import io.github.bonigarcia.wdm.WebDriverManager;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.BeforeSuite;

import static org.testng.Assert.assertEquals;
import static org.testng.Assert.assertTrue;
import static org.testng.AssertJUnit.assertFalse;

public class BaseClass{

    protected WebDriver driver;
    protected HomePage hp;
    public static final String title = "Home Page";

    @BeforeSuite
    public void setUpDriverPath() {
        WebDriverManager.chromedriver().setup();
    }

    @BeforeMethod
    public void setUp() {
        driver = new ChromeDriver();
        driver.get("https://epam.github.io/JDI");
    }

    @AfterMethod
    public void tearDown() {
        driver.close();
    }





    protected void selectCheckbox(String name) {
        driver.findElement(By.xpath("//label[contains(string(), '" + name + "')]/input")).click();
    }

    protected void logRow(String option, String condition) {
        WebElement logRowEl = driver.findElement(By.xpath("//ul[@class='panel-body-list logs']//li[contains(string(),'"
                + option + "')" + "and contains(text(), '" + condition + "')]"));
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



}
