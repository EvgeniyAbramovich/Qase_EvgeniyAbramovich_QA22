package tests;

import io.github.bonigarcia.wdm.WebDriverManager;
import modals.*;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;
import pages.HomePage;
import pages.LoginPage;
import pages.NewProjectPage;
import pages.ProjectsPage;
import com.codeborne.selenide.Configuration;
import org.openqa.selenium.WebDriver;
import org.testng.annotations.AfterClass;
import org.testng.annotations.BeforeClass;

import java.util.concurrent.TimeUnit;

import static com.codeborne.selenide.WebDriverRunner.getWebDriver;
import static com.codeborne.selenide.WebDriverRunner.setWebDriver;

public abstract class BaseTest {


protected LoginPage loginPage;
protected ProjectsPage projectsPage;
protected NewProjectPage newProjectPage;
protected HomePage homePage;
protected NewTestCaseModal newTestCaseModal;
protected NewDefectModal newDefectModal;
protected NewConfigurationsModal newConfigurationsModal;
protected NewEnvironmentsModal newEnvironmentsModal;
protected NewMilestonesModal newMilestonesModal;
protected NewSharedStepsModal newSharedStepsModal;
protected NewTestPlansModal newTestPlansModal;
protected NewTestRunsModal newTestRunsModal;


protected final static String USERNAME = "tinkerbox@yandex.by";
protected final static String PASSWORD = "Tinker89Ggg123";


    @BeforeClass
    public void initialize() {
        ChromeOptions options = new ChromeOptions();
        options.addArguments("--ignore-certificate-errors");
        options.addArguments("--disable-popup-blocking");
        options.addArguments("--disable-notifications");
        WebDriverManager.chromedriver().setup();
        WebDriver driver = new ChromeDriver(options);
        driver.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);
        driver.manage().timeouts().pageLoadTimeout(60, TimeUnit.SECONDS);
        setWebDriver(driver);
        Configuration.baseUrl = "https://app.qase.io";
        Configuration.browser = "chrome";
        Configuration.startMaximized = true;
        Configuration.reportsFolder = "target/reports";
        Configuration.timeout = 10000;
        Configuration.headless = false;
        Configuration.webdriverLogsEnabled = true;
        getWebDriver().manage().window().maximize();

        loginPage = new LoginPage();
        projectsPage = new ProjectsPage();
        newProjectPage = new NewProjectPage();
        homePage = new HomePage();
        newTestCaseModal = new NewTestCaseModal();
        newDefectModal = new NewDefectModal();
        newConfigurationsModal = new NewConfigurationsModal();
        newEnvironmentsModal = new NewEnvironmentsModal();
        newMilestonesModal = new NewMilestonesModal();
        newSharedStepsModal = new NewSharedStepsModal();
        newTestPlansModal = new NewTestPlansModal();
        newTestRunsModal = new NewTestRunsModal();
        }

    @AfterClass
    public void tearDown() {
        WebDriver driver = getWebDriver();
        driver.navigate().refresh();
        driver.quit();
    }
}
