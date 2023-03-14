package modals;

import elements.DataPlaceholder;
import elements.Input;
import lombok.extern.log4j.Log4j2;
import models.Environment;
import org.openqa.selenium.By;
import pages.EnvironmentsPage;

import static com.codeborne.selenide.Selenide.$;

@Log4j2
public class NewEnvironmentsModal extends BaseModal {


    private final static By CREATE_ENVIRONMENT_BUTTON = By.xpath("//button[text()='Create environment']");

    public NewEnvironmentsModal fillformEnvironments(Environment environment) {
        log.info("Setting values = {}", environment);
        new Input("Title").setValue(environment.getTitle());
        new Input("Slug").setValue(environment.getSlug());
        new DataPlaceholder("Description").setValue(environment.getDescription());
        new Input("Host").setValue(environment.getHost());
        return this;
    }

    public EnvironmentsPage clickCreateEnvironmentButton() {
        log.info("Clicking Create environment Button");
        $(CREATE_ENVIRONMENT_BUTTON).click();
        return new EnvironmentsPage();
    }


}
