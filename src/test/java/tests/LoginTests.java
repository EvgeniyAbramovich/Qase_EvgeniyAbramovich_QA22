package tests;

import org.testng.Assert;
import org.testng.annotations.Test;

import static com.codeborne.selenide.Selenide.$;
import static com.codeborne.selenide.Selenide.open;

public class LoginTests extends BaseTest{

    @Test
    public void positiveLoginTest() {

        open("/login");
        loginPage.setUsername(USERNAME).setPassword(PASSWORD).clickLoginButton().isPageOpened();
        Assert.assertTrue(projectsPage.createNewProjectButtonIsPresent());

    }

    @Test
    public void logoutTest() {
        open("/login");
        loginPage.setUsername(USERNAME).setPassword(PASSWORD).clickLoginButton().isPageOpened();
        homePage.clickAccountButton().clickSignOutButton().isPageOpened();
        Assert.assertTrue(loginPage.LoginButtonIsPresent());

    }

    @Test
    public void negativeLoginTest() {

        open("/login");
        loginPage.setUsername(USERNAME).setPassword("fhfhfh").clickLoginButton();
        Assert.assertTrue(loginPage.LoginErrorIsPresent());

    }



}
