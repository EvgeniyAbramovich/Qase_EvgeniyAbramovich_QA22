package modals;

import elements.DataPlaceholder;
import elements.Input;
import models.Environment;

public class NewEnvironmentsModal extends BaseModal{

    public NewEnvironmentsModal() {
        super(driver);
    }

    public void fillformEnvironments(Environment environment) {
        new Input(driver,"Title").setValue(environment.getTitle());
        new Input(driver,"Slug").setValue(environment.getSlug());
        new DataPlaceholder(driver,"Description").setValue(environment.getDescription());
        new Input(driver,"Host").setValue(environment.getHost());
    }
}
