package tests;

import adapters.*;
import com.google.gson.Gson;
import models.*;
import org.testng.Assert;
import org.testng.annotations.Test;
import utils.PropertyReader;

public class ApiTests {
    private final String EXPECTED_JSON = "{\"status\":true,\"result\":{\"total\":6,\"filtered\":6,\"count\":6," +
            "\"entities\":[{\"title\":\"Demo Project\",\"code\":\"DEMO\",\"counts\":{\"cases\":10,\"suites\":3," +
            "\"milestones\":2,\"runs\":{\"total\":0,\"active\":0},\"defects\":{\"total\":0,\"open\":0}}},{\"title\":" +
            "\"Evgeniy Abramovich. QA22. Homework 2\",\"code\":\"EAQH\",\"counts\":{\"cases\":11,\"suites\":2," +
            "\"milestones\":0,\"runs\":{\"total\":0,\"active\":0},\"defects\":{\"total\":6,\"open\":6}}},{\"title\":" +
            "\"QA22_Demo\",\"code\":\"1235\",\"counts\":{\"cases\":3,\"suites\":0,\"milestones\":0,\"runs\":{\"total\":" +
            "0,\"active\":0},\"defects\":{\"total\":1,\"open\":1}}},{\"title\":\"Title\",\"code\":\"DQ\",\"counts\":" +
            "{\"cases\":1,\"suites\":0,\"milestones\":0,\"runs\":{\"total\":0,\"active\":0},\"defects\":{\"total\":0," +
            "\"open\":0}}},{\"title\":\"TestProject\",\"code\":\"123\",\"counts\":{\"cases\":2,\"suites\":1," +
            "\"milestones\":1,\"runs\":{\"total\":0,\"active\":0},\"defects\":{\"total\":0,\"open\":0}}},{\"title\":" +
            "\"Project1\",\"code\":\"QA22\",\"counts\":{\"cases\":0,\"suites\":0,\"milestones\":0,\"runs\":{\"total\":" +
            "0,\"active\":0},\"defects\":{\"total\":0,\"open\":0}}}]}}";

    private final static Gson gson = new Gson();
    ProjectAdapter projectAdapter = new ProjectAdapter();

    @Test
    public void getAllProjectsTest() {
        String responseBody = projectAdapter.getAllProjects(200);
        Assert.assertEquals(responseBody, EXPECTED_JSON);
    }

    @Test
    public void createProjectTest() {
        String testCode = "CODE3";

        Project project = Project.builder()
                .title("NewProject")
                .code(testCode)
                .description("All Right")
                .build();

        ProjectResponse expectedProjectResponseBody = ProjectResponse
                .builder()
                .result(Project
                        .builder()
                        .code(testCode)
                        .build())
                .status(true)
                .build();

        String actualResponseBody = projectAdapter.createProject(200, gson.toJson(project));
        Assert.assertEquals(gson.fromJson(actualResponseBody, ProjectResponse.class),
                expectedProjectResponseBody);
    }

    @Test
    public void deleteProjectByCodeTest(){

       String actualResponse = projectAdapter.deleteProjectByCode(200,
               PropertyReader.getProperty("qase.api.project.createProject_deleteProject.code"));

       ProjectResponse expectedResponse = ProjectResponse.builder().build();

       Assert.assertEquals(actualResponse, expectedResponse);

    }
}

