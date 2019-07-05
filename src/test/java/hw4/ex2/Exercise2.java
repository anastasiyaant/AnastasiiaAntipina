package hw4.ex2;

import com.codeborne.selenide.Condition;
import hw3.utils.User;
import hw4.HomePage;
import hw4.MetalsAndColorsPage;
import hw4.base.BaseClass;
import hw4.builder.MetalAndColorsBuilder;
import hw4.enums.*;
import org.testng.annotations.DataProvider;
import org.testng.annotations.Test;

import java.util.Arrays;

import static com.codeborne.selenide.Selenide.open;
import static com.codeborne.selenide.Selenide.title;
import static org.testng.AssertJUnit.assertEquals;

public class Exercise2 extends BaseClass {

    @DataProvider(name = "builder")
    public Object[][] metalAndColorsDataProvider() {
        return new Object[][]{
                {MetalAndColorsBuilder.builder()
                        .elements(Arrays.asList(Elements.EARTH))
                        .colors(Arrays.asList(Colors.YELLOW))
                        .metals(Arrays.asList(Metals.GOLD))
                        .build()},
                {MetalAndColorsBuilder.builder()
                        .summary(Arrays.asList("3", "8"))
                        .vegetables(Arrays.asList(Vegetables.CUCUMBER, Vegetables.TOMATO))
                        .build()},
                {MetalAndColorsBuilder.builder()
                        .summary(Arrays.asList("3", "2"))
                        .elements(Arrays.asList(Elements.WIND, Elements.FIRE, Elements.WATER))
                        .metals(Arrays.asList(Metals.BRONZE))
                        .vegetables(Arrays.asList(Vegetables.ONION))
                        .build()
                },
                {MetalAndColorsBuilder.builder()
                        .summary(Arrays.asList("6", "5"))
                        .elements(Arrays.asList(Elements.WATER))
                        .colors(Arrays.asList(Colors.GREEN))
                        .metals(Arrays.asList(Metals.SELEN))
                        .vegetables(Arrays.asList(Vegetables.ONION, Vegetables.TOMATO, Vegetables.VEGETABLES, Vegetables.CUCUMBER))
                        .build()

                },
                {
                        MetalAndColorsBuilder.builder()
                                .elements(Arrays.asList(Elements.FIRE))
                                .colors(Arrays.asList(Colors.BLUE))
                                .vegetables(Arrays.asList(Vegetables.TOMATO, Vegetables.VEGETABLES, Vegetables.CUCUMBER)).build()
                }
        };
    }


    @Test(dataProvider = "builder")
    public void test2(MetalAndColorsBuilder testData) {
        // 1. Open test site by URL
        HomePage hp = open(link, HomePage.class);
        // 2. Assert Browser Title
        assertEquals(title(), browserTitle);
        // 3.Perform login
        User user = readUserData(userDataFilePath);
        hp.login(user.getUserName(), user.getPassword());
        // 4. Click on the link on the Header Section
        hp.clickButton(hp.getMenuItem(Menu.METALS_AND_COLORS));
        MetalsAndColorsPage metalsAndColorsPage = new MetalsAndColorsPage();
        // 5. Fill form  on the page
        if (testData.getSummary() != null) {
            for (String summaryEx : testData.getSummary()) {
                metalsAndColorsPage.clickOnSummary(summaryEx);
            }
        }
        metalsAndColorsPage.clickCalculate();

        if (testData.getElements() != null) {
            for (Elements element : testData.getElements()) {
                metalsAndColorsPage.clickOnElement(element);

            }
        }

        if (testData.getColors() != null) {
            metalsAndColorsPage.clickSelectColorButton();
            for (Colors color : testData.getColors()) {
                metalsAndColorsPage.clickOnColor(color);
            }
        }

        if (testData.getMetals() != null) {
            metalsAndColorsPage.clickOnMetalButton();
            for (Metals metal : testData.getMetals()) {
                metalsAndColorsPage.clickOnMetal(metal);
            }
        }

        if (testData.getVegetables() != null) {
            metalsAndColorsPage.clickOnVegetables();
            metalsAndColorsPage.clickOnVegetable(Vegetables.VEGETABLES);
            for (Vegetables vegetable : testData.getVegetables()) {
                metalsAndColorsPage.clickOnVegetable(vegetable);
            }
        }
        // 6. Click "Submit" button
        metalsAndColorsPage.clickSubmitButton();

        // 7. Check Results block output on the right-side
        // TODO Condition could be used static import
        if (testData.getSummary() != null) {
            int sum = 0;
            for (String summaryEx : testData.getSummary()) {
                sum += Integer.valueOf(summaryEx);
            }
            metalsAndColorsPage.findElementByName(MetalAndColorsElements.SUMMARY.getName())
                    .shouldHave(Condition.text(String.valueOf(sum)));

        }

        if (testData.getElements() != null) {
            for (Elements element : testData.getElements()) {
                metalsAndColorsPage.findElementByName(MetalAndColorsElements.ELEMENTS.getName())
                        .shouldHave(Condition.text(element.getValue()));
            }
        }

        if (testData.getColors() != null) {
            for (Colors color : testData.getColors()) {
                metalsAndColorsPage.findElementByName(MetalAndColorsElements.COLOR.getName())
                        .shouldHave(Condition.text(color.getValue()));
            }
        }

        if (testData.getMetals() != null) {
            for (Metals metal : testData.getMetals()) {
                metalsAndColorsPage.findElementByName(MetalAndColorsElements.METAL.getName())
                        .shouldHave(Condition.text(metal.getValue()));
            }
        }

        if (testData.getVegetables() != null) {
            for (Vegetables vegetable : testData.getVegetables()) {
                metalsAndColorsPage.findElementByName(MetalAndColorsElements.VEGETABLES.getName())
                        .shouldHave(Condition.text(String.valueOf(vegetable.getValue())));
            }
        }
    }
}
