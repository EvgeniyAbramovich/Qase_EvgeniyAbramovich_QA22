package modals;

import elements.DataPlaceholder;
import elements.Input;
import models.Environment;
import org.openqa.selenium.By;
import pages.ConfigurationsPage;
import pages.EnvironmentsPage;

import static com.codeborne.selenide.Selenide.$;

public class NewEnvironmentsModal extends BaseModal{


    private final static By CREATE_ENVIRONMENT_BUTTON = By.xpath("//button[text()='Create environment']");

    public NewEnvironmentsModal fillformEnvironments(Environment environment) {
        new Input("Title").setValue(environment.getTitle());
        new Input("Slug").setValue(environment.getSlug());
        new DataPlaceholder("Description").setValue(environment.getDescription());
        new Input("Host").setValue(environment.getHost());
        return this;
    }

    public EnvironmentsPage clickCreateEnvironmentButton() {
        $(CREATE_ENVIRONMENT_BUTTON).click();
        return new EnvironmentsPage();
    }


}
