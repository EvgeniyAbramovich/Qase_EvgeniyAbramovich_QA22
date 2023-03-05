package modals;

import elements.DataPlaceholder;
import elements.DropDownMilestone;
import elements.Input;
import models.Milestones;
import org.openqa.selenium.By;
import pages.MilestonesPage;

import static com.codeborne.selenide.Selenide.$;


public class NewMilestonesModal extends BaseModal{

    private final static By CREATE_MILESTONE_BUTTON = By.xpath("//button[text()='Create milestone']");


    public NewMilestonesModal fillformMilestones(Milestones milestones) {
        new Input("Milestone name").setValue(milestones.getMilestoneName());
        new DataPlaceholder("Description").setValue(milestones.getDescription());
        new DropDownMilestone("Status").selectValue(milestones.getStatus().getName());
        new Input("Due date").setValue(milestones.getDueDate());
        new Input("Due date").sendEnterKey();

        return this;
    }

    public MilestonesPage clickCreateMilestoneButton() {
        $(CREATE_MILESTONE_BUTTON).click();
        return new MilestonesPage();
    }




}
