package tests;

import enums.Status;
import models.Milestones;
import org.testng.Assert;
import org.testng.annotations.Test;

public class MilestonesTests extends BaseTest{

    @Test
    public void newMilestoneTest() {

        String projectName = "TestProject";

        loginPage.openLoginPage().setUsername(USERNAME).setPassword(PASSWORD).clickLoginButton().clickProjectLink(projectName);
        newProjectPage.clickMilestonesLabel();
        milestonesPage.clickCreateMilestoneButton();

        Milestones milestones = Milestones.builder().milestoneName("New Milestone").description("Good")
                .status(Status.COMPLETED).dueDate("2023-03-05").build();
        newMilestonesModal.fillformMilestones(milestones).clickCreateMilestoneButton().clickMilestoneTitle();

        Assert.assertEquals(editMilestonePage.getMilestoneDetails(), milestones);


    }
}
