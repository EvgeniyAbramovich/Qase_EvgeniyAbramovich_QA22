package pages;

import lombok.extern.log4j.Log4j2;
import modals.NewMilestonesModal;
import org.openqa.selenium.By;

import static com.codeborne.selenide.Selenide.$;
@Log4j2
public class MilestonesPage extends BasePage{

    private final static By CREATE_MILESTONE_BUTTON = By.id("createButton");

    private final static By MILESTONE_TITLE = By.cssSelector(".defect-title");


    public NewMilestonesModal clickCreateMilestoneButton() {
        log.info("Clicking Create Milestone Button");
        $(CREATE_MILESTONE_BUTTON).click();
        return new NewMilestonesModal();
    }

    public EditMilestonePage clickMilestoneTitle() {
        log.info("Clicking Milestone Title");
        $(MILESTONE_TITLE).click();
        return new EditMilestonePage();
    }
}
