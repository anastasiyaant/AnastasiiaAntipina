package hw4.ex1;

import com.codeborne.selenide.CollectionCondition;
import com.codeborne.selenide.Condition;
import hw3.utils.User;
import hw4.HomePage;
import hw4.TableWithPagesPage;
import hw4.base.BaseClass;
import hw4.enums.EntriesValues;
import hw4.enums.Menu;
import hw4.enums.ServiceHeaderTitles;
import org.testng.annotations.Test;

import static com.codeborne.selenide.Condition.*;
import static com.codeborne.selenide.Selenide.open;
import static com.codeborne.selenide.Selenide.title;
import static org.testng.AssertJUnit.assertEquals;

public class Exercise1 extends BaseClass {
    static final int expextedAmountOfRows = 1;
    static final String Search_text = "Custom";

    @Test
    public void test1() {
        //1. Open test site by URL
        HomePage hp = open(link, HomePage.class);
        // 2. Assert Browser Title
        assertEquals(title(), browserTitle);
        // 3.Perform login
        User user = readUserData(userDataFilePath);
        hp.login(user.getUserName(), user.getPassword());
        // 4.Assert User name in the left-top side of screen that user is loggined
        hp.getUserName().shouldHave(text(user.getFullName()));
        // 5. Click on "Service" subcategory in the header and check that drop down contains options
        hp.clickButton(hp.getMenuItem(Menu.SERVICE));
        hp.getServiceHeaders().shouldHave(CollectionCondition.texts(ServiceHeaderTitles.getServiceHeaderTitlesStringListUpperCase()));
        // 6. Click on "Service" subcategory in the left section and check that drop down contains options
        hp.clickButton(hp.getServiceLeftButton());
        hp.getServiceLeftHeader().shouldHave(CollectionCondition.textsInAnyOrder(ServiceHeaderTitles.getServiceHeaderTitlesStringList()));
        // 7. Open through the header menu Service -> Table with pages
        hp.clickButton(hp.getMenuItem(Menu.SERVICE));
        hp.clickButton(hp.getTableWithPagesButton());
        // 8. Check that default value for "Show entries" dropdown is 5
        TableWithPagesPage tableWithPagesPage = new TableWithPagesPage();
        Condition defaultValue = and(EntriesValues.FIVE.getValue(), visible);
        tableWithPagesPage.getShowEntriesDropdown().shouldHave(defaultValue);
        // 9. Assert that there is Right Section
        tableWithPagesPage.getRightSection().shouldBe(visible);
        // 10. Assert that there is Left Section
        tableWithPagesPage.getLeftSection().shouldBe(visible);
        // 11. Select new value for the entries in the dropdown list
        tableWithPagesPage.getShowEntriesDropdown().selectOptionContainingText(EntriesValues.TEN.getValue());
        // 12. Assert that for the dropdown there is an individual log row and value
        //     is corresponded to the value of dropdown
        tableWithPagesPage.checkLogRow("length", EntriesValues.TEN.getValue());
        // 13. Assert that in the table displayed corrected amount of entries
        tableWithPagesPage.logRowContent("length").shouldHave(CollectionCondition.size(expextedAmountOfRows));
        // 14. Type in "Search" text field
        tableWithPagesPage.getSearchField().setValue(Search_text);
        // 15. Assert the table contains only records with Search field value
        tableWithPagesPage.getSearchResultsRows().forEach(row -> row.shouldHave(text(Search_text)));
    }
}
