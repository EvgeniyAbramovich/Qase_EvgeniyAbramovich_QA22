package pages;

import org.openqa.selenium.By;

import static com.codeborne.selenide.Selenide.$;

public class RepositoryPage extends BasePage{

    public RepositoryPage() {
        super(driver);
    }

    @Override
    public boolean isPageOpened() {
        return false;
    }

    private final static By SUITE_NAME_LABEL = By.cssSelector(".DvbSwG");

    public String getSuiteName(String suiteName) {
        $(SUITE_NAME_LABEL).getText();
        return suiteName;
    }



}
