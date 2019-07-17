package hw5.steps;

import hw5.HomePage;
import hw3.enums.Menu;
import hw5.base.TestProvider;
import io.qameta.allure.Step;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;

import java.util.ArrayList;
import java.util.List;

import static org.testng.Assert.assertEquals;
import static org.testng.Assert.assertTrue;

public class HomePageSteps extends BaseSteps {

    private HomePage homePage;

    public HomePageSteps(WebDriver driver) {
        super(driver);
        TestProvider.getInstance().setDriver(driver);
        homePage = new HomePage(driver);
    }
    @Step("Check page TITLE")
    public void checkOpenPageTitle(String title) {
        assertEquals(homePage.getPageTitle(), title);
    }
    @Step("Login as user: '{0}'")
    public void loginUser(String userName, String password) {
        homePage.login(userName, password);
    }


    @Step("Check user logged in")
    public void checkLoginUser(String fullName) {
        String fullUserName = homePage.getFullUserName();
        assertEquals(fullUserName.toUpperCase(), fullName.toUpperCase());
    }

    @Step("Check header section elements")
    public void checkHeaderSectionElements() {
        List<WebElement> topMenuElements = homePage.getTopMenuElements();
        List<String> headerMenuTitle = Menu.getMenuStringList();
        checkElementsHaveProperText(topMenuElements, headerMenuTitle);
    }

    @Step("Check images on Home Page")
    public void checkHomePageImages(int expectedCount) {
        List<WebElement> images = homePage.getImages();
        assertEquals(images.size(), expectedCount);
    }
    @Step("Check text under icons on Home Page")
    public void checkTextUnderIconsHomePage(List<String> iconText) {
        List<WebElement> iconTextElements = homePage.getIconTextElements();
        List<String> actualIconText = new ArrayList<>();
        for (WebElement iconTextElement : iconTextElements) {
            actualIconText.add(iconTextElement.getText());
        }
        assertEquals(actualIconText, iconText);
    }
    @Step("Check main header text")
    public void checkMainHeadersText(List<String> mainHeadersText) {
        WebElement mainHeaderTextUpper = homePage.getMainHeaderTextUpper();
        assertEquals(mainHeaderTextUpper.getText(), mainHeadersText.get(0));
        WebElement mainHeaderTextDown = homePage.getMainHeaderTextDown();
        assertEquals(mainHeaderTextDown.getText(), mainHeadersText.get(1));
    }
    @Step("Check IFrame location")
    public void checkIFrameInTheCenter() {
        WebElement iframe = homePage.getIFrame();
        assertTrue(isElementDisplayed(iframe));
    }
    @Step("Check IFrame logo")
    public void checkIFrameLogo() {
        homePage.switchToIFrame();
        assertTrue(isElementDisplayed(homePage.getEpamLogo()));
    }
    @Step("Switch to original window")
    public void switchToOriginalWindow() {
        homePage.switchToOriginalWindow();
    }

    @Step("Check sub header text")
    public void checkSubHeaderText(String subHeader) {
        String realSubHeader = homePage.getSubHeader();
        assertEquals(realSubHeader, subHeader);
    }
    @Step("Check LINK")
    public void checkLink(String link) {
        String subHeaderLink = homePage.getLink();
        assertEquals(subHeaderLink, link);
    }
    @Step("Check left section")
    public void checkLeftSection() {
        WebElement leftSection = homePage.getLeftSection();
        assertTrue(isElementDisplayed(leftSection));
    }
    @Step("Check footer")
    public void checkFooter() {
        WebElement footer = homePage.getFooter();
        assertTrue(isElementDisplayed(footer));
    }
}
