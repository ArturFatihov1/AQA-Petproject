package tests.reqres.tests;

import io.restassured.response.Response;
import org.junit.jupiter.api.Test;
import tests.reqres.pojo.user.AuthUser;
import tests.reqres.pojo.user.Token;
import tests.reqres.tests.baseApiTest.BaseApiTest;

import static org.assertj.core.api.Assertions.assertThat;
import static org.junit.jupiter.api.Assertions.assertEquals;

public class AuthTest extends BaseApiTest {

    @Test
    public void successRegisterUserTest() {
        String email = "eve.holt@reqres.in";
        String password = "pistol";
        Response response = authenticationService.registerUser(email, password);

        AuthUser user = response.as(AuthUser.class);

        assertEquals(200, response.statusCode());

        assertThat(user.id()).isEqualTo(4);
        assertThat(user.token()).isEqualTo("QpwL5tke4Pnpja7X4");

    }

    @Test
    public void failedRegisterUserTest() {
        String email = "anna.hilt@reqres.in";
        String password = "posta";
        Response response = authenticationService.registerUser(email, password);

        assertEquals(400, response.statusCode());
    }

    @Test
    public void successLoginUserTest() {
        String email = "eve.holt@reqres.in";
        String password = "pistol";
        Response response = authenticationService.loginUser(email, password);

        Token user = response.as(Token.class);

        assertEquals(200, response.statusCode());
        assertThat(user.token()).isEqualTo("QpwL5tke4Pnpja7X4");
    }

    @Test
    public void failedLoginUserTest() {
        String email = "anna.hilt@reqres.in";
        String password = "posta";
        Response response = authenticationService.loginUser(email, password);

        assertEquals(400, response.statusCode());
    }

}
