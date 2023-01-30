package Modals;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;

import static com.codeborne.selenide.Selenide.$;

public class NewDefectModal extends BaseModal{
    public NewDefectModal(WebDriver driver) {
        super(driver);
    }

    public NewDefectModal setTitle(String title) {
        $(By.id("title")).setValue(title);
        return this;
    }
}
