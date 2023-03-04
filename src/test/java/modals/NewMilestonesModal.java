package modals;

import elements.Input;
import models.Milestones;


public class NewMilestonesModal extends BaseModal{


    public NewMilestonesModal fillformMilestones(Milestones milestones) {
        new Input("Milestone name").setValue(milestones.getMilestoneName());
        new Input("Due date").setValue(milestones.getDueDate());
        return this;
    }


}
