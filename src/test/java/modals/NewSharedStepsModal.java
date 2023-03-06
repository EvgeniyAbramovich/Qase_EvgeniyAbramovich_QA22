package modals;

import com.codeborne.selenide.SelenideElement;
import elements.DataPlaceholder;
import elements.Input;
import lombok.extern.log4j.Log4j2;
import models.SharedSteps;
import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import pages.SharedStepsPage;

import static com.codeborne.selenide.Selenide.$;

@Log4j2
public class NewSharedStepsModal extends BaseModal{

    private final static By ADD_STEP_BUTTON = By.id("addStep");
    private final static By CREATE_BUTTON = By.xpath("//button[text()='Create']");




    public NewSharedStepsModal fillformSharedSteps(SharedSteps sharedSteps) {
        log.info("Setting values = {}", sharedSteps);
        new Input("Shared step title").setValue(sharedSteps.getSharedStepTitle());
        new DataPlaceholder("Action").setValue(sharedSteps.getAction());
        new DataPlaceholder("Input data").setValue(sharedSteps.getInputData());
        new DataPlaceholder("Expected result").setValue(sharedSteps.getExpectedResult());
        return this;
    }

    public NewSharedStepsModal clickAddStepButton() {
        log.info("Clicking Add Step Button");
        $(ADD_STEP_BUTTON).click();
        return this;
    }

    public SharedStepsPage clickCreateButton() {
        log.info("Clicking Create Button");
        $(CREATE_BUTTON).click();
        return new SharedStepsPage();
    }


}
