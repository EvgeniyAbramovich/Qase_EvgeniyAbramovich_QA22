package tests;

import enums.Status;
import models.Milestones;
import models.Project;
import org.testng.Assert;
import org.testng.annotations.AfterTest;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.Test;

public class MilestonesTests extends BaseTest{

    private static final String TEST_PROJECT_NAME = "Test Project Milestone";
    private static final String PROJECT_CODE = "TPM";

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

    @Test(description = "Positive Create Milestone Test", groups = {"Smoke"})
    public void newMilestoneTest() {

        String projectName = TEST_PROJECT_NAME;

        loginPage.openLoginPage().setUsername(USERNAME).setPassword(PASSWORD).clickLoginButton().clickProjectLink(projectName);
        newProjectPage.clickMilestonesLabel();
        milestonesPage.clickCreateMilestoneButton();

        Milestones milestones = Milestones.builder().milestoneName("New Milestone").description("Good")
                .status(Status.COMPLETED).dueDate("2023-03-05").build();
        newMilestonesModal.fillformMilestones(milestones).clickCreateMilestoneButton().clickMilestoneTitle();

        Assert.assertEquals(editMilestonePage.getMilestoneDetails(), milestones);

    }
    @AfterTest(description = "Delete Created Test Project")
    public void deleteNewTestProjectByCode() {
        projectAdapter.deleteProjectByCode(200, PROJECT_CODE);
    }
}
