package tests.demoqa.tests.elements;

import com.codeborne.selenide.Selenide;
import org.junit.jupiter.api.AfterAll;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import tests.demoqa.pages.elementsPage.LinksPage;
import tests.demoqa.tests.base.BaseUiTest;

import static com.codeborne.selenide.Condition.text;
import static com.codeborne.selenide.Selenide.switchTo;
import static com.codeborne.selenide.Selenide.webdriver;
import static com.codeborne.selenide.WebDriverConditions.url;

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
    public void clickSimpleLinkTest() {
        linksPage.simpleLinkClick();
        switchTo().window(1);
        webdriver().shouldHave(url("https://demoqa.com/"));
    }

    @Test
    public void dynamicLinkTest() {
        linksPage.dynamicLinkClick();
        switchTo().window(1);
        webdriver().shouldHave(url("https://demoqa.com/"));
    }

    @Test
    public void clickCreatedTest() {
        linksPage.createdClick();
        linksPage.getResult().shouldHave(text("201"), text("Created"));
    }

    @Test
    public void clickNoContentTest() {
        linksPage.noContentClick();
        linksPage.getResult().shouldHave(text("204"), text("No Content"));
    }

    @Test
    public void clickMovedTest() {
        linksPage.movedClick();
        linksPage.getResult().shouldHave(text("301"), text("Moved Permanently"));
    }

    @Test
    public void clickBadRequestTest() {
        linksPage.badRequestClick();
        linksPage.getResult().shouldHave(text("400"), text("Bad Request"));
    }

    @Test
    public void clickUnauthorizedTest() {
        linksPage.unauthorizedClick();
        linksPage.getResult().shouldHave(text("401"), text("Unauthorized"));
    }

    @Test
    public void clickForbiddenTest() {
        linksPage.forbiddenClick();
        linksPage.getResult().shouldHave(text("403"), text("Forbidden"));
    }

    @Test
    public void clickNotFoundTest() {
        linksPage.invalidUrlClick();
        linksPage.getResult().shouldHave(text("404"), text("Not Found"));
    }
}
