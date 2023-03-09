package tests;

import adapters.ProjectAdapter;
import com.google.gson.Gson;
import models.Environment;
import models.Project;
import org.testng.Assert;
import org.testng.annotations.AfterTest;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.Test;

import static com.codeborne.selenide.Selenide.open;

public class EnvironmentsTests extends BaseTest{

    private static final String TEST_PROJECT_NAME = "Test Project Environment";
    private static final String PROJECT_CODE = "TPE";

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

    @Test(description = "Positive Create Environment Test", groups = {"Smoke"})
    public void newEnvironmentTest() {
        String projectName = TEST_PROJECT_NAME;
        String testEnvironmentName = "New Environment";
        String testSlug = "Envir";
        String description = "All Right";
        String testHost = "qase.io";

        loginPage.openLoginPage().setUsername(USERNAME).setPassword(PASSWORD).clickLoginButton().clickProjectLink(projectName);
        newProjectPage.clickEnvironmentsLabel();
        environmentsPage.clickCreateNewEnvironmentButton();

        Environment testEnvironment = Environment.builder().title(testEnvironmentName).slug(testSlug)
                .description(description).host(testHost).build();
        newEnvironmentsModal.fillformEnvironments(testEnvironment).clickCreateEnvironmentButton().clickEnvironmentTitle();

        Assert.assertEquals(editEnvironmentPage.getEnvironmentDetails(),testEnvironment);

    }

    @AfterTest(description = "Delete Created Test Project")
    public void deleteNewTestProjectByCode() {
        projectAdapter.deleteProjectByCode(200, PROJECT_CODE);
    }
}
