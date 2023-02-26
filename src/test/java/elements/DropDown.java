package elements;

import com.codeborne.selenide.SelenideElement;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;

import static com.codeborne.selenide.Selenide.$;

public class DropDown extends BaseElement{

    private final static String DROPDOWN_LOCATOR = "//label[text()='%s']/following-sibling::div";
    private String BUTTON_LOCATOR = ".//button";
    private String OPTION_LOCATOR = ".//div[contains(@class, 'DJXdnf') and text() = '%s']";

    public DropDown(WebDriver driver, String label) {
        super(driver, label);
    }

    public void selectValue(String value) {
        WebElement dropdown = $(By.xpath(String.format(DROPDOWN_LOCATOR, label)));
        scrollIntoView(dropdown);
        ((SelenideElement) dropdown).$(By.xpath(BUTTON_LOCATOR)).click();
        ((SelenideElement) dropdown).$(By.xpath(String.format(OPTION_LOCATOR, value))).click();
    }
}
