package tests;

import models.Project;
import models.SharedSteps;
import org.testng.Assert;
import org.testng.annotations.AfterTest;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.Test;

import static com.codeborne.selenide.Selenide.open;

public class SharedStepsTests extends BaseTest{

    private static final String TEST_PROJECT_NAME = "Test Project Shared Steps";
    private static final String PROJECT_CODE = "TPSS";

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

    @Test(description = "Positive Create Shared Step Test", groups = {"Smoke"})
    public void newSharedStepTest(){

        String projectName = TEST_PROJECT_NAME;
        String sharedStepName = "Authorization";

        loginPage.openLoginPage().setUsername(USERNAME).setPassword(PASSWORD).clickLoginButton().clickProjectLink(projectName);
        newProjectPage.clickSharedStepsLabel();

        sharedStepsPage.clickCreateSharedStepButton().clickAddStepButton();

        SharedSteps sharedSteps = SharedSteps.builder().sharedStepTitle(sharedStepName).action("Open Login Page")
                .inputData("Login").expectedResult("Open Projects Page").build();
        newSharedStepsModal.fillformSharedSteps(sharedSteps).clickCreateButton().clickSharedStepLink();

        Assert.assertEquals(editSharedStepPage.getSharedStepDetails(), sharedSteps);

        }

        @Test(description = "Negative Shared Step Page", groups = {"Regression"})
    public void negativeSharedStepTest(){

        String projectName = TEST_PROJECT_NAME;
        String sharedStepName = "Authorization";

        loginPage.openLoginPage().setUsername(USERNAME).setPassword(PASSWORD).clickLoginButton().clickProjectLink(projectName);
        newProjectPage.clickSharedStepsLabel();
        sharedStepsPage.clickCreateSharedStepButton();
        newSharedStepsModal.setSharedStepName(sharedStepName).clickCreateButton();

        Assert.assertTrue(newSharedStepsModal.ErrorMessageIsPresent());

        }

    @AfterTest(description = "Delete Created Test Project")
    public void deleteNewTestProjectByCode() {
        projectAdapter.deleteProjectByCode(200, PROJECT_CODE);
    }
}
