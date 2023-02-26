package tests;

import org.testng.Assert;
import org.testng.annotations.Test;


import static com.codeborne.selenide.Selenide.*;

public class ProjectTests extends BaseTest{


    @Test
    public void newProjectTest() {
        String ProjectName = "Project1";
        open("/login");
       loginPage.setUsername(USERNAME).setPassword(PASSWORD).clickLoginButton().clickCreateNewProjectButton().
               setProjectName(ProjectName).setProjectCode("QA22").setDescription("Good Project").
               clickCreateProjectButton().isPageOpened();
        Assert.assertEquals(newProjectPage.getProjectName(), ProjectName);

    }







    }







