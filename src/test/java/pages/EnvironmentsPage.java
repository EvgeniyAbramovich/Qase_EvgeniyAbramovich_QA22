package pages;

import modals.NewEnvironmentsModal;
import org.openqa.selenium.By;

import static com.codeborne.selenide.Selenide.$;

public class EnvironmentsPage extends BasePage {

    @Override
    public boolean isPageOpened() {
        return false;
    }

    public EnvironmentsPage() {
        super(driver);
    }

    private final static By CREATE_NEW_ENVIRONMENT_BUTTON = By.xpath("//a[text()='Create new environment']");
    private final static By ENVIRONMENT_TITLE = By.cssSelector(".defect-title");


    public NewEnvironmentsModal clickNewEnvironmentButton() {
        $(CREATE_NEW_ENVIRONMENT_BUTTON).click();
        return new NewEnvironmentsModal();
    }

    public String getEnvironmentName(String environmentName) {
        $(ENVIRONMENT_TITLE).getText();
        return environmentName;
    }
}
