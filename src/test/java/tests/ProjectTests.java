package tests;

import adapters.ProjectAdapter;
import org.testng.Assert;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.AfterTest;
import org.testng.annotations.DataProvider;
import org.testng.annotations.Test;
import utils.PropertyReader;

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

    @AfterMethod(onlyForGroups = {"Smoke"}, description = "Delete Created Project")
    public void deleteProjectByCode() {

        projectAdapter.deleteProjectByCode(200,
                PropertyReader.getProperty("qase.api.project.createProject_deleteProject.code"));
    }

    @DataProvider
    public Object[][] getAllProjectsTest(){
     return new Object[][]{
             {"Demo Project", "DEMO"},
             {"Evgeniy Abramovich. QA22. Homework 2", "EAQH"},
             {"QA22_Demo","1235"},
             {"TestProject", "123"},
             {"Title", "DQ"},
             {"NewProject", "CODE3"},
     };
    }

    @Test(dataProvider = "getAllProjectsTest")
    public void getAllProjectsTest(String projectName, String projectCode){
        loginPage.openLoginPage().setUsername(USERNAME).setPassword(PASSWORD).clickLoginButton();
        projectsPage.clickProjectLink(projectName);

        Assert.assertEquals(newProjectPage.getProjectName(projectName), projectName);
        Assert.assertEquals(newProjectPage.getProjectCode(projectCode), projectCode);

        homePage.clickAccountButton().clickSignOutButton();

    }






}







