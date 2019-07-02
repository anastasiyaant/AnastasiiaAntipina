package hw4;

import com.codeborne.selenide.ElementsCollection;
import com.codeborne.selenide.SelenideElement;
import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;

import static com.codeborne.selenide.Selenide.*;

public class TableWithPagesPage {
    @FindBy(className = "sidebar-menu")
    private SelenideElement leftSection;
    @FindBy(name = "log-sidebar")
    private SelenideElement rightSection;
    @FindBy(name = "table-with-pages_length")
    protected SelenideElement ShowEntriesDropdown;
    @FindBy(css = "input[type='search'")
    protected SelenideElement searchField;
    @FindBy(css="#table-with-pages tbody > tr")
    protected ElementsCollection searchResultsRows;

    public TableWithPagesPage(){
        page(this);
    }

    public SelenideElement getLeftSection() {
        return leftSection;
    }

    public SelenideElement getRightSection() {
        return rightSection;
    }
    public SelenideElement getShowEntriesDropdown() {
        return ShowEntriesDropdown;
    }

    public SelenideElement checkLogRow(String element, String condition) {
        return $(By.xpath("//ul[@class='panel-body-list logs']//li[contains(string(),'"
                + element + "')" + "and contains(text(), '" + condition + "')]"));
    }

    public ElementsCollection logRowContent(String element) {
        return $$(By.xpath("//ul[@class='panel-body-list logs']//li[contains(string(),'"
                + element + "')]"));
    }

    public SelenideElement getSearchField() {
        return searchField;
    }

    public ElementsCollection getSearchResultsRows() {
        return searchResultsRows;
    }
}
