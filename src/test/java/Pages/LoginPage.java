package Pages;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.support.PageFactory;

import static com.codeborne.selenide.Selenide.$;

public class LoginPage extends BasePage{

    private final static By USERNAME_INPUT = By.cssSelector("#inputEmail");
    private final static By PASSWORD_INPUT = By.cssSelector("#inputPassword");
    private final static By LOGIN_BUTTON = By.cssSelector("#btnLogin");

    public static final String USERNAME = "tinkerbox@yandex.by";
    public static final String PASSWORD = "Tinker89Ggg123";

    @Override
    public boolean isPageOpened() {
        return false;
    }

    public LoginPage setUsername() {
        $(USERNAME_INPUT).setValue(USERNAME);
        return this;
    }

    public LoginPage setPassword() {
        $(PASSWORD_INPUT).setValue(PASSWORD);
        return this;
    }

    public ProjectsPage clickLoginButton() {
        $(LOGIN_BUTTON).click();
        return new ProjectsPage(driver);
    }

    public LoginPage(WebDriver driver) {
        super(driver);
    }
}
