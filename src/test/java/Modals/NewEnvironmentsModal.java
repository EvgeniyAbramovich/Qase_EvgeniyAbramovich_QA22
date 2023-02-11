package Modals;

import Elements.DataPlaceholder;
import Elements.Input;
import Models.Environment;
import org.openqa.selenium.WebDriver;

public class NewEnvironmentsModal extends BaseModal{

    public NewEnvironmentsModal(WebDriver driver) {
        super(driver);
    }

    public void fillformEnvironments(Environment environment) {
        new Input(driver,"Title").setValue(environment.getTitle());
        new Input(driver,"Slug").setValue(environment.getSlug());
        new DataPlaceholder(driver,"Description").setValue(environment.getDescription());
        new Input(driver,"Host").setValue(environment.getHost());
    }
}
