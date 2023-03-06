package modals;

import elements.Input;
import lombok.extern.log4j.Log4j2;
import models.TestRuns;

@Log4j2
public class NewTestRunsModal extends BaseModal{


    public NewTestRunsModal fillformTestRuns(TestRuns testRuns) {
        log.info("Setting values = {}", testRuns);
        new Input("Description").setValue(testRuns.getDescrition());
        return this;
    }
}
