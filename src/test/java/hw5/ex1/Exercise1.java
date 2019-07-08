package hw5.ex1;

import hw3.utils.User;
import hw5.base.AllureAttachmentListener;
import hw5.base.BaseClass;
import hw5.steps.HomePageSteps;
import io.qameta.allure.Feature;
import io.qameta.allure.Story;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Listeners;
import org.testng.annotations.Test;

import java.util.Arrays;
import java.util.List;

@Listeners(AllureAttachmentListener.class)
public class Exercise1 extends BaseClass {

    private HomePageSteps homePageSteps;
    static final int IMAGES_COUNT = 4;
    static final List<String> ICON_TEXT = Arrays.asList("To include good practices\nand ideas from successful\nEPAM project",
            "To be flexible and\ncustomizable", "To be multiplatform",
            "Already have good base\n(about 20 internal and\nsome external projects),\nwish to get more…");
    static final List<String> MAIN_HEADERS_TEXT = Arrays.asList("EPAM FRAMEWORK WISHES…",
            "LOREM IPSUM DOLOR SIT AMET, CONSECTETUR ADIPISICING ELIT, SED DO EIUSMOD TEMPOR INCIDIDUNT UT LABORE " +
                    "ET DOLORE MAGNA ALIQUA. UT ENIM AD MINIM VENIAM, QUIS NOSTRUD EXERCITATION ULLAMCO LABORIS" +
                    " NISI UT ALIQUIP EX EA COMMODO CONSEQUAT DUIS AUTE IRURE DOLOR IN REPREHENDERIT IN" +
                    " VOLUPTATE VELIT ESSE CILLUM DOLORE EU FUGIAT NULLA PARIATUR.");
    static final String SUB_HEADER = "JDI GITHUB";
    static final String LINK = "https://github.com/epam/JDI";

    @BeforeMethod
    @Override
    public void setUp() {
        super.setUp();
        homePageSteps = new HomePageSteps(driver);
    }

    @Feature(value = "JDI test")
    @Story(value= "Home page testing")
    @Test (groups = "All")
    public void test1() {
        //2. Assert browser TITLE
        homePageSteps.checkOpenPageTitle(TITLE);
        // 3.Perform login
        User user = readUserData("src/test/resources//properties/user.properties");
        homePageSteps.loginUser(user.getUserName(), user.getPassword());
        // 4. Assert User name in the left-top side of screen that user is loggined
        homePageSteps.checkLoginUser(user.getFullName());
        // 5. Assert browser TITLE
        homePageSteps.checkOpenPageTitle(TITLE);
        //6. Assert that there are 4 items on the header section and they have proper texts
        homePageSteps.checkHeaderSectionElements();
        //7. Assert that there are 4 images on the Index Page and they are displayed
        homePageSteps.checkHomePageImages(IMAGES_COUNT);
        //8. Assert that there are 4 texts on the Index Page under icons and they have proper text
        homePageSteps.checkTextUnderIconsHomePage(ICON_TEXT);
        //9. Assert a text of the main headers
        homePageSteps.checkMainHeadersText(MAIN_HEADERS_TEXT);
        //10. Assert that there is the iframe in the center of page
        homePageSteps.checkIFrameInTheCenter();
        //11. Switch to the iframe and check that there is Epam logo in the left top conner of iframe
        homePageSteps.checkIFrameLogo();
        //12. Switch to original window back
        homePageSteps.switchToOriginalWindow();
        //13. Assert a text of the sub header
        homePageSteps.checkSubHeaderText(SUB_HEADER);
        //14. Assert that JDI GITHUB is a LINK and has a proper URL
        homePageSteps.checkLink(LINK);
        //15. Assert that there is Left Section
        homePageSteps.checkLeftSection();
        //16. Assert that there is Footer
        homePageSteps.checkFooter();
    }
}
