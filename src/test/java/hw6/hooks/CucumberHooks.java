package hw6.hooks;

import cucumber.api.java.After;
import cucumber.api.java.Before;
import hw6.DifferentElementPage;
import hw6.HomePage;
import hw6.UserPage;
import io.github.bonigarcia.wdm.WebDriverManager;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;

import java.util.concurrent.TimeUnit;

public class CucumberHooks {

    @Before
    public void setUp() {
        WebDriverManager.chromedriver().setup();
        WebDriver driver = new ChromeDriver();
        driver.manage().timeouts().implicitlyWait(50000, TimeUnit.MILLISECONDS);
        driver.manage().window().maximize();
        TestContext.setDriver(driver);
    }

    @After
    public void closeDriver() {
        DifferentElementPage.killInstance();
        HomePage.killInstance();
        UserPage.killInstance();
        TestContext.getDriver().close();
    }


}
