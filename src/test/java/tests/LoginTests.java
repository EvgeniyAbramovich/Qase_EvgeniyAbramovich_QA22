package tests;

import io.qameta.allure.Description;
import io.qameta.allure.Severity;
import io.qameta.allure.SeverityLevel;
import org.testng.Assert;
import org.testng.annotations.DataProvider;
import org.testng.annotations.Test;


public class LoginTests extends BaseTest{
    @Severity(SeverityLevel.CRITICAL)
    @Description("LogIn on qase.io for work with you projects")
    @Test(description = "Positive Login Test", groups = {"Smoke"}, retryAnalyzer = Retry.class)
    public void positiveLoginTest() {

        loginPage.openLoginPage().setUsername(USERNAME).setPassword(PASSWORD).clickLoginButton();
        Assert.assertTrue(projectsPage.createNewProjectButtonIsPresent());

    }
    @Severity(SeverityLevel.NORMAL)
    @Description("LogOut from your account")
    @Test(description = "Positive Logout Test", groups = {"Smoke"}, retryAnalyzer = Retry.class)
    public void logoutTest() {

        loginPage.openLoginPage().setUsername(USERNAME).setPassword(PASSWORD).clickLoginButton();
        homePage.clickAccountButton().clickSignOutButton();
        Assert.assertTrue(loginPage.LoginButtonIsPresent());

    }
    @Severity(SeverityLevel.NORMAL)
    @Description("Try to LogIn with incorrect password")
    @Test(dataProvider = "negativeLoginData", description = "Negative Login Test", groups = {"Regression"}, retryAnalyzer = Retry.class)
    public void negativeLoginTest(String userName, String password) {

        loginPage.openLoginPage().setUsername(userName).setPassword(password).clickLoginButton();
        Assert.assertTrue(loginPage.LoginErrorIsPresent());

    }

    @DataProvider
    public Object[][] negativeLoginData(){
        return new Object[][]{
                {"tinkerbox@yandex.by", "fhfhfh"},
                {"fakebox@mail.ru", "Tinker89Ggg123"},

        };
    }



}
