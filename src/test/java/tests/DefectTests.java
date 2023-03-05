package tests;

import enums.Severity;
import models.Defects;
import org.testng.annotations.Test;

public class DefectTests extends BaseTest{

    @Test
    public void newDefectTest(){

        String projectName = "TestProject";

        loginPage.openLoginPage().setUsername(USERNAME).setPassword(PASSWORD).clickLoginButton().clickProjectLink(projectName);
        newProjectPage.clickDefectLabel();
        defectsPage.clickCreateNewDefectButton();

        Defects defects = Defects.builder().defectTitle("New Defect").actualResult("Not work").severity(Severity.MAJOR).build();
        newDefectModal.fillformDefects(defects).clickCreateDefectButton();


    }
}
