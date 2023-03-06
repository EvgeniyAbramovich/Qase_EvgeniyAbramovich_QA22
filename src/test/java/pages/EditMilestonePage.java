package pages;

import elements.*;
import enums.Status;
import models.Milestones;

public class EditMilestonePage extends BasePage{

    public Milestones getMilestoneDetails() {
        Milestones.MilestonesBuilder milestone = Milestones.builder();

        milestone.milestoneName(new InputDetail("Milestone name").getInputDetailValue());
        milestone.description(new DataPlaceHolderDetail("Description").getDataPlaceholderDetailValue());
        milestone.status(Status.fromString(new DropDownMilestoneDetail("Status").getMilestoneDropDownValue()));
        milestone.dueDate(new InputMilestoneDetail("Due date").getMilestoneInputDetailValue());

        return milestone.build();

    }
}
