package Tests;

import org.testng.annotations.Test;

import static com.codeborne.selenide.Selenide.$;
import static com.codeborne.selenide.Selenide.open;

public class LoginTests extends BaseTest{

    @Test
    public void positiveLoginTest() {

        open("/login");
        loginPage.setUsername().setPassword().clickLoginButton().createNewProjectButtonIsPresent().isPageOpened();

    }

}
