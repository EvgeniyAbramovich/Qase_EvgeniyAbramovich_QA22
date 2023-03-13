package tests;

import io.qameta.allure.Description;
import io.qameta.allure.Severity;
import io.qameta.allure.SeverityLevel;
import models.SharedSteps;
import org.testng.Assert;
import org.testng.annotations.Test;

import static com.codeborne.selenide.Selenide.open;

public class SharedStepsTests extends BaseTest{
    @Severity(SeverityLevel.NORMAL)
    @Description("Create New Shared Step in created Test Project")
    @Test(description = "Positive Create Shared Step Test", groups = {"Smoke"}, retryAnalyzer = Retry.class)
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
        @Severity(SeverityLevel.NORMAL)
        @Description("Try to create New Shared Step without required values")
        @Test(description = "Negative Shared Step Page", groups = {"Regression"}, retryAnalyzer = Retry.class)
    public void negativeSharedStepTest(){

        String projectName = TEST_PROJECT_NAME;
        String sharedStepName = "Authorization";

        loginPage.openLoginPage().setUsername(USERNAME).setPassword(PASSWORD).clickLoginButton().clickProjectLink(projectName);
        newProjectPage.clickSharedStepsLabel();
        sharedStepsPage.clickCreateSharedStepButton();
        newSharedStepsModal.setSharedStepName(sharedStepName).clickCreateButton();

        Assert.assertTrue(newSharedStepsModal.ErrorMessageIsPresent());

        }

}
