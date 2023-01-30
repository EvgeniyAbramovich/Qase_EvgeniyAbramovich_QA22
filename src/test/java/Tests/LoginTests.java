package Tests;

import Pages.LoginPage;
import com.codeborne.selenide.Configuration;
import org.openqa.selenium.By;
import org.testng.annotations.AfterClass;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.Test;

import static com.codeborne.selenide.Condition.visible;
import static com.codeborne.selenide.Selenide.$;
import static com.codeborne.selenide.Selenide.open;

public class LoginTests extends BaseTest{




    @Test
    public void loginTest() {

        open("/login");
        loginPage.setUsername().setPassword().clickLoginButton().isPageOpened();
        $(By.id("createButton")).shouldBe(visible);
    }

}
