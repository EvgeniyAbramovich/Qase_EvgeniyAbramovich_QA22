package tests;

import enums.*;
import models.Project;
import models.TestCase;
import org.testng.Assert;
import org.testng.annotations.AfterTest;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.Test;


public class TestCaseTests extends BaseTest{

    private static final String TEST_PROJECT_NAME = "Test Project Test Case";
    private static final String PROJECT_CODE = "TPTC";

    @BeforeTest(description = "Create Test Project")
    public void createTestProject(){

        String testCode = PROJECT_CODE;
        Project project = Project.builder()
                .title(TEST_PROJECT_NAME)
                .code(testCode)
                .description("Test Project")
                .build();
        projectAdapter.createProject(200, GSON.toJson(project));
    }

    @Test(description = "Positive Create TestCase Test", groups = {"Smoke"})
    public void newTestCaseTest(){

        String projectName = TEST_PROJECT_NAME;
        String testCaseName = "Authorization";

        loginPage.openLoginPage().setUsername(USERNAME).setPassword(PASSWORD).clickLoginButton().clickProjectLink(projectName);
        newProjectPage.clickCreateCaseButton();

        TestCase testCase = TestCase.builder().title(testCaseName).status(Status.ACTUAL).description("New Test Case")
                .severity(Severity.MAJOR).priority(Priority.MEDIUM).type(Type.FUNCTIONAL).layer(Layer.API)
                .isFlaky(IsFlaky.NO).behavior(Behavior.POSITIVE).automationStatus(AutomationStatus.NOT_AUTOMATED)
                .preConditions("PreCondition").postConditions("PostCondition").build();
        newTestCaseModal.fillformTestCase(testCase);
        newTestCaseModal.clickSaveButton();
        repositoryPage.clickTestCaseLink().clickEditButton();

        Assert.assertEquals(editTestCasePage.getTestCaseDetails(),testCase);

    }

    @AfterTest(description = "Delete Created Test Project")
    public void deleteNewTestProjectByCode() {
        projectAdapter.deleteProjectByCode(200, PROJECT_CODE);
    }
}
