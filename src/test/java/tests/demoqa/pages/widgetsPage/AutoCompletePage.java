package tests.demoqa.pages.widgetsPage;

import com.codeborne.selenide.SelenideElement;
import io.qameta.allure.Step;
import lombok.Getter;

import static com.codeborne.selenide.Selenide.$;
import static com.codeborne.selenide.Selenide.$x;

@Getter
public class AutoCompletePage {
    private final SelenideElement autoCompleteMultipleInput = $("#autoCompleteMultipleInput"),
            autoCompleteSingleInput = $("#autoCompleteSingleInput"),
            blueRemove = $("[aria-label=\"Remove Blue\"]"),
            blackRemove = $("[aria-label=\"Remove Black\"]"),
            removeAll = $(".auto-complete__indicator"),
            resultMultiple = $x("//div[contains(@class,\"auto-complete__value-container\")][1]"),
            resultSingle = $x("//div[contains(@class,'auto-complete__single-value')]");

    @Step("Ввести значение в поле Multiple: {text}")
    public void setAutoCompleteMultipleInput(String text) {
        autoCompleteMultipleInput.setValue(text).pressEnter();
    }

    @Step("Ввести значение в поле Single: {text}")
    public void setAutoCompleteSingleInput(String text) {
        autoCompleteSingleInput.setValue(text).pressEnter();
    }

    @Step("Удалить все выбранные значения")
    public void removeAll() {
        removeAll.click();
    }

    @Step("Удалить цвет Black")
    public void removeBlack() {
        blackRemove.click();
    }

    @Step("Удалить цвет Blue")
    public void removeBlue() {
        blueRemove.click();
    }
}