package modals;

import elements.Input;
import models.TestRuns;
import org.openqa.selenium.WebDriver;

public class NewTestRunsModal extends BaseModal{

    public NewTestRunsModal() {
        super(driver);
    }

    public void fillformTestRuns(TestRuns testRuns) {
        new Input(driver,"Description").setValue(testRuns.getDescrition());
    }
}
