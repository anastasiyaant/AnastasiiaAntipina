
package hw3.base;

import hw3.utils.FileUtils;
import hw3.utils.User;
import io.github.bonigarcia.wdm.WebDriverManager;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.BeforeSuite;

import java.nio.file.Paths;

public class BaseClass {

    protected WebDriver driver;
    // TODO JAva Code Convention for the constants
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

    public User readUserData(String path) {
        return FileUtils.readUserFromFile(Paths.get(path).toAbsolutePath().toString());
    }
}
