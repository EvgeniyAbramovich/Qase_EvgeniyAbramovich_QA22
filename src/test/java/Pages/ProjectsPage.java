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
    private final static By CREATE_NEW_PROJECT_BUTTON = By.id("createButton");
    private final static By PROJECT_NAME_INPUT = By.id("project-name");
    private final static By PROJECT_CODE_INPUT = By.id("project-code");
    private final static By DESCRIPTION_TEXT_AREA = By.id("description-area");
    private final static By CREATE_PROJECT_BUTTON = By.xpath("//*[contains(text(), 'Create project')]");

    public ProjectsPage clickCreateNewProjectButton() {
        $(CREATE_NEW_PROJECT_BUTTON).click();
        return this;
    }

    public ProjectsPage createNewProjectButtonIsPresent () {
        $(CREATE_NEW_PROJECT_BUTTON).isDisplayed();
        return this;
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
        return new NewProjectPage(driver);
    }

    public void clickProjectLink(String projectName) {
       driver.findElement(getProjectContainerByName(projectName)).findElement(PROJECT_LINK).click();
    }

    private By getProjectContainerByName(String projectName) {
        return By.xpath(String.format(PROJECT_BLOCK_CONTAINER_LOCATOR, projectName));
    }
}
