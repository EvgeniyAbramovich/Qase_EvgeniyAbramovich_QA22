package modals;

import elements.Input;
import models.TestRuns;


public class NewTestRunsModal extends BaseModal{


    public NewTestRunsModal fillformTestRuns(TestRuns testRuns) {
        new Input("Description").setValue(testRuns.getDescrition());
        return this;
    }
}
