package elements;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;

public class DropDown extends BaseElement{

    private final static String DROPDOWN_LOCATOR = "//label[text()='%s']/following-sibling::div";
    private String BUTTON_LOCATOR = ".//button";
    private String OPTION_LOCATOR = ".//div[contains(@class, 'DJXdnf') and text() = '%s']";

    public DropDown(WebDriver driver, String label) {
        super(driver, label);
    }

    public void selectValue(String value) {
        WebElement dropdown = driver.findElement(By.xpath(String.format(DROPDOWN_LOCATOR, label)));
        scrollIntoView(dropdown);
        dropdown.findElement(By.xpath(BUTTON_LOCATOR)).click();
        dropdown.findElement(By.xpath(String.format(OPTION_LOCATOR, value))).click();
    }
}
