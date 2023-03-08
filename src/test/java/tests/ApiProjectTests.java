package tests;

import adapters.*;
import com.google.gson.Gson;
import org.testng.Assert;
import org.testng.annotations.Test;
import utils.PropertyReader;

public class ApiProjectTests{
    ProjectAdapter projectAdapter = new ProjectAdapter();
    private final String EXPECTED_JSON = "{\"status\":true,\"result\":{\"title\":\"QA22_Demo\",\"code\":\"1235\"," +
            "\"counts\":{\"cases\":3,\"suites\":0,\"milestones\":0,\"runs\":{\"total\":0,\"active\":0},\"defects\":" +
            "{\"total\":1,\"open\":1}}}}";


    @Test(description = "Get Project By Code Test", groups = {"API"})
    public void getProjectByCodeTest() {
        String responseBody = projectAdapter.getProjectByCode(200,PropertyReader.getProperty("qase.api.project.createProject_getProject.code"));
        Assert.assertEquals(responseBody, EXPECTED_JSON);

    }




}

