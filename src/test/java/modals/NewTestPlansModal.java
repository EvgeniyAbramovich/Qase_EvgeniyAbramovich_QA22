package modals;

import elements.DataPlaceholder;
import elements.Input;
import models.TestPlans;
import org.openqa.selenium.WebDriver;

public class NewTestPlansModal extends BaseModal{

    public NewTestPlansModal() {
        super(driver);
    }

    public void fillformTestPlans(TestPlans testPlans) {
        new Input(driver,"Title").setValue(testPlans.getTitle());
        new DataPlaceholder(driver,"Description").setValue(testPlans.getDescription());
    }
}
