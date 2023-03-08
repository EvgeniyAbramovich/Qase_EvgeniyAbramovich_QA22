package tests;

import adapters.DefectAdapter;
import com.google.gson.Gson;
import enums.Severity;
import models.DefectResponse;
import models.Defects;
import org.apache.http.HttpStatus;
import org.testng.Assert;
import org.testng.annotations.Test;
import utils.PropertyReader;

public class ApiDefectTests{

    private static final String PROJECT_CODE = PropertyReader.getProperty(
            "qase.api.all_tests.project_code");
    private static final Gson GSON = new Gson();
    DefectAdapter defectAdapter = new DefectAdapter();

    @Test
    public void createDefectTest() {
        Defects defects = Defects.builder()
                .defectTitle(PropertyReader.getProperty("qase_api.defect.createDefect.title"))
                .actualResult(PropertyReader.getProperty("qase_api.defect.createDefect.actual_result"))
                .severity(Severity.fromString(PropertyReader.getProperty("qase_api.defect.createDefect.severity")))
                .build();

        DefectResponse expectedResponse = DefectResponse.builder().result(Defects.builder().build()).build();

        String actualResponse = defectAdapter.createDefect(PROJECT_CODE, GSON.toJson(defects), HttpStatus.SC_OK);


        Assert.assertEquals(expectedResponse, GSON.toJson(actualResponse, DefectResponse.class));



    }
}
