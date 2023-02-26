package modals;

import elements.Input;
import models.SharedSteps;
import org.openqa.selenium.WebDriver;

public class NewSharedStepsModal extends BaseModal{

    public NewSharedStepsModal() {
        super(driver);
    }

    public void fillformSharedSteps(SharedSteps sharedSteps) {
        new Input(driver,"Shared step title").setValue(sharedSteps.getSharedStepTitle());
    }
}
