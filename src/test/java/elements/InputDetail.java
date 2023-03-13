package elements;

import com.codeborne.selenide.SelenideElement;
import lombok.extern.log4j.Log4j2;
import org.openqa.selenium.By;

import static com.codeborne.selenide.Selenide.$;
@Log4j2
public class InputDetail extends BaseElement{

    public InputDetail(String label) {
        super(label);
    }

    private final static String INPUT_DETAILS_LOCATOR = "//label[text()='%s']//following-sibling::div/child::input";

    public String getInputDetailValue(){
        SelenideElement inputDetail = $(By.xpath(String.format(INPUT_DETAILS_LOCATOR, this.label)));
        scrollIntoView(inputDetail);
        log.info("Get value from input = {}",label);
        return inputDetail.getValue();
    }










}
