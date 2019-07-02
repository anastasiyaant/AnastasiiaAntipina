package hw4.ex2;

import hw3.utils.User;
import hw4.HomePage;
import hw4.base.BaseClass;
import hw4.enums.*;
import org.testng.annotations.DataProvider;
import org.testng.annotations.Test;

import java.util.Arrays;

import static com.codeborne.selenide.Selenide.open;
import static com.codeborne.selenide.Selenide.title;
import static org.testng.AssertJUnit.assertEquals;

public class Exercise2 extends BaseClass {

    @DataProvider(name = "builder")
    public Object[][] metalAndColorsDaraProvider() {
        return new Object[][]{
                {MetalsAndColorsBuilder.builder()
                        .elements(Arrays.asList(Elements.EARTH))
                        .colors(Arrays.asList(Colors.YELLOW))
                        .metals(Arrays.asList(Metals.GOLD))
                        .build()},
                {MetalsAndColorsBuilder.builder()
                        .summary(Arrays.asList("3", "8"))
                        .vegetables(Arrays.asList(Vegetables.CUCUMBER, Vegetables.TOMATO))
                        .build()},
                {MetalsAndColorsBuilder.builder()
                        .summary(Arrays.asList("3", "2"))
                        .elements(Arrays.asList(Elements.WIND, Elements.FIRE, Elements.WATER))
                        .metals(Arrays.asList(Metals.BRONZE))
                        .vegetables(Arrays.asList(Vegetables.ONION))
                        .build()
                },
                {MetalsAndColorsBuilder.builder()
                        .summary(Arrays.asList("6", "5"))
                        .elements(Arrays.asList(Elements.WATER))
                        .colors(Arrays.asList(Colors.GREEN))
                        .metals(Arrays.asList(Metals.SELEN))
                        .vegetables(Arrays.asList(Vegetables.ONION, Vegetables.TOMATO, Vegetables.VEGETABLES, Vegetables.CUCUMBER))
                        .build()

                },
                {
                        MetalsAndColorsBuilder.builder()
                                .elements(Arrays.asList(Elements.FIRE))
                                .colors(Arrays.asList(Colors.BLUE))
                                .vegetables(Arrays.asList(Vegetables.TOMATO, Vegetables.VEGETABLES, Vegetables.CUCUMBER)).build()
                }
        };
    }


        @Test(dataProvider = "builder")
        public void test2 (MetalsAndColors testData) {
            // 1. Open test site by URL
            HomePage hp = open(link, HomePage.class);
            // 2. Assert Browser Title
            assertEquals(title(), browserTitle);
            // 3.Perform login
            User user = readUserData(userDataFilePath);
            hp.login(user.getUserName(), user.getPassword());
            // 4. Click on the link on the Header Section
            hp.clickButton(hp.getMenuItem(Menu.METALS_AND_COLORS));
            // 5. Fill form  on the page

            // 6. Click "Submit" button

            // 7. Check Results block output on the right-side

        }
    }
