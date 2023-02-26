package elements;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;

import static com.codeborne.selenide.Selenide.$;

public class Input extends BaseElement{
    public Input(WebDriver driver, String label) {
        super(driver, label);
    }

    private final static String INPUT_LOCATOR = "//label[text()='%s']/following-sibling::div/input";

    public void setValue(String value) {
        WebElement input = $(By.xpath(String.format(INPUT_LOCATOR, this.label)));
        scrollIntoView(input);
        input.sendKeys(value);
    }


}
