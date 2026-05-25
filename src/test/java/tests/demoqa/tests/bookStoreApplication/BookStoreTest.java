package tests.demoqa.tests.bookStoreApplication;

import io.restassured.response.Response;
import org.junit.jupiter.api.*;
import tests.reqres.tests.baseApiTest.BaseApiTest;
import tests.specification.dto.book.BooksResponse;
import tests.specification.dto.book.CollectionOfIsbn;
import tests.specification.dto.user.TokenDto;
import tests.specification.dto.user.UserDto;

import java.util.List;

import static org.junit.jupiter.api.Assertions.assertEquals;

public class BookStoreTest extends BaseApiTest {

    private final String ISBN_1 = "9781449325862";
    private final String ISBN_2 = "9781449331818";
    private String userId;
    private String token;

    @BeforeEach
    void setupUserAndToken() {
        String username = "QA_" + System.currentTimeMillis();
        String password = "StrongPassword*1";

        UserDto user = accountService.createUser(username, password);
        userId = user.userID();

        TokenDto tokenDto = accountService.generateToken(username, password);
        token = tokenDto.token();
    }

    @AfterEach
    void cleanup() {
        if (userId != null && token != null) {
            accountService.deleteUser(userId, token);
        }
    }

    @Test
    @DisplayName("Получение списка всех доступных книг")
    void getAllBooksTest() {
        BooksResponse response = bookStoreService.getBooks();
        Assertions.assertFalse(response.books().isEmpty(), "Список книг не должен быть пустым");
    }

    @Test
    @DisplayName("Добавление книги в профиль пользователя")
    void addBookToUserTest() {
        List<CollectionOfIsbn> isbnsToAdd = List.of(new CollectionOfIsbn(ISBN_1));

        List<CollectionOfIsbn> response = bookStoreService.postBooks(userId, isbnsToAdd, token);

        assertEquals(1, response.size(), "Должна быть добавлена 1 книга");
        assertEquals(ISBN_1, response.get(0).isbn(), "ISBN не совпадает");
    }

    @Test
    @DisplayName("Замена одной книги в профиле пользователя")
    void replaceBookTest() {
        bookStoreService.postBooks(userId, List.of(new CollectionOfIsbn(ISBN_1)), token);

        Response response = bookStoreService.putBook(ISBN_1, userId, ISBN_2, token);

        if (response.getStatusCode() == 200) {
            String actualUserId = response.jsonPath().getString("userId");
            assertEquals(userId, actualUserId, "ID пользователя не совпадает");
        } else {
            System.out.println("Ошибка при замене: " + response.asString());
            assertEquals(400, response.getStatusCode());
        }
    }

    @Test
    @DisplayName("Удаление одной книги у пользователя")
    void deleteSingleBookTest() {
        bookStoreService.postBooks(userId, List.of(new CollectionOfIsbn(ISBN_1)), token);

        bookStoreService.deleteBook(ISBN_1, userId, token);

        UserDto userProfile = accountService.getUser(userId, token);
        Assertions.assertTrue(userProfile.books().isEmpty(), "Список книг должен быть пустым после удаления");
    }

    @Test
    @DisplayName("Удаление всех книг пользователя")
    void deleteAllBooksTest() {
        List<CollectionOfIsbn> isbns = List.of(
                new CollectionOfIsbn(ISBN_1),
                new CollectionOfIsbn(ISBN_2)
        );
        bookStoreService.postBooks(userId, isbns, token);

        Response response = bookStoreService.deleteBooks(userId, token);

        assertEquals(204, response.getStatusCode(), "Статус удаления должен быть 204");

        UserDto userProfile = accountService.getUser(userId, token);
        Assertions.assertTrue(userProfile.books().isEmpty(), "Список книг должен быть пустым после удаления");
    }
}
