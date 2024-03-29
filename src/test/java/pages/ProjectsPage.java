package pages;

import lombok.extern.log4j.Log4j2;
import org.openqa.selenium.By;

import static com.codeborne.selenide.Condition.visible;
import static com.codeborne.selenide.Selenide.$;
import static com.codeborne.selenide.Selenide.open;

@Log4j2
public class ProjectsPage extends BasePage {

    private final static String PROJECT_BLOCK_CONTAINER_LOCATOR = "//a[@class='defect-title' and text()='%s']" +
            "/ancestor::tr[@class='project-row']";
    private final static By PROJECT_LINK = By.cssSelector(".defect-title");
    private final static By CREATE_NEW_PROJECT_BUTTON = By.id("createButton");
    private final static By PROJECT_NAME_INPUT = By.id("project-name");
    private final static By PROJECT_CODE_INPUT = By.id("project-code");
    private final static By DESCRIPTION_TEXT_AREA = By.id("description-area");
    private final static By CREATE_PROJECT_BUTTON = By.xpath("//*[contains(text(), 'Create project')]");


    public ProjectsPage clickCreateNewProjectButton() {
        log.info("Clicking Create New Project Button");
        $(CREATE_NEW_PROJECT_BUTTON).click();
        return this;
    }

    public boolean createNewProjectButtonIsPresent() {
        log.info("New Project Button is present");
        $(CREATE_NEW_PROJECT_BUTTON).shouldBe(visible);
        return true;
    }


    public ProjectsPage setProjectName(String projectName) {
        log.info("Setting Project Name = {}", projectName);
        $(PROJECT_NAME_INPUT).setValue(projectName);
        return this;
    }

    public ProjectsPage setProjectCode(String projectCode) {
        log.info("Setting Project Code = {}", projectCode);
        $(PROJECT_CODE_INPUT).setValue(projectCode);
        return this;
    }

    public ProjectsPage setDescription(String description) {
        log.info("Setting Description = {}", description);
        $(DESCRIPTION_TEXT_AREA).setValue(description);
        return this;
    }

    public NewProjectPage clickCreateProjectButton() {
        log.info("Clicking Create Project Button");
        $(CREATE_PROJECT_BUTTON).click();
        return new NewProjectPage();
    }

    public NewProjectPage clickProjectLink(String projectName) {
        log.info("Clicking Project Link with Name = {}", projectName);
        $(getProjectContainerByName(projectName)).$(PROJECT_LINK).click();
        return new NewProjectPage();
    }


    private By getProjectContainerByName(String projectName) {
        return By.xpath(String.format(PROJECT_BLOCK_CONTAINER_LOCATOR, projectName));
    }

    public ProjectsPage openProjectsPage() {
        log.info("Opened Projects page");
        open("/projects");
        return this;
    }
}
