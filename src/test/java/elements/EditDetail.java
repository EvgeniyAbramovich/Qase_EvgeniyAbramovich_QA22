package elements;

import com.codeborne.selenide.SelenideElement;
import org.openqa.selenium.By;

import static com.codeborne.selenide.Selenide.$;

public class EditDetail extends BaseElement{

    public EditDetail(String label) {
        super(label);
    }

    private final static String INPUT_DETAILS_LOCATOR = "//label[text()='%s']//following-sibling::div/child::input";

    private final static String DATA_PLACEHOLDER_DETAILS_LOCATOR = "//label[text()='%s']//parent::div//following-sibling::div//p[@class]";
    private final static String DROPDOWN_DETAILS_LOCATOR = "//label[text()='%s']/parent::div//button//child::div";
    private final static String MILESTONE_DROPDOWN_LOCATOR = "//label[text()='%s']/parent::div/parent::div//button//child::div";
    private final static String MILESTONE_INPUT_LOCATOR = "//label[text()='Due date']/parent::div/child::input";


    public String getInputDetailValue(){
        SelenideElement inputDetail = $(By.xpath(String.format(INPUT_DETAILS_LOCATOR, this.label)));
        scrollIntoView(inputDetail);
        return inputDetail.getValue();
    }

    public String getDataPlaceholderDetailValue(){
        SelenideElement dataPlaceholderDetail = $(By.xpath(String.format(DATA_PLACEHOLDER_DETAILS_LOCATOR, this.label)));
        scrollIntoView(dataPlaceholderDetail);
        return dataPlaceholderDetail.getText();
    }

    public String getDropdownDetailValue(){
        SelenideElement dropdownDetail = $(By.xpath(String.format(DROPDOWN_DETAILS_LOCATOR, this.label)));
        scrollIntoView(dropdownDetail);
        return dropdownDetail.getText();
    }

    public String getMilestoneDropDownValue() {

        SelenideElement dropdownMilestoneDetail = $(By.xpath(String.format(MILESTONE_DROPDOWN_LOCATOR, this.label)));
        scrollIntoView(dropdownMilestoneDetail);
        return dropdownMilestoneDetail.getText();
    }

    public String getMilestoneInputDetailValue(){
        SelenideElement inputDetail = $(By.xpath(String.format(MILESTONE_INPUT_LOCATOR, this.label)));
        scrollIntoView(inputDetail);
        return inputDetail.getValue();
    }


}
