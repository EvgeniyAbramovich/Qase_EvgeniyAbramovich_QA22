package pages;

import modals.NewDefectModal;
import modals.NewEnvironmentsModal;
import org.openqa.selenium.By;

import static com.codeborne.selenide.Selenide.$;

public class DefectsPage extends BasePage{

    private final static By CREATE_NEW_DEFECT_BUTTON = By.xpath("//a[text()='Create new defect']");

    public NewDefectModal clickCreateNewDefectButton() {
        $(CREATE_NEW_DEFECT_BUTTON).click();
        return new NewDefectModal();
    }
}
