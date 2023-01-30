package Modals;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;

import static com.codeborne.selenide.Selenide.$;

public class NewTestCaseModal extends BaseModal{

    public NewTestCaseModal(WebDriver driver) {
        super(driver);
    }

    public NewTestCaseModal setTitle(String title) {
        $(By.id("title")).setValue(title);
        return this;
    }



}
