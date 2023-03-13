package Elements;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;

public class DataPlaceholder extends BaseElement{

    public DataPlaceholder(WebDriver driver, String label) {
        super(driver, label);
    }

    private final static String DATA_PLACEHOLDER_LOCATOR = "//label[text()='%s']//following-sibling::div//p";

    public void setValue(String value) {
        WebElement input = driver.findElement(By.xpath(String.format(DATA_PLACEHOLDER_LOCATOR, this.label)));
        scrollIntoView(input);
        input.sendKeys(value);
    }
}
