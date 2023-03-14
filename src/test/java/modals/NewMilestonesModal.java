package modals;

import elements.DataPlaceholder;
import elements.Input;
import lombok.extern.log4j.Log4j2;
import models.Milestones;
import org.openqa.selenium.By;
import pages.MilestonesPage;

import static com.codeborne.selenide.Selenide.$;

@Log4j2
public class NewMilestonesModal extends BaseModal {

    private final static By CREATE_MILESTONE_BUTTON = By.xpath("//button[text()='Create milestone']");


    public NewMilestonesModal fillformMilestones(Milestones milestones) {
        log.info("Setting values = {}", milestones);
        new Input("Milestone name").setValue(milestones.getMilestoneName());
        new DataPlaceholder("Description").setValue(milestones.getDescription());
        new Input("Due date").setValue(milestones.getDueDate());
        new Input("Due date").sendEnterKey();

        return this;
    }

    public MilestonesPage clickCreateMilestoneButton() {
        log.info("Clicking Create Milestone Button");
        $(CREATE_MILESTONE_BUTTON).click();
        return new MilestonesPage();
    }


}
