package elements;

import com.codeborne.selenide.SelenideElement;
import org.openqa.selenium.By;

import static com.codeborne.selenide.Selenide.$;

public class TestCaseDetail extends BaseElement{

    public TestCaseDetail(String label) {
        super(label);
    }

    private final static String GENERAL_DETAILS_LOCATOR = "//label[text()='%s']//following-sibling::div";
    private final static String DROPDOWN_DETAILS_LOCATOR = "//label[text()='%s']//following-sibling::div//child::div[@class]";

    public String getGeneralDetailValue(){
        SelenideElement generalDetail = $(By.xpath(String.format(GENERAL_DETAILS_LOCATOR, this.label)));
        scrollIntoView(generalDetail);
        return generalDetail.getText();
    }

    public String getDropdownDetailValue(){
        SelenideElement dropdownDetail = $(By.xpath(String.format(DROPDOWN_DETAILS_LOCATOR, this.label)));
        scrollIntoView(dropdownDetail);
        return dropdownDetail.getText();
    }


}
