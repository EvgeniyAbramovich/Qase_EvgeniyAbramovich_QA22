package modals;

import elements.Input;
import models.Configurations;
import org.openqa.selenium.By;
import pages.ConfigurationsPage;

import static com.codeborne.selenide.Selenide.$;

public class NewConfigurationsModal extends BaseModal{
    public NewConfigurationsModal() {
        super(driver);
    }
    @Override
    public boolean isPageOpened() {
        return false;
    }

    private final static By CREATE_BUTTON = By.xpath("//span[@class='UdZcu9' and text()='Create']");

    public void fillformConfigurations(Configurations configurations) {
        new Input("Title").setValue(configurations.getTitle());
    }

    public ConfigurationsPage clickSaveButton() {
        $(CREATE_BUTTON).click();
        return new ConfigurationsPage();
    }
}
