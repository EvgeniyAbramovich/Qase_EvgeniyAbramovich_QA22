package modals;

import elements.Input;
import models.TestRuns;


public class NewTestRunsModal extends BaseModal{

    public NewTestRunsModal() {
        super(driver);
    }
    @Override
    public boolean isPageOpened() {
        return false;
    }

    public void fillformTestRuns(TestRuns testRuns) {
        new Input("Description").setValue(testRuns.getDescrition());
    }
}
