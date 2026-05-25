package tests.demoqa.tests.elements;

import com.codeborne.selenide.Selenide;
import org.junit.jupiter.api.AfterAll;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import tests.demoqa.pages.elementsPage.BrokenLinksPage;
import tests.demoqa.tests.base.BaseUiTest;

import static com.codeborne.selenide.Condition.text;
import static com.codeborne.selenide.Selenide.webdriver;
import static com.codeborne.selenide.WebDriverConditions.url;
import static org.junit.jupiter.api.Assertions.assertEquals;

public class BrokenLinksTest extends BaseUiTest {
    BrokenLinksPage brokenLinksPage = new BrokenLinksPage();

    @AfterAll
    static void close() {
        Selenide.closeWebDriver();
    }

    @BeforeEach
    public void openPage() {
        Selenide.open("broken");
    }

    @Test
    void validLinkTest() {
        brokenLinksPage.validLinkClick();
        webdriver().shouldHave(url("https://demoqa.com/"));
    }

    @Test
    void brokenLinkTest() {
        brokenLinksPage.brokenLinkClick();
        brokenLinksPage.getContent().shouldHave(text("This page returned a 500 status code."));
    }

    @Test
    void brokenImageTest() {
        assertEquals(0, brokenLinksPage.getBrokenImageWidth());
    }

}
