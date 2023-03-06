package tests;

import models.SharedSteps;
import org.testng.Assert;
import org.testng.annotations.Test;

import static com.codeborne.selenide.Selenide.open;

public class SharedStepsTests extends BaseTest{

    @Test(description = "Positive Create Shared Step Test", groups = {"Smoke"})
    public void newSharedStepTest(){

        String projectName = "TestProject";
        String sharedStepName = "Authorization";



        loginPage.openLoginPage().setUsername(USERNAME).setPassword(PASSWORD).clickLoginButton().clickProjectLink(projectName);
        newProjectPage.clickSharedStepsLabel();

        sharedStepsPage.clickCreateSharedStepButton().clickAddStepButton();

        SharedSteps sharedSteps = SharedSteps.builder().sharedStepTitle(sharedStepName).action("Open Login Page")
                .inputData("Login").expectedResult("Open Projects Page").build();
        newSharedStepsModal.fillformSharedSteps(sharedSteps).clickCreateButton().clickSharedStepLink();

        Assert.assertEquals(editSharedStepPage.getSharedStepDetails(), sharedSteps);










    }
}
