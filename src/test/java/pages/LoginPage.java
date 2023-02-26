package pages;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;

import static com.codeborne.selenide.Condition.visible;
import static com.codeborne.selenide.Selenide.$;
import static com.codeborne.selenide.Selenide.getWebDriverLogs;

public class LoginPage extends BasePage{

    private final static By USERNAME_INPUT = By.cssSelector("#inputEmail");
    private final static By PASSWORD_INPUT = By.cssSelector("#inputPassword");
    private final static By LOGIN_BUTTON = By.cssSelector("#btnLogin");
    private final static By LOGIN_ERROR = By.cssSelector(".form-control-feedback");

    public LoginPage() {
        super(driver);
    }

    @Override
    public boolean isPageOpened() {
        return false;
    }

    public LoginPage setUsername(String username) {
        $(USERNAME_INPUT).setValue(username);
        return this;
    }

    public LoginPage setPassword(String password) {
        $(PASSWORD_INPUT).setValue(password);
        return this;
    }

    public ProjectsPage clickLoginButton() {
        $(LOGIN_BUTTON).click();
        return new ProjectsPage();
        }

    public boolean LoginButtonIsPresent () {
        $(LOGIN_BUTTON).shouldBe(visible);
        return true;
    }

    public boolean LoginErrorIsPresent () {
        $(LOGIN_ERROR).shouldBe(visible);
        return true;
    }


}
