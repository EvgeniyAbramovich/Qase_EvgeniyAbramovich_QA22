package modals;

import elements.DataPlaceholder;
import elements.Input;
import models.Environment;
import org.openqa.selenium.By;
import pages.ConfigurationsPage;

import static com.codeborne.selenide.Selenide.$;

public class NewEnvironmentsModal extends BaseModal{

    public NewEnvironmentsModal() {
        super(driver);
    }
    @Override
    public boolean isPageOpened() {
        return false;
    }

    private final static By CREATE_ENVIRONMENT_BUTTON = By.xpath("//button[@class='btn btn-primary'" +
            " and text()='Create environment']");

    public void fillformEnvironments(Environment environment) {
        new Input("Title").setValue(environment.getTitle());
        new Input("Slug").setValue(environment.getSlug());
        new DataPlaceholder("Description").setValue(environment.getDescription());
        new Input("Host").setValue(environment.getHost());
    }

    public ConfigurationsPage clickCreateEnvironmentButton() {
        $(CREATE_ENVIRONMENT_BUTTON).click();
        return new ConfigurationsPage();
    }


}
