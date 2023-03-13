package tests;


import io.qameta.allure.Description;
import io.qameta.allure.Severity;
import io.qameta.allure.SeverityLevel;
import models.Environment;
import org.testng.Assert;
import org.testng.annotations.DataProvider;
import org.testng.annotations.Test;

import static com.codeborne.selenide.Selenide.open;

public class EnvironmentsTests extends BaseTest{


    @DataProvider
    public Object[][] environmentData(){
        return new Object[][]{
                {"New Environment", "Envir", "All Right", "qase.io"},
                {"Good Environment", "QA22", "", "yandex.ru"},
                {"Create Environment", "DQ", "Hey World", ""},
                {"Environment with required labels", "RL", "", ""},

        };
    }
    @Severity(SeverityLevel.NORMAL)
    @Description("Create New Environment in created Test Project with different values")
    @Test(dataProvider = "environmentData", description = "Positive Create Environment Test", groups = {"Smoke"}, retryAnalyzer = Retry.class)
    public void newEnvironmentTest(String testEnvironmentName, String testSlug, String description, String testHost) {
        String projectName = TEST_PROJECT_NAME;


        loginPage.openLoginPage().setUsername(USERNAME).setPassword(PASSWORD).clickLoginButton().clickProjectLink(projectName);
        newProjectPage.clickEnvironmentsLabel();
        environmentsPage.clickCreateNewEnvironmentButton();

        Environment testEnvironment = Environment.builder().title(testEnvironmentName).slug(testSlug)
                .description(description).host(testHost).build();
        newEnvironmentsModal.fillformEnvironments(testEnvironment).clickCreateEnvironmentButton().clickEnvironmentTitle();

        Assert.assertEquals(editEnvironmentPage.getEnvironmentDetails(),testEnvironment);

        homePage.clickAccountButton().clickSignOutButton();

    }


}
