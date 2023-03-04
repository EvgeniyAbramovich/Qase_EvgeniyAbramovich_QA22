package pages;

import modals.TestCaseDetailsModal;
import org.openqa.selenium.By;

import static com.codeborne.selenide.Selenide.$;

public class RepositoryPage extends BasePage{

    private final static By SUITE_NAME_LABEL = By.xpath("//*[@id='suitecases-container']//child::h3/child::span");
    private final static By TEST_CASE_LINK = By.xpath("//*[@id='suitecases-container']//child::div/child::a");


    public String getSuiteName(String suiteName) {
        $(SUITE_NAME_LABEL).getText();
        return suiteName;
    }

    public TestCaseDetailsModal clickTestCaseLink() {
        $(TEST_CASE_LINK).click();
        return new TestCaseDetailsModal();
    }



}
