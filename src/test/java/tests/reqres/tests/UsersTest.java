package tests.reqres.tests;

import io.restassured.response.Response;
import org.junit.jupiter.api.Test;
import tests.reqres.pojo.user.RootData;
import tests.reqres.pojo.user.UserData;
import tests.reqres.pojo.user.UserResponse;
import tests.reqres.tests.baseApiTest.BaseApiTest;
import tests.specification.dto.user.UserPut;

import static org.assertj.core.api.Assertions.assertThat;
import static org.junit.jupiter.api.Assertions.assertEquals;

public class UsersTest extends BaseApiTest {

    @Test
    void getUsersTest() {
        Response response = userService.getUsers();
        RootData userData = response.as(RootData.class);

        assertEquals(200, response.statusCode());

        assertThat(userData.page()).isEqualTo(2);
        assertThat(userData.perPage()).isEqualTo(6);

        assertThat(userData.data())
                .isNotEmpty()
                .hasSize(6)
                .extracting(UserData::firstName)
                .contains("Michael", "Lindsay");
    }

    @Test
    void getSingleUserTest() {
        Response response = userService.getUser("2");
        UserData userData = response.jsonPath().getObject("data", UserData.class);

        assertEquals(200, response.statusCode());

        assertThat(userData.id()).isEqualTo(2);
        assertThat(userData.email()).isEqualTo("janet.weaver@reqres.in");
        assertThat(userData.firstName()).isEqualTo("Janet");
        assertThat(userData.lastName()).isEqualTo("Weaver");
        assertThat(userData.avatar()).isEqualTo("https://reqres.in/img/faces/2-image.jpg");
    }

    @Test
    void createUserTest() {
        Response response = userService.postUser("Artur");
        UserResponse userData = response.as(UserResponse.class);

        assertEquals(201, response.statusCode());

        assertThat(userData.name()).isEqualTo("Artur");
    }

    @Test
    void updateUserTest() {
        String name = "morpheus";
        String job = "Programmer";

        Response response = userService.putUser(name, job);
        UserPut user = response.as(UserPut.class);

        assertEquals(200, response.statusCode());

        assertThat(user.name()).isEqualTo(name);
        assertThat(user.job()).isEqualTo(job);
    }

    @Test
    void deleteUserTest() {
        Response response = userService.deleteUser("2");
        assertEquals(204, response.statusCode());
    }
}
