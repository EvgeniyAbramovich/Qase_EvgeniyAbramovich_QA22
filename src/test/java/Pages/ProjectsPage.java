package Pages;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;

import static com.codeborne.selenide.Selectors.byXpath;
import static com.codeborne.selenide.Selenide.$;

public class ProjectsPage extends BasePage{

    public ProjectsPage(WebDriver driver) {
        super(driver);
    }

    @Override
    public boolean isPageOpened() {
        return false;
    }

    private final static String PROJECT_BLOCK_CONTAINER_LOCATOR = "//span[@class='project-title' and text()='%s']";

    private final static By PROJECT_LINK = By.xpath("//div[@class='project-block']");

    public ProjectsPage clickCreateNewProjectButton() {
        $("#createButton").click();
        return this;
    }

    public ProjectsPage setProjectName(String projectName) {
        $("#project-name").setValue(projectName);
        return this;
    }

    public ProjectsPage setProjectCode(String projectCode) {
        $("#project-code").setValue(projectCode);
        return this;
    }

    public ProjectsPage setDescription(String description) {
        $("#description-area").setValue(description);
        return this;
    }

    public NewProjectPage clickCreateProjectButton() {
        $(byXpath("//*[contains(text(), 'Create project')]")).click();
        return new NewProjectPage(driver);
    }

    public void clickProjectLink(String projectName) {
       driver.findElement(getProjectContainerByName(projectName)).findElement(PROJECT_LINK).click();
    }

    private By getProjectContainerByName(String projectName) {
        return By.xpath(String.format(PROJECT_BLOCK_CONTAINER_LOCATOR, projectName));
    }
}
