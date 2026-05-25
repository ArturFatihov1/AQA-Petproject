package tests.demoqa.pages.elementsPage;

import com.codeborne.selenide.SelenideElement;
import io.qameta.allure.Step;
import lombok.Getter;

import static com.codeborne.selenide.Selenide.$;

@Getter
public class LinksPage {
    private final SelenideElement simpleLink = $("#simpleLink"),
            dynamicLink = $("#dynamicLink"),
            created = $("#created"),
            noContent = $("#no-content"),
            moved = $("#moved"),
            badRequest = $("#bad-request"),
            unauthorized = $("#unauthorized"),
            forbidden = $("#forbidden"),
            invalidUrl = $("#invalid-url"),
            result = $("#linkResponse");

    @Step("Нажать на простую ссылку")
    public void simpleLinkClick() {
        simpleLink.click();
    }

    @Step("Нажать на динамическую ссылку")
    public void dynamicLinkClick() {
        dynamicLink.click();
    }

    @Step("Нажать на ссылку, возвращающую статус 201 Created")
    public void createdClick() {
        created.click();
    }

    @Step("Нажать на ссылку, возвращающую статус 204 No Content")
    public void noContentClick() {
        noContent.click();
    }

    @Step("Нажать на ссылку, возвращающую статус 301 Moved")
    public void movedClick() {
        moved.click();
    }

    @Step("Нажать на ссылку, возвращающую статус 400 Bad Request")
    public void badRequestClick() {
        badRequest.click();
    }

    @Step("Нажать на ссылку, возвращающую статус 401 Unauthorized")
    public void unauthorizedClick() {
        unauthorized.click();
    }

    @Step("Нажать на ссылку, возвращающую статус 403 Forbidden")
    public void forbiddenClick() {
        forbidden.click();
    }

    @Step("Нажать на ссылку, возвращающую статус 404 Not Found")
    public void invalidUrlClick() {
        invalidUrl.click();
    }
}