package stellarburgers.api.user;

import io.qameta.allure.Step;
import io.restassured.response.ValidatableResponse;
import stellarburgers.api.common.CommonRestClient;

import static io.restassured.RestAssured.given;
import static stellarburgers.api.common.ApiConstants.*;

public class UserClient extends CommonRestClient {
    @Step("Запрос на создание пользователя с {user} ")
    public ValidatableResponse create(User user) {
        return given().log().all()
                .spec(getBaseSpec())
                .body(user)
                .when()
                .post(CREATE_USER_PATH)
                .then().log().all();
    }

    @Step("Запрос на авторизацию пользователя c {userCredentials}")
    public ValidatableResponse login(UserCredentials userCredentials) {
        return given().log().all()
                .spec(getBaseSpec())
                .body(userCredentials)
                .when()
                .post(LOGIN_USER_PATH)
                .then().log().all();
    }
    @Step("Запрос на удаление созданного пользователя {user}")
    public void deleteUser(User user, String token) {
        given().log().all()
                .header("Authorization", token)
                .spec(getBaseSpec())
                .body(user)
                .when()
                .delete(UPDATE_USER_PATH)
                .then().log().all();
    }
}
