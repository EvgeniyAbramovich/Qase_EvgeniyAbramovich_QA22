package modals;

import elements.DataPlaceholder;
import elements.Input;
import models.TestPlans;

public class NewTestPlansModal extends BaseModal{


    public NewTestPlansModal fillformTestPlans(TestPlans testPlans) {
        new Input("Title").setValue(testPlans.getTitle());
        new DataPlaceholder("Description").setValue(testPlans.getDescription());
        return this;
    }
}
