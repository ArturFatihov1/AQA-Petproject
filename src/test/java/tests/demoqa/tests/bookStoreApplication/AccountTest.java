package tests.demoqa.tests.bookStoreApplication;

import io.restassured.response.Response;
import org.junit.jupiter.api.*;
import tests.reqres.tests.baseApiTest.BaseApiTest;
import tests.specification.dto.user.TokenDto;
import tests.specification.dto.user.UserDto;

@TestMethodOrder(MethodOrderer.OrderAnnotation.class)
public class AccountTest extends BaseApiTest {

    private static final String PASSWORD = "Password@123";
    private static String currentUserId;
    private static String currentToken;
    private static String uniqueUserName;

    @BeforeAll
    static void setupData() {
        uniqueUserName = "User_" + System.currentTimeMillis();
    }

    @Test
    @Order(1)
    @DisplayName("Создание пользователя")
    void registerUserTest() {
        UserDto response = accountService.createUser(uniqueUserName, PASSWORD);

        Assertions.assertNotNull(response.userID(), "ID пользователя не должен быть null");
        Assertions.assertEquals(uniqueUserName, response.username(), "Имя пользователя не совпадает");

        currentUserId = response.userID();
    }

    @Test
    @Order(2)
    @DisplayName("Генерация токена")
    void generateTokenTest() {
        TokenDto response = accountService.generateToken(uniqueUserName, PASSWORD);

        Assertions.assertEquals("Success", response.status(), "Статус должен быть Success");
        Assertions.assertNotNull(response.token(), "Токен не сгенерирован");

        currentToken = response.token();
    }

    @Test
    @Order(3)
    @DisplayName("Проверка авторизации")
    void checkAuthorizedTest() {
        boolean isAuthorized = accountService.authorize(uniqueUserName, PASSWORD);
        Assertions.assertTrue(isAuthorized, "Пользователь должен быть авторизован");
    }

    @Test
    @Order(4)
    @DisplayName("Получение данных пользователя")
    void getUserProfileTest() {
        UserDto response = accountService.getUser(currentUserId, currentToken);
        Assertions.assertEquals(uniqueUserName, response.username());
        Assertions.assertNotNull(response.books(), "Список книг должен инициализироваться");
    }

    @Test
    @Order(5)
    @DisplayName("Удаление пользователя")
    void deleteUserTest() {
        Response response = accountService.deleteUser(currentUserId, currentToken);
        Assertions.assertEquals(204, response.getStatusCode(), "Код ответа при удалении должен быть 204");
    }
}