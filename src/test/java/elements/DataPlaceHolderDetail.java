package elements;

import com.codeborne.selenide.SelenideElement;
import lombok.extern.log4j.Log4j2;
import org.openqa.selenium.By;

import static com.codeborne.selenide.Selenide.$;
@Log4j2
public class DataPlaceHolderDetail extends BaseElement{

    public DataPlaceHolderDetail(String label) {
        super(label);
    }

    private final static String DATA_PLACEHOLDER_DETAILS_LOCATOR = "//label[text()='%s']//parent::div//following-sibling::div//p[@class]";

    public String getDataPlaceholderDetailValue(){
        SelenideElement dataPlaceholderDetail = $(By.xpath(String.format(DATA_PLACEHOLDER_DETAILS_LOCATOR, this.label)));
        scrollIntoView(dataPlaceholderDetail);
        log.info("Get value from DataPlaceholder={}",label);
        return dataPlaceholderDetail.getText();
    }
}
