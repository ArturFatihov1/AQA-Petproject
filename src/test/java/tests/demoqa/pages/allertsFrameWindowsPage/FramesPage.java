package tests.demoqa.pages.allertsFrameWindowsPage;

import com.codeborne.selenide.SelenideElement;
import io.qameta.allure.Step;
import lombok.Getter;

import static com.codeborne.selenide.Selenide.$;

@Getter
public class FramesPage {
    private final SelenideElement sampleHeading = $("#sampleHeading"),
            frames = $(".text-center");

    @Step("Проверить заголовок внутри фрейма")
    public void checkHeading(String expectedText) {
        sampleHeading.shouldHave(com.codeborne.selenide.Condition.text(expectedText));
    }

    @Step("Проверить заголовок страницы 'Frames'")
    public void checkFramesPageTitle(String expectedText) {
        frames.shouldHave(com.codeborne.selenide.Condition.text(expectedText));
    }
}
