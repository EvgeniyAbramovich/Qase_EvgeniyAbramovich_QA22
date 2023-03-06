package modals;

import elements.DataPlaceholder;
import elements.Input;
import lombok.extern.log4j.Log4j2;
import models.Defects;
import org.openqa.selenium.By;
import pages.DefectsPage;

import static com.codeborne.selenide.Selenide.$;

@Log4j2
public class NewDefectModal extends BaseModal{

    private final static By CREATE_DEFECT_BUTTON = By.xpath("//button[text()='Create defect']");

    public NewDefectModal fillformDefects(Defects defects) {
        log.info("Setting values = {}", defects);
        new Input("Defect title").setValue(defects.getDefectTitle());
        new DataPlaceholder("Actual result").setValue(defects.getActualResult());
        return this;
    }

    public DefectsPage clickCreateDefectButton() {
        log.info("Clicking Create defect Button");
        $(CREATE_DEFECT_BUTTON).click();
        return new DefectsPage();
    }

}
