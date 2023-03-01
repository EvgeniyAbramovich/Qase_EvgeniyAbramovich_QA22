package modals;

import elements.Input;
import models.SharedSteps;


public class NewSharedStepsModal extends BaseModal{

    public NewSharedStepsModal() {
        super(driver);
    }
    @Override
    public boolean isPageOpened() {
        return false;
    }

    public void fillformSharedSteps(SharedSteps sharedSteps) {
        new Input("Shared step title").setValue(sharedSteps.getSharedStepTitle());
    }
}
