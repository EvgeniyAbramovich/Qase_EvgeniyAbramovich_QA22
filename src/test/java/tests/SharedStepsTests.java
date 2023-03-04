package tests;

import org.testng.annotations.Test;

import static com.codeborne.selenide.Selenide.open;

public class SharedStepsTests extends BaseTest{

    @Test
    public void newSharedStepTest(){

        String projectName = "TestProject";

        loginPage.openLoginPage().setUsername(USERNAME).setPassword(PASSWORD).clickLoginButton().clickProjectLink(projectName);
        newProjectPage.clickSharedStepsLabel();

        sharedStepsPage.clickCreateSharedStepButton();





    }
}
