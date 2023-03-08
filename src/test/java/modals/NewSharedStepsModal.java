package modals;

import elements.DataPlaceholder;
import elements.Input;
import lombok.extern.log4j.Log4j2;
import models.SharedSteps;
import org.openqa.selenium.By;
import pages.SharedStepsPage;

import static com.codeborne.selenide.Condition.visible;
import static com.codeborne.selenide.Selenide.$;

@Log4j2
public class NewSharedStepsModal extends BaseModal{

    private final static By ADD_STEP_BUTTON = By.id("addStep");
    private final static By CREATE_BUTTON = By.xpath("//button[text()='Create']");
    private final static By SHARED_STEP_TITLE_INPUT = By.id("title");
    private final static By ERROR_MESSAGE = By.xpath("//*[@id='layout']//descendant::div/child::span/child::span[text()]");




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

    public NewSharedStepsModal setSharedStepName(String sharedStepName) {
        log.info("Setting Description = {}", sharedStepName);
        $(SHARED_STEP_TITLE_INPUT).setValue(sharedStepName);
        return this;
    }

    public boolean ErrorMessageIsPresent() {
        log.info("Error Message is present");
        $(ERROR_MESSAGE).shouldBe(visible);
        return true;
    }


}
