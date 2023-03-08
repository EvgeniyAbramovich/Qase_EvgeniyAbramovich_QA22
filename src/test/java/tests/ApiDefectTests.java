package tests;

import adapters.DefectAdapter;
import com.google.gson.Gson;
import models.DefectResponse;
import models.Defects;
import org.apache.http.HttpStatus;
import org.testng.Assert;
import org.testng.annotations.Test;

public class ApiDefectTests{

    private static final String PROJECT_CODE = "123";
    private static final Gson GSON = new Gson();
    DefectAdapter defectAdapter = new DefectAdapter();
    String DEFECT_TITLE = "New Defect";
    String ACTUAL_RESULT = "Project not work";
    int SEVERITY_VALUE = 1;

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

    @Test
    public void deleteDefectByProjectCodeAndId(){
        final int DEFECT_ID = Integer.parseInt("17");

        defectAdapter.deleteDefectByProjectCodeAndDefectId(PROJECT_CODE, DEFECT_ID, HttpStatus.SC_OK);



    }


}
