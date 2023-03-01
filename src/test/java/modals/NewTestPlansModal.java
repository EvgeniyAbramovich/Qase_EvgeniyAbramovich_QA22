package modals;

import elements.DataPlaceholder;
import elements.Input;
import models.TestPlans;

public class NewTestPlansModal extends BaseModal{

    public NewTestPlansModal() {
        super(driver);
    }
    @Override
    public boolean isPageOpened() {
        return false;
    }

    public void fillformTestPlans(TestPlans testPlans) {
        new Input("Title").setValue(testPlans.getTitle());
        new DataPlaceholder("Description").setValue(testPlans.getDescription());
    }
}
