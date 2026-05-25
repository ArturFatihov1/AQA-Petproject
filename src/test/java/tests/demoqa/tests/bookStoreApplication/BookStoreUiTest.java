package tests.demoqa.tests.bookStoreApplication;

import com.codeborne.selenide.Selenide;
import org.junit.jupiter.api.AfterAll;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import tests.demoqa.pages.bookStoreApplicationPage.BookStorePage;
import tests.demoqa.tests.base.BaseUiTest;

import static com.codeborne.selenide.Condition.text;

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
    public void getTitleSearchElementTest() {
        bookStorePage.search("Speaking");
        bookStorePage.getFirstTitle().shouldHave(text("Speaking JavaScript"));
    }

    @Test
    public void openSearchElementTest() {
        bookStorePage.search("Speaking");
        bookStorePage.getFirstTitle().shouldHave(text("Speaking JavaScript"));

        bookStorePage.clickTitle();
        bookStorePage.getDescription().shouldHave(text("Like it or not, JavaScript"));

        bookStorePage.back();
        bookStorePage.getFirstTitle().shouldHave(text("Speaking JavaScript"));
    }
}
