package pages;

import elements.DataPlaceHolderDetail;
import elements.InputDetail;
import models.SharedSteps;

public class EditSharedStepPage extends BasePage {

    public SharedSteps getSharedStepDetails() {
        SharedSteps.SharedStepsBuilder sharedSteps = SharedSteps.builder();

        sharedSteps.sharedStepTitle(new InputDetail("Shared step title").getInputDetailValue());
        sharedSteps.action(new DataPlaceHolderDetail("Action").getDataPlaceholderDetailValue());
        sharedSteps.inputData(new DataPlaceHolderDetail("Input data").getDataPlaceholderDetailValue());
        sharedSteps.expectedResult(new DataPlaceHolderDetail("Expected result").getDataPlaceholderDetailValue());

        return sharedSteps.build();

    }
}
