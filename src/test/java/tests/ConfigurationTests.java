package tests;

import io.qameta.allure.Description;
import io.qameta.allure.Severity;
import io.qameta.allure.SeverityLevel;
import models.Configurations;
import org.testng.Assert;
import org.testng.annotations.Test;


public class ConfigurationTests extends BaseTest {

    @Severity(SeverityLevel.NORMAL)
    @Description("Create New Configuration in created Test Project")
    @Test(description = "Positive Create Configuration Test", groups = {"Smoke"}, retryAnalyzer = Retry.class)
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


}
