package tests.demoqa.pages.elementsPage;

import com.codeborne.selenide.SelenideElement;
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

    public void simpleLinkClick() {
        simpleLink.click();
    }

    public void dynamicLinkClick() {
        dynamicLink.click();
    }

    public void createdClick() {
        created.click();
    }

    public void noContentClick() {
        noContent.click();
    }

    public void movedClick() {
        moved.click();
    }

    public void badRequestClick() {
        badRequest.click();
    }

    public void unauthorizedClick() {
        unauthorized.click();
    }

    public void forbiddenClick() {
        forbidden.click();
    }

    public void invalidUrlClick() {
        invalidUrl.click();
    }
}
