package Modals;

import Elements.DataPlaceholder;
import Elements.Input;
import Models.TestPlans;
import org.openqa.selenium.WebDriver;

public class NewTestPlansModal extends BaseModal{

    public NewTestPlansModal(WebDriver driver) {
        super(driver);
    }

    public void fillformTestPlans(TestPlans testPlans) {
        new Input(driver,"Title").setValue(testPlans.getTitle());
        new DataPlaceholder(driver,"Description").setValue(testPlans.getDescription());
    }
}
