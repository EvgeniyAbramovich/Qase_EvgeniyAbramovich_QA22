package pages;

import lombok.extern.log4j.Log4j2;
import modals.NewEnvironmentsModal;
import org.openqa.selenium.By;

import static com.codeborne.selenide.Selenide.$;

@Log4j2
public class EnvironmentsPage extends BasePage {

    private final static By CREATE_NEW_ENVIRONMENT_BUTTON = By.xpath("//a[text()='Create new environment']");
    private final static By ENVIRONMENT_TITLE = By.cssSelector(".defect-title");


    public NewEnvironmentsModal clickCreateNewEnvironmentButton() {
        log.info("Clicking Create New Environment Button");
        $(CREATE_NEW_ENVIRONMENT_BUTTON).click();
        return new NewEnvironmentsModal();
    }

    public EditEnvironmentPage clickEnvironmentTitle() {
        log.info("Clicking Environment Title");
        $(ENVIRONMENT_TITLE).click();
        return new EditEnvironmentPage();
    }
}
