package pages;

import lombok.extern.log4j.Log4j2;
import org.openqa.selenium.By;

import static com.codeborne.selenide.Condition.visible;
import static com.codeborne.selenide.Selenide.$;
import static com.codeborne.selenide.Selenide.open;

@Log4j2
public class LoginPage extends BasePage {

    private final static By USERNAME_INPUT = By.cssSelector("#inputEmail");
    private final static By PASSWORD_INPUT = By.cssSelector("#inputPassword");
    private final static By LOGIN_BUTTON = By.cssSelector("#btnLogin");
    private final static By LOGIN_ERROR = By.cssSelector(".form-control-feedback");


    public LoginPage setUsername(String username) {
        log.info("Setting username = {}", username);
        $(USERNAME_INPUT).setValue(username);
        return this;
    }

    public LoginPage setPassword(String password) {
        log.info("Setting password = {}", password);
        $(PASSWORD_INPUT).setValue(password);
        return this;
    }

    public ProjectsPage clickLoginButton() {
        log.info("Clicking Login Button");
        $(LOGIN_BUTTON).click();
        return new ProjectsPage();
    }

    public boolean LoginButtonIsPresent() {
        log.info("Login Button is present");
        $(LOGIN_BUTTON).shouldBe(visible);
        return true;
    }

    public boolean LoginErrorIsPresent() {
        log.info("Login Error is present");
        $(LOGIN_ERROR).shouldBe(visible);
        return true;
    }

    public LoginPage openLoginPage() {
        log.info("Opened Login page");
        open("/login");
        return this;
    }


}
