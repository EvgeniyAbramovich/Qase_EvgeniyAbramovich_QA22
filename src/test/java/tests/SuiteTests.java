package tests;

import modals.NewSuiteModal;
import models.Project;
import models.Suite;
import org.testng.Assert;
import org.testng.annotations.AfterTest;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.Test;

import static com.codeborne.selenide.Selenide.open;

public class SuiteTests extends BaseTest{
    private static final String TEST_PROJECT_NAME = "Test Project Suite";
    private static final String PROJECT_CODE = "TPS";

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

    @Test(description = "Positive Create Suite Test", groups = {"Smoke"})
    public void newSuiteTest(){

        String projectName = TEST_PROJECT_NAME;
        String testSuiteName = "Smoke";
        String description = "Smoke Tests";
        String preconditions = "Open qase.io";

        loginPage.openLoginPage().setUsername(USERNAME).setPassword(PASSWORD).clickLoginButton().clickProjectLink(projectName);
        newProjectPage.clickCreateSuiteButton();

        Suite suite = Suite.builder().suitName(testSuiteName).description(description).preconditions(preconditions).build();
        newSuiteModal.fillformSuite(suite);
        newSuiteModal.clickCreateButton();

        Assert.assertEquals(repositoryPage.getSuiteName(testSuiteName), testSuiteName);
    }

    @AfterTest(description = "Delete Created Test Project")
    public void deleteNewTestProjectByCode() {
        projectAdapter.deleteProjectByCode(200, PROJECT_CODE);
    }
}
