package modals;

import elements.Input;
import models.Configurations;
import org.openqa.selenium.By;
import pages.ConfigurationsPage;

import static com.codeborne.selenide.Selenide.$;

public class NewConfigurationsModal extends BaseModal{

    private final static By CREATE_BUTTON = By.xpath("//span[@class='UdZcu9' and text()='Create']");

    public NewConfigurationsModal fillformConfigurations(Configurations configurations) {
        new Input("Title").setValue(configurations.getTitle());
        return this;
    }

    public ConfigurationsPage clickSaveButton() {
        $(CREATE_BUTTON).click();
        return new ConfigurationsPage();
    }
}
