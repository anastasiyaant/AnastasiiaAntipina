package hw3.steps;

import hw3.HomePage;
import hw3.enums.Menu;
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
        homePage = new HomePage(driver);
    }

    public void checkOpenPageTitle(String title) {
        assertEquals(homePage.getPageTitle(), title);
    }

    public void loginUser(String userName, String password) {
        homePage.login(userName, password);
    }

    public void checkLoginUser(String fullName) {
        String fullUserName = homePage.getFullUserName();
        assertEquals(fullUserName.toUpperCase(), fullName.toUpperCase());
    }

    public void checkHeaderSectionElements() {
        List<WebElement> topMenuElements = homePage.getTopMenuElements();
        List<String> headerMenuTitle = Menu.getMenuStringList();
        checkElementsHaveProperText(topMenuElements, headerMenuTitle);
    }

    public void checkHomePageImages(int expectedCount) {
        List<WebElement> images = homePage.getImages();
        assertEquals(images.size(), expectedCount);
    }

    public void checkTextUnderIconsHomePage(List<String> iconText) {
        List<WebElement> iconTextElements = homePage.getIconTextElements();
        List<String> actualIconText = new ArrayList<>();
        for (WebElement iconTextElement : iconTextElements) {
            actualIconText.add(iconTextElement.getText());
        }
        assertEquals(actualIconText, iconText);
    }

    public void checkMainHeadersText(List<String> mainHeadersText) {
        WebElement mainHeaderTextUpper = homePage.getMainHeaderTextUpper();
        assertEquals(mainHeaderTextUpper.getText(), mainHeadersText.get(0));
        WebElement mainHeaderTextDown = homePage.getMainHeaderTextDown();
        assertEquals(mainHeaderTextDown.getText(), mainHeadersText.get(1));
    }

    // TODO checkIFrameInTheCenter
    public void checkIframeInTheCenter() {
        WebElement iframe = homePage.getIframe();
        assertTrue(isElementDisplayed(iframe));
    }

    // TODO checkIFrameLogo
    public void checkIframeLogo() {
        homePage.switchToIframe();
        assertTrue(isElementDisplayed(homePage.getEpamLogo()));
    }

    public void switchToOriginalWindow() {
        homePage.switchToOriginalWindow();
    }

    public void checkSubHeaderText(String subHeader) {
        String realSubHeader = homePage.getSubHeader();
        assertEquals(realSubHeader, subHeader);
    }

    public void checkLink(String link) {
        String subHeaderLink = homePage.getLink();
        assertEquals(subHeaderLink, link);
    }

    public void checkLeftSection() {
        WebElement leftSection = homePage.getLeftSection();
        assertTrue(isElementDisplayed(leftSection));
    }

    public void checkFooter() {
        WebElement footer = homePage.getFooter();
        assertTrue(isElementDisplayed(footer));
    }
}
