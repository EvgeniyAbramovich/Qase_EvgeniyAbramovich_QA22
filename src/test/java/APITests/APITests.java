package APITests;

import Models.Counts;
import Models.Project;
import Models.ProjectResponse;
import com.google.gson.Gson;
import io.restassured.response.Response;
import org.hamcrest.CoreMatchers;
import org.testng.Assert;
import org.testng.annotations.Test;

import static io.restassured.RestAssured.*;
import static org.hamcrest.CoreMatchers.equalTo;
import static org.hamcrest.CoreMatchers.hasItems;

public class APITests {

    private static final String TOKEN = "e25efa9b75dc801c68cbf3e4efb14f48ab418746533f296cfee28e4a47f1aed1";
    private static final String BASE_URL = "https://api.qase.io/v1";

    @Test
    public void verifyGetDefectsRequestReturnsBodyData () {
        given().pathParam("code","1235")
                .header("Token",TOKEN)
                .when()
                .log().all()
                .get(BASE_URL + "/defect/{code}")
                .then()
                .log().all()
                .statusCode(200).body("status", CoreMatchers.equalTo(true),
                        "result.entities[0].title", CoreMatchers.equalTo("Brand New Defect"),
                "result.entities.id", hasItems(1)
                );
    }

    @Test
    public void verifyPostDefectsRequestReturnsBodyData () {
        given().pathParam("code","1235")
                .header("Token",TOKEN)
                .header("Content-Type","application/json")
                .body("{\"title\": \"QWE\", \"actual_result\": \"zxc\", \"severity\": 3 }")
                .when()
                .log().all()
                .post(BASE_URL + "/defect/{code}")
                .then()
                .log().all()
                .statusCode(200).body("status", CoreMatchers.equalTo(true));
    }

    @Test
    public void projectGetTest() {
        Gson gson = new Gson();
        ProjectResponse expectedResponse = ProjectResponse.builder()
                .status(true).result(Project.builder()
                        .code("1235").title("QA22_Demo")
                        .counts(Counts.builder()
                                .cases(0)
                                .suites(0)
                                .milestones(0)
                                .runs(Counts.Runs.builder()
                                        .total(0)
                                        .active(0)
                                        .build()).defects(Counts.Defects.builder()
                                        .total(2)
                                        .open(2)
                                        .build())
                                .build())
                        .build())
                .build();

        given().pathParam("code","1235")
                .header("Token",TOKEN)
                .when()
                .log().all()
                .get(BASE_URL + "/project/{code}")
                .then()
                .log().all()
                .statusCode(200).body(equalTo(gson.toJson(expectedResponse)));

    }

    @Test
    public void projectGetTestJsonToJava() {
        Gson gson = new Gson();
        ProjectResponse expectedResponse = ProjectResponse.builder()
                .status(true).result(Project.builder()
                        .code("1235").title("QA22_Demo")
                        .counts(Counts.builder()
                                .cases(0)
                                .suites(0)
                                .milestones(0)
                                .runs(Counts.Runs.builder()
                                        .total(0)
                                        .active(0)
                                        .build()).defects(Counts.Defects.builder()
                                        .total(2)
                                        .open(2)
                                        .build())
                                .build())
                        .build())
                .build();

        String responseString = given().pathParam("code","1235")
                .header("Token",TOKEN)
                .when()
                .log().all()
                .get(BASE_URL + "/project/{code}")
                .then()
                .log().all()
                .extract()
                .body()
                .asString();

        Assert.assertEquals(gson.fromJson(responseString, ProjectResponse.class), expectedResponse);

    }


}
