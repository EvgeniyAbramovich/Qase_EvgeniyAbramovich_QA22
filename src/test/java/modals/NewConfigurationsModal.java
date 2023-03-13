package modals;

import elements.Input;
import lombok.extern.log4j.Log4j2;
import models.Configurations;
import org.openqa.selenium.By;
import pages.ConfigurationsPage;

import static com.codeborne.selenide.Selenide.$;
@Log4j2
public class NewConfigurationsModal extends BaseModal{

    private final static By CREATE_BUTTON = By.xpath("//span[@class='UdZcu9' and text()='Create']");

    public NewConfigurationsModal fillformConfigurations(Configurations configurations) {
        log.info("Setting values = {}", configurations);
        new Input("Title").setValue(configurations.getTitle());
        return this;
    }

    public ConfigurationsPage clickSaveButton() {
        log.info("Clicking Save Button");
        $(CREATE_BUTTON).click();
        return new ConfigurationsPage();
    }
}
