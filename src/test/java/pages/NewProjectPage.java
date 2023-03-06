package pages;

import lombok.extern.log4j.Log4j2;
import modals.*;
import org.openqa.selenium.By;

import static com.codeborne.selenide.Selenide.$;
@Log4j2
public class NewProjectPage extends BasePage{

    private final static By PROJECT_NAME_TEXT = By.xpath("//*[@id='layout']/child::div/child::div/" +
            "child::div//child::img/following-sibling::div");
    private final static By PROJECT_CODE_TEXT = By.xpath("//*[@id='application-content']/child::div/" +
            "child::div/child::h1");
    private final static By CREATE_CASE_BUTTON = By.id("create-case-button");
    private final static By CREATE_SUITE_BUTTON = By.id("create-suite-button");
    private final static By DEFECTS_LABEL = By.cssSelector("[aria-label = 'Defects']");
    private final static By SHARED_STEPS_LABEL = By.cssSelector("[aria-label='Shared Steps']");
    private final static By TEST_PLANS_LABEL = By.cssSelector("[aria-label='Test Plans']");
    private final static By TEST_RUNS_LABEL = By.cssSelector("[aria-label='Test Runs']");
    private final static By CONFIGURATIONS_LABEL = By.cssSelector("[aria-label='Configurations']");
    private final static By ENVIRONMENTS_LABEL = By.cssSelector("[aria-label='Environments']");
    private final static By MILESTONES_LABEL = By.cssSelector("[aria-label='Milestones']");



    public String getProjectName(String projectName) {
        log.info("Getting Project Name = {}",projectName);
        $(PROJECT_NAME_TEXT).getText();
        return projectName;
    }
    public String getProjectCode(String projectCode) {
        log.info("Getting Project Code = {}",projectCode);
        $(PROJECT_CODE_TEXT).getText();
        return projectCode;
    }
    public NewTestCaseModal clickCreateCaseButton() {
        log.info("Clicking Create Case Button");
        $(CREATE_CASE_BUTTON).click();
        return new NewTestCaseModal();
    }
    public NewSuiteModal clickCreateSuiteButton() {
        log.info("Clicking Create Suite Button");
        $(CREATE_SUITE_BUTTON).click();
        return new NewSuiteModal();
    }
    public NewDefectModal clickDefectLabel() {
        log.info("Clicking Defect Label");
        $(DEFECTS_LABEL).click();
        return new NewDefectModal();
    }
    public NewSharedStepsModal clickSharedStepsLabel() {
        log.info("Clicking Shared Steps Label");
        $(SHARED_STEPS_LABEL).click();
        return new NewSharedStepsModal();
    }
    public NewTestPlansModal clickTestPlansLabel() {
        log.info("Clicking Test Plans Label");
        $(TEST_PLANS_LABEL).click();
        return new NewTestPlansModal();
    }
    public NewTestRunsModal clickTestRunsLabel() {
        log.info("Clicking Test Runs Label");
        $(TEST_RUNS_LABEL).click();
        return new NewTestRunsModal();
    }
    public NewConfigurationsModal clickConfigurationsLabel() {
        log.info("Clicking Configuration Label");
        $(CONFIGURATIONS_LABEL).click();
        return new NewConfigurationsModal();
    }
    public NewEnvironmentsModal clickEnvironmentsLabel() {
        log.info("Clicking Environment Label");
        $(ENVIRONMENTS_LABEL).click();
        return new NewEnvironmentsModal();
    }
    public NewMilestonesModal clickMilestonesLabel() {
        log.info("Clicking Milestones Label");
        $(MILESTONES_LABEL).click();
        return new NewMilestonesModal();
    }


}
