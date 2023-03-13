package modals;

import elements.DataPlaceholder;
import elements.Input;
import lombok.extern.log4j.Log4j2;
import models.Suite;
import org.openqa.selenium.By;
import pages.RepositoryPage;

import static com.codeborne.selenide.Selenide.$;
@Log4j2
public class NewSuiteModal extends BaseModal{

    private final static By CREATE_BUTTON = By.xpath("//span[text()='Create']");

    public NewSuiteModal fillformSuite(Suite suite) {
        log.info("Setting values = {}", suite);
        new Input("Suite name").setValue(suite.getSuitName());
        new DataPlaceholder("Description").setValue(suite.getDescription());
        new DataPlaceholder("Preconditions").setValue(suite.getPreconditions());
        return this;
    }

    public RepositoryPage clickCreateButton() {
        log.info("Clicking Create Button");
        $(CREATE_BUTTON).click();
        return new RepositoryPage();
    }
}
