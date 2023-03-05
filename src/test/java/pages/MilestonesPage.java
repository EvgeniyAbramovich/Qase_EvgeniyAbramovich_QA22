package pages;

import modals.NewMilestonesModal;
import org.openqa.selenium.By;

import static com.codeborne.selenide.Selenide.$;

public class MilestonesPage extends BasePage{

    private final static By CREATE_MILESTONE_BUTTON = By.id("createButton");

    private final static By MILESTONE_TITLE = By.cssSelector(".defect-title");


    public NewMilestonesModal clickCreateMilestoneButton() {
        $(CREATE_MILESTONE_BUTTON).click();
        return new NewMilestonesModal();
    }

    public EditMilestonePage clickMilestoneTitle() {
        $(MILESTONE_TITLE).click();
        return new EditMilestonePage();
    }
}
