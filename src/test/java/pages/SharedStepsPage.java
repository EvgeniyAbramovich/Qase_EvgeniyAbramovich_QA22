package pages;

import modals.NewEnvironmentsModal;
import modals.NewSharedStepsModal;
import org.openqa.selenium.By;

import static com.codeborne.selenide.Selenide.$;

public class SharedStepsPage extends BasePage{

    @Override
    public boolean isPageOpened() {
        return false;
    }

    public SharedStepsPage() {
        super(driver);
    }

    private final static By CREATE_SHARED_STEP_BUTTON = By.xpath("//span[@class='UdZcu9' and text()='Create shared step']");

    public NewSharedStepsModal clickCreateSharedStepButton() {
        $(CREATE_SHARED_STEP_BUTTON).click();
        return new NewSharedStepsModal();
    }
}
