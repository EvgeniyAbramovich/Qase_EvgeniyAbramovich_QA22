package pages;

import modals.NewSharedStepsModal;
import org.openqa.selenium.By;

import static com.codeborne.selenide.Selenide.$;

public class SharedStepsPage extends BasePage{

    private final static By CREATE_SHARED_STEP_BUTTON = By.xpath("//span[text()='Create shared step']");
    private final static By CREATED_SHARED_STEP_LINK = By.xpath("//*[@id='application-content']//descendant::table//td/child::a");

    public NewSharedStepsModal clickCreateSharedStepButton() {
        $(CREATE_SHARED_STEP_BUTTON).click();
        return new NewSharedStepsModal();
    }

    public String getSharedStepName(String sharedStepName) {
        $(CREATED_SHARED_STEP_LINK).getText();
        return sharedStepName;
    }

    public EditSharedStepPage clickSharedStepLink() {
        $(CREATED_SHARED_STEP_LINK).click();
        return new EditSharedStepPage();
    }

}
