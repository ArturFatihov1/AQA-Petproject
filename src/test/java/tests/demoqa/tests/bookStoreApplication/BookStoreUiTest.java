package tests.demoqa.tests.bookStoreApplication;

import com.codeborne.selenide.Selenide;
import io.qameta.allure.*;
import org.junit.jupiter.api.AfterAll;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import tests.demoqa.pages.bookStoreApplicationPage.BookStorePage;
import tests.demoqa.tests.BaseUiTest;

import static com.codeborne.selenide.Condition.text;

@Epic("DemoQA test ui")
@Feature("Book Store Application")
@Story("Book Store")
@DisplayName("Тестирование поиска и просмотра книг")
public class BookStoreUiTest extends BaseUiTest {
    BookStorePage bookStorePage = new BookStorePage();

    @AfterAll
    static void close() {
        Selenide.closeWebDriver();
    }

    @BeforeEach
    public void openPage() {
        Selenide.open("books");
    }

    @Test
    @DisplayName("Проверка поиска книги по названию")
    @Severity(SeverityLevel.NORMAL)
    public void getTitleSearchElementTest() {
        bookStorePage.search("Speaking");
        bookStorePage.getFirstTitle().shouldHave(text("Speaking JavaScript"));
    }

    @Test
    @DisplayName("Проверка открытия карточки книги и возврата назад")
    @Severity(SeverityLevel.NORMAL)
    public void openSearchElementTest() {
        bookStorePage.search("Speaking");
        bookStorePage.getFirstTitle().shouldHave(text("Speaking JavaScript"));

        bookStorePage.clickTitle();
        bookStorePage.getDescription().shouldHave(text("Like it or not, JavaScript"));

        bookStorePage.back();
        bookStorePage.getFirstTitle().shouldHave(text("Speaking JavaScript"));
    }
}