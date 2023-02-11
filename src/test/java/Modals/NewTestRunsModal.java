package Modals;

import Elements.Input;
import Models.TestRuns;
import org.openqa.selenium.WebDriver;

public class NewTestRunsModal extends BaseModal{

    public NewTestRunsModal(WebDriver driver) {
        super(driver);
    }

    public void fillformTestRuns(TestRuns testRuns) {
        new Input(driver,"Description").setValue(testRuns.getDescrition());
    }
}
