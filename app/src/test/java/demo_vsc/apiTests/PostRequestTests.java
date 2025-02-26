package demo_vsc.apiTests;

import static org.hamcrest.Matchers.is;
import static org.junit.jupiter.api.Assertions.assertEquals;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import demo_vsc.apiTests.models.CreateUserModel;
import demo_vsc.apiTests.models.LoginResponseUserModel;
import demo_vsc.apiTests.models.LoginUserModel;
import static demo_vsc.apiTests.specifications.LoginSpecification.loginRequestSpec;
import static demo_vsc.apiTests.specifications.LoginSpecification.loginResponseSpec;
import static io.qameta.allure.Allure.step;
import static io.restassured.RestAssured.given;

public class PostRequestTests {

    @DisplayName("Создание пользователя")
    @Test
    void postCreateUsers() {

        CreateUserModel createUser = new CreateUserModel();
        createUser.setName("morpheus");
        createUser.setJob("leader");

        step("Сохдание польхователя", () -> 
            given(loginRequestSpec)
                .body(createUser)
            .when()
                .post("/users")
            .then()
                .spec(loginResponseSpec)
                .statusCode(201)
                .body("name", is("morpheus"))
                .body("job", is("leader"))
        );

        
    }

    @DisplayName("Логин пользователя")
    @Test
    void postLoginUsers() {

        LoginUserModel loginUser = new LoginUserModel();
        loginUser.setEmail("eve.holt@reqres.in");
        loginUser.setPassword("cityslicka");

        LoginResponseUserModel response = step("Make request", () -> 
            given(loginRequestSpec)
                .body(loginUser)
            .when()
                .post("/login")
            .then()
                .spec(loginResponseSpec)
                .statusCode(200)
                .extract().as(LoginResponseUserModel.class));
        
        step("Verification response", () -> 
            assertEquals("QpwL5tke4Pnpja7X4", response.getToken()));
        
    }
}
