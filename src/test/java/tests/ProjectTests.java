package tests;

import org.testng.Assert;
import org.testng.annotations.Test;


import static com.codeborne.selenide.Selenide.*;

public class ProjectTests extends BaseTest{

    @Test
    public void newProjectTest() {
        String projectName = "Project1";
        String projectCode = "QA22";
        String projectDescription = "Good Project";
        open("/projects");

       loginPage.setUsername(USERNAME).setPassword(PASSWORD).clickLoginButton().clickCreateNewProjectButton().
               setProjectName(projectName).setProjectCode(projectCode).setDescription(projectDescription).
               clickCreateProjectButton().isPageOpened();
       Assert.assertEquals(newProjectPage.getProjectName(projectName), projectName);
       Assert.assertEquals(newProjectPage.getProjectCode(projectCode), projectCode);

    }
}







