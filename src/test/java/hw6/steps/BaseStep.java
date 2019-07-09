package hw6.steps;

import hw6.DifferentElementPage;
import hw6.HomePage;
import hw6.UserPage;
import hw6.hooks.TestContext;
import org.openqa.selenium.WebElement;

public abstract class BaseStep {
    protected HomePage homePage;
    protected DifferentElementPage diffPage;
    protected UserPage userPage;

    public BaseStep() {
        homePage = HomePage.getInstanse(TestContext.getDriver());
        diffPage = DifferentElementPage.getInstanse(TestContext.getDriver());
        userPage = UserPage.getInstanse(TestContext.getDriver());
    }

    public boolean isElementDisplayed(WebElement element) {
        return element.isDisplayed();
    }
}
