package Modals;

import Elements.DataPlaceholder;
import Elements.DropDown;
import Elements.Input;
import Models.Defects;
import org.openqa.selenium.WebDriver;


public class NewDefectModal extends BaseModal{
    public NewDefectModal(WebDriver driver) {
        super(driver);
    }

    public void fillformDefects(Defects defects) {
        new Input(driver,"Defect title").setValue(defects.getDefectTitle());
        new DataPlaceholder(driver,"Actual result").setValue(defects.getActualResult());
        new DropDown(driver,"Severity").selectValue(defects.getSeverity().getName());
    }
}
