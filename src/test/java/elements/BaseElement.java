package elements;


import org.openqa.selenium.WebElement;

import static com.codeborne.selenide.Selenide.executeJavaScript;

public abstract class BaseElement {

    protected String label;
    public BaseElement(String label) {
        this.label = label;
    }
    public void scrollIntoView(WebElement element) {
        executeJavaScript("arguments[0].scrollIntoView(true)", element);
    }
}
