package Modals;

import Elements.Input;
import Models.Configurations;
import org.openqa.selenium.WebDriver;

public class NewConfigurationsModal extends BaseModal{
    public NewConfigurationsModal(WebDriver driver) {
        super(driver);
    }

    public void fillformConfigurations(Configurations configurations) {
        new Input(driver,"Title").setValue(configurations.getTitle());
    }
}
