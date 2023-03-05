package tests;

import org.testng.annotations.Test;

public class TestPlansTests extends BaseTest{

    @Test
    public void newTestPlanTest(){

        String projectName = "TestProject";

        loginPage.openLoginPage().setUsername(USERNAME).setPassword(PASSWORD).clickLoginButton().clickProjectLink(projectName);
        newProjectPage.clickTestPlansLabel();


    }
}
