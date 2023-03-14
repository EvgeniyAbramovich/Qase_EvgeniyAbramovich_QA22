package pages;

import elements.DataPlaceHolderDetail;
import elements.InputDetail;
import elements.InputMilestoneDetail;
import models.Milestones;

public class EditMilestonePage extends BasePage {

    public Milestones getMilestoneDetails() {
        Milestones.MilestonesBuilder milestone = Milestones.builder();

        milestone.milestoneName(new InputDetail("Milestone name").getInputDetailValue());
        milestone.description(new DataPlaceHolderDetail("Description").getDataPlaceholderDetailValue());
        milestone.dueDate(new InputMilestoneDetail("Due date").getMilestoneInputDetailValue());

        return milestone.build();

    }
}
