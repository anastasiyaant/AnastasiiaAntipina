package hw4;

import com.codeborne.selenide.Condition;
import com.codeborne.selenide.ElementsCollection;
import com.codeborne.selenide.SelenideElement;
import hw4.enums.Colors;
import hw4.enums.Elements;
import hw4.enums.Metals;
import hw4.enums.Vegetables;
import org.openqa.selenium.By;
import org.openqa.selenium.support.FindBy;

import static com.codeborne.selenide.Selenide.page;


public class MetalsAndColorsPage {
    @FindBy(css = "#odds-selector > p")
    protected ElementsCollection summaryOdd;
    @FindBy(css = "#even-selector > p")
    protected ElementsCollection summaryEven;
    @FindBy(id = "calculate-button")
    protected SelenideElement calculateButton;
    @FindBy(css = "#elements-block label")
    protected ElementsCollection elements;
    @FindBy(css = "#colors li > a")
    protected ElementsCollection colors;
    @FindBy(css = "#colors button")
    protected SelenideElement colorButton;
    @FindBy(css = "#metals span.caret")
    protected SelenideElement metalButton;
    @FindBy(css = "#metals li > a")
    protected ElementsCollection metals;
    @FindBy(css = "#vegetables button")
    protected SelenideElement vegetableButton;
    @FindBy(css = "#vegetables li > a")
    protected ElementsCollection vegetables;
    @FindBy(id = "submit-button")
    protected SelenideElement submitButton;
    @FindBy(css = "ul[class='panel-body-list results']")
    protected SelenideElement resultPanel;

    public MetalsAndColorsPage() {
        page(this);
    }

    public void clickOnSummary(String summaryEx) {
        if (Integer.valueOf(summaryEx) % 2 == 0) {
            summaryEven.findBy(Condition.text(summaryEx)).click();
        } else {
            summaryOdd.findBy(Condition.text(summaryEx)).click();
        }
    }

    public void clickCalculate() {
        calculateButton.click();
    }

    public void clickOnColor(Colors color) {
        colors.findBy(Condition.text(color.getValue())).click();
    }

    public void clickOnElement(Elements element) {
        elements.findBy(Condition.text(element.getValue())).click();
    }

    public void clickSelectColorButton() {
        colorButton.click();
    }

    public void clickOnMetalButton() {
        metalButton.click();
    }

    public void clickOnMetal(Metals metal) {
        metals.findBy(Condition.text(metal.getValue())).click();
    }

    public void clickOnVegetables() {
        vegetableButton.click();
    }

    public void clickOnVegetable(Vegetables vegetable) {
        vegetables.findBy(Condition.text(vegetable.getValue())).click();
    }

    public void clickSubmitButton() {
        submitButton.click();
    }

    public SelenideElement findElementByName(String name) {
        return resultPanel.find(By.xpath(".//li[contains(string(),'" + name + "')]"));
    }
}
