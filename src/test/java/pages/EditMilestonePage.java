package pages;

import elements.EditDetail;
import enums.Status;
import models.Milestones;

public class EditMilestonePage extends BasePage{

    public Milestones getMilestoneDetails() {
        Milestones.MilestonesBuilder milestone = Milestones.builder();

        milestone.milestoneName(new EditDetail("Milestone name").getInputDetailValue());
        milestone.description(new EditDetail("Description").getDataPlaceholderDetailValue());
        milestone.status(Status.fromString(new EditDetail("Status").getMilestoneDropDownValue()));
        milestone.dueDate(new EditDetail("Due date").getMilestoneInputDetailValue());

        return milestone.build();

    }
}
