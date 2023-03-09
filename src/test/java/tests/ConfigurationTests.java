package tests;

import models.Configurations;
import models.Project;
import org.testng.Assert;
import org.testng.annotations.AfterTest;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.Test;


public class ConfigurationTests extends BaseTest{

    private static final String TEST_PROJECT_NAME = "Test Project Configuration";
    private static final String PROJECT_CODE = "TPC";

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

    @Test(description = "Positive Create Configuration Test", groups = {"Smoke"})
    public void newConfigurationTest() {
        String projectName = TEST_PROJECT_NAME;
        String testConfigurationGroupName = "New Configuration Group";

        loginPage.openLoginPage().setUsername(USERNAME).setPassword(PASSWORD).clickLoginButton().clickProjectLink(projectName);
        newProjectPage.clickConfigurationsLabel();
        configurationsPage.clickCreateConfigurationGroupButton();

        Configurations testConfigurations = Configurations.builder().title(testConfigurationGroupName).build();
        newConfigurationsModal.fillformConfigurations(testConfigurations);
        newConfigurationsModal.clickSaveButton();

        Assert.assertEquals(configurationsPage.getConfigurationGroupName(testConfigurationGroupName), testConfigurationGroupName);

    }

    @AfterTest(description = "Delete Created Test Project")
    public void deleteNewTestProjectByCode() {
        projectAdapter.deleteProjectByCode(200, PROJECT_CODE);
    }
}
