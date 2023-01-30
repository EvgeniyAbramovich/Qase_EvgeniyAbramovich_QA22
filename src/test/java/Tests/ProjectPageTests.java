package Tests;

import Modals.NewDefectModal;
import com.codeborne.selenide.CollectionCondition;
import org.openqa.selenium.By;
import org.testng.annotations.Test;


import static com.codeborne.selenide.CollectionCondition.size;
import static com.codeborne.selenide.Condition.*;
import static com.codeborne.selenide.Selectors.byXpath;
import static com.codeborne.selenide.Selenide.*;

public class ProjectPageTests extends BaseTest{

    private static final String PROJECT_NAME = "Project1";
    private static final String PROJECT_CODE = "QA22";
    private static final String DESCRIPTION = "Good Project";
    private static final String TEST_CASE_TITLE = "New Test Case";
    private static final String DEFECT_TITLE = "New Defect";
    private static final String DEFECT_RESULT = "Fail";
    String projectName = "Demo Project";

    @Test
    public void newProjectTest() {

        open("/login");
       loginPage.setUsername().setPassword().clickLoginButton().clickCreateNewProjectButton().
               setProjectName(PROJECT_NAME).setProjectCode(PROJECT_CODE).
                setDescription(DESCRIPTION).clickCreateProjectButton().isPageOpened();
        $((".sqabXr")).shouldHave(exactText(PROJECT_NAME));


    }

    @Test
    public void newTestCaseTest() {

        open("/login");
        loginPage.setUsername().setPassword().clickLoginButton().isPageOpened();
        $$(".defect-title").shouldHave(size(3)).get(2).click();
        newProjectPage.clickCreateCaseButton();
        newTestCaseModal.setTitle(TEST_CASE_TITLE);
        $(By.id("save-case")).click();
        $(byXpath("//*[contains(@class, 'nzJYNg')]")).shouldHave(exactText(TEST_CASE_TITLE));
    }

    @Test
    public void newDefectTest() {

        open("/login");
        loginPage.setUsername().setPassword().clickLoginButton().isPageOpened();
        $$(".defect-title").shouldHave(size(3)).get(2).click();
        newProjectPage.clickDefectLabel();
        $(byXpath("//*[contains(@class, 'btn-primary')]")).click();
        newDefectModal.setTitle(DEFECT_TITLE);
        $("[type = 'submit']").click();
        $(".toastui-editor-ww-container").click();
        $(".toastui-editor-ww-container").shouldBe(focused).setValue(DEFECT_RESULT);
        $(By.id("defect-2-title")).shouldHave(exactText(TEST_CASE_TITLE));




    }






}
