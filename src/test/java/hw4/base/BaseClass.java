package hw4.base;

import com.codeborne.selenide.Browsers;
import com.codeborne.selenide.Configuration;
import hw3.utils.FileUtils;
import hw3.utils.User;
import org.testng.annotations.BeforeMethod;

import java.nio.file.Paths;

public class BaseClass {
    public static final String link = "https://epam.github.io/JDI";
    public static final String browserTitle = "Home Page";
    public static final String userDataFilePath = "src/test/resources//properties/user.properties";
    @BeforeMethod
    public void setUp() {
        Configuration.browser = Browsers.CHROME;
        Configuration.startMaximized = true;
    }

    public User readUserData(String path) {
        return FileUtils.readUserFromFile(Paths.get(path).toAbsolutePath().toString());
    }
}
