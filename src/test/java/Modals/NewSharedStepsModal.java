package Modals;

import Elements.Input;
import Models.SharedSteps;
import org.openqa.selenium.WebDriver;

public class NewSharedStepsModal extends BaseModal{

    public NewSharedStepsModal(WebDriver driver) {
        super(driver);
    }

    public void fillformSharedSteps(SharedSteps sharedSteps) {
        new Input(driver,"Shared step title").setValue(sharedSteps.getSharedStepTitle());
    }
}
