package hw2.ex1;

import hw2.base.BaseClass;
import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.testng.annotations.Test;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

import static org.testng.Assert.assertEquals;
import static org.testng.Assert.assertTrue;

public class Exercise1 extends BaseClass {

    @Test
    public void Exercise1Test() {
        //2. Assert browser title
        checkOpenPageTitle("Home Page");

        //6. Assert that there are 4 items on the header section and they have proper texts
        List<WebElement> topMenuElements = driver.findElements(By.xpath("//*[@class='uui-navigation nav navbar-nav m-l8']/li"));
        List<String> headerMenuTitle = Arrays.asList("HOME", "CONTACT FORM", "SERVICE", "METALS & COLORS");

        // TODO Why do you decide not extract getting webElement text to the separate method?
        // Yes, it will be better. Fixed it.
        List<String> actualHeaderMenuTitle = new ArrayList<>();
        for (WebElement topMenuElement : topMenuElements) {
            actualHeaderMenuTitle.add(getElementText(topMenuElement));
        }
        assertEquals(actualHeaderMenuTitle, headerMenuTitle);

        //7. Assert that there are 4 images on the Index Page and they are displayed
        List<WebElement> images = driver.findElements(By.cssSelector("div.benefit-icon"));
        assertEquals(images.size(), 4);

        //8. Assert that there are 4 texts on the Index Page under icons and they have proper text
        List<String> iconText = Arrays.asList("To include good practices\nand ideas from successful\nEPAM project",
                "To be flexible and\ncustomizable", "To be multiplatform", "Already have good base\n(about 20 internal and\nsome external projects),\nwish to get more…");
        List<WebElement> iconTextElements = driver.findElements((By.cssSelector("span.benefit-txt")));
        // TODO Why do you decide not extract getting webElement text to the separate method?
        // Fixed it.
        List<String> actualIconText = new ArrayList<>();
        for (WebElement iconTextElement : iconTextElements) {
            actualIconText.add(getElementText(iconTextElement));
        }
        assertEquals(actualIconText, iconText);

        //9. Assert a text of the main headers
        List<String> mainHeadersText = Arrays.asList("EPAM FRAMEWORK WISHES…",
                "LOREM IPSUM DOLOR SIT AMET, CONSECTETUR ADIPISICING ELIT, SED DO EIUSMOD TEMPOR INCIDIDUNT UT LABORE " +
                        "ET DOLORE MAGNA ALIQUA. UT ENIM AD MINIM VENIAM, QUIS NOSTRUD EXERCITATION ULLAMCO LABORIS" +
                        " NISI UT ALIQUIP EX EA COMMODO CONSEQUAT DUIS AUTE IRURE DOLOR IN REPREHENDERIT IN" +
                        " VOLUPTATE VELIT ESSE CILLUM DOLORE EU FUGIAT NULLA PARIATUR.");
        WebElement mainHeaderTextUpper = driver.findElement(By.name("main-title"));
        assertEquals(mainHeaderTextUpper.getText(), mainHeadersText.get(0));

        WebElement mainHeaderTextDown = driver.findElement(By.name("jdi-text"));
        assertEquals(mainHeaderTextDown.getText(), mainHeadersText.get(1));

        //10. Assert that there is the iframe in the center of page
        WebElement iframe = driver.findElement(By.id("iframe"));
        assertTrue(isElementDisplayed(iframe));

        //11. Switch to the iframe and check that there is Epam logo in the left top conner of iframe
        String windowHandler = driver.getWindowHandle();
        driver.switchTo().frame("iframe");
        WebElement epamLogo = driver.findElement(By.id("epam_logo"));
        assertTrue(isElementDisplayed(epamLogo));

        //12. Switch to original window back
        driver.switchTo().window(windowHandler);

        //13. Assert a text of the sub header
        WebElement subHeader = driver.findElement(By.linkText("JDI GITHUB"));
        assertTrue(isElementDisplayed(subHeader));

        //14. Assert that JDI GITHUB is a link and has a proper URL
        String subHeaderLink = subHeader.getAttribute("href");
        assertEquals(subHeaderLink, "https://github.com/epam/JDI");

        //15. Assert that there is Left Section
        WebElement leftSection = driver.findElement(By.name("navigation-sidebar"));
        assertTrue(isElementDisplayed(leftSection));

        //16. Assert that there is Footer
        WebElement footer = driver.findElement(By.className("footer-bg"));
        assertTrue(isElementDisplayed(footer));
    }

}
