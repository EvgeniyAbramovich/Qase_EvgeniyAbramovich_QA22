package Modals;

import Pages.BasePage;
import org.openqa.selenium.WebDriver;

public abstract class BaseModal extends BasePage {


    public BaseModal(WebDriver driver) {
        super(driver);
    }

    @Override
    public boolean isPageOpened() {
        return false;
    }


}
