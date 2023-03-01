package tests;

import models.Configurations;
import org.testng.Assert;
import org.testng.annotations.Test;

import static com.codeborne.selenide.Selenide.open;

public class ConfigurationTest extends BaseTest{

    @Test
    public void newConfigurationTest() {
        String projectName = "TestProject";
        String testConfigurationGroupName = "New Configuration Group";
        open("/login");

        loginPage.setUsername(USERNAME).setPassword(PASSWORD).clickLoginButton().clickProjectLink(projectName);
        newProjectPage.clickConfigurationsLabel().isPageOpened();
        configurationsPage.clickCreateConfigurationGroupButton().isPageOpened();

        Configurations testConfigurations = Configurations.builder().title(testConfigurationGroupName).build();
        newConfigurationsModal.fillformConfigurations(testConfigurations);
        newConfigurationsModal.clickSaveButton();

        Assert.assertEquals(configurationsPage.getConfigurationGroupName(testConfigurationGroupName), testConfigurationGroupName);

    }
}
