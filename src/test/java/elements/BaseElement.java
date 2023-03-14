package elements;


import com.codeborne.selenide.SelenideElement;
import lombok.extern.log4j.Log4j2;

import static com.codeborne.selenide.Selenide.executeJavaScript;

@Log4j2
public abstract class BaseElement {

    protected String label;

    public BaseElement(String label) {
        this.label = label;
    }

    public void scrollIntoView(SelenideElement element) {
        log.debug("Scrolling to element ={}", element);
        executeJavaScript("arguments[0].scrollIntoView(true)", element);
    }
}
