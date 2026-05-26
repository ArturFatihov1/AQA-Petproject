package tests.demoqa.tests.elements;

import com.codeborne.selenide.Selenide;
import io.qameta.allure.Epic;
import io.qameta.allure.Feature;
import io.qameta.allure.Severity;
import io.qameta.allure.SeverityLevel;
import org.junit.jupiter.api.AfterAll;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import tests.demoqa.pages.elementsPage.BrokenLinksPage;
import tests.demoqa.tests.BaseUiTest;

import static com.codeborne.selenide.Condition.text;
import static com.codeborne.selenide.Selenide.webdriver;
import static com.codeborne.selenide.WebDriverConditions.url;
import static org.junit.jupiter.api.Assertions.assertEquals;

@Epic("DemoQA test ui")
@Feature("Elements")
@DisplayName("Тестирование проверки битых ссылок и изображений")
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
    @DisplayName("Проверка перехода по валидной ссылке")
    @Severity(SeverityLevel.NORMAL)
    void validLinkTest() {
        brokenLinksPage.validLinkClick();
        webdriver().shouldHave(url("https://demoqa.com/"));
    }

    @Test
    @DisplayName("Проверка перехода по битой ссылке (статус 500)")
    @Severity(SeverityLevel.NORMAL)
    void brokenLinkTest() {
        brokenLinksPage.brokenLinkClick();
        brokenLinksPage.getContent().shouldHave(text("This page returned a 500 status code."));
    }

    @Test
    @DisplayName("Проверка, что битое изображение не загружается (ширина 0)")
    @Severity(SeverityLevel.MINOR)
    void brokenImageTest() {
        assertEquals(0, brokenLinksPage.getBrokenImageWidth());
    }

}
