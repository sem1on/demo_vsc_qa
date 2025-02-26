package demo_vsc.apiTests;

import static org.hamcrest.Matchers.is;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import static io.restassured.RestAssured.given;

public class GetRequestTests {

    @DisplayName("Получение списка пользователей")
    @Test
    void getListUsers() {
        given()
        .when()
            .get("https://reqres.in/api/users?page=2")
        .then()
            .body("total", is(12))
            .body("data[0].id", is(7));
    }

    @DisplayName("Получение одного пользователя")
    @Test
    void getSingleUser() {
        given()
        .when()
            .get("https://reqres.in/api/users/2")
        .then()
            .body("data.email", is("janet.weaver@reqres.in"))
            .body("data.first_name", is("Janet"));
    }

    @DisplayName("Отсутствие выбранного пользователя")
    @Test
    void getSingleUserNotFound() {
        given()
        .when()
            .get("https://reqres.in/api/users/23")
        .then()
            .statusCode(404);
    }

    @DisplayName("Получение списка ресурсов")
    @Test
    void getListResurs() {
        given()
        .when()
            .get("https://reqres.in/api/unknown")
        .then()
            .body("total", is(12))
            .body("total_pages", is(2))
            .body("per_page", is(6));
    }
}
