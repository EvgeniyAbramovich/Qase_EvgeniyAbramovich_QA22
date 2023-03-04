package pages;

import org.openqa.selenium.By;

import static com.codeborne.selenide.Selenide.$;

public class HomePage extends BasePage{

    private final static By PROJECTS_LINK = By.xpath("//a[text()='Projects']");
    private final static By WORKSPACE_LINK = By.xpath("//a[text()='Workspace']");
    private final static By APPS_LINK = By.xpath("//a[text()='Apps']");
    private final static By ACCOUNT_BUTTON = By.cssSelector("[class$=NMUwK0]");
    private final static By SIGN_OUT_BUTTON = By.xpath("//span[text()='Sign out']");

    public HomePage clickProjectLink() {
        $(PROJECTS_LINK).click();
        return this;
    }

    public HomePage clickWorkspaceLink() {
        $(WORKSPACE_LINK).click();
        return this;
    }

    public HomePage clickAppsLink() {
        $(APPS_LINK).click();
        return this;
    }

    public HomePage clickAccountButton() {
        $(ACCOUNT_BUTTON).click();
        return this;
    }

    public LoginPage clickSignOutButton() {
        $(SIGN_OUT_BUTTON).click();
        return new LoginPage();
    }

}
