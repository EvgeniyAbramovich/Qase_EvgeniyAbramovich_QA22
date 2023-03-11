package tests.api;

import adapters.*;
import com.google.gson.Gson;
import models.Project;
import org.testng.Assert;
import org.testng.annotations.AfterTest;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.Test;

public class ApiProjectTests{
    ProjectAdapter projectAdapter = new ProjectAdapter();
    private static final String TEST_PROJECT_NAME = "Test Project Projects API";
    private static final String PROJECT_CODE = "123";
    private static final Gson GSON = new Gson();
    private final String EXPECTED_JSON = "{\"status\":true,\"result\":{\"title\":\"Test Project Projects API\",\"code\":\"123\"," +
            "\"counts\":{\"cases\":0,\"suites\":0,\"milestones\":0,\"runs\":{\"total\":0,\"active\":0},\"defects\":" +
            "{\"total\":0,\"open\":0}}}}";


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

    @Test(description = "Get Project By Code Test", groups = {"API"})
    public void getProjectByCodeTest() {
        String responseBody = projectAdapter.getProjectByCode(200,PROJECT_CODE);
        Assert.assertEquals(responseBody, EXPECTED_JSON);

    }

    @AfterTest(alwaysRun = true, description = "Delete Created Test Project")
    public void deleteNewTestProjectByCode() {
        projectAdapter.deleteProjectByCode(200, PROJECT_CODE);
    }

}

