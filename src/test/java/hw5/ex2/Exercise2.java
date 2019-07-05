package hw5.ex2;

import hw3.base.BaseClass;
import hw3.enums.Checkbox;
import hw3.enums.Colors;
import hw3.enums.Conditions;
import hw3.enums.Radio;
import hw5.base.AllureAttachmentListener;
import hw5.steps.DifferentElementSteps;
import hw5.steps.HomePageSteps;
import hw3.utils.User;
import io.qameta.allure.Feature;
import io.qameta.allure.Story;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Listeners;
import org.testng.annotations.Test;


@Listeners(AllureAttachmentListener.class)
@Feature(value = "JDI test")
@Story(value= "Home page testing")
public class Exercise2 extends BaseClass {

    HomePageSteps homePageSteps;
    DifferentElementSteps diffElSteps;

    static final int CHECKBOXES_COUNT = 4;
    static final int DROPDOWNS_COUNT = 1;
    static final int RADIO_COUNT = 4;
    static final String RADIO_ELEMENT = "metal";
    static final String DROPDOWN_ELEMENT = "Colors";

    @BeforeMethod
    @Override
    public void setUp() {
        super.setUp();
        homePageSteps = new HomePageSteps(driver);
        diffElSteps = new DifferentElementSteps(driver);
    }

    @Test
    public void test2() {
        // 2. Assert browser TITLE
        homePageSteps.checkOpenPageTitle(title);
        // 3.Perform login
        User user = readUserData("src/test/resources/properties/user.properties");
        homePageSteps.loginUser(user.getUserName(), user.getPassword());
        // 4. Assert User name in the left-top side of screen that user is loggined
        homePageSteps.checkLoginUser(user.getFullName());
        //5. Click on "Service" subcategory in the header and check that drop down contains options
        diffElSteps.checkServiceSubcategory();
        //6. Click on "Service" subcategory in the left section and check that drop down contains options
        diffElSteps.checkLeftServiceSubcategory();
        //7. Open through the header menu Service->Different element page
        diffElSteps.openDifElPage();
        //8. Check interface on Different element page, it contains all needed elements
        diffElSteps.checkInterfaceDiffELPAge(CHECKBOXES_COUNT, RADIO_COUNT, DROPDOWNS_COUNT);
        //9. Assert that there is Right Section
        diffElSteps.checkRightSection();
        //10. Assert that there is Left Section
        diffElSteps.checkLeftSection();
        //11. Select Checkboxes
        diffElSteps.selectCheckbox(Checkbox.WATER.getValue());
        diffElSteps.selectCheckbox(Checkbox.WIND.getValue());
        //12. Assert that for each checkbox there is an individual log row and value
        // is corresponded to the status of checkbox
        diffElSteps.checkLogRow(Checkbox.WATER.getValue(), Conditions.TRUE.getValue());
        diffElSteps.checkLogRow(Checkbox.WIND.getValue(), Conditions.TRUE.getValue());
        //13.Select radio
        diffElSteps.selectRadio(Radio.SELEN.getValue());
        //14. Assert that for radiobutton there is a log row and value is corresponded to the section value
        diffElSteps.checkLogRow(RADIO_ELEMENT, Radio.SELEN.getValue());
        //15. Select in dropdown
        diffElSteps.selectDropdown(Colors.YELLOW.getValue());
        //16. Assert that for dropdown there is a log row and value is corresponded to the section value
        diffElSteps.checkLogRow(DROPDOWN_ELEMENT, Colors.YELLOW.getValue());
        //17. Unselect and assert checkboxes
        diffElSteps.unselectCheckbox(Checkbox.WATER.getValue());
        diffElSteps.unselectCheckbox(Checkbox.WIND.getValue());
        //18. Assert that for each checkbox there is an individual log row and value
        //is corresponded to the status of checkbox
        diffElSteps.checkLogRow(Checkbox.WATER.getValue(), Conditions.FALSE.getValue());
        diffElSteps.checkLogRow(Checkbox.WIND.getValue(), Conditions.FALSE.getValue());
    }
}
