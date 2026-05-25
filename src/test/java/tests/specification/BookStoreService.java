package tests.specification;

import io.restassured.response.Response;
import tests.specification.dto.book.*;

import java.util.List;

public class BookStoreService {
    private final RestClient restClient;

    public BookStoreService() {
        this.restClient = new RestClient();
    }

    public BooksResponse getBooks() {
        return restClient.get("/BookStore/v1/Books", BooksResponse.class);
    }

    public List<CollectionOfIsbn> postBooks(String userId, List<CollectionOfIsbn> isbns, String token) {
        UserBookRequest body = new UserBookRequest(userId, isbns);
        UserBookResponse response = restClient.post("/BookStore/v1/Books", body, token, UserBookResponse.class);

        if (response == null || response.books() == null) {
            throw new RuntimeException("Сервер вернул пустой ответ");
        }
        return response.books();
    }

    public Response deleteBooks(String userId, String token) {
        return restClient.delete("/BookStore/v1/Books/", userId, token);
    }

    public Book getBook(String isbn) {
        return restClient.get("/BookStore/v1/Book/" + isbn, Book.class);
    }

    public Response deleteBook(String isbn, String userId, String token) {
        BookIsbn body = new BookIsbn(isbn, userId);
        return restClient.delete("/BookStore/v1/Book", body, token);
    }

    public Response putBook(String oldIsbn, String userId, String newIsbn, String token) {
        BookIsbn body = new BookIsbn(userId, newIsbn);
        return restClient.put("/BookStore/v1/Books/" + oldIsbn, body, token);
    }
}
