package modals;

import elements.DataPlaceholder;
import elements.DropDown;
import elements.Input;
import models.TestCase;
import org.openqa.selenium.By;
import pages.RepositoryPage;

import static com.codeborne.selenide.Selenide.$;


public class NewTestCaseModal extends BaseModal{

    private final static By SAVE_BUTTON = By.id("save-case");

    public NewTestCaseModal fillformTestCase(TestCase testCase) {
        new Input("Title").setValue(testCase.getTitle());
        new DropDown("Status").selectValue(testCase.getStatus().getName());
        new DataPlaceholder("Description").setValue(testCase.getDescription());
        new DropDown("Severity").selectValue(testCase.getSeverity().getName());
        new DropDown("Priority").selectValue(testCase.getPriority().getName());
        new DropDown("Type").selectValue(testCase.getType().getName());
        new DropDown("Layer").selectValue(testCase.getLayer().getName());
        new DropDown("Is flaky").selectValue(testCase.getIsFlaky().getName());
        new DropDown("Behavior").selectValue(testCase.getBehavior().getName());
        new DropDown("Automation status").selectValue(testCase.getAutomationStatus().getName());
        new DataPlaceholder("Pre-conditions").setValue(testCase.getPreConditions());
        new DataPlaceholder("Post-conditions").setValue(testCase.getPostConditions());
        return this;
    }

    public RepositoryPage clickSaveButton() {
        $(SAVE_BUTTON).click();
        return new RepositoryPage();
    }




}
