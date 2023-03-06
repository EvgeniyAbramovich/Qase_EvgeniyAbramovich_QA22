package pages;

import lombok.extern.log4j.Log4j2;
import modals.NewDefectModal;
import modals.NewEnvironmentsModal;
import org.openqa.selenium.By;

import static com.codeborne.selenide.Selenide.$;
@Log4j2
public class DefectsPage extends BasePage{

    private final static By CREATE_NEW_DEFECT_BUTTON = By.xpath("//a[text()='Create new defect']");

    public NewDefectModal clickCreateNewDefectButton() {
        log.info("Clicking Create New Defect Button");
        $(CREATE_NEW_DEFECT_BUTTON).click();
        return new NewDefectModal();
    }
}
