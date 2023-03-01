package modals;

import elements.Input;
import models.Milestones;


public class NewMilestonesModal extends BaseModal{

    public NewMilestonesModal() {
        super(driver);
    }
    @Override
    public boolean isPageOpened() {
        return false;
    }

    public void fillformMilestones(Milestones milestones) {
        new Input("Milestone name").setValue(milestones.getMilestoneName());
        new Input("Due date").setValue(milestones.getDueDate());
    }


}
