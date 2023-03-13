package elements;

import com.codeborne.selenide.SelenideElement;
import lombok.extern.log4j.Log4j2;
import org.openqa.selenium.By;


import static com.codeborne.selenide.Selenide.$;
@Log4j2
public class DropDown extends BaseElement{

    private final static String DROPDOWN_LOCATOR = "//label[text()='%s']/parent::div";
    private String BUTTON_LOCATOR = ".//span";
    private String OPTION_LOCATOR = ".//following::div[@id='modals']//following::div[text()='%s']";

    public DropDown(String label) {
        super(label);
    }

    public void selectValue(String value) {

        SelenideElement dropdown = $(By.xpath(String.format(DROPDOWN_LOCATOR, label)));
        scrollIntoView(dropdown);
        log.info("Clicking dropdown with label = {}",this.label);
        (dropdown).$(By.xpath(BUTTON_LOCATOR)).click();
        log.info("Select option '{}' dropdown = {}", value,label);
        (dropdown).$(By.xpath(String.format(OPTION_LOCATOR, value))).click();
    }
}
