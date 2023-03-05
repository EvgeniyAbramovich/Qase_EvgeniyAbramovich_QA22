package elements;

import com.codeborne.selenide.SelenideElement;
import org.openqa.selenium.By;

import static com.codeborne.selenide.Selenide.$;

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
        (dropdown).$(By.xpath(BUTTON_LOCATOR)).click();
        (dropdown).$(By.xpath(String.format(OPTION_LOCATOR, value))).click();
    }
}
