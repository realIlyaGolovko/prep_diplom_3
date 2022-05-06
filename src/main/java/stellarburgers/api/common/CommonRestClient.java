package stellarburgers.api.common;

import io.qameta.allure.restassured.AllureRestAssured;
import io.restassured.builder.RequestSpecBuilder;
import io.restassured.specification.RequestSpecification;

import static io.restassured.http.ContentType.JSON;
import static stellarburgers.api.common.ApiConstants.BASE_URL;

//базовая спецификация для запросов
public class CommonRestClient {
    protected RequestSpecification getBaseSpec() {
        return new RequestSpecBuilder()
                .addFilter(new AllureRestAssured())
                .setContentType(JSON)
                .setBaseUri(BASE_URL)
                .build();

    }
}