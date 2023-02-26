package apitests;

import io.restassured.RestAssured;
import io.restassured.http.ContentType;
import io.restassured.mapper.ObjectMapperType;
import models.Counts;
import models.Project;
import models.ProjectResponse;
import com.google.gson.Gson;
import org.apache.http.protocol.HTTP;
import org.hamcrest.CoreMatchers;
import org.hamcrest.MatcherAssert;
import org.testng.Assert;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.Test;

import java.io.File;
import java.util.HashMap;
import java.util.Map;

import static io.restassured.RestAssured.*;
import static org.apache.http.HttpStatus.SC_OK;
import static org.hamcrest.CoreMatchers.*;

public class SimpleAPITests {

    private static final String TOKEN = "e25efa9b75dc801c68cbf3e4efb14f48ab418746533f296cfee28e4a47f1aed1";
    private static final String BASE_URL = "https://api.qase.io/v1";

    @BeforeTest
    public void setup() {
        RestAssured.baseURI = BASE_URL;
        RestAssured.requestSpecification = given()
                //Api Token auth
                .header("TOKEN", TOKEN)
                .header(HTTP.CONTENT_TYPE, ContentType.JSON);
                //.auth().preemptive().basic("username", "password");
                // oAuth 2.0 (Token)
                // .auth().preemptive().oauth2("token");
    }

    @Test
    public void testCreateProject() {
        String code = "DQ";
        String title = "Title";
        Map<String, Object> requestBody = new HashMap<>();
        requestBody.put("title", title);
        requestBody.put("code", code);

        given().body(requestBody)
                .when()
                .log().all()
                .post("/project")
                .then()
                .log().all()
                .statusCode(SC_OK);

    }

    @Test
    public void testCreateProject1() {
        File file = new File(System.getProperty("user.dir") + "/src/test/resources/requestBody.json");
        given().body(file)
                .when()
                .log().all()
                .post("/project")
                .then()
                .log().all()
                .statusCode(SC_OK);

    }

    @Test
    public void testCreateProject2() {
        Project project = Project.builder()
                .title("sdsdsdsds")
                .code("FGH")
                .build();
        given().body(project, ObjectMapperType.GSON)
                .when()
                .log().all()
                .post("/project")
                .then()
                .log().all()
                .statusCode(SC_OK);

    }



    @Test
    public void verifyGetDefectsRequestReturnsBodyData () {
        given().pathParam("code","1235")
                .when()
                .log().all()
                .get("/defect/{code}")
                .then()
                .log().all()
                .statusCode(200).body("status", CoreMatchers.equalTo(true),
                        "result.entities[0].title", CoreMatchers.equalTo("Brand New Defect"),
                "result.entities.id", hasItems(7)
                );
    }

    @Test
    public void test1234() {
        String a = "qwe";
        int b = 6;
        MatcherAssert.assertThat(a, startsWith("w"));
                Assert.assertTrue(a.startsWith("e"));
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
