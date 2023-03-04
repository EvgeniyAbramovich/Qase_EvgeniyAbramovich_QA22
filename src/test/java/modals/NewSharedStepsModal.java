package modals;

import elements.Input;
import models.SharedSteps;


public class NewSharedStepsModal extends BaseModal{


    public NewSharedStepsModal fillformSharedSteps(SharedSteps sharedSteps) {
        new Input("Shared step title").setValue(sharedSteps.getSharedStepTitle());
        return this;
    }
}
