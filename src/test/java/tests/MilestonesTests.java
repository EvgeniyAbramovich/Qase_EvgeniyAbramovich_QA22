package tests;

import io.qameta.allure.Severity;
import io.qameta.allure.SeverityLevel;
import jdk.jfr.Description;
import models.Milestones;
import org.testng.Assert;
import org.testng.annotations.Test;

public class MilestonesTests extends BaseTest{

    @Severity(SeverityLevel.NORMAL)
    @Description("Create New Milestone in created Test Project")
    @Test(description = "Positive Create Milestone Test", groups = {"Smoke"}, retryAnalyzer = Retry.class)
    public void newMilestoneTest() {

        String projectName = TEST_PROJECT_NAME;

        loginPage.openLoginPage().setUsername(USERNAME).setPassword(PASSWORD).clickLoginButton().clickProjectLink(projectName);
        newProjectPage.clickMilestonesLabel();
        milestonesPage.clickCreateMilestoneButton();

        Milestones milestones = Milestones.builder().milestoneName("New Milestone").description("Good")
                .dueDate("2023-03-05").build();
        newMilestonesModal.fillformMilestones(milestones).clickCreateMilestoneButton().clickMilestoneTitle();

        Assert.assertEquals(editMilestonePage.getMilestoneDetails(), milestones);

    }

}
