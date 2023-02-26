package modals;

import elements.Input;
import models.Configurations;

public class NewConfigurationsModal extends BaseModal{
    public NewConfigurationsModal() {
        super(driver);
    }

    public void fillformConfigurations(Configurations configurations) {
        new Input(driver,"Title").setValue(configurations.getTitle());
    }
}
