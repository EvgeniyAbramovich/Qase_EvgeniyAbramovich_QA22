package modals;

import elements.Input;
import models.Milestones;
import org.openqa.selenium.WebDriver;

public class NewMilestonesModal extends BaseModal{

    public NewMilestonesModal() {
        super(driver);
    }

    public void fillformMilestones(Milestones milestones) {
        new Input(driver,"Milestone name").setValue(milestones.getMilestoneName());
        new Input(driver,"Due date").setValue(milestones.getDueDate());
    }


}
