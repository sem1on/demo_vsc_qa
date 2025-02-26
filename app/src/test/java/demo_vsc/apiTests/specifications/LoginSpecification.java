package demo_vsc.apiTests.specifications;

import io.qameta.allure.restassured.AllureRestAssured;
import static io.restassured.RestAssured.with;
import io.restassured.builder.ResponseSpecBuilder;
import static io.restassured.filter.log.LogDetail.BODY;
import static io.restassured.filter.log.LogDetail.STATUS;
import static io.restassured.http.ContentType.JSON;
import io.restassured.specification.RequestSpecification;
import io.restassured.specification.ResponseSpecification;

public class LoginSpecification {

    public static RequestSpecification loginRequestSpec = with()
        .filter(new AllureRestAssured())
        .log().uri()
        .log().body()
        .contentType(JSON)
        .baseUri("https://reqres.in")
        .basePath("/api");

    public static ResponseSpecification loginResponseSpec = new ResponseSpecBuilder()
        .log(STATUS)
        .log(BODY)
        .build();
}
