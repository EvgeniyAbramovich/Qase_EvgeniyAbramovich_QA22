package tests;

import org.testng.Assert;
import org.testng.annotations.*;

public class ProjectTests extends BaseTest{

    @DataProvider
    public Object[][] createNewProjectTest(){
        return new Object[][]{
                {"Project1", "QA22"},
                {"TestProject", "123"},
                {"TitleProject", "DQ"},
                {"NewProject", "CODE3"},
        };
    }
    @Test(dataProvider = "createNewProjectTest", description = "DataProvider Positive Create Project Test", groups = {"Smoke"})
    public void newProjectTest(String projectName, String projectCode) {

       loginPage.openLoginPage().setUsername(USERNAME).setPassword(PASSWORD).clickLoginButton().clickCreateNewProjectButton().
               setProjectName(projectName).setProjectCode(projectCode).clickCreateProjectButton();
       Assert.assertEquals(newProjectPage.getProjectName(projectName), projectName);
       Assert.assertEquals(newProjectPage.getProjectCode(projectCode), projectCode);

        homePage.clickAccountButton().clickSignOutButton();
    }

   @AfterTest(description = "Delete Created Project1")
    public void deleteProject1ByCode() {
        String projectCode = "QA22";
        projectAdapter.deleteProjectByCode(200, projectCode);
  }

    @AfterTest(description = "Delete Created TestProject")
    public void deleteTestProjectByCode() {
        String projectCode = "123";
        projectAdapter.deleteProjectByCode(200, projectCode);
    }

    @AfterTest(description = "Delete Created TitleProject")
    public void deleteTitleTestProjectByCode() {
        String projectCode = "DQ";
        projectAdapter.deleteProjectByCode(200, projectCode);
    }

    @AfterTest(description = "Delete Created Project")
    public void deleteNewTestProjectByCode() {
        String projectCode = "CODE3";
        projectAdapter.deleteProjectByCode(200, projectCode);
    }

}







