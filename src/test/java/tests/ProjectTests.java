package tests;

import io.qameta.allure.Description;
import io.qameta.allure.Severity;
import io.qameta.allure.SeverityLevel;
import org.testng.Assert;
import org.testng.annotations.*;

public class ProjectTests extends BaseTest{

    @Severity(SeverityLevel.CRITICAL)
    @Description("Create New Project")
    @Test(description = "Create New Project Test", groups = {"Smoke"}, retryAnalyzer = Retry.class)
    public void newProjectTest() {
        String projectName = "Project1";
        String projectCode = "QA";
        String projectDescription = "Good Project";


       loginPage.openLoginPage().setUsername(USERNAME).setPassword(PASSWORD).clickLoginButton().clickCreateNewProjectButton().
               setProjectName(projectName).setProjectCode(projectCode).clickCreateProjectButton();
       Assert.assertEquals(newProjectPage.getProjectName(projectName), projectName);
       Assert.assertEquals(newProjectPage.getProjectCode(projectCode), projectCode);

        }


}







