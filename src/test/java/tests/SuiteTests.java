package tests;

import io.qameta.allure.Description;
import io.qameta.allure.Severity;
import io.qameta.allure.SeverityLevel;
import models.Suite;
import org.testng.Assert;
import org.testng.annotations.Test;

public class SuiteTests extends BaseTest{

    @Severity(SeverityLevel.CRITICAL)
    @Description("Create New Test Suite in created Test Project")
    @Test(description = "Positive Create Suite Test", groups = {"Smoke"}, retryAnalyzer = Retry.class)
    public void newSuiteTest(){

        String projectName = TEST_PROJECT_NAME;
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
