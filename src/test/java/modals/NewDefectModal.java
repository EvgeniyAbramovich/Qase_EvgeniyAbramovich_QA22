package modals;

import elements.DataPlaceholder;
import elements.DropDown;
import elements.Input;
import models.Defects;


public class NewDefectModal extends BaseModal{

    public NewDefectModal fillformDefects(Defects defects) {
        new Input("Defect title").setValue(defects.getDefectTitle());
        new DataPlaceholder("Actual result").setValue(defects.getActualResult());
        new DropDown("Severity").selectValue(defects.getSeverity().getName());
        return this;
    }
}
