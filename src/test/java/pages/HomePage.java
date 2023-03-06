package pages;

import lombok.extern.log4j.Log4j2;
import org.openqa.selenium.By;

import static com.codeborne.selenide.Selenide.$;
@Log4j2
public class HomePage extends BasePage{

    private final static By PROJECTS_LINK = By.xpath("//a[text()='Projects']");
    private final static By WORKSPACE_LINK = By.xpath("//a[text()='Workspace']");
    private final static By APPS_LINK = By.xpath("//a[text()='Apps']");
    private final static By ACCOUNT_BUTTON = By.cssSelector("[class$=NMUwK0]");
    private final static By SIGN_OUT_BUTTON = By.xpath("//span[text()='Sign out']");

    public HomePage clickProjectLink() {
        log.info("Clicking Projects Link");
        $(PROJECTS_LINK).click();
        return this;
    }

    public HomePage clickWorkspaceLink() {
        log.info("Clicking Workspace Link");
        $(WORKSPACE_LINK).click();
        return this;
    }

    public HomePage clickAppsLink() {
        log.info("Clicking Apps Link");
        $(APPS_LINK).click();
        return this;
    }

    public HomePage clickAccountButton() {
        log.info("Clicking Account Button");
        $(ACCOUNT_BUTTON).click();
        return this;
    }

    public LoginPage clickSignOutButton() {
        log.info("Clicking SignOut Button");
        $(SIGN_OUT_BUTTON).click();
        return new LoginPage();
    }

}
