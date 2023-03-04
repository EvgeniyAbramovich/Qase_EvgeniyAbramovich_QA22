package pages;

import org.openqa.selenium.By;

import static com.codeborne.selenide.Condition.visible;
import static com.codeborne.selenide.Selenide.$;

public class ProjectsPage extends BasePage{

    private final static String PROJECT_BLOCK_CONTAINER_LOCATOR = "//a[@class='defect-title' and text()='%s']" +
            "/ancestor::tr[@class='project-row']";
    private final static By PROJECT_LINK = By.cssSelector(".defect-title");
    private final static By CREATE_NEW_PROJECT_BUTTON = By.id("createButton");
    private final static By PROJECT_NAME_INPUT = By.id("project-name");
    private final static By PROJECT_CODE_INPUT = By.id("project-code");
    private final static By DESCRIPTION_TEXT_AREA = By.id("description-area");
    private final static By CREATE_PROJECT_BUTTON = By.xpath("//*[contains(text(), 'Create project')]");

    public ProjectsPage clickCreateNewProjectButton() {
        $(CREATE_NEW_PROJECT_BUTTON).click();
        return this;
    }

    public boolean createNewProjectButtonIsPresent () {
        $(CREATE_NEW_PROJECT_BUTTON).shouldBe(visible);
        return true;
    }


    public ProjectsPage setProjectName(String projectName) {
        $(PROJECT_NAME_INPUT).setValue(projectName);
        return this;
    }

    public ProjectsPage setProjectCode(String projectCode) {
        $(PROJECT_CODE_INPUT).setValue(projectCode);
        return this;
    }

    public ProjectsPage setDescription(String description) {
        $(DESCRIPTION_TEXT_AREA).setValue(description);
        return this;
    }

    public NewProjectPage clickCreateProjectButton() {
        $(CREATE_PROJECT_BUTTON).click();
        return new NewProjectPage();
    }

    public void clickProjectLink(String projectName) {
       $(getProjectContainerByName(projectName)).$(PROJECT_LINK).click();
    }

    private By getProjectContainerByName(String projectName) {
        return By.xpath(String.format(PROJECT_BLOCK_CONTAINER_LOCATOR, projectName));
    }
}
