package hw4.base;

import com.codeborne.selenide.Browsers;
import com.codeborne.selenide.Configuration;
import hw3.utils.FileUtils;
import hw3.utils.User;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;

import java.nio.file.Paths;

import static com.codeborne.selenide.Selenide.close;

public class BaseClass {
    // TODO Java Code Code convention for the constants
    //fixed
    public static final String LINK = "https://epam.github.io/JDI";
    public static final String BROWSER_TITLE = "Home Page";
    public static final String USER_DATA_FILE_PATH = "src/test/resources//properties/user.properties";

    @BeforeMethod
    public void setUp() {
        Configuration.browser = Browsers.CHROME;
        Configuration.startMaximized = true;
    }

    public User readUserData(String path) {
        return FileUtils.readUserFromFile(Paths.get(path).toAbsolutePath().toString());
    }

    @AfterMethod
    public void tearDown() {
        close();
    }
}
