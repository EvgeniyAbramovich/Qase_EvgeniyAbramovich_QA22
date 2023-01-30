package Modals;

import Pages.BasePage;
import Pages.ProjectsPage;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;

import static com.codeborne.selenide.Selectors.byXpath;
import static com.codeborne.selenide.Selenide.$;

public class BaseModal extends BasePage {


    public BaseModal(WebDriver driver) {
        super(driver);
    }

    @Override
    public boolean isPageOpened() {
        return false;
    }

    public static void clickSaveButton() {
        $(By.id("save-case")).click();
    }

    public static void clickCancelButton() {
        $(byXpath("//*[contains(text(), 'Cancel')]")).click();
    }


}
