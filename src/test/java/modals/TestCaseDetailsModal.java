package modals;


import lombok.extern.log4j.Log4j2;
import org.openqa.selenium.By;
import pages.EditTestCasePage;

import static com.codeborne.selenide.Selenide.$;

@Log4j2
public class TestCaseDetailsModal extends BaseModal {

    private final static By EDIT_BUTTON = By.xpath("//*[@id='suitecases-container']//descendant::a/span[text()]");


    public EditTestCasePage clickEditButton() {
        $(EDIT_BUTTON).click();
        return new EditTestCasePage();
    }

}
