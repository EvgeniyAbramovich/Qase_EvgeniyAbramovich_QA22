package elements;

import com.codeborne.selenide.SelenideElement;
import org.openqa.selenium.By;


import static com.codeborne.selenide.Selenide.$;

public class DataPlaceholder extends BaseElement{

    public DataPlaceholder(String label) {
        super(label);
    }

    private final static String DATA_PLACEHOLDER_LOCATOR = "//label[text()='%s']//parent::div//following-sibling::div//p[@class]";

    public void setValue(String value) {
        SelenideElement dataPlaceholder = $(By.xpath(String.format(DATA_PLACEHOLDER_LOCATOR, this.label)));
        scrollIntoView(dataPlaceholder);
        dataPlaceholder.sendKeys(value);
    }
}
