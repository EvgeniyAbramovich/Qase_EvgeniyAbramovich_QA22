package elements;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;

import static com.codeborne.selenide.Selenide.$;

public class DataPlaceholder extends BaseElement{

    public DataPlaceholder(WebDriver driver, String label) {
        super(driver, label);
    }

    private final static String DATA_PLACEHOLDER_LOCATOR = "//label[text()='%s']//following-sibling::div//p";

    public void setValue(String value) {
        WebElement dataPlaceholder = $(By.xpath(String.format(DATA_PLACEHOLDER_LOCATOR, this.label)));
        scrollIntoView(dataPlaceholder);
        dataPlaceholder.sendKeys(value);
    }
}
