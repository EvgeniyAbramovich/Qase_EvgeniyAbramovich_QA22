package tests;

import models.Configurations;
import org.testng.Assert;
import org.testng.annotations.Test;



public class ConfigurationTest extends BaseTest{

    @Test(description = "Positive Create Configuration Test", groups = {"Smoke"})
    public void newConfigurationTest() {
        String projectName = "TestProject";
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
