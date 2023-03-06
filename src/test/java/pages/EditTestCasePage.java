package pages;

import elements.DataPlaceHolderDetail;
import elements.DropDownDetail;
import elements.InputDetail;
import enums.*;
import models.TestCase;

public class EditTestCasePage extends BasePage{

    public TestCase getTestCaseDetails() {
        TestCase.TestCaseBuilder testCase = TestCase.builder();

        testCase.title(new InputDetail("Title").getInputDetailValue());
        testCase.description(new DataPlaceHolderDetail("Description").getDataPlaceholderDetailValue());
        testCase.preConditions(new DataPlaceHolderDetail("Pre-conditions").getDataPlaceholderDetailValue());
        testCase.postConditions(new DataPlaceHolderDetail("Post-conditions").getDataPlaceholderDetailValue());
        testCase.severity(Severity.fromString(new DropDownDetail("Severity").getDropdownDetailValue()));
        testCase.status(Status.fromString(new DropDownDetail("Status").getDropdownDetailValue()));
        testCase.priority(Priority.fromString(new DropDownDetail("Priority").getDropdownDetailValue()));
        testCase.behavior(Behavior.fromString(new DropDownDetail("Behavior").getDropdownDetailValue()));
        testCase.isFlaky(IsFlaky.fromString(new DropDownDetail("Is flaky").getDropdownDetailValue()));
        testCase.layer(Layer.fromString(new DropDownDetail("Layer").getDropdownDetailValue()));
        testCase.automationStatus(AutomationStatus.fromString(new DropDownDetail("Automation status").getDropdownDetailValue()));
        testCase.type(Type.fromString(new DropDownDetail( "Type").getDropdownDetailValue()));

        return testCase.build();

    }
}
