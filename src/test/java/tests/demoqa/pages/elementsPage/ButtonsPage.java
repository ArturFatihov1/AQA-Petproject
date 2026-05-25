package tests.demoqa.pages.elementsPage;

import com.codeborne.selenide.SelenideElement;
import io.qameta.allure.Step;
import lombok.Getter;
import lombok.NoArgsConstructor;

import static com.codeborne.selenide.Condition.visible;
import static com.codeborne.selenide.Selectors.byText;
import static com.codeborne.selenide.Selenide.$;

@Getter
@NoArgsConstructor
public class ButtonsPage {
    private final SelenideElement doubleClickBtn = $("#doubleClickBtn"),
            rightClickBtn = $("#rightClickBtn"),
            clickBtn = $(byText("Click Me")),
            doubleClickMessage = $("#doubleClickMessage"),
            rightClickMessage = $("#rightClickMessage"),
            clickMessage = $("#dynamicClickMessage");

    @Step("Выполнить двойной клик по кнопке")
    public void doubleClick() {
        doubleClickBtn.shouldBe(visible).doubleClick();
    }

    @Step("Выполнить правый клик по кнопке")
    public void rightClick() {
        rightClickBtn.shouldBe(visible).contextClick();
    }

    @Step("Выполнить обычный клик по кнопке")
    public void click() {
        clickBtn.shouldBe(visible).click();
    }
}
