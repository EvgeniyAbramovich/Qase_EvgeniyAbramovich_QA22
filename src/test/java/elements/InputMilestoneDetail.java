package elements;

import com.codeborne.selenide.SelenideElement;
import lombok.extern.log4j.Log4j2;
import org.openqa.selenium.By;

import static com.codeborne.selenide.Selenide.$;

@Log4j2
public class InputMilestoneDetail extends BaseElement {

    public InputMilestoneDetail(String label) {
        super(label);
    }

    private final static String MILESTONE_INPUT_LOCATOR = "//label[text()='Due date']/parent::div/child::input";

    public String getMilestoneInputDetailValue() {
        SelenideElement inputDetail = $(By.xpath(String.format(MILESTONE_INPUT_LOCATOR, this.label)));
        scrollIntoView(inputDetail);
        log.info("Get value from input = {}", label);
        return inputDetail.getValue();
    }
}