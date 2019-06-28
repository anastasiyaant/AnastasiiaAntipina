package hw3.ex2;

import hw2.base.BaseClass;
import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.testng.annotations.Test;
import org.testng.asserts.SoftAssert;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

import static org.testng.Assert.assertEquals;
import static org.testng.Assert.assertTrue;

public class Exercise2 extends BaseClass {
    @Test
    public void Exercise2Test() {





        //8. Check interface on Different element page, it contains all needed elements
        List<WebElement> checkboxes = driver.findElements(By.className("label-checkbox"));
        List<WebElement> radios = driver.findElements(By.className("label-radio"));
        List<WebElement> dropdowns = driver.findElements(By.className("colors"));
        WebElement buttonLeft = driver.findElement(By.name("Default Button"));
        WebElement buttonRight = driver.findElement(By.cssSelector("input[value='Button']"));
        assertEquals(checkboxes.size(), 4);
        assertEquals(radios.size(), 4);
        assertEquals(dropdowns.size(), 1);
        assertTrue(isElementDisplayed(buttonLeft));
        assertTrue(isElementDisplayed(buttonRight));

        //9. Assert that there is Right Section
        WebElement rightSection = driver.findElement(By.name("log-sidebar"));
        assertTrue(isElementDisplayed(rightSection));

        //10. Assert that there is Left Section
        WebElement leftSection = driver.findElement(By.className("sidebar-menu"));
        assertTrue(isElementDisplayed(leftSection));

        //11. Select Checkboxes
        selectCheckbox("Water");
        selectCheckbox("Wind");

        //12. Assert that for each checkbox there is an individual log row and value
        // is corresponded to the status of checkbox
        logRow("Water", "true");
        logRow("Wind", "true");

        //13.Select radio
        selectRadio("Selen");

        //14. Assert that for radiobutton there is a log row and value is corresponded to the section value
        logRow("metal", "Selen");

        //15. Select in dropdown
        selectOption("Yellow");

        //16. Assert that for dropdown there is a log row and value is corresponded to the section value
        logRow("Colors", "Yellow");

        //17. Unselect and assert checkboxes
        checkUnselectedCheckbox("Water");
        checkUnselectedCheckbox("Wind");

        //18. Assert that for each checkbox there is an individual log row and value
        //is corresponded to the status of checkbox
        logRow("Water", "false");
        logRow("Wind", "false");
    }

}


