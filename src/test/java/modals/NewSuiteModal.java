package modals;

import elements.DataPlaceholder;
import elements.Input;
import models.Suite;
import org.openqa.selenium.By;
import pages.RepositoryPage;

import static com.codeborne.selenide.Selenide.$;

public class NewSuiteModal extends BaseModal{

    private final static By CREATE_BUTTON = By.xpath("//span[text()='Create']");

    public NewSuiteModal fillformSuite(Suite suite) {
        new Input("Suite name").setValue(suite.getSuitName());
        new DataPlaceholder("Description").setValue(suite.getDescription());
        new DataPlaceholder("Preconditions").setValue(suite.getPreconditions());
        return this;
    }

    public RepositoryPage clickCreateButton() {
        $(CREATE_BUTTON).click();
        return new RepositoryPage();
    }
}
