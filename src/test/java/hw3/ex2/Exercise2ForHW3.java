package hw3.ex2;

import hw3.DifferentElementPage;
import hw3.base.BaseClass;
import hw3.steps.DifferentElementSteps;
import hw3.steps.HomePageSteps;
import hw3.utils.User;
import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;
import org.testng.asserts.SoftAssert;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

import static hw3.utils.FileUtils.readUserFromFile;

public class Exercise2ForHW3 extends BaseClass {

    HomePageSteps homePageSteps;
    DifferentElementSteps diffElSteps;

    @BeforeMethod
    @Override
    public void setUp() {
        super.setUp();
        homePageSteps = new HomePageSteps(driver);
    }

    @Test
    public void test2() {
        // 2. Assert browser title
        homePageSteps.checkOpenPageTitle(title);
        // 3.Perform login
        User user = readUserFromFile("src/test/resources/properties/user.properties");
        homePageSteps.loginUser(user.getUserName(), user.getPassword());
        // 4. Assert User name in the left-top side of screen that user is loggined
        homePageSteps.checkLoginUser(user.getFullName());
        //5. Click on "Service" subcategory in the header and check that drop down contains options
        diffElSteps.checkServiceSubcategory();
        //6. Click on "Service" subcategory in the left section and check that drop down contains options
        diffElSteps.checkLeftServiceSubcategory();
        //7. Open through the header menu Service->Different element page
        diffElStep.openDifElpage();





    }

}
