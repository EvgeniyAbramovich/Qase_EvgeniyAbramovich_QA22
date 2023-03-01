package pages;

import modals.NewConfigurationsModal;
import org.openqa.selenium.By;

import static com.codeborne.selenide.Selenide.$;

public class ConfigurationsPage extends BasePage{

    @Override
    public boolean isPageOpened() {
        return false;
    }

    public ConfigurationsPage() {
        super(driver);
    }

    private final static By CREATE_CONFIGURATION_GROUP_BUTTON = By.xpath("//button[text()='Create configuration group']");
    private final static By CONFIGURATION_GROUP_TITLE = By.cssSelector(".configurations-group-header-title");

    public NewConfigurationsModal clickCreateConfigurationGroupButton() {
        $(CREATE_CONFIGURATION_GROUP_BUTTON).click();
        return new NewConfigurationsModal();
    }

    public String getConfigurationGroupName(String configurationGroupName) {
        $(CONFIGURATION_GROUP_TITLE).getText();
        return configurationGroupName;
    }
}
