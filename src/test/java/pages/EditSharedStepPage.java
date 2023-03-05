package pages;

import elements.EditDetail;
import models.SharedSteps;

public class EditSharedStepPage extends BasePage{

    public SharedSteps getSharedStepDetails() {
        SharedSteps.SharedStepsBuilder sharedSteps = SharedSteps.builder();

        sharedSteps.sharedStepTitle(new EditDetail("Shared step title").getInputDetailValue());
        sharedSteps.action(new EditDetail("Action").getDataPlaceholderDetailValue());
        sharedSteps.inputData(new EditDetail("Input data").getDataPlaceholderDetailValue());
        sharedSteps.expectedResult(new EditDetail("Expected result").getDataPlaceholderDetailValue());

        return sharedSteps.build();

    }
}
