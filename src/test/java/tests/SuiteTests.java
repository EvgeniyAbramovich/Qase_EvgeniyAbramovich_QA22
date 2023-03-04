package tests;

import modals.NewSuiteModal;
import models.Suite;
import org.testng.Assert;
import org.testng.annotations.Test;

import static com.codeborne.selenide.Selenide.open;

public class SuiteTests extends BaseTest{

    @Test
    public void newSuiteTest(){

        String projectName = "TestProject";

        String testSuiteName = "Smoke";
        String description = "Smoke Tests";
        String preconditions = "Open qase.io";

        loginPage.openLoginPage().setUsername(USERNAME).setPassword(PASSWORD).clickLoginButton().clickProjectLink(projectName);
        newProjectPage.clickCreateSuiteButton();

        Suite suite = Suite.builder().suitName(testSuiteName).description(description).preconditions(preconditions).build();
        newSuiteModal.fillformSuite(suite);
        newSuiteModal.clickCreateButton();

        Assert.assertEquals(repositoryPage.getSuiteName(testSuiteName), testSuiteName);

    }
}
