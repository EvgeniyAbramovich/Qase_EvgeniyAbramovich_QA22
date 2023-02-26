package modals;

import elements.DataPlaceholder;
import elements.DropDown;
import elements.Input;
import models.Defects;


public class NewDefectModal extends BaseModal{
    public NewDefectModal() {
        super(driver);
    }

    public void fillformDefects(Defects defects) {
        new Input(driver,"Defect title").setValue(defects.getDefectTitle());
        new DataPlaceholder(driver,"Actual result").setValue(defects.getActualResult());
        new DropDown(driver,"Severity").selectValue(defects.getSeverity().getName());
    }
}
