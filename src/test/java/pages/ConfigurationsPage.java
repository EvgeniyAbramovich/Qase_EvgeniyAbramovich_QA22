package pages;

import lombok.extern.log4j.Log4j2;
import modals.NewConfigurationsModal;
import org.openqa.selenium.By;

import static com.codeborne.selenide.Selenide.$;
@Log4j2
public class ConfigurationsPage extends BasePage{

    private final static By CREATE_CONFIGURATION_GROUP_BUTTON = By.xpath("//button[text()='Create configuration group']");
    private final static By CONFIGURATION_GROUP_TITLE = By.cssSelector(".configurations-group-header-title");

       public NewConfigurationsModal clickCreateConfigurationGroupButton() {
           log.info("Clicking Create Configuration Button");
        $(CREATE_CONFIGURATION_GROUP_BUTTON).click();
        return new NewConfigurationsModal();
    }

    public String getConfigurationGroupName(String configurationGroupName) {
           log.info("Getting Created Configuration Group Name = {}",configurationGroupName);
        $(CONFIGURATION_GROUP_TITLE).getText();
        return configurationGroupName;
    }
}
