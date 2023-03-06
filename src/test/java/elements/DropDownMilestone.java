package elements;

import com.codeborne.selenide.Selenide;
import com.codeborne.selenide.SelenideElement;
import lombok.extern.log4j.Log4j2;
import org.openqa.selenium.By;

import static com.codeborne.selenide.Selenide.$;
@Log4j2
public class DropDownMilestone extends BaseElement{
    public DropDownMilestone(String label) {
        super(label);
    }

    private final static String DROPDOWN_LOCATOR = "//label[text()='%s']/parent::div/parent::div";
    private String BUTTON_LOCATOR = ".//button";
    private String OPTION_LOCATOR = ".//button/following::div[@class and text()='%s']";


    public void selectValue(String value) {

        SelenideElement dropdown = $(By.xpath(String.format(DROPDOWN_LOCATOR, label)));
        scrollIntoView(dropdown);
        log.info("Clicking dropdown with label = {}",this.label);
        (dropdown).$(By.xpath(BUTTON_LOCATOR)).click();
        log.info("Select dropdown option = {}", value);
        (dropdown).$(By.xpath(String.format(OPTION_LOCATOR, value))).click();
    }
}
