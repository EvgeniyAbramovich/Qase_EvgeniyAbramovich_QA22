package modals;

import elements.TestCaseDetail;
import enums.*;
import models.TestCase;
import org.openqa.selenium.By;

import static com.codeborne.selenide.Selenide.$;

public class TestCaseDetailsModal extends BaseModal{

    private final static By TEST_CASE_NAME = By.xpath("//*[@id='suitecases-container']/child::div/descendant::h1/child::div");


public TestCase getTestCaseDetails() {
    TestCase.TestCaseBuilder testCase = TestCase.builder();

    testCase.description(new TestCaseDetail("Description").getGeneralDetailValue());
    testCase.preConditions(new TestCaseDetail("Pre-conditions").getGeneralDetailValue());
    testCase.postConditions(new TestCaseDetail("Post-conditions").getGeneralDetailValue());
    testCase.severity(Severity.fromString(new TestCaseDetail("Severity").getDropdownDetailValue()));
    testCase.status(Status.fromString(new TestCaseDetail("Status").getDropdownDetailValue()));
    testCase.priority(Priority.fromString(new TestCaseDetail("Priority").getDropdownDetailValue()));
    testCase.behavior(Behavior.fromString(new TestCaseDetail("Behavior").getDropdownDetailValue()));
    testCase.isFlaky(IsFlaky.fromString(new TestCaseDetail("Is flaky").getDropdownDetailValue()));
    testCase.layer(Layer.fromString(new TestCaseDetail("Layer").getDropdownDetailValue()));
    testCase.automationStatus(AutomationStatus.fromString(new TestCaseDetail("Automation status").getDropdownDetailValue()));
    testCase.type(Type.fromString(new TestCaseDetail( "Type").getDropdownDetailValue()));

    return testCase.build();

}
    public String getTestCaseName(String testCaseName) {
        $(TEST_CASE_NAME).getText();
        return testCaseName;
    }

}
