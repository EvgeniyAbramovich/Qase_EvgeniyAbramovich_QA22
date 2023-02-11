package Pages;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;

import static com.codeborne.selenide.Selenide.$;

public class NewProjectPage extends BasePage{


    public NewProjectPage(WebDriver driver) {
        super(driver);
    }

    private final static By PROJECT_NAME_TEXT = By.cssSelector(".sqabXr");
    private final static By CREATE_CASE_BUTTON = By.id("create-case-button");
    private final static By DEFECTS_LABEL = By.cssSelector("[aria-label = 'Defects']");
    private final static By SHARED_STEPS_LABEL = By.cssSelector("[aria-label='Shared Steps']");
    private final static By TEST_PLANS_LABEL = By.cssSelector("[aria-label='Test Plans']");
    private final static By TEST_RUNS_LABEL = By.cssSelector("[aria-label='Test Runs']");
    private final static By CONFIGURATIONS_LABEL = By.cssSelector("[aria-label='Configurations']");
    private final static By ENVIRONMENTS_LABEL = By.cssSelector("[aria-label='Environments']");
    private final static By MILESTONES_LABEL = By.cssSelector("[aria-label='Milestones']");

    @Override
    public boolean isPageOpened() {
        return false;
    }

    public NewProjectPage getProjectName() {
        $(PROJECT_NAME_TEXT).getText();
        return this;
    }
    public NewProjectPage clickCreateCaseButton() {
        $(CREATE_CASE_BUTTON).click();
        return this;
    }
    public NewProjectPage clickDefectLabel() {
        $(DEFECTS_LABEL).click();
        return this;
    }
    public NewProjectPage clickSharedStepsLabel() {
        $(SHARED_STEPS_LABEL).click();
        return this;
    }
    public NewProjectPage clickTestPlansLabel() {
        $(TEST_PLANS_LABEL).click();
        return this;
    }
    public NewProjectPage clickTestRunsLabel() {
        $(TEST_RUNS_LABEL).click();
        return this;
    }
    public NewProjectPage clickConfigurationsLabel() {
        $(CONFIGURATIONS_LABEL).click();
        return this;
    }
    public NewProjectPage clickEnvironmentsLabel() {
        $(ENVIRONMENTS_LABEL).click();
        return this;
    }
    public NewProjectPage clickMilestonesLabel() {
        $(MILESTONES_LABEL).click();
        return this;
    }




}
