package tests.specification;

import io.qameta.allure.restassured.AllureRestAssured;
import io.restassured.RestAssured;
import io.restassured.builder.RequestSpecBuilder;
import io.restassured.filter.log.RequestLoggingFilter;
import io.restassured.filter.log.ResponseLoggingFilter;
import io.restassured.http.ContentType;
import io.restassured.response.Response;
import io.restassured.specification.RequestSpecification;

import static io.restassured.RestAssured.given;

public class RestClient {

    static {
        RestAssured.baseURI = System.getProperty("api.base.uri", "https://demoqa.com/");
    }

    private final RequestSpecification baseSpec;

    public RestClient() {
        baseSpec = new RequestSpecBuilder()
                .setContentType(ContentType.JSON)
                .addFilter(new AllureRestAssured())
                .addFilter(new RequestLoggingFilter())
                .addFilter(new ResponseLoggingFilter())
                .build();
    }

    public <T> T get(String path, String token, Class<T> responseType) {
        return buildSpec().auth().oauth2(token).get(path).then().extract().as(responseType);
    }

    public <T> T get(String path, Class<T> responseType) {
        return buildSpec().get(path).then().extract().as(responseType);
    }

    public <T> T post(String path, Object body, String token, Class<T> responseType) {
        return buildSpec().auth().oauth2(token).body(body).post(path).then().extract().as(responseType);
    }

    public Response post(String path, Object body) {
        return buildSpec().body(body).post(path);
    }

    public <T> T post(String path, Object body, Class<T> responseType) {
        return buildSpec().body(body).post(path).then().extract().as(responseType);
    }

    public <T> T put(String path, Object body, Class<T> responseType) {
        return buildSpec().body(body).put(path).then().extract().as(responseType);
    }

    public Response put(String path, Object body) {
        return buildSpec().body(body).put(path);
    }

    public Response put(String path, Object body, String token) {
        return buildSpec().auth().oauth2(token).body(body).put(path);
    }

    public <T> T put(String path, Object body, String token, Class<T> responseType) {
        return buildSpec().auth().oauth2(token).body(body).put(path).then().extract().as(responseType);
    }

    public <T> T put(String path, String token, Class<T> responseType) {
        return buildSpec().auth().oauth2(token).put(path).then().extract().as(responseType);
    }

    public Response delete(String path, String authToken) {
        return buildSpec().auth().oauth2(authToken).delete(path);
    }

    public Response delete(String path, Object body, String authToken) {
        return buildSpec()
                .auth().oauth2(authToken)
                .body(body)
                .delete(path);
    }

    public Response delete(String path, String userId, String token) {
        return buildSpec()
                .auth().oauth2(token)
                .queryParam("UserId", userId)
                .delete(path);
    }

    protected RequestSpecification buildSpec() {
        return given().spec(baseSpec);
    }
}