package modals;



import org.openqa.selenium.By;
import pages.RepositoryPage;

import static com.codeborne.selenide.Selenide.$;

public class TestCaseDetailsModal extends BaseModal{

    private final static By TEST_CASE_NAME = By.xpath("//*[@id='suitecases-container']/child::div/descendant::h1/child::div");
    private final static By EDIT_BUTTON = By.xpath("//*[@id='suitecases-container']//descendant::a/span[text()]");



    public String getTestCaseName(String testCaseName) {
        $(TEST_CASE_NAME).getText();
        return testCaseName;
    }

    public RepositoryPage clickEditButton() {
        $(EDIT_BUTTON).click();
        return new RepositoryPage();
    }

}
