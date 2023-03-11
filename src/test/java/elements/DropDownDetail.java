package elements;

import com.codeborne.selenide.SelenideElement;
import lombok.extern.log4j.Log4j2;
import org.openqa.selenium.By;
import static com.codeborne.selenide.Selenide.$;

@Log4j2
public class DropDownDetail extends BaseElement{

    public DropDownDetail(String label) {
        super(label);
    }

    private final static String DROPDOWN_DETAILS_LOCATOR = "//label[text()='%s']/parent::div/child::div";

    public String getDropdownDetailValue(){
        SelenideElement dropdownDetail = $(By.xpath(String.format(DROPDOWN_DETAILS_LOCATOR, this.label)));
        scrollIntoView(dropdownDetail);
        log.info("Get value from dropdown = {}",label);
        return dropdownDetail.getText();
    }
}
