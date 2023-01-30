package Pages;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.support.PageFactory;

import static com.codeborne.selenide.Selenide.$;

public class LoginPage extends BasePage{

    public static final String USERNAME = "tinkerbox@yandex.by";
    public static final String PASSWORD = "Tinker89Ggg123";

    @Override
    public boolean isPageOpened() {
        return false;
    }

    public LoginPage setUsername() {
        $("#inputEmail").setValue(USERNAME);
        return this;
    }

    public LoginPage setPassword() {
        $("#inputPassword").setValue(PASSWORD);
        return this;
    }

    public ProjectsPage clickLoginButton() {
        $("#btnLogin").click();
        return new ProjectsPage(driver);
    }

    public LoginPage(WebDriver driver) {
        super(driver);
        PageFactory.initElements(driver, this);
        }
}
