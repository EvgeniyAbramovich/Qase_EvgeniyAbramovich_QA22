package Tests;

import Modals.NewDefectModal;
import Modals.NewTestCaseModal;
import Pages.LoginPage;
import Pages.NewProjectPage;
import Pages.ProjectsPage;
import com.codeborne.selenide.Configuration;
import org.openqa.selenium.WebDriver;
import org.testng.annotations.AfterClass;
import org.testng.annotations.BeforeClass;

public abstract class BaseTest {

protected WebDriver driver;
protected LoginPage loginPage;
protected ProjectsPage projectsPage;
protected NewProjectPage newProjectPage;
protected NewTestCaseModal newTestCaseModal;
protected NewDefectModal newDefectModal;



    @BeforeClass
    public void initialize() {
        Configuration.baseUrl = "https://app.qase.io";
        Configuration.startMaximized = true;
        Configuration.reportsFolder = "target/reports";
        Configuration.timeout = 10000;
        Configuration.webdriverLogsEnabled = true;

        loginPage = new LoginPage(driver);
        projectsPage = new ProjectsPage(driver);
        newProjectPage = new NewProjectPage(driver);
        newTestCaseModal = new NewTestCaseModal(driver);
        newDefectModal = new NewDefectModal(driver);


    }

    @AfterClass
    public void tearDown() {

    }
}
