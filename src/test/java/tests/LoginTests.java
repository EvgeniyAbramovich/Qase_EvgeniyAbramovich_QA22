package tests;

import org.testng.Assert;
import org.testng.annotations.Test;

import static com.codeborne.selenide.Selenide.$;
import static com.codeborne.selenide.Selenide.open;

public class LoginTests extends BaseTest{

    @Test
    public void positiveLoginTest() {

        loginPage.openLoginPage().setUsername(USERNAME).setPassword(PASSWORD).clickLoginButton();
        Assert.assertTrue(projectsPage.createNewProjectButtonIsPresent());

    }

    @Test
    public void logoutTest() {

        loginPage.openLoginPage().setUsername(USERNAME).setPassword(PASSWORD).clickLoginButton();
        homePage.clickAccountButton().clickSignOutButton();
        Assert.assertTrue(loginPage.LoginButtonIsPresent());

    }

    @Test
    public void negativeLoginTest() {

        loginPage.openLoginPage().setUsername(USERNAME).setPassword("fhfhfh").clickLoginButton();
        Assert.assertTrue(loginPage.LoginErrorIsPresent());

    }



}
