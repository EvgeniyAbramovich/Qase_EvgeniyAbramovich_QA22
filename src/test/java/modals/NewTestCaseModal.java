package modals;

import elements.DataPlaceholder;
import elements.DropDown;
import elements.Input;
import models.TestCase;
import org.openqa.selenium.WebDriver;


public class NewTestCaseModal extends BaseModal{

    public NewTestCaseModal() {
        super(driver);
    }

    public void fillformTestCase(TestCase testCase) {
        new Input(driver,"Title").setValue(testCase.getTitle());
        new DropDown(driver,"Status").selectValue(testCase.getStatus().getName());
        new DataPlaceholder(driver,"Description").setValue(testCase.getDescription());
        new DropDown(driver,"Severity").selectValue(testCase.getSeverity().getName());
        new DropDown(driver,"Priority").selectValue(testCase.getSeverity().getName());
        new DropDown(driver,"Type").selectValue(testCase.getType().getName());
        new DropDown(driver,"Layer").selectValue(testCase.getLayer().getName());
        new DropDown(driver,"Is flaky").selectValue(testCase.getIsFlaky().getName());
        new DropDown(driver,"Behavior").selectValue(testCase.getBehavior().getName());
        new DropDown(driver,"Automation status").selectValue(testCase.getAutomationStatus().getName());
        new DataPlaceholder(driver,"Pre-conditions").setValue(testCase.getPreConditions());
        new DataPlaceholder(driver,"Post-conditions").setValue(testCase.getPostConditions());
    }


}
