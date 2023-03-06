package modals;

import elements.DataPlaceholder;
import elements.Input;
import lombok.extern.log4j.Log4j2;
import models.TestPlans;
@Log4j2
public class NewTestPlansModal extends BaseModal{


    public NewTestPlansModal fillformTestPlans(TestPlans testPlans) {
        log.info("Setting values = {}", testPlans);
        new Input("Title").setValue(testPlans.getTitle());
        new DataPlaceholder("Description").setValue(testPlans.getDescription());
        return this;
    }
}
