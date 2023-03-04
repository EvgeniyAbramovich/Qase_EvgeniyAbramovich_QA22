package tests;

import enums.*;
import models.TestCase;
import org.testng.Assert;
import org.testng.annotations.Test;


public class TestCaseTests extends BaseTest{

    @Test
    public void newTestCaseTest(){

        String projectName = "TestProject";
        String testCaseName = "Authorization";


        loginPage.openLoginPage().setUsername(USERNAME).setPassword(PASSWORD).clickLoginButton().clickProjectLink(projectName);
        newProjectPage.clickCreateCaseButton();
        newTestCaseModal.setTitleTestCase(testCaseName);

        TestCase testCase = TestCase.builder().status(Status.ACTUAL).description("New Test Case")
                .severity(Severity.MAJOR).priority(Priority.MEDIUM).type(Type.FUNCTIONAL).layer(Layer.API)
                .isFlaky(IsFlaky.NO).behavior(Behavior.POSITIVE).automationStatus(AutomationStatus.NOT_AUTOMATED)
                .preConditions("PreCondition").postConditions("PostCondition").build();
        newTestCaseModal.fillformTestCase(testCase);
        newTestCaseModal.clickSaveButton();
        repositoryPage.clickTestCaseLink();

        Assert.assertEquals(testCaseDetailsModal.getTestCaseName(testCaseName), testCaseName);
        Assert.assertEquals(testCaseDetailsModal.getTestCaseDetails(),testCase);






    }
}