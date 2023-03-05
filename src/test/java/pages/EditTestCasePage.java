package pages;

import elements.EditDetail;
import enums.*;
import models.TestCase;

public class EditTestCasePage extends BasePage{

    public TestCase getTestCaseDetails() {
        TestCase.TestCaseBuilder testCase = TestCase.builder();

        testCase.title(new EditDetail("Title").getInputDetailValue());
        testCase.description(new EditDetail("Description").getDataPlaceholderDetailValue());
        testCase.preConditions(new EditDetail("Pre-conditions").getDataPlaceholderDetailValue());
        testCase.postConditions(new EditDetail("Post-conditions").getDataPlaceholderDetailValue());
        testCase.severity(Severity.fromString(new EditDetail("Severity").getDropdownDetailValue()));
        testCase.status(Status.fromString(new EditDetail("Status").getDropdownDetailValue()));
        testCase.priority(Priority.fromString(new EditDetail("Priority").getDropdownDetailValue()));
        testCase.behavior(Behavior.fromString(new EditDetail("Behavior").getDropdownDetailValue()));
        testCase.isFlaky(IsFlaky.fromString(new EditDetail("Is flaky").getDropdownDetailValue()));
        testCase.layer(Layer.fromString(new EditDetail("Layer").getDropdownDetailValue()));
        testCase.automationStatus(AutomationStatus.fromString(new EditDetail("Automation status").getDropdownDetailValue()));
        testCase.type(Type.fromString(new EditDetail( "Type").getDropdownDetailValue()));

        return testCase.build();

    }
}
