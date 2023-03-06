package pages;

import lombok.extern.log4j.Log4j2;
import modals.NewSharedStepsModal;
import org.openqa.selenium.By;

import static com.codeborne.selenide.Selenide.$;
@Log4j2
public class SharedStepsPage extends BasePage{

    private final static By CREATE_SHARED_STEP_BUTTON = By.xpath("//span[text()='Create shared step']");
    private final static By CREATED_SHARED_STEP_LINK = By.xpath("//*[@id='application-content']//descendant::table//td/child::a");

    public NewSharedStepsModal clickCreateSharedStepButton() {
        log.info("Clicking Create Shared Step Button");
        $(CREATE_SHARED_STEP_BUTTON).click();
        return new NewSharedStepsModal();
    }

    public String getSharedStepName(String sharedStepName) {
        log.info("Getting Shared Step Name={}",sharedStepName);
        $(CREATED_SHARED_STEP_LINK).getText();
        return sharedStepName;
    }

    public EditSharedStepPage clickSharedStepLink() {
        log.info("Clicking Shared Step Link");
        $(CREATED_SHARED_STEP_LINK).click();
        return new EditSharedStepPage();
    }

}
