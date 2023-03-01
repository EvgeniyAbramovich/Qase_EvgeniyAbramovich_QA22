package tests;

import models.Environment;
import org.testng.Assert;
import org.testng.annotations.Test;

import static com.codeborne.selenide.Selenide.open;

public class EnvironmentsTests extends BaseTest{

    @Test
    public void newEnvironmentTest() {
        String projectName = "TestProject";
        String testEnvironmentName = "New Environment";
        String testSlug = "Envir";
        String description = "All Right";
        String testHost = "qase.io";
        open("/login");

        loginPage.setUsername(USERNAME).setPassword(PASSWORD).clickLoginButton().clickProjectLink(projectName);
        newProjectPage.clickEnvironmentsLabel().isPageOpened();
        environmentsPage.clickNewEnvironmentButton().isPageOpened();

        Environment testEnvironment = Environment.builder().title(testEnvironmentName).slug(testSlug)
                .description(description).host(testHost).build();
        newEnvironmentsModal.fillformEnvironments(testEnvironment);
        newEnvironmentsModal.clickCreateEnvironmentButton();

        Assert.assertEquals(environmentsPage.getEnvironmentName(testEnvironmentName), testEnvironmentName);

    }
}
