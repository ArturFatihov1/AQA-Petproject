package tests.demoqa.tests.elements;

import com.codeborne.selenide.Selenide;
import io.qameta.allure.*;
import org.junit.jupiter.api.AfterAll;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import tests.demoqa.pages.elementsPage.LinksPage;
import tests.demoqa.tests.base.BaseUiTest;

import static com.codeborne.selenide.Condition.text;
import static com.codeborne.selenide.Selenide.switchTo;
import static com.codeborne.selenide.Selenide.webdriver;
import static com.codeborne.selenide.WebDriverConditions.url;

@Epic("DemoQA test ui")
@Feature("Elements")
@Story("Links")
@DisplayName("Тестирование работы ссылок и API статусов")
public class LinksTest extends BaseUiTest {
    LinksPage linksPage = new LinksPage();

    @AfterAll
    static void close() {
        Selenide.closeWebDriver();
    }

    @BeforeEach
    public void openPage() {
        Selenide.open("links");
    }

    @Test
    @DisplayName("Проверка открытия простой ссылки")
    @Severity(SeverityLevel.NORMAL)
    public void clickSimpleLinkTest() {
        linksPage.simpleLinkClick();
        switchTo().window(1);
        webdriver().shouldHave(url("https://demoqa.com/"));
    }

    @Test
    @DisplayName("Проверка открытия динамической ссылки")
    @Severity(SeverityLevel.NORMAL)
    public void dynamicLinkTest() {
        linksPage.dynamicLinkClick();
        switchTo().window(1);
        webdriver().shouldHave(url("https://demoqa.com/"));
    }

    @Test
    @DisplayName("Проверка API ответа: 201 Created")
    @Severity(SeverityLevel.MINOR)
    public void clickCreatedTest() {
        linksPage.createdClick();
        linksPage.getResult().shouldHave(text("201"), text("Created"));
    }

    @Test
    @DisplayName("Проверка API ответа: 204 No Content")
    @Severity(SeverityLevel.MINOR)
    public void clickNoContentTest() {
        linksPage.noContentClick();
        linksPage.getResult().shouldHave(text("204"), text("No Content"));
    }

    @Test
    @DisplayName("Проверка API ответа: 301 Moved Permanently")
    @Severity(SeverityLevel.MINOR)
    public void clickMovedTest() {
        linksPage.movedClick();
        linksPage.getResult().shouldHave(text("301"), text("Moved Permanently"));
    }

    @Test
    @DisplayName("Проверка API ответа: 400 Bad Request")
    @Severity(SeverityLevel.MINOR)
    public void clickBadRequestTest() {
        linksPage.badRequestClick();
        linksPage.getResult().shouldHave(text("400"), text("Bad Request"));
    }

    @Test
    @DisplayName("Проверка API ответа: 401 Unauthorized")
    @Severity(SeverityLevel.MINOR)
    public void clickUnauthorizedTest() {
        linksPage.unauthorizedClick();
        linksPage.getResult().shouldHave(text("401"), text("Unauthorized"));
    }

    @Test
    @DisplayName("Проверка API ответа: 403 Forbidden")
    @Severity(SeverityLevel.MINOR)
    public void clickForbiddenTest() {
        linksPage.forbiddenClick();
        linksPage.getResult().shouldHave(text("403"), text("Forbidden"));
    }

    @Test
    @DisplayName("Проверка API ответа: 404 Not Found")
    @Severity(SeverityLevel.MINOR)
    public void clickNotFoundTest() {
        linksPage.invalidUrlClick();
        linksPage.getResult().shouldHave(text("404"), text("Not Found"));
    }
}
