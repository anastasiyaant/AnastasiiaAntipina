package hw3.ex1;

import hw3.HomePage;
import hw3.base.BaseClass;
import hw3.steps.HomePageSteps;
import hw3.utils.User;
import hw3.utils.FileUtils;
import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

import static hw3.utils.FileUtils.readUserFromFile;
import static org.testng.Assert.assertEquals;
import static org.testng.Assert.assertTrue;

public class Exercise1ForHW3 extends BaseClass {

    private HomePageSteps homePageSteps;
    static final int imagesCount = 4;
    static final List<String> iconText = Arrays.asList("To include good practices\nand ideas from successful\nEPAM project",
            "To be flexible and\ncustomizable", "To be multiplatform",
            "Already have good HomePage\n(about 20 internal and\nsome external projects),\nwish to get more…");
    static final List<String> mainHeadersText = Arrays.asList("EPAM FRAMEWORK WISHES…",
            "LOREM IPSUM DOLOR SIT AMET, CONSECTETUR ADIPISICING ELIT, SED DO EIUSMOD TEMPOR INCIDIDUNT UT LABORE " +
                    "ET DOLORE MAGNA ALIQUA. UT ENIM AD MINIM VENIAM, QUIS NOSTRUD EXERCITATION ULLAMCO LABORIS" +
                    " NISI UT ALIQUIP EX EA COMMODO CONSEQUAT DUIS AUTE IRURE DOLOR IN REPREHENDERIT IN" +
                    " VOLUPTATE VELIT ESSE CILLUM DOLORE EU FUGIAT NULLA PARIATUR.");
    static final String subHeader= "JDI GITHUB";
    static  final String link ="https://github.com/epam/JDI";

    @BeforeMethod
    @Override
    public void setUp() {
        super.setUp();
        homePageSteps = new HomePageSteps(driver);
    }

    @Test
    public void test1() {
        //2. Assert browser title
        homePageSteps.checkOpenPageTitle(title);
        // 3.Perform login
        User user = readUserFromFile("src/test/resources/properties/user.properties");
        homePageSteps.loginUser(user.getUserName(), user.getPassword());
        // 4. Assert User name in the left-top side of screen that user is loggined
        homePageSteps.checkLoginUser(user.getFullName());
        // 5. Assert browser title
        homePageSteps.checkOpenPageTitle(title);
        //6. Assert that there are 4 items on the header section and they have proper texts
        homePageSteps.checkHeaderSectionElements();
        //7. Assert that there are 4 images on the Index Page and they are displayed
        homePageSteps.checkHomePageImages(imagesCount);
        //8. Assert that there are 4 texts on the Index Page under icons and they have proper text
        homePageSteps.checkTextUnderIconsHomePage(iconText);
        //9. Assert a text of the main headers
        homePageSteps.checkMainHeadersText(mainHeadersText);
        //10. Assert that there is the iframe in the center of page
        homePageSteps.checkIframeInTheCenter();
        //11. Switch to the iframe and check that there is Epam logo in the left top conner of iframe
        homePageSteps.checkIframeLogo();
        //12. Switch to original window back
        homePageSteps.switchToOriginalWindow();
        //13. Assert a text of the sub header
        homePageSteps.checkSubHeaderText(subHeader);
        //14. Assert that JDI GITHUB is a link and has a proper URL
        homePageSteps.checkLink(link);
        //15. Assert that there is Left Section
        homePageSteps.checkLeftSection();
        //16. Assert that there is Footer
        homePageSteps.checkFooter();
    }
}
