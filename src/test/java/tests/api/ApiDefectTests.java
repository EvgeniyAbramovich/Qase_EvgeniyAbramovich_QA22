package tests.api;

import adapters.DefectAdapter;
import adapters.ProjectAdapter;
import com.google.gson.Gson;
import models.Counts;
import models.DefectResponse;
import models.Defects;
import models.Project;
import org.apache.http.HttpStatus;
import org.openqa.selenium.remote.Response;
import org.testng.Assert;
import org.testng.annotations.AfterTest;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.Test;


public class ApiDefectTests{

    private static final String TEST_PROJECT_NAME = "Test Project";
    private static final String PROJECT_CODE = "QA22";
    private static final Gson GSON = new Gson();
    ProjectAdapter projectAdapter = new ProjectAdapter();
    DefectAdapter defectAdapter = new DefectAdapter();
    String DEFECT_TITLE = "New Defect";
    String ACTUAL_RESULT = "Project not work";
    int SEVERITY_VALUE = 1;
    int DEFECT_ID = 1;

    @BeforeTest(alwaysRun = true, description = "Create Test Project")
    public void createTestProject(){

            String testCode = PROJECT_CODE;

            Project project = Project.builder()
                    .title(TEST_PROJECT_NAME)
                    .code(testCode)
                    .description("Test Project")
                    .build();

            projectAdapter.createProject(200, GSON.toJson(project));

        }

    @Test(description = "Create Defect Test", groups = {"API"})
    public void createDefectTest() {
        Defects defects = Defects.builder().build().builder()
                .title(DEFECT_TITLE)
                .actualResult(ACTUAL_RESULT)
                .severity(SEVERITY_VALUE)
                .build();

        DefectResponse expectedResponse = DefectResponse.builder().result(Defects.builder().build()).build();

        String actualResponse = defectAdapter.createDefect(PROJECT_CODE, GSON.toJson(defects), HttpStatus.SC_OK);

        Assert.assertEquals(expectedResponse, GSON.fromJson(actualResponse, DefectResponse.class));
    }

    @Test(description = "Get Specific Defect Test", groups = {"API"})
    public void getSpecificDefectTest() {

        Defects defects = Defects.builder().build().builder()
                .title(DEFECT_TITLE)
                .actualResult(ACTUAL_RESULT)
                .severity(SEVERITY_VALUE)
                .build();

        defectAdapter.createDefect(PROJECT_CODE, GSON.toJson(defects), HttpStatus.SC_OK);

       DefectResponse expectedResponse = DefectResponse.builder().result(Defects.builder().build()).build();

       String actualResponse = defectAdapter.getDefectByProjectCodeAndDefectId(PROJECT_CODE, DEFECT_ID, HttpStatus.SC_OK);

       Assert.assertEquals(expectedResponse, actualResponse);

    }

    @AfterTest(alwaysRun = true)
    public void deleteDefectByProjectCodeAndId(){
        defectAdapter.deleteDefectByProjectCodeAndDefectId(PROJECT_CODE, DEFECT_ID, HttpStatus.SC_OK);

    }

    @AfterTest(alwaysRun = true, description = "Delete Created Test Project")
    public void deleteNewTestProjectByCode() {
        projectAdapter.deleteProjectByCode(200, PROJECT_CODE);
    }


}
