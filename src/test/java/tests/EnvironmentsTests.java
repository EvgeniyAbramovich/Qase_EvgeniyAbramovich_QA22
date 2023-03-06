package tests;

import models.Environment;
import org.testng.Assert;
import org.testng.annotations.Test;

import static com.codeborne.selenide.Selenide.open;

public class EnvironmentsTests extends BaseTest{

    @Test(description = "Positive Create Environment Test", groups = {"Smoke"})
    public void newEnvironmentTest() {
        String projectName = "TestProject";
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
}
