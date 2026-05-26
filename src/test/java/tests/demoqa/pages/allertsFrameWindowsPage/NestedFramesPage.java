package tests.demoqa.pages.allertsFrameWindowsPage;

import com.codeborne.selenide.SelenideElement;
import io.qameta.allure.Step;
import lombok.Getter;

import static com.codeborne.selenide.Condition.text;
import static com.codeborne.selenide.Selenide.$;

@Getter
public class NestedFramesPage {
    private final SelenideElement textInFrame = $("body"),
            textOutFrame = $(".text-center");

    @Step("Проверить текст внутри текущего фрейма: {expectedText}")
    public void checkTextInFrame(String expectedText) {
        textInFrame.shouldHave(text(expectedText));
    }

    @Step("Проверить заголовок страницы: {expectedText}")
    public void checkPageTitle(String expectedText) {
        textOutFrame.shouldHave(text(expectedText));
    }
}
