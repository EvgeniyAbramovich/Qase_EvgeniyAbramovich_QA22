package Pages;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;

import static com.codeborne.selenide.Selectors.byXpath;
import static com.codeborne.selenide.Selenide.$;

public class NewProjectPage extends BasePage{


    public NewProjectPage(WebDriver driver) {
        super(driver);
    }

    @Override
    public boolean isPageOpened() {
        return false;
    }

    public NewProjectPage clickCreateCaseButton() {
        $(By.id("create-case-button")).click();
        return this;
    }

    public NewProjectPage clickDefectLabel() {
        $(("[aria-label = 'Defects']")).click();
        return this;
    }




}
