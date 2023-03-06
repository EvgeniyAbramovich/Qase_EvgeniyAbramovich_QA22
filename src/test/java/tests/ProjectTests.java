package tests;

import org.testng.Assert;
import org.testng.annotations.AfterTest;
import org.testng.annotations.Test;


import static com.codeborne.selenide.Selenide.*;

public class ProjectTests extends BaseTest{

    @Test(description = "Positive Create Project Test", groups = {"Smoke"})
    public void newProjectTest() {
        String projectName = "Project1";
        String projectCode = "QA22";
        String projectDescription = "Good Project";

       loginPage.openLoginPage().setUsername(USERNAME).setPassword(PASSWORD).clickLoginButton().clickCreateNewProjectButton().
               setProjectName(projectName).setProjectCode(projectCode).setDescription(projectDescription).
               clickCreateProjectButton();
       Assert.assertEquals(newProjectPage.getProjectName(projectName), projectName);
       Assert.assertEquals(newProjectPage.getProjectCode(projectCode), projectCode);

    }


}







