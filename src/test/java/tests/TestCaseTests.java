package tests;

import enums.*;
import io.qameta.allure.Description;
import io.qameta.allure.SeverityLevel;
import models.TestCase;
import org.testng.Assert;
import org.testng.annotations.Test;


public class TestCaseTests extends BaseTest{
    @io.qameta.allure.Severity(SeverityLevel.CRITICAL)
    @Description("Create New Test Case in created Test Project")
    @Test(description = "Positive Create TestCase Test", groups = {"Smoke"}, retryAnalyzer = Retry.class)
    public void newTestCaseTest(){

        String projectName = TEST_PROJECT_NAME;
        String testCaseName = "Authorization";

        loginPage.openLoginPage().setUsername(USERNAME).setPassword(PASSWORD).clickLoginButton().clickProjectLink(projectName);
        newProjectPage.clickCreateCaseButton();

        TestCase testCase = TestCase.builder().title(testCaseName).status(Status.ACTUAL).description("New Test Case")
                .severity(Severity.MAJOR).priority(Priority.MEDIUM).type(Type.FUNCTIONAL).layer(Layer.API)
                .isFlaky(IsFlaky.NO).behavior(Behavior.POSITIVE).automationStatus(AutomationStatus.NOT_AUTOMATED)
                .preConditions("PreCondition").postConditions("PostCondition").build();
        newTestCaseModal.fillformTestCase(testCase);
        newTestCaseModal.clickSaveButton();
        repositoryPage.clickTestCaseLink().clickEditButton();

        Assert.assertEquals(editTestCasePage.getTestCaseDetails(),testCase);

    }

}
