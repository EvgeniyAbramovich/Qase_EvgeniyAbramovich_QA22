package elements;

import com.codeborne.selenide.SelenideElement;
import lombok.extern.log4j.Log4j2;
import org.openqa.selenium.By;
import org.openqa.selenium.Keys;

import static com.codeborne.selenide.Selenide.$;
@Log4j2
public class Input extends BaseElement{
    public Input(String label) {
        super(label);
    }

    private final static String INPUT_LOCATOR = "//label[text()='%s']//parent::div//following-sibling::div//input[@class]";

    public void setValue(String value) {
        SelenideElement input = $(By.xpath(String.format(INPUT_LOCATOR, this.label)));
        scrollIntoView(input);
        log.info("Set value = {}", value);
        input.sendKeys(value);

    }

    public void sendEnterKey() {
        SelenideElement input = $(By.xpath(String.format(INPUT_LOCATOR, this.label)));
        scrollIntoView(input);
        log.info("Send ENTER key");
        input.sendKeys(Keys.ENTER);

    }


}
