package pages;

import lombok.extern.log4j.Log4j2;
import modals.TestCaseDetailsModal;
import org.openqa.selenium.By;

import static com.codeborne.selenide.Selenide.$;
@Log4j2
public class RepositoryPage extends BasePage{

    private final static By SUITE_NAME_LABEL = By.xpath("//*[@id='suitecases-container']//child::h3/child::span");
    private final static By TEST_CASE_LINK = By.xpath("//*[@id='suitecases-container']//child::div/child::a");


    public String getSuiteName(String suiteName) {
        log.info("Getting Suite Name", suiteName);
        $(SUITE_NAME_LABEL).getText();
        return suiteName;
    }

    public TestCaseDetailsModal clickTestCaseLink() {
        log.info("Clicking Test Case Link");
        $(TEST_CASE_LINK).click();
        return new TestCaseDetailsModal();
    }



}
