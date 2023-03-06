package elements;

import com.codeborne.selenide.SelenideElement;
import lombok.extern.log4j.Log4j2;
import org.openqa.selenium.By;
import static com.codeborne.selenide.Selenide.$;

@Log4j2
public class DropDownMilestoneDetail extends BaseElement{

    public DropDownMilestoneDetail(String label) {
        super(label);
    }

    private final static String MILESTONE_DROPDOWN_LOCATOR = "//label[text()='%s']/parent::div/parent::div//button//child::div";

    public String getMilestoneDropDownValue() {

        SelenideElement dropdownMilestoneDetail = $(By.xpath(String.format(MILESTONE_DROPDOWN_LOCATOR, this.label)));
        scrollIntoView(dropdownMilestoneDetail);
        log.info("Get value from dropdown");
        return dropdownMilestoneDetail.getText();
    }
}
